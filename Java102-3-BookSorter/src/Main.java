import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Book> t1 = new TreeSet<>();

        t1.add(new Book("Alp's World",152,"Alp","22/02/2020"));
        t1.add(new Book("Tuana's World",122,"Tuana","12/04/2021"));
        t1.add(new Book("Selim's World",854,"Selim","03/05/2024"));
        t1.add(new Book("Muharrem's World",254,"Muharrem","05/01/2020"));
        t1.add(new Book("Ünal's World",652,"Ünal","27/02/2023"));

        for(Book b1 : t1){
            System.out.println(b1.getTitle());
        }

        TreeSet<Book> t2 = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return Integer.compare(o1.getPageNum(), o2.getPageNum());
            }
        });
        System.out.println("###############");
        t2.addAll(t1);
        for(Book b1 : t2){
            System.out.println(b1.getPageNum());
        }




    }
}