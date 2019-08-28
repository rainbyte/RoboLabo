package laboratorio;
import robocode.*;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/JuniorRobot.html


public class LaboRobot extends JuniorRobot
{
	IBattleStrategy battleStrategy = new BattleStrategyCatedra();

	@Override	
	public void run() {

		setColors(orange, blue, white, yellow, black);


		while(true) {
			battleStrategy.tick(this);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	@Override
	public void onScannedRobot() {
		battleStrategy.onScannedRobot(this);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	@Override
	public void onHitByBullet() {
		battleStrategy.onHitByBullet(this);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	@Override
	public void onHitWall() {
		battleStrategy.onHitWall(this);
	}	
}