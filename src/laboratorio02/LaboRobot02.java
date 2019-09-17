package laboratorio02;

import java.awt.Color;

import laboratorio02.IStrategist.Energy;
import laboratorio02.IStrategist.Position;
import robocode.*;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/JuniorRobot.html


public class LaboRobot02 extends AdvancedRobot
{
	
	IStrategist strategist = Strategist.getInstance();

	private IBattleStrategy withStrategy() {
		Energy e = new Energy(this.getEnergy());
		Position p = new Position(this.getX(), this.getY());
		return strategist.getStrategy(strategist.genStatus(p, e));
	}

	@Override	
	public void run() {

		setColors(Color.RED, Color.RED, Color.WHITE, Color.RED, Color.BLACK);
		this.withStrategy().prepare(this);
		while(true) {
			this.withStrategy().tick(this);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	@Override
	public void onScannedRobot(ScannedRobotEvent e) {
		this.withStrategy().onScannedRobot(this, e);
	}	

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	@Override
	public void onHitByBullet(HitByBulletEvent e) {
		this.withStrategy().onHitByBullet(this, e);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	@Override
	public void onHitWall(HitWallEvent e) {
		this.withStrategy().onHitWall(this, e);
	}	
	
	public void onHitRobot(HitRobotEvent e) {
		this.withStrategy().onHitRobot(this, e);
	}
}