import java.util.*;

interface MealPlan {
    String info();
}

class VegetarianMeal implements MealPlan {
    String name; int calories;
    VegetarianMeal(String name,int calories){ this.name = name; this.calories = calories; }
    public String info(){ return "Vegetarian " + name + " " + calories + " kcal"; }
    public String toString(){ return info(); }
}

class VeganMeal implements MealPlan {
    String name; int calories;
    VeganMeal(String name,int calories){ this.name = name; this.calories = calories; }
    public String info(){ return "Vegan " + name + " " + calories + " kcal"; }
    public String toString(){ return info(); }
}

class KetoMeal implements MealPlan {
    String name; int calories;
    KetoMeal(String name,int calories){ this.name = name; this.calories = calories; }
    public String info(){ return "Keto " + name + " " + calories + " kcal"; }
    public String toString(){ return info(); }
}

class Meal<T extends MealPlan> {
    T plan;
    Meal(T plan){ this.plan = plan; }
    T get(){ return plan; }
    public String toString(){ return plan.toString(); }
}

public class MealPlanGenerator {
    static <T extends MealPlan> Meal<T> generate(T plan){
        return new Meal<>(plan);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Choose meal type 1 Vegetarian 2 Vegan 3 Keto");
        int t = in.nextInt();
        System.out.println("Enter meal name");
        String name = in.next();
        System.out.println("Enter calories");
        int cal = in.nextInt();
        if(t==1){
            Meal<VegetarianMeal> m = generate(new VegetarianMeal(name,cal));
            System.out.println("Generated: " + m);
        } else if(t==2){
            Meal<VeganMeal> m = generate(new VeganMeal(name,cal));
            System.out.println("Generated: " + m);
        } else {
            Meal<KetoMeal> m = generate(new KetoMeal(name,cal));
            System.out.println("Generated: " + m);
        }
    }
}
