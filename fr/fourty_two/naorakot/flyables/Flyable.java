package fr.fourty_two.naorakot.flyables;
import fr.fourty_two.naorakot.towers.WeatherTower;
import java.io.IOException;

public interface Flyable {
  public  void updateConditions() throws IOException;
  public  String toString();
  public  boolean landed() throws IOException;
  public  void registerTower(WeatherTower p_tower);
}
