package laboratorio;

import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;

public class BattleStrategyWalls implements IBattleStrategy {
	boolean peek; // Don't turn if there's a robot there
	double moveAmount; // How much to move, but avoiding the walls

	private void recalculateMoveAmount(LaboRobot02 r) {
		int heading = (int) Math.floor(r.getHeading());
		switch (heading) {
			case NORTH:
				moveAmount = r.getBattleFieldHeight() - (r.getY() + r.getHeight() + 1);
				break;
			case EAST:
				moveAmount = r.getBattleFieldWidth() - (r.getX() + r.getWidth() + 1);
				break;
			case SOUTH:
				moveAmount = r.getY() - (r.getHeight() + 1);
				break;
			default:
				moveAmount = r.getX() - (r.getWidth() + 1);
				break;
		}		
	}

	@Override
	public void tick(LaboRobot02 r) {
		this.recalculateMoveAmount(r);
		// Look before we turn when ahead() completes.
		peek = true;
		// Move up the wall
		r.ahead((int) moveAmount);
		// Don't look now
		peek = false;

		r.turnRight(90);

	}

	@Override
	public void onScannedRobot(LaboRobot02 r, ScannedRobotEvent e) {
		r.fire(5);
		// Note that scan is called automatically when the robot is moving.
		// By calling it manually here, we make sure we generate another scan event if
		// there's a robot on the next
		// wall, so that we do not start moving up it until it's gone.
		if (peek) {
			r.scan();
		}
	}

	public void onHitRobot(LaboRobot02 r, HitRobotEvent e) {
		// If he's in front of us, set back up a bit.
		if (e.getBearing() > -90 && e.getBearing() < 90) {
			r.back(100);
		} // else he's in back of us, so set ahead a bit.
		else {
			r.ahead(100);
		}
	}

	@Override
	public void onHitByBullet(LaboRobot02 r, HitByBulletEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onHitWall(LaboRobot02 r, HitWallEvent e) {
//		r.turnRight(90);
	}

	@Override
	public void prepare(LaboRobot02 r) {
		// Do not take extra precautions
		peek = false;

		// Face a wall and move the right amount
		r.turnLeft(r.getHeading() % 90);
		this.recalculateMoveAmount(r);
		r.ahead((int) moveAmount);

		// Watch out for the enemies
		peek = true;
		r.turnGunRight(90);
	}
}
