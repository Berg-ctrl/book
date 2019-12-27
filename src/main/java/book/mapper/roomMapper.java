package book.mapper;

import book.domain.*;
public interface roomMapper {
    int deleteByPrimaryKey(Integer room_id);

    int insert(room record);

    int insertSelective(room record);

    room selectByPrimaryKey(Integer room_id);

    int updateByPrimaryKeySelective(room record);

    int updateByPrimaryKey(room record);
}