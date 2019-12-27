package book.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import book.Page;
import book.domain.BorrowingBooks;

public interface categoryService {

	Page<BorrowingBooks> userSelectByPageNum(int i, HttpServletRequest request);

}
