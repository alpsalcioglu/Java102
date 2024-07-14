import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Book {
    private String title;
    private int pageNum;
    private String authorName;
    private String publishDate;

    public Book(String title, int pageNum, String authorName, String publishDate) {
        this.title = title;
        this.pageNum = pageNum;
        this.authorName = authorName;
        this.publishDate = publishDate;
    }
    public static void generatePrintBook(){
        List<Book> list1 = new ArrayList<>();
        list1.add(new Book("A1",123,"Alp","2022"));
        list1.add(new Book("A2",25,"Tuana","2020"));
        list1.add(new Book("A3",145,"Muharrem","2021"));
        list1.add(new Book("A4",56,"Ünal","2023"));
        list1.add(new Book("A5",321,"Selim","2010"));
        list1.add(new Book("A6",86,"Mert","2012"));
        list1.add(new Book("A7",621,"Fatma","2019"));
        list1.add(new Book("A8",77,"Mehmet","2022"));
        list1.add(new Book("A9",69,"Dilara","2024"));
        list1.add(new Book("A0",198,"Emircan","2023"));

        Map<String, String> bookAuthorMap = list1.stream().collect(Collectors.toMap(Book::getTitle, Book::getAuthorName));
        System.out.println("All Books: ");
        bookAuthorMap.forEach((title , authorName) -> System.out.println(title + " : " +authorName));
        List<Book> list2 =  list1.stream().filter(book->book.getPageNum()>100).collect(Collectors.toList());
        System.out.println("Books Over 100 Pages:");
        list2.forEach(book-> System.out.println(book.getTitle()+ " : " + book.getPageNum()));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
}
