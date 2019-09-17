package laboratorio02;

import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;

/**
 * BattleStrategyCatedra
 */
public class BattleStrategyCatedra implements IBattleStrategy {
    @Override
    public void tick(LaboRobot02 r) {
        r.ahead(100);
        r.turnGunRight(360);
        r.back(100);
        r.turnGunRight(360);
    }

    @Override
    public void onScannedRobot(LaboRobot02 r, ScannedRobotEvent e) {
        r.fire(1);
    }

    @Override
    public void onHitByBullet(LaboRobot02 r, HitByBulletEvent e) {
        r.back(10);
    }

    @Override
    public void onHitWall(LaboRobot02 r, HitWallEvent e) {
        r.back(20);
    }

    @Override
    public void onHitRobot(LaboRobot02 r, HitRobotEvent e) {
        // TODO Auto-generated method stub

    }
}