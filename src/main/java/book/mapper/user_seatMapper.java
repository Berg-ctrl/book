package book.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import book.domain.user_seat;
@Mapper
public interface user_seatMapper {
    int deleteByPrimaryKey(Integer user_seat_id);

    int insert(user_seat record);

    int insertSelective(user_seat record);

    user_seat selectByPrimaryKey(Integer user_seat_id);

    int updateByPrimaryKeySelective(user_seat record);

    int updateByPrimaryKey(user_seat record);

    @Insert("insert into user_seat values(null,#{user_id},#{seat_id},#{date},null)")
	void addRecord(@Param("seat_id")Integer seat_id, @Param("user_id")int user_id, @Param("date")Date date);

    @Update("update seat set seat_state='${'空闲'}' where seat_id in (select seat_id from user_seat where user_id=#{user_id} and clear_time is Null)")
	void updateSeat(Integer user_id);

    @Update("update user_seat set clear_time=#{date} where clear_time is Null and user_id=#{user_id}")
	void updateSeat2(@Param("date")Date date,@Param("user_id")int user_id);
}