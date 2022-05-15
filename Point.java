/** Represent a location of (x,y) in a coordinate plane */
public class Point {
  /** Represent the x coordinate of the point */
  public int x;
  
  /** Represent the y coordinate of the point */
  public int y;

  /**
   *  Default Constructor - creates a point at (0,0)
   */
  public Point() {
    x = 0;
    y = 0;
  }

  /**
   * Overload Constructor - create a point at a specific x and y coordinates
   * by calling the setLocation() function
   * @param xVal is the x coordinate of the new point
   * @param yVal is the y coordinate of the new point
   */
  public Point( int xVal, int yVal ) {
    setLocation(xVal,yVal);
  }

  /**
   * Changes the location of the point
   * @param xVal is assigning the x coordinate of the new point
   * @param yVal is assigning the y coordinate of the new point
   */
  public void setLocation( int xVal, int yVal ) {
    x = xVal;
    y = yVal;
  }

  /**
   * Shifts the location of the point by adding the value of dx and dy
   * @param dx is the amount to move this point in the x direction
   * @param dy is the amount to move this point in the y direction
   */
  public void move( int dx, int dy ) {
    x = x + dx;
    y = y + dy;
  }

  /**
   * Retrieve the value of the x coordinate
   * @return the x coordinate of the point
   */
  public int getX() {
    return x;
  }

  /**
   * Retrieve the value of the y coordinate
   * @return the y coordinate of the point
   */
  public int getY() {
    return y;
  }
  
  /**
   * String representation of the Point object
   * @return string representation of the Point
   */
  @Override
  public String toString() {
    return "(" + x + ", " + y + ")";
  }
}
