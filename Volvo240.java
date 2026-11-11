import java.awt.*;

public class Volvo240 extends Car {

    private final double trimFactor;

    public Volvo240(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {
        super(nrDoors, enginePower, currentSpeed, color, modelName);
        this.trimFactor = 1.25;
    }

    public Volvo240() {
        super(4,100,0,Color.black,"Volvo240");
        this.trimFactor = 0;
    }

    public double getTrimFactor(){
        return trimFactor;
    }
}
