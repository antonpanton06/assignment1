import java.awt.*;

public class Saab95 extends Car {
    private boolean turboOn;

    public Saab95(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName){
        super(nrDoors, enginePower, currentSpeed, color, modelName);
        this.turboOn = false;
    }
    
    public Saab95() {
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        turboOn = false;
        modelName = "Saab95";
        stopEngine();
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }
}
