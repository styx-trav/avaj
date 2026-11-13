package fr.fourty_two.naorakot.flyables;
import fr.fourty_two.naorakot.flyables.Aircraft;
import fr.fourty_two.naorakot.coords.Coordinates;

class JetPlane extends Aircraft {
  public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
    super(p_id, ("JetPlane#" + p_name), p_coordinates);
    mutate[0] = new int[] {10, 0, 2};
    mutate[1] = new int[] {0, 5, 0};
    mutate[2] = new int[] {0, 1, 0};
    mutate[3] = new int[] {0, 0, -7};
    announcement[0] = "beautiful day, isn't it ?";
    announcement[1] = "i've always loved a rainy day.";
    announcement[2] = "honestly ? i like it. the grey reminds me of home.";
    announcement[3] = "i've never really seen snow before, y'know ? pretty cool.";
  }
}
