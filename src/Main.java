//Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
//        Создать множество ноутбуков.
//        Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
//        отвечающие фильтру. Критерии фильтрации можно хранить в Map.
//        Например: “Введите цифру, соответствующую необходимому критерию:
//        1 - ОЗУ
//        2 - Объем ЖД
//        3 - Операционная система
//        4 - Цвет …
//        Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
//        Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.


import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<Laptop> laptopList = new ArrayList<>();
        Laptop ID1 = new Laptop("Apple", 4, 128, "Mac", "white");
        Laptop ID2 = new Laptop("HP", 4, 256, "Windows10", "black");
        Laptop ID3 = new Laptop("DELL", 8, 128, "Windows10", "pink");
        Laptop ID4 = new Laptop("Lenovo", 8, 512, "Windows10", "black");
        Laptop ID5 = new Laptop("Acer", 16, 256, "Windows11", "grey");
        Laptop ID6 = new Laptop("Asus", 16, 1000, "Windows11", "white");
        Laptop ID7 = new Laptop("Samsung", 16, 512, "Linux", "red");
        Laptop ID8 = new Laptop("Panasonic", 32, 512, "Linux", "red");
        Laptop ID9 = new Laptop("Huawei", 32, 128, "Windows11", "black");
        Laptop ID10 = new Laptop("Honor", 64, 2000, "Linux", "black");

        laptopList.add(ID1);
        laptopList.add(ID2);
        laptopList.add(ID3);
        laptopList.add(ID4);
        laptopList.add(ID5);
        laptopList.add(ID6);
        laptopList.add(ID7);
        laptopList.add(ID8);
        laptopList.add(ID9);
        laptopList.add(ID10);

        var map = customerChoice();
        var list = getResultListLaptop(laptopList,map);
        printResultListLaptop(list);
    }

    public static Map<String, Object> customerChoice() {
        Map<String, Object> map = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("""
                    \nМеню:
                    1 - Бренд
                    2 - ОЗУ
                    3 - Объем ЖД
                    4 - Операционная система
                    5 - Цвет
                    6 - Просмотр ноутбуков по выбранным критериям\n
                    Введите цифру, соответствующую необходимому критерию: """);
            String choice = scan.next();

            switch (choice) {
                case "1" -> {
                    System.out.print("Введите название бренда: ");
                    String brand = scan.next();
                    map.put("brand", brand);
                }
                case "2" -> {
                    while (true){
                        System.out.print("Введите минимальное значение ОЗУ: ");
                        String size_RAM = scan.next();
                        if(isDigit(size_RAM)){
                            map.put("size_RAM", Integer.parseInt(size_RAM));
                            break;
                        }
                        else System.out.println("Вы ввели не число!");
                    }
                }
                case "3" -> {
                    while (true){
                        System.out.print("Введите минимальный объем ЖД: ");
                        String size_HD = scan.next();
                        if(isDigit(size_HD)){
                            map.put("size_HD", Integer.parseInt(size_HD));
                            break;
                        }
                        else System.out.println("Вы ввели не число!");
                    }
                }
                case "4" -> {
                    System.out.print("Введите название ОС: ");
                    String name_OS = scan.next();
                    map.put("name_OS", name_OS);
                }
                case "5" -> {
                    System.out.print("Введите цвет: ");
                    String color = scan.next();
                    map.put("color", color);
                }
                case "6" -> {
                    scan.close();
                    return map;
                }
                default -> System.out.print("Значение не соответствует пункту меню!\n");
            }
        }
    }
    public static List<Laptop> getResultListLaptop(List<Laptop> laptopList, Map<String, Object> map) {
        List<Laptop> resaltList = new ArrayList<>();
        for (Laptop item : laptopList) {
            if (item.compareBrand(map) && item.compareColor(map) && item.compareHD(map) && item.compareOS(map) && item.compareRam(map)) {
                resaltList.add(item);
            }
        }
        return resaltList;
    }
    public static void printResultListLaptop(List<Laptop> resList) {
        if (!resList.isEmpty()) {
            System.out.println("\nНоутбуки по выбранным параметрам:");
            for (Laptop item : resList)
                System.out.println(item);
        } else System.out.println("\nНоутбуков по выбранным параметрам нет.");
    }
    public static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}




