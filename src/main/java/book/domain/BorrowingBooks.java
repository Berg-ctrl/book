package book.domain;

import java.util.Calendar;
import java.util.Date;

public class BorrowingBooks {
    private Integer id;

    private Integer user_id;

    private Integer book_id;
    
    private String book_name;
    public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	private Date date;

    private Date true_back_date;

    private Date should_back_date;
    
    public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	private String user_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTrue_back_date() {
        return true_back_date;
    }

    public void setTrue_back_date(Date true_back_date) {
        this.true_back_date = true_back_date;
    }

    public Date getShould_back_date() {
        return should_back_date;
    }

    public void setShould_back_date() {
    	Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(this.date);
        rightNow.add(Calendar.MONTH,1);//日期加1个月
        this.should_back_date=rightNow.getTime();
        
    }
}