package laboratorio;

import robocode.HitByBulletEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;
import robocode.HitRobotEvent;

/**
 * IBattleStrategy
 */
public interface IBattleStrategy {

    void tick(LaboRobot r);

    void onScannedRobot(LaboRobot r, ScannedRobotEvent e);

    void onHitByBullet(LaboRobot r, HitByBulletEvent e);

    void onHitWall(LaboRobot r, HitWallEvent e);
    
    void onHitRobot(LaboRobot r, HitRobotEvent e);
    
    default void prepare(LaboRobot r) {}
}