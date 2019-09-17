package laboratorio02;

import robocode.AdvancedRobot;
import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;

/**
 * BattleStrategyRamFire
 */
public class BattleStrategyVelociRobot implements IBattleStrategy {
    private double velocityRate; // Pixels per turn
	private double turnRate; // Radians per turn
	private double gunRotationRate; // Radians per turn
    private double radarRotationRate; // Radians per turn
    private int turnCounter = 0;

    @Override
    public void tick(AdvancedRobot r) {
        if (turnCounter % 64 == 0) {
            // Straighten out, if we were hit by a bullet and are turning
            this.turnRate = 0;
            // Go forward with a velocity of 4
            this.velocityRate = 4;
        }
        if (turnCounter % 64 == 32) {
            // Go backwards, faster
            this.velocityRate = -6;
        }
        turnCounter++;

        r.setMaxVelocity(this.velocityRate);
		if (this.velocityRate > 0) {
			r.setAhead(Double.POSITIVE_INFINITY);
		} else if (velocityRate < 0) {
			r.setBack(Double.POSITIVE_INFINITY);
		} else {
			r.setAhead(0);
		}

		r.setTurnGunRightRadians(gunRotationRate); 			
		r.setTurnRadarRightRadians(radarRotationRate); 
		r.setTurnRightRadians(turnRate);
    }

    @Override
    public void onScannedRobot(AdvancedRobot r, ScannedRobotEvent e) {
        r.fire(1);
    }

    @Override
    public void onHitByBullet(AdvancedRobot r, HitByBulletEvent e) {
        this.turnRate = 5;
    }

    @Override
    public void onHitWall(AdvancedRobot r, HitWallEvent e) {
        this.velocityRate *= -1;
    }

    @Override
    public void onHitRobot(AdvancedRobot r, HitRobotEvent e) {
    }
}