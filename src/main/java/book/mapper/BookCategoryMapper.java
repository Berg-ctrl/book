package book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import book.domain.*;

public interface BookCategoryMapper {
    int deleteByPrimaryKey(Integer category_id);

    int insert(BookCategory record);

    int insertSelective(BookCategory record);

    BookCategory selectByPrimaryKey(Integer category_id);

    int updateByPrimaryKeySelective(BookCategory record);

    int updateByPrimaryKey(BookCategory record);

    @Select("select * from book_category")
	List<BookCategory> findAll();
}