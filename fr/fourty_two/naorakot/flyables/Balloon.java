package fr.fourty_two.naorakot.flyables;
import fr.fourty_two.naorakot.flyables.Aircraft;
import fr.fourty_two.naorakot.coords.Coordinates;

class Balloon extends Aircraft {
  public Balloon(long p_id, String p_name, Coordinates p_coordinates) {
    super(p_id, ("Balloon#" + p_name), p_coordinates);
    mutate[0] = new int[] {2, 0, 4};
    mutate[1] = new int[] {0, 0, -5};
    mutate[2] = new int[] {0, 0, -3};
    mutate[3] = new int[] {0, 0, -15};
    announcement[0] = "Ah, perfect weather. Maybe I can drop you guys off at a beach, eh ?";
    announcement[1] = "Oof, this rain is going to slow us down for sure ! Sorry about this, guys.";
    announcement[2] = "Alright, nobody jump off ! I know the fog is scary, but the ground is still way too far to land just yet.";
    announcement[3] = "This snow is going to ground us for the next week and a half, mark my words.";
  }
}
