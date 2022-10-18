package org.example;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int number = 1;
        Store store = new Store("Спар");
        fillStore(store);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(showMenu(store, number));
            String input = scanner.nextLine();
            number = processingRequest(store, number, input);
            if (number == 0) {
                System.out.println("Программа завершилась");
                break;
            }
        }
    }

    public static int processingRequest(Store store, int number, String input) {
        int newNumber;
        switch (number) {
            case 1:
                newNumber = Integer.parseInt(input);
                store.criateNewOrder();
                return number * 10 + newNumber;
            case 11:
                newNumber = Integer.parseInt(input);
                if (newNumber == 1)
                    store.standartStock();
                if (newNumber == 0)
                    return number / 10;
                else
                    return number * 10 + newNumber;
            case 12:
                newNumber = Integer.parseInt(input);
                store.reloadOrder(newNumber);
                return 11;

            case 111:
                String parts[] = input.split(" ");
                if (parts.length == 2) {
                    int productNumber = Integer.parseInt(parts[0]) - 1;
                    int productCount = Integer.parseInt(parts[1]);
                    store.addInOrder(productNumber, productCount);
                } else {
                    newNumber = Integer.parseInt(input);
                    if (newNumber == 0) {
                        return number / 10;
                    } else {
                        System.out.println("Вы ввели неверный заказ");
                        return 111;
                    }
                }
                return 111;
            case 112:
                store.filterStockByName(input);
                return 111;
            case 113:
                String parts2[] = input.split(" ");
                if (parts2.length == 2) {
                    int min = Integer.parseInt(parts2[0]);
                    int max = Integer.parseInt(parts2[1]);
                    store.filterStockByPrice(min, max);
                } else {
                    System.out.println("Вы неверно ввели значения");
                }
                return 111;
            case 114:
                return 11;

            case 115:
                return 1;

            default:
                return number / 10;
        }
    }

    public static String showMenu(Store store, int number) {
        switch (number) {
            case 1:
                return "Выберете действие:" +
                        "\n1. Создать новый заказ" +
                        "\n2. Повторить заказ" +
                        "\n0. Выйти из программы";
            case 11:
                return "Выберете действие:" +
                        "\n1. Добавить товар из списка" +
                        "\n2. Поиск по имени товара" +
                        "\n3. Поиск товара по цене" +
                        "\n4. Показать промежуточный заказ" +
                        "\n5. Завершить оформление заказа" +
                        "\n0. Вернуться в предыдущее меню";
            case 12:
                return "Выберете заказ для повторного добавления из списка:\n" +
                        store.showOrders() +
                        "0. Вернуться в предыдущее меню";

            case 111:
                return "Выберете товар из списка и через пробел укажите количество:\n" +
                        store.showStock() +
                        "0. Вернуться в предыдущее меню";
            case 112:
                return "Введите имя товара";

            case 113:
                return "Введите минимальную цену и через пробел максимальную";

            case 114:
                return store.showOrder() +
                        "\nНажмите Enter для продолжения";
            case 115:
                return store.completeOrder() +
                        "\nбыл оформлен.Нажмите Enter для продолжения";
        }
        return "Вы выбрали несуществующий пункт. Нажмите любую клавишу для продолжения.";
    }


    public static void fillStore(Store store) {
        //Don’t Repeat Yourself. Добавление продукта на склад вынесено в отдельный метод
        store.addProuduct("Хлеб", 100, 50);
        store.addProuduct("Яблоки", 10, 55);
        store.addProuduct("Молоко", 50, 75);
    }
}

















/*
    Scanner scanner = new Scanner(System.in);
    String[] products = {"Хлеб", "Яблоки", "Молоко"};
    int[] prices = {50, 14, 80};
    int[] count = {0, 0, 0};
    int sumProducts = 0;

        System.out.println("Список возможных товаров для покупки");
                for (int i=0;i<products.length;i++)
        {
        System.out.println((i+1)+". "+products[i]+" "+prices[i]+" руб/шт");
        }

        while(true){
        System.out.println("Выберите товар и количество или введите `end`");
        String input=scanner.nextLine();
        if("end".equals(input)){
        break;
        }

        String parts[]=input.split(" ");
        int productNumber = Integer.parseInt(parts[0])-1;
        int productCount = Integer.parseInt(parts[1]);
        count[productNumber]+=productCount;
        }

        System.out.println("Ваша корзина:");
        System.out.println("Наименование товара   Количество  Цена/за.ед  Общая стоимость");
        for (int i=0;i<products.length;i++)
        {
        sumProducts+=prices[i]*count[i];
        System.out.println(products[i]+"\t\t"+prices[i]+"\t\t"+count[i]+"\t\t"+(prices[i]*count[i]));
        }
        System.out.println("Итого:\t\t\t\t\t\t"+sumProducts);


 */