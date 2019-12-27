package book.domain;

public class seat {
    private Integer seat_id;

    private Integer seat_num;

    private String seat_state;

    private Integer room_id;

    private Integer seat_used_num;

    public Integer getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(Integer seat_id) {
        this.seat_id = seat_id;
    }

    public Integer getSeat_num() {
        return seat_num;
    }

    public void setSeat_num(Integer seat_num) {
        this.seat_num = seat_num;
    }

    public String getSeat_state() {
        return seat_state;
    }

    public void setSeat_state(String seat_state) {
        this.seat_state = seat_state == null ? null : seat_state.trim();
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public Integer getSeat_used_num() {
        return seat_used_num;
    }

    public void setSeat_used_num(Integer seat_used_num) {
        this.seat_used_num = seat_used_num;
    }
}