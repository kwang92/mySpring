package controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.WeatherService;

@Controller
@RequestMapping("/weather")
public class WeatherController {
	@Autowired
	private WeatherService service;
	
	@ResponseBody
	@RequestMapping("/show")
	public String getWeather(@RequestParam Map<String, String> pos) {
		double posX = Double.parseDouble(pos.get("posX"));
		double posY = Double.parseDouble(pos.get("posY"));

		try {
			return service.showWeather(posX, posY);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/weatherForm")
	public String weatherForm() {
		return "weather";
	}
}
