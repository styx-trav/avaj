package fr.fourty_two.naorakot.flyables;
import fr.fourty_two.naorakot.flyables.Flyable;
import fr.fourty_two.naorakot.coords.Coordinates;
import fr.fourty_two.naorakot.towers.WeatherTower;
import java.io.IOException;

public class Aircraft implements Flyable {
  protected WeatherTower weatherTower;
  protected long id;
  protected String name;
  protected Coordinates coordinates;
  protected int[][] mutate ;
  protected String[] announcement;
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
  private void updateCoord(int season) {
    int lo = coordinates.getLongitude() + mutate[season][0];
    int lat = coordinates.getLatitude() + mutate[season][1];
    int h = coordinates.getHeight() + mutate[season][2];
    if (h < 0) { h = 0; }
    else if (h > 100) { h = 100; }
    coordinates = new Coordinates(lo, lat, h);
  }
  public void updateConditions() throws IOException {
    String weather = weatherTower.getWeather(coordinates);
    int season = 0;
    while (weather.compareTo(seasons[season]) != 0)
    	season++;
    this.ntoString();
    weatherTower.fout.write(announcement[season] + "\n");
    this.updateCoord(season);
  }
  public boolean landed() {
    return (coordinates.getHeight() == 0);
  }
  public void ntoString() throws IOException {
    String str = name + "(" + id + "): ";
    weatherTower.fout.write(str);
  }
}
