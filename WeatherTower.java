import java.util.LinkedList;

class WeatherTower extends Tower {
  WeatherTower() { super(); }
  public String getWeather(Coordinate p_coordinates) {
    String season = WeatherProvider.getCurrentWeather(p_coordinates);
    return season;
    //unsure why we wouldn't just go for WeatherProvider directly... hm.
  }
  public void changeWeather() {
    LinkedList<Flyable> obv = this.getObservers();
    for(int i = 0; i != obv.size(); i++)
      obv.get(i).updateCoord();
  }
  public void register(Flyable p_flyable) {
    super.register(p_flyable);
    p_flyable.registerTower(this);
    System.out.println("weather tower.");
  }
  public void unregister(Flyable p_flyable) {
    super.unregister(p_flyable);
    System.out.println("weather tower.");
  }
}
