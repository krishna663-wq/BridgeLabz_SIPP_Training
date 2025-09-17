interface Vehicle {
    void start();
    void stop();
    default void honk() {
        System.out.println("Honking... Beep Beep!");
    }
    static void serviceReminder() {
        System.out.println("All vehicles must be serviced every 6 months!");
    }
}

class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car started");
    }
    @Override
    public void stop() {
        System.out.println("Car stopped");
    }
}

class Bike implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bike started");
    }
    @Override
    public void stop() {
        System.out.println("Bike stopped");
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle bike = new Bike();
        car.start();
        car.honk();
        bike.start();
        Vehicle.serviceReminder();
    }
}
