import java.util.Map;

public class Laptop {
    String brand;
    Integer size_RAM;
    Integer size_HD;
    String name_OS;
    String color;

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

    public boolean compareBrand(Map<String, Object> map) {
        if (map.containsKey("brand") && brand.equalsIgnoreCase((String) map.get("brand"))) {
            return true;
        }
        return !map.containsKey("brand");
    }
    public boolean compareRam(Map<String, Object> map) {
        if (map.containsKey("size_RAM") && (Integer) map.get("size_RAM") <= size_RAM) {
            return true;
        }
        return !map.containsKey("size_RAM");
    }

    public boolean compareHD(Map<String, Object> map) {
        if (map.containsKey("size_HD") && (Integer) map.get("size_HD") <= size_HD){
            return true;
            }
        return !map.containsKey("size_HD");
    }
    public boolean compareOS(Map<String, Object> map) {
        if (map.containsKey("name_OS") && name_OS.equalsIgnoreCase((String) map.get("name_OS"))) {
            return true;
        }
        return !map.containsKey("name_OS");
    }
    public boolean compareColor(Map<String, Object> map) {
        if (map.containsKey("color") && color.equalsIgnoreCase((String) map.get("color"))){
            return true;
        }
        return !map.containsKey("color");
    }
}

