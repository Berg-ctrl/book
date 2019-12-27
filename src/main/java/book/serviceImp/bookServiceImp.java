package book.serviceImp;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import book.domain.Book;
import book.domain.BorrowingBooks;
import book.mapper.BookMapper;
import book.mapper.BorrowingBooksMapper;
import book.service.adminService;
import book.service.bookService;
@Service
public class bookServiceImp implements bookService {
	@Resource
	private BookMapper bookMapper;
	@Resource
	private BorrowingBooksMapper borrowingBooksMapper;
	@Override
	public Book selectById(Integer book_id) {
		// TODO Auto-generated method stub
		return bookMapper.selectById(book_id);
	}
	@Override
	public void updateState(Integer book_id) {
		// TODO Auto-generated method stub
		bookMapper.updateState(book_id);
	}
	@Override
	public void updateState2(Integer book_id) {
		// TODO Auto-generated method stub
		bookMapper.updateState2(book_id);
	}
	@Override
	public List<Book> findBookByName(String bookName) {
		// TODO Auto-generated method stub
		return bookMapper.findBookByName(bookName);
	}

	
	

}
