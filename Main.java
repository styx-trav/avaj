import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

class Main {
	public static void main(String[] args) {
    if (args.length != 1) {
    	System.out.println("Error : need one argument (file name)");
    	return ;
    }
    FileReader obj;
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
		try { thetow.conditionChanged(); }
		catch(IOException e) {
			System.out.println("Error : output file could not be written to");
			try { outfile.close(); } catch(IOException e2) {}
			return ;
		}
		thetow.changeWeather();
	}
	try { outfile.close(); } catch(IOException e2) {}
  }
}
