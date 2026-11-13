package fr.fourty_two.naorakot.flyables;
import fr.fourty_two.naorakot.flyables.Aircraft;
import fr.fourty_two.naorakot.coords.Coordinates;

class Helicopter extends Aircraft {
  public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
    super(p_id, ("Helicopter#" + p_name), p_coordinates);
    mutate[0] = new int[] {10, 0, 2};
    mutate[1] = new int[] {5, 0, 0};
    mutate[2] = new int[] {1, 0, 0};
    mutate[3] = new int[] {0, 0, -12};
    announcement[0] = "the sun is burning my skin !";
    announcement[1] = "wonder if the blades spin fast enough to split a raindrop in half.";
    announcement[2] = "damnit, i can't see a thing ! let's slow down a bit.";
    announcement[3] = "snow ??? it's the middle of summer ! climate change, man.";
  }
}
