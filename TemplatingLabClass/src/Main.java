import java.util.*;

interface Ingredient{
    String getName();
    double getQuantity();
}

class SolidIngredient implements Ingredient{
    private String _ingredient;
    private double _quantity;
    public SolidIngredient(String i, double q){
        _ingredient = i;
        _quantity = q;
    }
    public String getName(){return _ingredient;}
    public double getQuantity(){return _quantity;}
}

class LiquidIngredient implements Ingredient{
    private String _ingredient;
    private double _quantity;
    public LiquidIngredient(String i, double q){
        _ingredient = i;
        _quantity = q;
    }
    public String getName(){return _ingredient;}
    public double getQuantity(){return _quantity;}
}

class Recipe<T extends Ingredient>{
    private String _name;
    private String _instructions;
    private ArrayList<T> _ingredients;
    public Recipe(String name, String instructions, ArrayList<T> ingredients){
        _name = name;
        _instructions = instructions;
        _ingredients = ingredients;
    }
    public void addIngredient(T t){
        _ingredients.add(t);
    }
    public void print(){
        System.out.println(_name);
        System.out.println(_instructions);
        System.out.println(_ingredients);
    }

}

public class Main {
    public static void main(String[] args) {
        int choice = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Add Ingredient");
        System.out.println("2. Show Ingredient List");
        
    }
}