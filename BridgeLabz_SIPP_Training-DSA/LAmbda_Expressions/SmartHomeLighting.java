interface LightBehavior {
    void activate();
}

public class SmartHomeLighting {
    public static void main(String[] args) {
        LightBehavior motionSensor = () -> System.out.println("Lights ON due to motion detected!");
        LightBehavior eveningTime = () -> System.out.println("Soft yellow lights ON for evening mode!");
        LightBehavior voiceCommand = () -> System.out.println("Lights dimmed on voice command!");

        motionSensor.activate();
        eveningTime.activate();
        voiceCommand.activate();
    }
}
