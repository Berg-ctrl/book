package book.mapper;

import book.domain.*;
public interface wyMapper {
    int deleteByPrimaryKey(Integer wy_id);

    int insert(wy record);

    int insertSelective(wy record);

    wy selectByPrimaryKey(Integer wy_id);

    int updateByPrimaryKeySelective(wy record);

    int updateByPrimaryKey(wy record);
}