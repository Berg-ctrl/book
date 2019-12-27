package book.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import book.service.*;
import book.Page;
import book.domain.BorrowingBooks;
import book.domain.user;
@Controller
public class borrowingController {
	@Resource
    private userService userService;

    @Resource
    private borrowingService borrowingBooksRecordService;

    @Resource
    private bookService bookService;

	@RequestMapping("userBorrowingBooksPage")
	public String userBorrowingBooksPage(Model model,HttpServletRequest request)
	{
		user u=(user) request.getSession().getAttribute("user");
		List<BorrowingBooks> list=borrowingBooksRecordService.
				getBorrowingList(u.getUser_id());
		for(BorrowingBooks b:list){
			b.setShould_back_date();
		}
		model.addAttribute("list",list);
		return "user/borrowingBooksRecord";
		
	}
}
