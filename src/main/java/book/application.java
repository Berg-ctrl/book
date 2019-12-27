package book;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("book.mapper")
@ServletComponentScan
public class application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(application.class, args);
	}

}
