import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** Map Class - representation of a map*/
public class Map {
  /** The 2D array hold the char of each spot of the map */
  private char[][] map;
  
  /** The 2D array holds the truth value if the spot is revealed or not */
  private boolean[][] revealed;

  /**
   * Default Constructor - creates map of 5 rows with 5 columns
   */
  public Map() {
    map = new char[5][5];
    revealed = new boolean[5][5];
  }

  /**
   * Load the correct map to the 2D array map if the txt file is found
   * @param mapNum what map number is being used to get loaded in
   * @throws FileNotFoundException when the text file is not found
   */
  public void loadMap( int mapNum ) {
    try {
      Scanner read = new Scanner(new File("Map" + mapNum + ".txt"));
      int row = 0;
      while( read.hasNext() ) {
        String line = read.nextLine();
        String[] split = line.split(" ");
        
        String newWrd = "";
        for( int j = 0; j < split.length; j++ ) {
          newWrd = newWrd + split[j];
        }
        
        for( int col = 0; col < map[0].length; col++ ) {
          map[row][col] = newWrd.charAt(col);
        }
        row++;
      }
      read.close();
      revealed = new boolean[5][5]; 
    }
    catch( FileNotFoundException fnf ) {
      System.out.println("File was not found");
    }
  }

  /**
   * Retrieve the location of a spot on the map and checks if it is out of bounds
   * @param point is the point of where the location is
   * @return 'X' is representing that it is out of bounds
   * @return the located spot on the map
   */
  public char getCharAtLoc( Point point ) {
    if( point.getX() > 4 || point.getX() < 0 || point.getY() > 4 || point.getY() < 0 ) {
      return 'X';
    }
    return map[point.getX()][point.getY()];
  }

  /**
   * Display the correct map to the screen with the current location of where the player is at
   * @param currentSpot is the location of the hero
   */
  public void displayMap( Point currentSpot ) {
    for( int row = 0; row < map.length; row++ ) {
      for( int col = 0; col < map[0].length; col++ ) {
        if( row == currentSpot.getX() && col == currentSpot.getY() ) {
          System.out.print("* ");
        }
        else if( revealed[row][col] ) {
          System.out.print(map[row][col] + " ");
        }
        else {
          System.out.print("x ");
        }
      }
      System.out.println();
    }
  }

  /**
   * Find where the start of the game is on the map
   * @return the point coordinate of where the start is
   */
  public Point findStart() {
    Point start = new Point();
    for( int row = 0; row < map.length; row++ ) {
      for( int col = 0; col < map[0].length; col++ ) {
        if( map[row][col] == 's' ) {
          start = new Point(row, col);
        }
      } 
    }
    return start;
  }
  
  /**
   * Show the spot on the map of your previous location by 
   * setting the location in the revealed 2D array to be true
   * @param previous is the location of the previous spot
   */
  public void reveal( Point previous ) {
    for( int row = 0; row < map.length; row++ ) {
      for( int col = 0; col < map[0].length; col++ ) {
        if( row == previous.getX() && col == previous.getY() ) {
          revealed[row][col] = true;
        }
      }
    }  
  }

  /**
   * Remove the char at the specific location by
   * setting it in the map 2D array to 'n' to represent nothing
   * @param removeSpot is the location of the spot to be removed 
   */
  public void removeCharAtLoc( Point removeSpot ) {
    map[removeSpot.getX()][removeSpot.getY()] = 'n';
  }
}
