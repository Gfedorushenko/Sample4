package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Store implements Stock, Order {
    //SOLID (Interface Segregation Principle) Методы разделены на разные интерфейсы по их назначению.
    //SOLID (Liskov Substitution Principle). Нет наследования от класса, но методы имлементируются только в том класса, где они требуются.
    protected Random random = new Random();
    ;
    protected String title;
    protected List<Product> stock = new ArrayList<>();

    protected List<Product> filtrStock = new ArrayList<>();

    protected List<String> orders = new ArrayList<>();

    protected String newOrder;

    public Store(String title) {
        this.title = title;
    }

    public void addProuduct(String name, int count, int price) {
        stock.add(new Product(name, count, price));
    }

    public String showOrders() {
        String orderList = "";
        int counter = 1;
        for (String order : orders) {
            orderList += counter + ". " + order + "\n";
            counter++;
        }
        return orderList;
    }

    @Override
    public void addInOrder(int number, int count) {
        //Принцип избегания магических чисел. Используется размер листа, вместо конкретного значения
        if (stock.size() > number) {
            if (count > 0) {
                newOrder += stock.get(number) + " " + count + "*" + stock.get(number).getPrice() + "=" + (count * stock.get(number).getPrice()) + "\n";
            }
        } else {
            System.out.println("Позици " + (number + 1) + " отсутствует в списке товаров");
        }
    }

    @Override
    public void criateNewOrder() {
        newOrder = "";
    }

    @Override
    public String completeOrder() {
        orders.add("Заказ № " + random.nextInt(10000000) + ":\n" + newOrder);
        newOrder = "";
        return orders.get(orders.size() - 1);
    }

    @Override
    public String showOrder() {
        return newOrder;
    }

    @Override
    public void reloadOrder(int number) {
        if (orders.size() >= number) {
            String parts[] = orders.get(number - 1).split(":\n");
            newOrder = parts[1];
            System.out.println("Продукты из заказа были доавлены в корзину");
        } else {
            System.out.println("Заказ " + number + " отсутствует в списке заказов");
        }
    }

    public void standartStock() {
        filtrStock = stock;
    }

    @Override
    public void filterStockByName(String name) {
        filtrStock = stock.stream()
                .filter(value -> value.getName().contains(name))
                .collect(Collectors.toList());
    }

    @Override
    public void filterStockByPrice(int min, int max) {
        filtrStock = stock.stream()
                .filter(x -> x.getPrice() >= min)
                .filter(x -> x.getPrice() <= max)
                .collect(Collectors.toList());
    }

    @Override
    public String showStock() {
        String text = "";
        int counter = 1;
        for (Product product : filtrStock) {
            text += counter + ". " + product.getName() + " " + product.getPrice() + " руб\n";
            counter++;
        }
        return text;
    }
}
