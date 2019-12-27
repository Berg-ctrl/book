package book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import book.domain.*;

public interface seatMapper {
    int deleteByPrimaryKey(Integer seat_id);

    int insert(seat record);

    int insertSelective(seat record);

    seat selectByPrimaryKey(Integer seat_id);

    int updateByPrimaryKeySelective(seat record);

    int updateByPrimaryKey(seat record);

    @Select("select * from seat where seat_state='${'空闲'}'")
	List<seat> selectAll();

	@Update("update seat set seat_state='${'忙碌'}',seat_used_num=seat_used_num+1 where seat_id=#{seat_id}")
	void useSeat(Integer seat_id);
}