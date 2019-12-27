package book.controller;

import java.util.List;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import book.domain.Admin;
import book.domain.*;
import book.mapper.*;
import book.mapper.BookCategoryMapper;
import book.mapper.BookMapper;

@Controller
public class adminController {
	@Resource
	private AdminMapper adminMapper;
	@Resource
	private userMapper userMapper;
	@Resource
	private BookCategoryMapper bookCategoryMapper;
	@Resource
	private BookMapper bookmapper;
	@Resource
	private BorrowingBooksMapper borrowingmapper;
	private int admin_id;
	@RequestMapping("adminLoginPage")
	public String AdminLoginPage()
	{
		return "adminLogin";
	}
	
	@RequestMapping("adminLogin")
	public String adminLogin(Model model,Admin admin,HttpSession session)
	{
		if(adminMapper.selectByName(admin)!=null)
		{
			if(adminMapper.checkPass(admin)!=null)
			{
				this.admin_id=adminMapper.checkPass(admin).getAdmin_id();
				session.setAttribute("admin", adminMapper.checkPass(admin));
				return "admin/index";
			}
			else
			{
				String mes="密码错误";
				model.addAttribute("mes",mes);
				return "adminLogin";
			}
		}
		String mes="用户不存在";
		model.addAttribute("mes",mes);
		return "adminLogin";
	}
	
	@RequestMapping("addBookPage")
	public String addBookPage(Model model)
	{
		List<BookCategory> list=bookCategoryMapper.findAll();
		model.addAttribute("list",list);
		return "admin/addBook";
	}
	
	@RequestMapping("addBook")
	public String addBook(Book book)
	{
		book.setBook_id(null);
		bookmapper.insert(book);
		return "redirect:addBookPage";
	}
	
	@RequestMapping("addCategoryPage")
	public String addCategoryPage(Model model,@ModelAttribute("mes") String mes)
	{
		List<BookCategory> list=bookCategoryMapper.findAll();
		model.addAttribute("list",list);
		return "admin/addCategory";
	}
	
	@RequestMapping("showBooksPage")
	public String showBooksPage(Model model)
	{
		List<Book> list=bookmapper.findAll();
		List<BookCategory> list2=bookCategoryMapper.findAll();
		model.addAttribute("list",list);
		model.addAttribute("list2",list2);
		return "admin/showBooks";
	}
	
	@RequestMapping("showBooksResultPageByCategoryId")
	public String showBooksResultPageByCategoryId(Integer book_category,Model model)
	{
		List<Book> list=bookmapper.findAll2(book_category);
		List<BookCategory> list2=bookCategoryMapper.findAll();
		model.addAttribute("list",list);
		model.addAttribute("list2",list2);
		return "admin/showBooks";
	}
	
	@RequestMapping("addCategory")
	public String addCategory(BookCategory category,RedirectAttributes redirectAttributes)
	{
		bookCategoryMapper.insert(category);
		redirectAttributes.addAttribute("mes","添加成功");
		return "redirect:addCategoryPage";
	}
	
	@RequestMapping("deleteCategory")
	public String deleteCategory(RedirectAttributes redirectAttributes,Integer category_id)
	{
		bookCategoryMapper.deleteByPrimaryKey(category_id);
		redirectAttributes.addAttribute("mes","删除成功");
		return "redirect:addCategoryPage";
	}
	
	@RequestMapping("showUsersPage")
	public String showUsersPage(Model model)
	{
		List<user> list=userMapper.findAll();
		model.addAttribute("list",list);
		return "admin/showUsers";
	}
	
	
	@RequestMapping("deleteUser")
	public String deleteUser(Integer user_id)
	{
		userMapper.deleteByPrimaryKey(user_id);
		return "redirect:showUsersPage";
	}
	
	@RequestMapping("addUserPage")
	public String addUserPage(Model model,@ModelAttribute("mes") String mes)
	{
		return "admin/addUser";
	}
	
	
	@RequestMapping("addUser")
	public String addUser(RedirectAttributes redirectAttributes,user user)
	{
		userMapper.insert(user);
		redirectAttributes.addAttribute("mes","添加成功");
		return "redirect:addUserPage";
	}
	
	
	@RequestMapping("allBorrowBooksRecordPage")
	public String allBorrowBooksRecordPage(Model model)
	{
		List<BorrowingBooks> list=borrowingmapper.findAll();
		model.addAttribute("list",list);
		return "admin/allBorrowingBooksRecord";
	}
	
	@RequestMapping("alluse_seat")
	public String alluse_seat()
	{
		return "admin/alluse_seat";
	}
}
