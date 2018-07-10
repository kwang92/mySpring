package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/image")
public class ImageController {
	private static final String PATH = "C:\\weatherImg\\";
	
	@ResponseBody
	@RequestMapping("/reqUrl")
	public void getSource(String pattern, HttpServletResponse resp) {
		String fileName = PATH+pattern+".png";
		try {
			FileInputStream fis = new FileInputStream(new File(fileName));
			BufferedInputStream bis = new BufferedInputStream(fis);
			BufferedOutputStream output = new BufferedOutputStream(resp.getOutputStream());
			for(int data; (data = bis.read()) > -1;) {
				output.write(data);
			}
			output.flush();
			output.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
