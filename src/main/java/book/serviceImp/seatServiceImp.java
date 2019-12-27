package book.serviceImp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import book.mapper.*;
import book.domain.seat;
import book.service.seatService;
@Service
public class seatServiceImp implements seatService {
	
	@Resource
	private seatMapper seatMapper;
	@Override
	public List<seat> selectAll(){
		return seatMapper.selectAll();
	}
	@Override
	public void useSeat(Integer seat_id) {
		// TODO Auto-generated method stub
		seatMapper.useSeat(seat_id);
	}

}
