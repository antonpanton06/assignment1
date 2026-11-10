import java.awt.*;

public class Volvo240 extends Car {
    private double trimFactor;

    public Volvo240(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName){
        super(nrDoors, enginePower, currentSpeed, color, modelName);
        this.trimFactor = 1.25;
    }

    public Volvo240() {
        this.nrDoors = 4;
        this.color = Color.black;
        this.enginePower = 100;
        this.modelName = "Volvo240";
        stopEngine();
    }
}
