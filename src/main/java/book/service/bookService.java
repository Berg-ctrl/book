package book.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import book.domain.Book;
import book.domain.BorrowingBooks;
public interface bookService {

	Book selectById(Integer book_id);

	void updateState(Integer book_id);

	void updateState2(Integer book_id);

	List<Book> findBookByName(String bookName);



}
