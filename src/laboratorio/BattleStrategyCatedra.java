package laboratorio;

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
    }

    @Override
    public void onScannedRobot(LaboRobot r, ScannedRobotEvent e) {
        r.fire(1);
    }

    @Override
    public void onHitByBullet(LaboRobot r) {
        r.back(10);
    }

    @Override
    public void onHitWall(LaboRobot r) {
        r.back(20);
    }
}