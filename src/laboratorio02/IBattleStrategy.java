package laboratorio02;

import robocode.AdvancedRobot;
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

    void tick(AdvancedRobot r);

    void onScannedRobot(AdvancedRobot r, ScannedRobotEvent e);

    void onHitByBullet(AdvancedRobot r, HitByBulletEvent e);

    void onHitWall(AdvancedRobot r, HitWallEvent e);
    
    void onHitRobot(AdvancedRobot r, HitRobotEvent e);
    
    default void prepare(AdvancedRobot r) {}
}