package laboratorio;

import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;

public class BattleStrategyWalls implements IBattleStrategy {
	boolean peek; // Don't turn if there's a robot there
	double moveAmount; // How much to move

	@Override
	public void tick(LaboRobot r) {
		// Look before we turn when ahead() completes.
		peek = true;
		// Move up the wall
		r.ahead((int) moveAmount);
		// Don't look now
		peek = false;
	}

	@Override
	public void onScannedRobot(LaboRobot r, ScannedRobotEvent e) {
		r.fire(5);
		// Note that scan is called automatically when the robot is moving.
		// By calling it manually here, we make sure we generate another scan event if
		// there's a robot on the next
		// wall, so that we do not start moving up it until it's gone.
		if (peek) {
			r.scan();
		}
	}

	public void onHitRobot(LaboRobot r, HitRobotEvent e) {
		// If he's in front of us, set back up a bit.
		if (e.getBearing() > -90 && e.getBearing() < 90) {
			r.back(100);
		} // else he's in back of us, so set ahead a bit.
		else {
			r.ahead(100);
		}
	}

	@Override
	public void onHitByBullet(LaboRobot r, HitByBulletEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onHitWall(LaboRobot r, HitWallEvent e) {
		r.turnRight(90);
	}

	@Override
	public void prepare(LaboRobot r) {
		// Initialize moveAmount to the maximum possible for this battlefield.
		moveAmount = Math.max(r.getBattleFieldWidth(), r.getBattleFieldHeight());
		// Initialize peek to false
		peek = false;

		// turnLeft to face a wall.
		// getHeading() % 90 means the remainder of
		// getHeading() divided by 90.

		r.turnLeft(r.getHeading() % 90);
		r.ahead((int) moveAmount); // Turn the gun toturn right 90 degrees.
		peek = true;
		r.turnGunRight(90);
//		r.turnRight(90);
	}
}
