package org.example;

public interface Order {
    public void criateNewOrder();

    public String completeOrder();

    public void reloadOrder(int number);

    public void addInOrder(int number, int count);

    public String showOrder();
}
