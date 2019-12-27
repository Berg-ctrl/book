package book.domain;

import java.util.Date;

public class user_seat {
    private Integer user_seat_id;

    private Integer user_id;

    private Integer seat_id;

    private Date use_time;

    private Date clear_time;

    public Integer getUser_seat_id() {
        return user_seat_id;
    }

    public void setUser_seat_id(Integer user_seat_id) {
        this.user_seat_id = user_seat_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(Integer seat_id) {
        this.seat_id = seat_id;
    }

    public Date getUse_time() {
        return use_time;
    }

    public void setUse_time(Date use_time) {
        this.use_time = use_time;
    }

    public Date getClear_time() {
        return clear_time;
    }

    public void setClear_time(Date clear_time) {
        this.clear_time = clear_time;
    }
}