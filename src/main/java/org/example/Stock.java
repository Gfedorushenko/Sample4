package org.example;

public interface Stock {
    public String showStock();

    public void filterStockByName(String name);

    public void filterStockByPrice(int min, int max);
}
