package book.domain;

import java.util.Date;

public class fine {
    private Integer fine_id;

    private Integer user_id;

    private Integer book_id;

    private Date deal_time;

    private Integer fine_money;

    private String is_handin;

    private Integer admin_id;

    public Integer getFine_id() {
        return fine_id;
    }

    public void setFine_id(Integer fine_id) {
        this.fine_id = fine_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public Date getDeal_time() {
        return deal_time;
    }

    public void setDeal_time(Date deal_time) {
        this.deal_time = deal_time;
    }

    public Integer getFine_money() {
        return fine_money;
    }

    public void setFine_money(Integer fine_money) {
        this.fine_money = fine_money;
    }

    public String getIs_handin() {
        return is_handin;
    }

    public void setIs_handin(String is_handin) {
        this.is_handin = is_handin == null ? null : is_handin.trim();
    }

    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }
}