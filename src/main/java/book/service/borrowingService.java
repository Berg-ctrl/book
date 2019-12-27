package book.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import book.Page;
import book.domain.BorrowingBooks;

public interface borrowingService {

	Page<BorrowingBooks> userSelectByPageNum(int i, HttpServletRequest request);
	List<BorrowingBooks> getBorrowingList(Integer user_id);
	void insertBorrowingRecord(BorrowingBooks borrowingBooks);
	void updateBackTime(Date true_back_date,Integer book_id,Integer user_id);

}
