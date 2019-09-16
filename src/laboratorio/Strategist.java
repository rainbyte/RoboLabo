package laboratorio;

/**
 * Strategist
 */
public class Strategist implements IStrategist{
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

    IBattleStrategy battleStrategy = new BattleStrategyWalls();

    @Override
    public IBattleStrategy getStrategy(IRobotStatus rstatus) {
        return battleStrategy;
    }

    @Override
    public IRobotStatus genStatus(Position p, Energy e) {
        return new RobotStatus(p, e);
    }
}