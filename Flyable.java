import java.io.IOException;

interface Flyable {
  public abstract void updateCoord();
  public abstract void updateConditions() throws IOException;
  public abstract void ntoString() throws IOException;
  public abstract boolean landed();
  public void registerTower(WeatherTower p_tower);
}
