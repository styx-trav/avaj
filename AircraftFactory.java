class AircraftFactory {
  static long id_ct = 0;
  private AircraftFactory() {};
  static String[] types = {"Helicopter", "JetPlane", "Balloon"};
  static Flyable newAircraft(String p_type, String p_name, Coordinate p_coordinates) {
    Flyable ret;
    id_ct++;
    int i = 0;
    while (i != 3) {
      if (types[i].compareTo(p_type) == 0)
        break ;
      i++;
    }
    switch(i) {
      case 0:
        ret = new Helicopter(id_ct, p_name, p_coordinates);
        break ;
      case 1:
        ret = new JetPlane(id_ct, p_name, p_coordinates);
        break ;
      default:
        ret = new Balloon(id_ct, p_name, p_coordinates);
    }
    return ret;
  }
}
