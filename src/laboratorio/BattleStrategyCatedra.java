package laboratorio;

import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;

/**
 * BattleStrategyCatedra
 */
public class BattleStrategyCatedra implements IBattleStrategy {
    @Override
    public void tick(LaboRobot r) {
        r.ahead(100);
        r.turnGunRight(360);
        r.back(100);
        r.turnGunRight(360);
        if(r.getEnergy() < 50) {
        	r.battleStrategy = new BattleStrategyWalls();
        }
    }

    @Override
    public void onScannedRobot(LaboRobot r, ScannedRobotEvent e) {
        r.fire(1);
    }

    @Override
    public void onHitByBullet(LaboRobot r, HitByBulletEvent e) {
        r.back(10);
    }

    @Override
    public void onHitWall(LaboRobot r, HitWallEvent e) {
        r.back(20);
    }

	@Override
	public void onHitRobot(LaboRobot r, HitRobotEvent e) {
		// TODO Auto-generated method stub
		
	}
}