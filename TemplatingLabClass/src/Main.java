import java.util.*;

interface Ingredient{
    String getName();
    double getQuantity();
}

class SolidIngredient implements Ingredient{
    private String _ingredient;
    private double _quantityInGrams;
    public SolidIngredient(String i, double q){
        _ingredient = i;
        _quantityInGrams = q;
    }
    public String getName(){return _ingredient;}
    public double getQuantity(){return _quantityInGrams;}
}

class LiquidIngredient implements Ingredient{
    private String _ingredient;
    private double _quantityInML;
    public LiquidIngredient(String i, double q){
        _ingredient = i;
        _quantityInML = q;
    }
    public String getName(){return _ingredient;}
    public double getQuantity(){return _quantityInML;}
}

class Recipe<T extends Ingredient>{
    private String _name;
    private String _instructions;
    private ArrayList<T> _ingredients;
    public Recipe(String name, String instructions){
        _name = name;
        _instructions = instructions;
        _ingredients = new ArrayList<>();
    }
    public void addIngredient(T t){
        _ingredients.add(t);
    }

    public ArrayList<T> getIngredients(){
        return _ingredients;
    }
    public void print(){
        System.out.println("Recipe: " + _name);
        System.out.println("Instructions: " + _instructions);
        System.out.println("Ingredients: ");
        for(T t: _ingredients){
            System.out.println("- " + t.getName() + ": " + t.getQuantity());
        }
        System.out.println("___________________________________________________");
    }

}

public class Main {
    public static int menu(Scanner scan){
        int choice = 0;
        System.out.println("1. Add Ingredient");
        System.out.println("2. Show Ingredient List");
        System.out.println("3. Quit");
        try {
            choice = Integer.parseInt(scan.nextLine());
            while(choice > 3 || choice < 0){
                System.out.println("Invalid, try again");
                choice = Integer.parseInt(scan.nextLine());
            }
        }
        catch(InputMismatchException | NumberFormatException e){
            System.out.println("Invalid data entered");
            System.exit(-1);
        }
        return choice;
    }

    public static void addIngredient(Recipe<Ingredient> recipe, Scanner scan){
        String name;
        String dryOrLiquid;
        double quantity = 0;

        System.out.println("Dry or Liquid: (d/l)");
        dryOrLiquid = scan.nextLine().toLowerCase();
        while(dryOrLiquid.length() != 1){
            System.out.println("Error, must enter 'd' or 'l'.");
            System.out.println("Dry or Liquid: (d/l) ");
            dryOrLiquid = scan.nextLine().toLowerCase();
        }

        System.out.println("Name of ingredient: ");
        name = scan.nextLine();

        System.out.println("Quantity: ");
        try{
            quantity = Double.parseDouble(scan.nextLine());
        }
        catch(NumberFormatException e){
            System.out.println("Error");
            System.exit(-1);
        }

        Ingredient ingredient;
        if (dryOrLiquid.charAt(0) == 'd') {
            ingredient = new SolidIngredient(name, quantity);
            recipe.addIngredient(ingredient);
            System.out.println("Added Dry ingredient");
        }

        else if (dryOrLiquid.charAt(0) == 'l') {
            ingredient = new LiquidIngredient(name, quantity);
            recipe.addIngredient(ingredient);
            System.out.println("Added Dry ingredient");
        }
        else {
            System.out.println("Error, 'd' or 'l' was not chosen");
        }
    }

    public static void main(String[] args) {
        Recipe<Ingredient> recipe;
        Scanner scan = new Scanner(System.in);

        System.out.println("Recipe name: ");
        String name = scan.nextLine();

        System.out.println("Instructions: ");
        String instructions = scan.nextLine();

        recipe = new Recipe<>(name, instructions);
        int choice = menu(scan);

        while(choice != 3) {
            if (choice == 1)
                addIngredient(recipe, scan);
            else
                recipe.print();

            choice = menu(scan);
        }
        System.out.println("Goodbye");
    }
}