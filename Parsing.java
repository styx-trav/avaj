import java.util.Scanner;
import java.io.FileReader;
import java.util.LinkedList;
import java.lang.NumberFormatException;
import java.io.IOException;
import flyables.Flyable;
import flyables.AircraftFactory;
import towers.WeatherTower;
import coords.Coordinates;

public class Parsing {
  public LinkedList<Flyable> objs;
  private Scanner reader;
  public Parsing(FileReader obj) {
    reader = new Scanner(obj);
    objs = new LinkedList<Flyable>();
  }
  public static boolean istype(String str) {
    String[] tab = { "Helicopter", "Balloon", "JetPlane" };
    for (int i = 0; i != 3; i++) {
      if (str.compareTo(tab[i]) == 0) { return true; }
    }
    return false;
  }
  public static int toPosInt(String str) {
    try { return Integer.parseInt(str); }
    catch(NumberFormatException e) { return -1; }
  }
  private int ender(int ret) { reader.close(); return ret; }
  private int parseElse(String str) {
    String[] tab = str.split("\\s+", 6);
    if (tab.length < 5) { return 0; }
    int[] coord = {0, 0, 0};
    if (!istype(tab[0]))
    	return 0;
    if (tab[1].isEmpty())
    	return 0;
	for (int i = 2; i != 5; i++) {
		if (tab[i].isEmpty())
			return 0;
		coord[i -2] = toPosInt(tab[i]);
		if (coord[i -2] < 0)
			return 0;
	}
    if (tab.length > 5 && !tab[5].isEmpty())
		return 0;
    objs.add(AircraftFactory.newAircraft(tab[0], tab[1], new Coordinates(coord[0], coord[1], coord[2])));
    return 1;
  }
  public int parse() {
    if (!reader.hasNextLine())
    	return ender(-1);
    int sim = toPosInt(reader.nextLine());
    if (sim <= 0)
    	return ender(sim);
    while (reader.hasNextLine()) {
      if (parseElse(reader.nextLine()) == 0)
        return ender(-1);
    }
    if (objs.size() == 0)
    	return ender(0);
    return ender(sim);
  }
  public void register(WeatherTower tower) throws IOException {
    for(int i = 0; i != objs.size(); i++) {
      tower.register(objs.get(i));
    }
  }
}
