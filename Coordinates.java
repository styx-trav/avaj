class Coordinate {
 private int longitude;
 private int latitude;
 private int height;
 Coordinate(int p_longitude, int p_latitude, int p_height) {
  longitude = p_longitude;
  latitude = p_latitude;
  height = p_height;
  if (height > 100) { height = 100; }
 }
 int getLongitude() { return longitude; }
 int getLatitude() { return latitude; }
 int getHeight() { return height; }
}
