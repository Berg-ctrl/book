package book.serviceImp;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import book.Page;
import book.domain.*;
import book.service.adminService;
import book.service.userService;
import book.mapper.*;
@Service
public class userServiceImp implements userService {
	
	@Resource
	private userMapper userMapper;

	@Override
	public user selectByName(user user) {
		// TODO Auto-generated method stub
		return userMapper.selectByName(user);
	}

	@Override
	public user checkPass(user user) {
		// TODO Auto-generated method stub
		return userMapper.checkPass(user);
	}
	
}
