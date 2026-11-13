public class CarTest {
    private static void reportResult(String testName, boolean success) {
        IO.println((success ? "SUCCESS: " : "FAILURE: ") + testName);
    }

    /** Tests whether a Saab with turbo enabled
     *  gains more speed than one without.
     */
    private static void testTurbo() {
        Saab95 slowSaab = new Saab95();
        Saab95 fastSaab = new Saab95();
        fastSaab.setTurboOn();
        slowSaab.setTurboOff();
        fastSaab.gas(0.5);
        slowSaab.gas(0.5);
        boolean result = slowSaab.getCurrentSpeed() < fastSaab.getCurrentSpeed();
        reportResult("Turbo yields more speed", result);
    }

    /** Tests that a car facing north moves along the y-axis by it speed. */
    private static void testMoveForward() {
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        volvo.move();
        boolean result1 = volvo.getY() == volvo.getCurrentSpeed() && volvo.getX() == 0;
        reportResult("Car facing north moves along y by its speed", result1);
        volvo.turnRight();
        volvo.move();
        boolean result2 = volvo.getY() == 0.1 && volvo.getX() == volvo.getCurrentSpeed();
        reportResult("Car facing east and moved along x by its speed", result2);

    }

    /** Tests that gas() and brake() only accept values in 0, 1. */
    private static void testAmountInRange() {
        Volvo240 volvo = new Volvo240();
        boolean gasRejected = false;
        boolean brakeRejected = false;
        try {
            volvo.gas(1.5);
        } catch (IllegalArgumentException e) {
            gasRejected = true;
        }
        try {
            volvo.brake(-0.5);
        } catch (IllegalArgumentException e) {
            brakeRejected = true;
        }
        reportResult("gas and brake only accept values in [0, 1]", gasRejected && brakeRejected);
    }

    /** Tests that currentSpeed never goes above enginePower. */
    private static void testSpeedNotAboveEnginePower() {
        Volvo240 volvo = new Volvo240();
        for (int i = 0; i < 200; i++) {
            volvo.gas(1);
        }
        reportResult("Speed never exceeds enginePower",
                volvo.getCurrentSpeed() <= volvo.getEnginePower());
    }

    /** Tests that currentSpeed never goes below 0. */
    private static void testSpeedNotBelowZero() {
        Saab95 saab = new Saab95();
        saab.brake(1);
        reportResult("Speed never goes below 0", saab.getCurrentSpeed() >= 0);
    }

    /** Tests that gas() cant decrease speed. */
    private static void testGasDoesNotDecreaseSpeed() {
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        double before = volvo.getCurrentSpeed();
        volvo.gas(0.5);
        reportResult("gas does not decrease speed", volvo.getCurrentSpeed() >= before);
    }

    /** Tests that brake() cant increase speed. */
    private static void testBrakeDoesNotIncreaseSpeed() {
        Volvo240 volvo = new Volvo240();
        volvo.gas(1);
        double before = volvo.getCurrentSpeed();
        volvo.brake(0.5);
        reportResult("brake does not increase speed", volvo.getCurrentSpeed() <= before);
    }

    static void main() {
        testTurbo();
        testMoveForward();
        testAmountInRange();
        testSpeedNotAboveEnginePower();
        testSpeedNotBelowZero();
        testGasDoesNotDecreaseSpeed();
        testBrakeDoesNotIncreaseSpeed();
    }
}
