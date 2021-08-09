package gateway;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import entities.Weather;

@Slf4j
public class YandexWeatherGateway {
    
  private static final String URL = "https://api.weather.yandex.ru/v1/forecast";
  private static final String TOKEN = "9cd188f3-747a-4413-a036-561debdeb869";


    @SneakyThrows
    public Weather getWeather(String translated_text, String longitude, String language) {
        Gson gson = new Gson();
        HttpResponse<String> response = Unirest.get(URL)
                .header("Accept", "*/*")
                .header("X-Yandex-API-Key", TOKEN)
                .queryString("text", translated_text)
                .queryString("lang", longitude)
                .queryString("lang", language)
                .asString();
        String strResponse = response.getBody();
       log.info("response: "+strResponse);
        return gson.fromJson(strResponse, Weather.class);
    }
}