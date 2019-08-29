package laboratorio;

import robocode.HitByBulletEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;
import robocode.HitRobotEvent;

/**
 * IBattleStrategy
 */
public interface IBattleStrategy {

    final int NORTH = 0; 
    final int EAST = 90;
    final int SOUTH = 180;
    final int WEST = 270;

    void tick(LaboRobot r);

    void onScannedRobot(LaboRobot r, ScannedRobotEvent e);

    void onHitByBullet(LaboRobot r, HitByBulletEvent e);

    void onHitWall(LaboRobot r, HitWallEvent e);
    
    void onHitRobot(LaboRobot r, HitRobotEvent e);
    
    default void prepare(LaboRobot r) {}
}