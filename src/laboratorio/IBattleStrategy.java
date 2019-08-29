package laboratorio;

import robocode.HitByBulletEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;

/**
 * IBattleStrategy
 */
public interface IBattleStrategy {

    void tick(LaboRobot r);

    void onScannedRobot(LaboRobot r, ScannedRobotEvent e);

    void onHitByBullet(LaboRobot r, HitByBulletEvent e);

    void onHitWall(LaboRobot r, HitWallEvent e);
}