public class Book implements Comparable<Book>{
    private String title;
    private int pageNum;
    private String author;
    private String publishDate;


    public Book(String title, int pageNum, String author, String publishDate) {
        this.title = title;
        this.pageNum = pageNum;
        this.author = author;
        this.publishDate = publishDate;
    }

    @Override
    public int compareTo(Book o) {
        return this.getTitle().compareTo(o.getTitle());
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
}
