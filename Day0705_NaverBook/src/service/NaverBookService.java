package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import model.Book;

@Service
public class NaverBookService {
	private static final String CLIENT_ID = "SNxxfQ8EH7oRscKHYfQW";
	private static final String SECRET = "NFV7Sj2KJP";
	
	public List<Book> searchBooks(String keyword) throws IOException{
		String apiURL = "https://openapi.naver.com/v1/search/book.json";
		String encodedKeyword = URLEncoder.encode(keyword, "UTF-8");
		apiURL += "?query="+encodedKeyword;
		
		URL url = new URL(apiURL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
		conn.setRequestProperty("X-Naver-Client-Secret", SECRET);
		
		int responseCode = conn.getResponseCode();
		
		BufferedReader br = null;
		if(responseCode == 200) {
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			System.out.println("성공");
			
		} else {
			br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			System.out.println("실패");
			return null;
		}
		String inputLine = "";
		StringBuilder sb = new StringBuilder();
		while((inputLine = br.readLine()) != null) {
			sb.append(inputLine);
		}
		br.close();
		
		// ctrl + shift + o (import 정리)
		System.out.println("응답 데이터 : "+sb.toString());
		JSONObject jsonObject = new JSONObject(sb.toString());
		JSONArray items = jsonObject.getJSONArray("items");
		
		List<Book> bookList = new ArrayList<Book>();
		for(int i = 0; i < items.length(); i++) {
			JSONObject item = items.getJSONObject(i);
			
			Book book = new Book();
			book.setTitle(item.getString("title"));
			book.setAuthor(item.getString("author"));
			book.setDescription(item.getString("description"));
			book.setDiscount(item.getInt("discount"));
			book.setImage(item.getString("image"));
			book.setIsbn(item.getString("isbn"));
			book.setLink(item.getString("link"));
			book.setPrice(item.getInt("price"));
			book.setPublisher(item.getString("publisher"));
			book.setPubdate(item.getString("pubdate"));
			bookList.add(book);
		}	
		System.out.println(bookList);
		return bookList;
	}
}
