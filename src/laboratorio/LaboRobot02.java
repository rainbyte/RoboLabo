package laboratorio;
import java.awt.Color;

import robocode.*;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/JuniorRobot.html


public class LaboRobot02 extends AdvancedRobot
{
	IBattleStrategy battleStrategy = new BattleStrategyWalls();

	@Override	
	public void run() {

		setColors(Color.RED, Color.RED, Color.WHITE, Color.RED, Color.BLACK);
		battleStrategy.prepare(this);
		while(true) {
			battleStrategy.tick(this);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	@Override
	public void onScannedRobot(ScannedRobotEvent e) {
		battleStrategy.onScannedRobot(this, e);
	}	

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	@Override
	public void onHitByBullet(HitByBulletEvent e) {
		battleStrategy.onHitByBullet(this, e);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	@Override
	public void onHitWall(HitWallEvent e) {
		battleStrategy.onHitWall(this, e);
	}	
	
	public void onHitRobot(HitRobotEvent e) {
		battleStrategy.onHitRobot(this, e);
	}
}