package fr.fourty_two.naorakot.towers;
import java.util.LinkedList;
import java.io.FileWriter;
import java.io.IOException;
import fr.fourty_two.naorakot.flyables.Flyable;
import fr.fourty_two.naorakot.coords.Coordinates;
import fr.fourty_two.naorakot.weather.WeatherProvider;

public class WeatherTower extends Tower {
  public WeatherTower(FileWriter f) { super(f); }
  public String getWeather(Coordinates p_coordinates) {
    String season = WeatherProvider.getCurrentWeather(p_coordinates);
    return season;
  }
  public void changeWeather() throws IOException {
    this.conditionChanged();
  }
  public void register(Flyable p_flyable) throws IOException {
    super.register(p_flyable);
    p_flyable.registerTower(this);
    fout.write("Tower says: ");
    p_flyable.ntoString();
    fout.write(" registered to weather tower.\n");
  }
  public void unregister(Flyable p_flyable) throws IOException {
    super.unregister(p_flyable);
    fout.write("Tower says: ");
    p_flyable.ntoString();
    fout.write(" unregistered from ");
    fout.write("weather tower.\n");
  }
}
