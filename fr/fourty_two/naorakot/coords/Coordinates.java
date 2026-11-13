package fr.fourty_two.naorakot.coords;

public class Coordinates {
 private int longitude;
 private int latitude;
 private int height;
 public Coordinates(int p_longitude, int p_latitude, int p_height) {
  longitude = p_longitude;
  latitude = p_latitude;
  height = p_height;
  if (height > 100) { height = 100; }
 }
 public int getLongitude() { return longitude; }
 public int getLatitude() { return latitude; }
 public int getHeight() { return height; }
}
