package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParser;

@Service
public class WeatherService {
	private String url = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2";
	private static final String KEY = "G%2Fam94qe09ffWYFLKa8DdSGFBME5VlUXpZB5VZSNNLF4HKw506z5eT%2BoSxTMTW6I1FP5cWOdSnutZbUTCqFtZA%3D%3D";
	private static final String SECRET = "47dbb50a4441852fc9b51454265610e1";
	
	public String showWeather(double x, double y) throws IOException{
		String lon = "126.977948";
		String lat = "37.566386";
		String urlStr = "http://api.openweathermap.org/data/2.5/weather";
		urlStr += "?lat="+x;
		urlStr += "&lon="+y;
		urlStr += "&appid="+SECRET;
		URL url = new URL(urlStr);
		BufferedReader br;
		String line;
		String result = "";
		
		br = new BufferedReader(new InputStreamReader(url.openStream()));
		while((line = br.readLine()) != null) {
			result = result.concat(line);
		}
		JSONObject jsonObject = new JSONObject(result);
		
		
		
		JSONArray weatherArray = (JSONArray)jsonObject.get("weather");
		JSONObject obj = (JSONObject) weatherArray.get(0);
		JSONObject mainArray =(JSONObject) jsonObject.get("main");
		double ktemp = Double.parseDouble(mainArray.get("temp").toString());
		double temp = ktemp-273.15;
		
		
		String weather = "";
		weather += jsonObject.get("name")+",";
		weather += obj.get("main")+",";
		weather += temp+",";
		
		return weather;
	}
}
