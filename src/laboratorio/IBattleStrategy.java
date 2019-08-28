package laboratorio;

import robocode.ScannedRobotEvent;

/**
 * IBattleStrategy
 */
public interface IBattleStrategy {

    void tick(LaboRobot r);

    void onScannedRobot(LaboRobot r, ScannedRobotEvent e);

    void onHitByBullet(LaboRobot r);

    void onHitWall(LaboRobot r);
}