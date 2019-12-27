package book.serviceImp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import book.Page;
import book.domain.BorrowingBooks;
import book.service.adminService;
import book.service.borrowingService;
import book.service.categoryService;
@Service
public class categoryServiceImp implements categoryService {
	public Page<BorrowingBooks> userSelectByPageNum(int i, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
