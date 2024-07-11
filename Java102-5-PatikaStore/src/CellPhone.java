import java.util.ArrayList;
import java.util.List;

public class CellPhone extends Product{
private double battery;
private String color;
private int camera;

    public CellPhone(int id, String name, Brand brand, int price, int memory, double screenSize, int ram, double battery, String color, int camera) {
        super(id, name, brand, price, memory, screenSize, ram);
        this.battery = battery;
        this.color = color;
        this.camera = camera;
    }

    public static List<Product> createCellPhone(){
        List<Product> list2 = new ArrayList<>();
        List<Brand> brands = Brand.createBrandList();
        Brand samsung = brands.stream().filter(b -> b.getBrandName().equals("Samsung")).findFirst().orElse(null);
        Brand apple = brands.stream().filter(b -> b.getBrandName().equals("Apple")).findFirst().orElse(null);
        Brand xiaomi = brands.stream().filter(b -> b.getBrandName().equals("Xiaomi")).findFirst().orElse(null);
        Brand casper = brands.stream().filter(b -> b.getBrandName().equals("Casper")).findFirst().orElse(null);
        Brand asus = brands.stream().filter(b -> b.getBrandName().equals("Asus")).findFirst().orElse(null);
        Brand monster = brands.stream().filter(b -> b.getBrandName().equals("Monster")).findFirst().orElse(null);
        Brand huawei = brands.stream().filter(b -> b.getBrandName().equals("Huawei")).findFirst().orElse(null);
        Brand lenovo = brands.stream().filter(b -> b.getBrandName().equals("Lenovo")).findFirst().orElse(null);
        Brand hp = brands.stream().filter(b -> b.getBrandName().equals("HP")).findFirst().orElse(null);
        list2.add(new CellPhone(1, "Galaxy A51", samsung, 3199, 128, 6.5, 6, 4000, "Black", 32));
        list2.add(new CellPhone(2, "iPhone 11", apple, 7379, 64, 6.1, 4, 3046, "Blue", 5));
        list2.add(new CellPhone(3, "Redmi Note 10 Pro", xiaomi, 4012, 128, 6.5, 6, 4000, "White", 35));
       return list2;
    }
    public static void printCellPhone(){
        System.out.println("################## CELLPHONE ########################################################################################################################################");
        for (Product c1 : createCellPhone()){
            System.out.println("ID:"+c1.getId() +" || Name: "+ c1.getName() +
                    " || Price: "+  c1.getPrice() +"tl || Brand: "+  c1.getBrand()+
                    " || Memory: "+c1.getMemory() +" || RAM: "+c1.getRam()+"GB || Screen: "+c1.getScreenSize()+
                    "Inch || Camera: "+c1.getCamera() + "Mp || Battery: "+c1.getBattery()+"mAh || Color: "+c1.getColor());
        }
        System.out.println("#####################################################################################################################################################################");
    }

    public double getBattery() {
        return battery;
    }

    public void setBattery(double battery) {
        this.battery = battery;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }
}
