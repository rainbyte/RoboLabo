package laboratorio02;

import robocode.AdvancedRobot;
import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;

/**
 * BattleStrategyCatedra
 */
public class BattleStrategyCatedra implements IBattleStrategy {
    @Override
    public void tick(AdvancedRobot r) {
        r.ahead(100);
        r.turnGunRight(360);
        r.back(100);
        r.turnGunRight(360);
    }

    @Override
    public void onScannedRobot(AdvancedRobot r, ScannedRobotEvent e) {
        r.fire(1);
    }

    @Override
    public void onHitByBullet(AdvancedRobot r, HitByBulletEvent e) {
        r.back(10);
    }

    @Override
    public void onHitWall(AdvancedRobot r, HitWallEvent e) {
        r.back(20);
    }

    @Override
    public void onHitRobot(AdvancedRobot r, HitRobotEvent e) {
        // TODO Auto-generated method stub

    }
}