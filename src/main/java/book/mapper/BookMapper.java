package book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import book.domain.*;
public interface BookMapper {
    int deleteByPrimaryKey(Integer bookId);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
    
	Book selectById(Integer book_id);
	
	@Update("update book set book_state = '${'不可借'}' where book_id=#{book_id}")
	void updateState(Integer book_id);

	@Update("update book set book_state = '${'可借'}' where book_id=#{book_id}")
	void updateState2(Integer book_id);
	
	@Select("select * from book where book_name like concat('%',#{book_name},'%')")
	List<Book> findBookByName(String bookName);

	@Select("select * from book where book_category=#{book_category}")
	List<Book> findAll2(Integer book_category);
	@Select("select * from book")
	List<Book> findAll();

	@Select("select * from book where book_category=#{book_category} and book_name like concat('%',#{bookName},'%')")
	List<Book> findBook(@Param("bookName")String bookName, @Param("book_category")String book_category);
}