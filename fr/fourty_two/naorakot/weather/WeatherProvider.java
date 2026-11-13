package fr.fourty_two.naorakot.weather;
import fr.fourty_two.naorakot.coords.Coordinates;

public class WeatherProvider {
  private static String[] weather = new String[] {"SUN", "RAIN", "FOG", "SNOW"};
  private WeatherProvider() {};
  public static String getCurrentWeather(Coordinates p_coordinates) {
    int res = p_coordinates.getLongitude() + p_coordinates.getLatitude() + p_coordinates.getHeight();
    return weather[res % 4];
  }
}
