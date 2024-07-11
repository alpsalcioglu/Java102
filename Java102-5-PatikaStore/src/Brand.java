import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Brand implements Comparable<Brand>{

    private String brandName;


    public Brand(String brandName) {
        this.brandName = brandName;
    }
    public static List<Brand> createBrandList(){
        List<Brand> list1 = new ArrayList<>();
        list1.add(new Brand("Xiaomi"));
        list1.add(new Brand("Samsung"));
        list1.add(new Brand("Apple"));
        list1.add(new Brand("Casper"));
        list1.add(new Brand("Asus"));
        list1.add(new Brand("Monster"));
        list1.add(new Brand("Huawei"));
        list1.add(new Brand("Lenovo"));
        list1.add(new Brand("HP"));
        Collections.sort(list1);

        return list1;
    }

    @Override
    public String toString() {
        return brandName;
    }

    @Override
    public int compareTo(Brand o) {
        return this.brandName.compareTo(o.getBrandName());
    }


    public static void printBrandName(){
        System.out.println("#####BRANDS#####");
        for(Brand br : Brand.createBrandList()){
            System.out.println("-> "+br);
        }
        System.out.println("################");
    }


    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }


}
