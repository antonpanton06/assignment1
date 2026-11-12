import java.awt.*;
/*
Car as superclass and the different models as subclasses (inheritance)

The Open-Closed Principle (OCP) states:
Software entities should be open for extension but closed for modification.

In the original structure, if you wanted to add another car model,
you might end up copying methods and attributes from existing classes.

With the new structure, you can simply create another subclass such as BMW for example.
 */

public abstract class Car implements Movable {

    // The direction the car is facing, in order of clockwise
    public enum Direction {
        NORTH, EAST, SOUTH, WEST }

    // The shared attributes of a car:
    private final int nrDoors; // Number of doors on the car
    protected final double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car, not final because we want to be able to change value
    private Color color; // Color of the car, not final because we want to be able to change value
    private final String modelName; // The car model name

    // Start values for the positioning of the car
    private double x = 0;
    private double y = 0;
    private Direction direction = Direction.NORTH;

    // Conductor:
    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
    }
    // Getters (methods to call the different values):
    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public String getModelName() {
        return modelName;
    }

    // Setters and the common functionalities of a car (to prevent duplication of code):
    public void setColor(Color clr) {
        this.color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    protected abstract double speedFactor();

    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
    }

    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public Direction getDirection() { return direction; }

    @Override
    public void move(){
        switch (direction) {
            case NORTH -> y += currentSpeed;
            case SOUTH -> y -= currentSpeed;
            case EAST -> x += currentSpeed;
            case WEST -> x -= currentSpeed;
        }
    }

    @Override
    public void turnLeft(){
      direction = Direction.values()[(direction.ordinal() + 3) % 4];
    }

    @Override
    public void turnRight() {
        direction = Direction.values()[(direction.ordinal() + 1) % 4];
    }

    // TODO fix this method according to assignment pm
    public void gas(double amount) {
        if (amount < 0 || amount > 1){ throw new IllegalArgumentException("Amounts cannot be less than 0 or more than 1");}
        incrementSpeed(amount);
    }

    // TODO fix this method according to assignment pm
    public void brake(double amount) {
        if (amount < 0 || amount > 1){ throw new IllegalArgumentException("Amounts cannot be less than 0 or more than 1");}
        decrementSpeed(amount);
    }
}