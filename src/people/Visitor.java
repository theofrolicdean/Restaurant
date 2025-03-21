package people;

import java.text.NumberFormat;
import java.util.Locale;

public class Visitor {
	private String name;
    private int totalPrice = 0;
    private static final NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
    
    public Visitor(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void addBill(int price) {
        totalPrice += price;
    }
    
    public void showTotalPrice() {
        System.out.println("\n========== BILL SUMMARY FOR " + name.toUpperCase() + " ==========\n");
        System.out.println("Total bill: " + currencyFormatter.format(totalPrice));
        System.out.println("===================================================\n");
    }
}
