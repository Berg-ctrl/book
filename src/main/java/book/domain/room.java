package book.domain;

public class room {
    private Integer room_id;

    private String room_address;

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public String getRoom_address() {
        return room_address;
    }

    public void setRoom_address(String room_address) {
        this.room_address = room_address == null ? null : room_address.trim();
    }
}