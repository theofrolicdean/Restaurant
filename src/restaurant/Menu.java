package restaurant;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Menu {
	private String name;
    private List<Food> items = new ArrayList<Food>();
    private static final NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
    
    public Menu(String name) {
        this.name = name;
    }
    
    public void add(Food food) {
        items.add(food);
    }
    
    public void showItems() {
        System.out.println(name.toUpperCase() + " MENU:");
        for (Food food : items) 
            System.out.println("- " + food.getName() + ": " + currencyFormatter.format(food.getPrice()));
    }
    
    public Food getFood(String name) {
        for (Food food : items) 
            if (food.getName().equals(name)) return food;
        return null;
    }
}
