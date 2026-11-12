package flyables;
import flyables.Flyable;
import coords.Coordinates;
import towers.WeatherTower;
import java.io.IOException;

public class Aircraft implements Flyable {
  protected WeatherTower weatherTower;
  protected long id;
  protected String name;
  protected Coordinates coordinates;
  protected int[][] mutate ;
  protected String[] announcement;
  protected int season;
  private static String[] seasons = new String[] {"SUN", "RAIN", "FOG", "SNOW"};
  protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
    mutate = new int[4][3];
    announcement = new String[4];
    id = p_id;
    name = p_name;
    coordinates = p_coordinates;
  }
  public void registerTower(WeatherTower p_tower) {
    weatherTower = p_tower;
  }
  public void updateCoord() {
    int lo = coordinates.getLongitude() + mutate[season][0];
    int lat = coordinates.getLatitude() + mutate[season][1];
    int h = coordinates.getHeight() + mutate[season][2];
    if (h < 0) { h = 0; }
    else if (h > 100) { h = 100; }
    coordinates = new Coordinates(lo, lat, h);
  }
  public void updateConditions() throws IOException {
    String weather = weatherTower.getWeather(coordinates);
    for (int i = 0; i != 4; i++) {
    	if (weather.compareTo(seasons[i]) == 0) {
    		season = i;
    		break ;
    	}
    }
    this.ntoString();
    weatherTower.fout.write(announcement[season] + "\n");
  }
  public boolean landed() {
    if (coordinates.getHeight() == 0)
      return true;
    return false;
  }
  public void ntoString() throws IOException {
    String str = name + "(" + id + "): ";
    weatherTower.fout.write(str);
  }
}
