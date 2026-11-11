import java.util.LinkedList;

class Tower {
  private LinkedList<Flyable> observers;
  Tower() { observers = new LinkedList<Flyable>(); }
  LinkedList<Flyable> getObservers() { return observers; }
  public void register(Flyable p_flyable) {
    observers.add(p_flyable);
    System.out.print("Tower says: ");
    p_flyable.ntoString();
    System.out.print(" registered to ");
  }
  public void unregister(Flyable p_flyable) {
    for(int i = 0; i != observers.size(); i++) {
      if (p_flyable == observers.get(i)) {
        System.out.print("Tower says: ");
        p_flyable.ntoString();
        System.out.print(" unregistered from ");
        observers.remove(i);
        i--;
      }
    }
  }
  protected void conditionChanged() {
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
