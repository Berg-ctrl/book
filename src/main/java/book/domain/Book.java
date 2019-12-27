package book.domain;

public class Book {
    private Integer book_id;

    private String book_name;

    private String book_author;

    private String book_publish;

    private Integer book_category;

    private Double book_price;

    private String book_introduction;

    private Integer book_copyNum;

    private Integer book_roomNo;

    private String book_state;

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name == null ? null : book_name.trim();
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author == null ? null : book_author.trim();
    }

    public String getBook_publish() {
        return book_publish;
    }

    public void setBook_publish(String book_publish) {
        this.book_publish = book_publish == null ? null : book_publish.trim();
    }

    public Integer getBook_category() {
        return book_category;
    }

    public void setBook_category(Integer book_category) {
        this.book_category = book_category;
    }

    public Double getBook_price() {
        return book_price;
    }

    public void setBook_price(Double book_price) {
        this.book_price = book_price;
    }

    public String getBook_introduction() {
        return book_introduction;
    }

    public void setBook_introduction(String book_introduction) {
        this.book_introduction = book_introduction == null ? null : book_introduction.trim();
    }

    public Integer getBook_copyNum() {
        return book_copyNum;
    }

    public void setBook_copyNum(Integer book_copyNum) {
        this.book_copyNum = book_copyNum;
    }

    public Integer getBook_roomNo() {
        return book_roomNo;
    }

    public void setBook_roomNo(Integer book_roomNo) {
        this.book_roomNo = book_roomNo;
    }

    public String getBook_state() {
        return book_state;
    }

    public void setBook_state(String book_state) {
        this.book_state = book_state == null ? null : book_state.trim();
    }
}