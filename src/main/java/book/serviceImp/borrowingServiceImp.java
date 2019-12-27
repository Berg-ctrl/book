package book.serviceImp;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import book.Page;
import book.domain.BorrowingBooks;
import book.mapper.BorrowingBooksMapper;
import book.service.adminService;
import book.service.borrowingService;
@Service
public class borrowingServiceImp implements borrowingService {
	@Resource
	private BorrowingBooksMapper borrowingBooksMapper;
	
	@Override
	public Page<BorrowingBooks> userSelectByPageNum(int i, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BorrowingBooks> getBorrowingList(Integer user_id) {
		// TODO Auto-generated method stub
		return borrowingBooksMapper.getBorrowingList(user_id);
	}

	@Override
	public void insertBorrowingRecord(BorrowingBooks borrowingBooks) {
		// TODO Auto-generated method stub
		borrowingBooksMapper.insertBorrowingRecord(borrowingBooks);
	}

	@Override
	public void updateBackTime(Date true_back_date,Integer book_id,Integer user_id) {
		// TODO Auto-generated method stub
		borrowingBooksMapper.updateBackTime(true_back_date,book_id,user_id);
	}


}
