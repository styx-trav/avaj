import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import fr.fourty_two.naorakot.towers.WeatherTower;

public class Main {
	public static void main(String[] args) {
    if (args.length != 1) {
    	System.out.println("Error : need one argument (file name)");
    	return ;
    }
    try { Main.execute(args[0]); }
    catch(IOException e) {
		System.out.println("Error : file error");
	}
    /*FileReader obj;
    FileWriter outfile;
    Parsing parser;
    int res;
	try { obj = new FileReader(args[0]); }
	catch(IOException e) {
		System.out.println("Error : input file could not be opened/read");
		return ;
	}
	parser = new Parsing(obj);
	res = parser.parse();
	if (res < 0) { System.out.println("Error : invalid input file"); return ; }
	try { outfile = new FileWriter("simulation.txt"); }
	catch(IOException e) {
		System.out.println("Error : output file could not be opened/created");
		return ;
	}
	if (res == 0) { return ; }
	WeatherTower thetow = new WeatherTower(outfile);
	try { parser.register(thetow); }
	catch(IOException e) {
		System.out.println("Error : output file could not be written to");
		try { outfile.close(); } catch(IOException e2) {}
		return ;
	}
	for(int i = 0; i != res -1; i++) {
		try { thetow.changeWeather(); }
		catch(IOException e) {
			System.out.println("Error : output file could not be written to");
			try { outfile.close(); } catch(IOException e2) {}
			return ;
		}
	}
	try { outfile.close(); } catch(IOException e2) {}*/
  }
  public static void execute(String arg) throws IOException {
  	FileReader obj;
  	FileWriter outfile;
    Parsing parser;
    int res;
	obj = new FileReader(arg);
	parser = new Parsing(obj);
	res = parser.parse();
	if (res < 0) { System.out.println("Error : invalid input file"); return ; }
	outfile = new FileWriter("simulation.txt");
	if (res == 0) { return ; }
	WeatherTower thetow = new WeatherTower(outfile);
	parser.register(thetow);
	for(int i = 0; i != res -1; i++) {
		thetow.changeWeather();
	}
	outfile.close();
  }
}
