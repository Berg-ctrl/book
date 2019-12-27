package book.service;

import java.util.List;

import book.domain.seat;

public interface seatService {

	public List<seat> selectAll();

	public void useSeat(Integer seat_id);

}
