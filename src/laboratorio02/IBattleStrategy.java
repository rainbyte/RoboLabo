package laboratorio02;

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

    void tick(LaboRobot02 r);

    void onScannedRobot(LaboRobot02 r, ScannedRobotEvent e);

    void onHitByBullet(LaboRobot02 r, HitByBulletEvent e);

    void onHitWall(LaboRobot02 r, HitWallEvent e);
    
    void onHitRobot(LaboRobot02 r, HitRobotEvent e);
    
    default void prepare(LaboRobot02 r) {}
}