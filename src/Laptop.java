import java.util.Map;

public class Laptop {
    private String brand;
    private Integer size_RAM;
    private Integer size_HD;
    private String name_OS;
    private String color;

    public Laptop(String brand, Integer size_RAM, Integer size_HD, String name_OS, String color) {
        this.brand = brand;
        this.size_RAM = size_RAM;
        this.size_HD = size_HD;
        this.name_OS = name_OS;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Бренд: " + brand + ", ОЗУ: " + size_RAM + ", Объем ЖД: " + size_HD + ", " +
                "Операционная система: " + name_OS + ", Цвет: " + color;
    }
    public boolean compareParams(Map<String, Object> map) {
        return (!map.containsKey("brand") || name_OS.equalsIgnoreCase((String) map.get("brand"))) &&
                (!map.containsKey("size_RAM") || (Integer) map.get("size_RAM") <= size_RAM) &&
                (!map.containsKey("size_HD") || (Integer) map.get("size_HD") <= size_HD) &&
                (!map.containsKey("name_OS") || name_OS.equalsIgnoreCase((String) map.get("name_OS"))) &&
                (!map.containsKey("color") || color.equalsIgnoreCase((String) map.get("color")));
    }
}

