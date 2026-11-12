public class Main {
    public static void main(String[] args) {
        Car car = new Volvo240();
        System.out.println(car.getDirection());
        car.turnLeft();
        System.out.println(car.getDirection());

    }
}
