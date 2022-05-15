import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/** EnemyGenerator class - representation of an enemy being created */
public class EnemyGenerator {
  /** List of magical and physical enemies */
  private ArrayList<Enemy> enemyList;

  /** Item generator that generates random items */
  private ItemGenerator ig;

  /**
   * This Constructor reads in the enemy from a txt file and creates the enemy
   * to be added to the ArrayList and checks if the file is found or not
   * @param ig is the item the enemy will get from the ItemGenerator class
   * @throws FileNotFoundException when the text file is not found
   */
  public EnemyGenerator( ItemGenerator ig ) {
    enemyList = new ArrayList<Enemy>();
    this.ig = ig;
    try {
      Scanner read = new Scanner(new File("EnemyList.txt"));
      while( read.hasNext() ) {
        Random rand = new Random();
        
        String line = read.nextLine();
        
        String[] tokens = line.split(",");
        
        Item enemyArtifact = this.ig.generateItem();
        
        int randHp = rand.nextInt(7) + 1;
        
        Enemy opponent;
        
        if( tokens[2].equals("p") ) {
          opponent = new Enemy(tokens[0], Integer.parseInt(tokens[1]) + randHp, enemyArtifact);
        }
        
        else {
          opponent = new MagicalEnemy(tokens[0], Integer.parseInt(tokens[1]) + randHp, enemyArtifact);
        }
        enemyList.add(opponent);
      }
      read.close();
    }
    catch( FileNotFoundException fnf ) {
      System.out.println("File was not found");
    }
  }

  /**
   * Generate a random enemy from the ArrayList of enemys and 
   * check if the enemy is physical or magical and then creates the new enemy
   * @param level is use to determine the level the player is on
   * @return a random enemy created from the template 
   */
  public Enemy generateEnemy( int level ) {
    Random rand = new Random();
    int randNum = rand.nextInt(enemyList.size());
    
    Enemy templateEnemy = enemyList.get(randNum);
    Enemy villain = enemyList.get(randNum);
    
    if( villain instanceof MagicalEnemy ) {
      villain = new MagicalEnemy(templateEnemy.getName(), templateEnemy.getMaxHp(),templateEnemy.getItem());
    }
    
    else {
      villain = new Enemy(templateEnemy.getName(), templateEnemy.getMaxHp(),templateEnemy.getItem());
    }
    return villain;
  }
}
