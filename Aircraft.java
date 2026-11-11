class Aircraft implements Flyable {
  protected WeatherTower weatherTower;
  protected long id;
  protected String name;
  protected Coordinate coordinates;
  protected int[][] mutate ;
  protected String[] announcement;
  protected int season;
  protected Aircraft(long p_id, String p_name, Coordinate p_coordinates) {
    mutate = new int[4][3];
    announcement = new String[4];
    id = p_id;
    name = p_name;
    coordinates = p_coordinates;
  }
  public void registerTower(WeatherTower p_tower) {
    weatherTower = p_tower;
  }
  //recall only
  public void announce() {
    System.out.print("object " + name + "(" + id + ")");
    System.out.println(", with coordinates :: " + coordinates.getLongitude() + ", " + coordinates.getLatitude() + ", " + coordinates.getHeight() + ".");
  }
  public void updateCoord() {
    int lo = coordinates.getLongitude() + mutate[season][0];
    int lat = coordinates.getLatitude() + mutate[season][1];
    int h = coordinates.getHeight() + mutate[season][2];
    if (h < 0) { h = 0; }
    else if (h > 100) { h = 100; }
    //this.ntoString();
    //System.out.println(" goes from [" + coordinates.getLongitude() + ", " + coordinates.getLatitude() + ", " + coordinates.getHeight() + "]" + " to [" + lo + ", " + lat + ", " + h + "] for season " + season);
    coordinates = new Coordinate(lo, lat, h);
  }
  public void updateConditions() {
    String weather = weatherTower.getWeather(coordinates);
    //switch case if its possible with a string ig
    //otherwise a for loop for checking ?? maaybe
    if (weather.compareTo("SUN") == 0)
      season = 0;
    else if (weather.compareTo("RAIN") == 0)
      season = 1;
    else if (weather.compareTo("FOG") == 0)
      season = 2;
    else
      season = 3;
    this.ntoString();
    System.out.println(announcement[season]);
  }
  public boolean landed() {
    if (coordinates.getHeight() == 0)
      return true;
    return false;
  }
  public void ntoString() {
    String str = name + "(";
    System.out.print(str);
    System.out.print(id);
    System.out.print("): ");
  }
}
