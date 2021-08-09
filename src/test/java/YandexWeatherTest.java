import entities.Weather;
import gateway.YandexWeatherGateway;
//import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class YandexWeatherTest {
    private static final String MOSCOW_LATITUDE = "56.630842";
    private static final String MOSCOW_LONGITUDE = "47.886089";
    private static final String LANGUAGE_RU = "ru_RU";

    @Test
    @DisplayName("Погода в Москве")
    public void getMoscowWeather(){
        YandexWeatherGateway yandexWeatherGateway = new YandexWeatherGateway();
        Weather moscowWeather = yandexWeatherGateway.getWeather(MOSCOW_LATITUDE, MOSCOW_LONGITUDE, LANGUAGE_RU);
        Assertions.assertEquals(moscowWeather.getInfo().getLat().toString(), MOSCOW_LATITUDE);
        Assertions.assertEquals(moscowWeather.getInfo().getLon().toString(), MOSCOW_LONGITUDE);
        System.out.println("Тест ОК");
    }
}