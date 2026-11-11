interface Flyable {
  public abstract void updateCoord();
  public abstract void updateConditions();
  public abstract void ntoString();
  public abstract void announce(); //temporary recall function
  public abstract boolean landed();
  public void registerTower(WeatherTower p_tower);
}
