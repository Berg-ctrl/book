package book.service;

import java.util.List;
import book.domain.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

public interface userService {

	user selectByName(user user);

	user checkPass(user user);
}
