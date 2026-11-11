import java.io.IOException;
import java.io.FileReader;

class Main {
  public static void main(String[] args) {
    System.out.println("START");
    try {
      FileReader obj = new FileReader("sim1.txt");
      Parsing parser = new Parsing(obj);
      int res = parser.parse();
      if (res < 0) { System.out.println("Error"); }
      else if (res == 0) { System.out.println("No sim"); }
      else {
        System.out.println("Sim for " + res);
        //parser.announce();
        WeatherTower thetow = new WeatherTower();
        parser.register(thetow);
        for(int i = 0; i != res; i++) {
          thetow.conditionChanged();
          thetow.changeWeather();
        }
      }
    }
    catch(IOException e) { System.out.println("Error (file)"); }
    System.out.println("OVER");
  }
}
