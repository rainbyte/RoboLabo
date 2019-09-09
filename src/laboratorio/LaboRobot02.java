package laboratorio;
import java.awt.Color;

import robocode.*;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/JuniorRobot.html


public class LaboRobot02 extends AdvancedRobot
{
	public class StrategistWalls{
		IBattleStrategy battleStrategy = new BattleStrategyWalls();
		public IBattleStrategy getStrategy() {
			return battleStrategy;
		}
	}
	
	StrategistWalls strategist = new StrategistWalls();

	@Override	
	public void run() {

		setColors(Color.RED, Color.RED, Color.WHITE, Color.RED, Color.BLACK);
		strategist.getStrategy().prepare(this);
		while(true) {
			strategist.getStrategy().tick(this);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	@Override
	public void onScannedRobot(ScannedRobotEvent e) {
		strategist.getStrategy().onScannedRobot(this, e);
	}	

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	@Override
	public void onHitByBullet(HitByBulletEvent e) {
		strategist.getStrategy().onHitByBullet(this, e);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	@Override
	public void onHitWall(HitWallEvent e) {
		strategist.getStrategy().onHitWall(this, e);
	}	
	
	public void onHitRobot(HitRobotEvent e) {
		strategist.getStrategy().onHitRobot(this, e);
	}
}