public class TemperatureWeightConverter {
    public static void main(String[] args) {
        double f = 98.6;
        double c = (f - 32) * 5 / 9;
        System.out.println("Fahrenheit to Celsius: " + c);

        c = 37.0;
        f = (c * 9 / 5) + 32;
        System.out.println("Celsius to Fahrenheit: " + f);

        double kg = 50.0;
        double lb = kg * 2.20462;
        System.out.println("Kilograms to Pounds: " + lb);

        lb = 110.0;
        kg = lb * 0.453592;
        System.out.println("Pounds to Kilograms: " + kg);

        double liters = 5.0;
        double gallons = liters * 0.264172;
        System.out.println("Liters to Gallons: " + gallons);

        gallons = 1.32;
        liters = gallons * 3.78541;
        System.out.println("Gallons to Liters: " + liters);
    }
}