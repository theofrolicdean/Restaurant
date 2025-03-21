package people;

import java.util.HashMap;
import java.util.Map;

public class Chef {
	private String name;
    private Map<String, Integer> cookHistory = new HashMap<String, Integer>();
    
    public Chef(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void addCookHistory(String food, int quantity) {
        cookHistory.put(food, cookHistory.getOrDefault(food, 0) + quantity);
    }
    
    public void showCookHistory() {
        System.out.println("\n========== COOK HISTORY OF " + name.toUpperCase() + " ==========\n");
        for (Map.Entry<String, Integer> entry : cookHistory.entrySet()) 
            System.out.println("- " + entry.getKey() + ": " + entry.getValue());
        System.out.println("===========================================\n");
    }
}
