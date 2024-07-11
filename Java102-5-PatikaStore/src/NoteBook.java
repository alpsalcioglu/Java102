import java.util.ArrayList;
import java.util.List;

public class NoteBook extends Product{

    public NoteBook(int id, String name, Brand brand, int price, int memory, double screenSize, int ram) {
        super(id, name, brand, price, memory, screenSize, ram);
    }
    public static List<Product> createNoteBook(){
        List<Product> list3 = new ArrayList<>();
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
        list3.add(new NoteBook(1, "Matebook 14", huawei, 7000, 512, 14.0, 16));
        list3.add(new NoteBook(2, "V14 IGL", lenovo, 3699, 1024, 14.0, 8));
        list3.add(new NoteBook(3, "ASUS Tuf Gaming", asus, 8199, 2048, 15.6, 32));
        return list3;
    }
    public static void printNoteBook(){
        System.out.println("\n################## NOTEBOOK ########################################################################################################################################");
        for (Product c1 : createNoteBook()){
            System.out.println("ID:"+c1.getId() +" || Name: "+ c1.getName() +
                    " || Price: "+  c1.getPrice() +"tl || Brand: "+  c1.getBrand()+
                    " || Memory: "+c1.getMemory() +" || RAM: "+c1.getRam()+"GB || Screen: "+c1.getScreenSize()+
                    "Inch");
        }
        System.out.println("#####################################################################################################################################################################");
    }
}
