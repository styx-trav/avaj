class WeatherProvider {
  private static String[] weather = new String[] {"SUN", "RAIN", "FOG", "SNOW"};
  private WeatherProvider() {};
  public static String getCurrentWeather(Coordinate p_coordinates) {
    //so far this equation is the one i saw the most variation with.
    //not sure what kind of key search words would get me closer to the mathematical equivalent of this
    int res = p_coordinates.getLongitude() + p_coordinates.getLatitude() + p_coordinates.getHeight();
    if (res < 0) { res *= -1; }
    while (res > 4) { res /= 4; }
    return weather[res % 4];
  }
}
