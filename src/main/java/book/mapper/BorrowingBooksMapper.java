package book.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import book.domain.*;
public interface BorrowingBooksMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BorrowingBooks record);

    int insertSelective(BorrowingBooks record);

    BorrowingBooks selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BorrowingBooks record);

    int updateByPrimaryKey(BorrowingBooks record);
    
    @Select("select *,book_name FROM borrowingbooks,book,p_user "
    		+ "where borrowingbooks.user_id = p_user.user_id and "
    		+ "borrowingbooks.user_id=#{user_id} and borrowingbooks.book_id=book.book_id")
	List<BorrowingBooks> getBorrowingList(Integer user_id);
    
	void insertBorrowingRecord(BorrowingBooks borrowingBooks);

	@Update("update borrowingbooks set true_back_date=#{true_back_date} where book_id=#{book_id} and user_id=#{user_id}")
	void updateBackTime(@Param("true_back_date")Date true_back_date,@Param("book_id")Integer book_id,@Param("user_id")Integer user_id);

	@Select("select *,book_name,user_name FROM borrowingbooks,book,p_user "
    		+ "where borrowingbooks.user_id = p_user.user_id and "
    		+ "borrowingbooks.book_id=book.book_id")
	List<BorrowingBooks> findAll();

    
//    @Select("select *,user_name FROM borrowingbooks,p_user where borrowingbooks.user_id = p_user.user_id "
//    		+ "<if test='user_id != null'>and borrowingbooks.user_id=#{user_id}</if>")
//	List<BorrowingBooks> getBorrowingList(Integer user_id);
    
}