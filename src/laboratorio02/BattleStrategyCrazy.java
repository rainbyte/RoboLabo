/**
 * Copyright (c) 2001-2019 Mathew A. Nelson and Robocode contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://robocode.sourceforge.io/license/epl-v10.html
 */
package laboratorio02;


import robocode.*;


/**
 * Crazy - a sample robot by Mathew Nelson.
 * <p>
 * This robot moves around in a crazy pattern.
 *
 * @author Mathew A. Nelson (original)
 * @author Flemming N. Larsen (contributor)
 */
public class BattleStrategyCrazy extends AdvancedRobot implements IBattleStrategy{
	boolean movingForward;

	/**
	 * run: Crazy's main run function
	 */


	/**
	 * onHitWall:  Handle collision with wall.
	 */
	public void onHitWall(HitWallEvent e) {
		
	}

	/**
	 * reverseDirection:  Switch from ahead to back & vice versa
	 */
	public void reverseDirection(LaboRobot02 r) {
		if (movingForward) {
			r.setBack(40000);
			movingForward = false;
		} else {
			r.setAhead(40000);
			movingForward = true;
		}
	}

	/**
	 * onScannedRobot:  Fire!
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		
	}

	/**
	 * onHitRobot:  Back up!
	 */
	public void onHitRobot(HitRobotEvent e) {
		
	}

	@Override
	public void tick(LaboRobot02 r) {
		// Tell the game we will want to move ahead 40000 -- some large number
		r.setAhead(40000);
		movingForward = true;
		// Tell the game we will want to turn right 90
		r.setTurnRight(90);
		// At this point, we have indicated to the game that *when we do something*,
		// we will want to move ahead and turn right.  That's what "set" means.
		// It is important to realize we have not done anything yet!
		// In order to actually move, we'll want to call a method that
		// takes real time, such as waitFor.
		// waitFor actually starts the action -- we start moving and turning.
		// It will not return until we have finished turning.
		r.waitFor(new TurnCompleteCondition(r));
		// Note:  We are still moving ahead now, but the turn is complete.
		// Now we'll turn the other way...
		r.setTurnLeft(180);
		// ... and wait for the turn to finish ...
		r.waitFor(new TurnCompleteCondition(r));
		// ... then the other way ...
		r.setTurnRight(180);
		// .. and wait for that turn to finish.
		r.waitFor(new TurnCompleteCondition(r));
		// then back to the top to do it all again

	}

	@Override
	public void onScannedRobot(LaboRobot02 r, ScannedRobotEvent e) {
		r.fire(1);

	}

	@Override
	public void onHitByBullet(LaboRobot02 r, HitByBulletEvent e) {
		// Move ahead 100 and in the same time turn left papendicular to the bullet
		r.turnLeft(90 - e.getBearing());
		r.ahead(100);
	}

	@Override
	public void onHitWall(LaboRobot02 r, HitWallEvent e) {
		// Bounce off!
		reverseDirection(r);

	}

	@Override
	public void onHitRobot(LaboRobot02 r, HitRobotEvent e) {
		// If we're moving the other robot, reverse!
		if (e.isMyFault()) {
			reverseDirection(r);
		}
	}
}
