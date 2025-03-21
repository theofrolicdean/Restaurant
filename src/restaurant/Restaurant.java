package restaurant;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import people.Chef;

public class Restaurant {
	private String name;
    private ArrayList<Menu> menus = new ArrayList<Menu>();
    private ArrayList<Chef> chefs = new ArrayList<Chef>();
    private int totalIncome = 0;
    private static final NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
    
    public Restaurant(String name) {
        this.name = name;
    }
    
    public void addMenu(Menu menu) {
        menus.add(menu);
    }
    
    public void showMenu() {
        System.out.println("\n========== MENU " + name.toUpperCase() + " ==========\n");
        for (Menu menu : menus) 
            menu.showItems();
        System.out.println("=======================================\n");
    }
    
    public void addChef(people.Chef chef) {
        chefs.add(chef);
    }
    
    public void showChef() {
        System.out.println("\n========== LIST OF CHEFS ==========\n");
        for (people.Chef chef : chefs) 
            System.out.println("- " + chef.getName());
        System.out.println("==================================\n");
    }
    
    public void order(people.Chef chef, people.Visitor visitor, String foodName, int quantity) {
        for (Menu menu : menus) {
            Food food = menu.getFood(foodName);
            if (food != null) {
                int price = food.getPrice() * quantity;
                visitor.addBill(price);
                chef.addCookHistory(foodName, quantity);
                totalIncome += price;
                System.out.println(visitor.getName() + " ordered " + quantity + " " + foodName + " cooked by " + chef.getName());
                return;
            }
        }
        System.out.println("Food " + foodName + " not found!");
    }
    
    public void showTotalIncome() {
        System.out.println("\n========== TOTAL INCOME ==========\n");
        System.out.println("Total income: " + currencyFormatter.format(totalIncome));
        System.out.println("=================================\n");
    }
}
