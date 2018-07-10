package controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Book;
import service.NaverBookService;

@Controller
@RequestMapping("book")
public class BookController {

	@Autowired
	private NaverBookService service;
	
	@RequestMapping("/searchForm")
	public String searchForm() {
		return "bookList";
	}
	
	@ResponseBody
	@RequestMapping("/bookSearch")
	public List<Book> bookSearch(@RequestParam(required=false, defaultValue = "") String keyword) {	// RequestParam에 required=false면 키워드 인자가 안넘어와도 에러가 발생하지 않음
		try {
			System.out.println("받은 데이터 : "+keyword);
			return service.searchBooks(keyword);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
