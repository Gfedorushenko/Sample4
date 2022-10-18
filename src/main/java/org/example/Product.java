package org.example;

public class Product {
    //SOLID (Single Responsibility Principle). В классе продукт содержится информация только о продуктах
    protected String name;
    protected int price;
    protected int count;

    protected int reting;

    //SOLID (Open Closed Principle). Чтение и изменение переменных возможно только через get и set

    public Product(String name, int count, int price) {
        this.price = price;
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        int result = name == null ? 0 : name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Product c = (Product) o;
        return name.equals(c.getName());
    }
}
