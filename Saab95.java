import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;

    public Saab95(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {
        super(nrDoors, enginePower, currentSpeed, color, modelName);
        this.turboOn = false;
    }

    public Saab95() {
        super(2, 125, 0, Color.red, "Saab95");
        this.turboOn = false;
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    public boolean isTurboOn() {
        return turboOn;
    }

    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}
