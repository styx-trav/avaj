package weather;
import coords.Coordinates;

public class WeatherProvider {
  private static String[] weather = new String[] {"SUN", "RAIN", "FOG", "SNOW"};
  private WeatherProvider() {};
  public static String getCurrentWeather(Coordinates p_coordinates) {
    int res = p_coordinates.getLongitude() + p_coordinates.getLatitude() + p_coordinates.getHeight();
    if (res < 0) { res *= -1; }
    while (res > 4) { res /= 4; }
    return weather[res % 4];
  }
}
