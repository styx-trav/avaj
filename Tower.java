import java.util.LinkedList;
import java.io.FileWriter;
import java.io.IOException;

class Tower {
  private LinkedList<Flyable> observers;
  public FileWriter fout;
  Tower(FileWriter f) {
  	fout = f;
  	observers = new LinkedList<Flyable>();
  }
  LinkedList<Flyable> getObservers() { return observers; }
  public void register(Flyable p_flyable) throws IOException { observers.add(p_flyable); }
  public void unregister(Flyable p_flyable) throws IOException {
    for(int i = 0; i != observers.size(); i++) {
      if (p_flyable == observers.get(i)) {
        observers.remove(i);
        i--;
      }
    }
  }
  protected void conditionChanged() throws IOException {
    for(int i = 0; i != observers.size(); i++) {
      if (observers.get(i).landed()) {
        this.unregister(observers.get(i));
        i--;
      }
      else
        observers.get(i).updateConditions();
    }
  }
}
