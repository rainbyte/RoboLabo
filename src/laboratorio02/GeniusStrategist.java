package laboratorio02;

/**
 * Strategist
 */
public class GeniusStrategist implements IStrategist{
    /**
     * RobotStatus    
     */
    private class RobotStatus implements IRobotStatus {
        final Energy energy;
        final Position position;

        RobotStatus(Position position, Energy energy) {
            this.energy = energy;
            this.position = position;
        }

        @Override
        public Position getPosition() {
            return position;
        }

        @Override
        public Energy getEnergy() {
            return energy;
        }
    
    }

    IBattleStrategy battleStrategy = new BattleStrategyCrazy();

    private static final GeniusStrategist INSTANCE = new GeniusStrategist();

    public static GeniusStrategist getInstance() {
        return INSTANCE;
    }

    private GeniusStrategist() {
    }

    @Override
    public IBattleStrategy getStrategy(IRobotStatus rstatus) {
        if(rstatus.getEnergy().value < 50){
            this.battleStrategy = new BattleStrategyWalls();
        }
        return battleStrategy;
    }

    @Override
    public IRobotStatus genStatus(Position p, Energy e) {
        return new RobotStatus(p, e);
    }
}