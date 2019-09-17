package laboratorio02;

import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;

/**
 * BattleStrategyRamFire
 */
public class BattleStrategyRamFire implements IBattleStrategy {
    int turnDirection = 1;

    @Override
    public void tick(LaboRobot02 r) {
        r.turnRight(5 * turnDirection);
    }

    @Override
    public void onScannedRobot(LaboRobot02 r, ScannedRobotEvent e) {
		if (e.getBearing() >= 0) {
			turnDirection = 1;
		} else {
			turnDirection = -1;
		}

		r.turnRight(e.getBearing());
		r.ahead(e.getDistance() + 5);
		r.scan(); // Might want to move ahead again!
    }

    @Override
    public void onHitByBullet(LaboRobot02 r, HitByBulletEvent e) {
    }

    @Override
    public void onHitWall(LaboRobot02 r, HitWallEvent e) {
    }

    @Override
    public void onHitRobot(LaboRobot02 r, HitRobotEvent e) {
        if (e.getBearing() >= 0) {
			turnDirection = 1;
		} else {
			turnDirection = -1;
		}
		r.turnRight(e.getBearing());

		// Determine a shot that won't kill the robot...
		// We want to ram him instead for bonus points
		if (e.getEnergy() > 16) {
			r.fire(3);
		} else if (e.getEnergy() > 10) {
			r.fire(2);
		} else if (e.getEnergy() > 4) {
			r.fire(1);
		} else if (e.getEnergy() > 2) {
			r.fire(.5);
		} else if (e.getEnergy() > .4) {
			r.fire(.1);
		}
		r.ahead(40); // Ram him again!
    }
}