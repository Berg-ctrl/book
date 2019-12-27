package book.mapper;

import book.domain.*;
public interface fineMapper {
    int deleteByPrimaryKey(Integer fine_id);

    int insert(fine record);

    int insertSelective(fine record);

    fine selectByPrimaryKey(Integer fine_id);

    int updateByPrimaryKeySelective(fine record);

    int updateByPrimaryKey(fine record);
}