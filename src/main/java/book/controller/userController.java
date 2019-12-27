package book.controller;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import book.Page;
import book.domain.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import book.domain.*;
import book.mapper.*;
import book.service.*;
import book.mapper.*;


@Controller
public class userController {
	
	 @Resource
	 private userService userService;

	 @Resource
	 private borrowingService borrowingService;

	 @Resource
	 private bookService bookService;
	 
	 @Resource
	 private seatService seatService;
	 @Resource
	 private user_seatMapper user_seatMapper;
	 @Resource
	 private BookMapper bookMapper;
	 
	 private int user_id;
	 
	 @Resource
	 private BookCategoryMapper bookCategoryMapper;
	 
	@RequestMapping("")
	public String index()
	{
		return "index";
	}
	
	@RequestMapping("userLogin")
	public String userLogin(user user,Model model,HttpSession session,HttpServletRequest request)
	{
		if(userService.selectByName(user)!=null)
		{
			if(userService.checkPass(user)!=null)
			{
				this.user_id=userService.checkPass(user).getUser_id();
				request.getSession().setAttribute("user", user);
				//session.setAttribute("user", userService.checkPass(user));
				return "user/index";
			}
			else
			{
				String mes="密码错误";
				model.addAttribute("mes",mes);
				return "index";
			}
		}
		String mes="用户不存在";
		model.addAttribute("mes",mes);
		return "index";
	}

	@RequestMapping("borrowingPage")
	public String borrowingPage(Model model,@ModelAttribute("mes") String mes)
	{
		return "user/borrowingBooks";
	}
	
	@RequestMapping("insertBorrowingRecord")
	public String insertBorrowingRecord(@RequestParam("book_id") Integer book_id,
			Model model,HttpSession session,RedirectAttributes redirectAttributes)
	{
		Book book=bookService.selectById(book_id);
		if(book!=null)
		{
			Date date=new Date();
			user u=(user)session.getAttribute("user");
			BorrowingBooks borrowingBooks=new BorrowingBooks();
			borrowingBooks.setId(null);
			borrowingBooks.setBook_id(book_id);
			borrowingBooks.setUser_id(u.getUser_id());
			borrowingBooks.setDate(date);
			borrowingBooks.setShould_back_date();
			borrowingBooks.setTrue_back_date(null);
			borrowingService.insertBorrowingRecord(borrowingBooks);
			bookService.updateState(book_id);
			String mes="借书成功";
			redirectAttributes.addFlashAttribute("mes", mes);
			return "redirect:borrowingPage";
		}
		else
		{
			String mes="查询无结果";
			redirectAttributes.addFlashAttribute("mes", mes);
			return "redirect:borrowingPage";
		}
	}
	
	@RequestMapping("userReturnBooksPage")
	public String userReturnBooksPage(@ModelAttribute("mes") String mes)
	{
		return "user/returnBooks";
	}
	
	@RequestMapping("returnBook")
	public String returnBook(Integer book_id,HttpSession session,RedirectAttributes redirectAttributes)
	{
		Date true_back_date=new Date();
		System.out.print(book_id);
		user u=(user)session.getAttribute("user");
		bookService.updateState2(book_id);
		borrowingService.updateBackTime(true_back_date,book_id,u.getUser_id());
		redirectAttributes.addAttribute("mes","还书成功");
		return "redirect:userReturnBooksPage";
	}
	
	@RequestMapping("findBookPage")
	public String findBookPage(Model model)
	{
		List<BookCategory> list2=bookCategoryMapper.findAll();
		List<Book> list=bookMapper.findAll();
		model.addAttribute("list",list);
		model.addAttribute("list2",list2);
		return "user/findBook";
	}
	
	@RequestMapping("findBookByName")
	public String findBookByName(String bookName,Model model,String book_category)
	{
		List<Book> list=bookMapper.findBook(bookName,book_category);
		List<BookCategory> list2=bookCategoryMapper.findAll();
		model.addAttribute("list",list);
		model.addAttribute("list2",list2);
		return "user/findBook";
	}
	
	@RequestMapping("userSelectSeat")
	public String userSelectSeat(Model model)
	{
		List<seat> list=seatService.selectAll();
		System.out.print(list.toString());
		model.addAttribute("list",list);
		return "user/seat";
	}
	
	@RequestMapping("useSeat")
	public String useSeat(Integer seat_id,Model model)
	{
		//seatService.useSeat(seat_id);
		//user_seatMapper.addRecord(seat_id,user_id,new Date());
		//return "redirect:userSelectSeat";
		model.addAttribute("time","8:00-21:00");
		model.addAttribute("id",seat_id);
		return "user/seat2";
	}
	
	@RequestMapping("useSeat2")
	public String useSeat2(Model model,String usertime1,String usertime2)
	{
		model.addAttribute("mes","预约成功");
		
		return "user/seat2";
	}
	
	@RequestMapping("userBackSeat")
	public String userBackSeat(Model model)
	{
		//user_seatMapper.updateSeat(user_id);
		//user_seatMapper.updateSeat2(new Date(),user_id);
		//model.addAttribute("mes","取消成功");
		return "user/back_seat";
	}
}
