package laboratorio;

/**
 * IStrategist
 */
public interface IStrategist {
    class Position {
        final double x;
        final double y;
        Position(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    class Energy {
        final double value;
        Energy(double value) {
            this.value = value;
        }
    }

    interface IRobotStatus {
        Position getPosition();
        Energy getEnergy();
    }

    public IBattleStrategy getStrategy(IRobotStatus rs);

    public IRobotStatus genStatus(Position p, Energy e);
}