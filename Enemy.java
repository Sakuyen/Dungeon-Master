import java.util.Random;

/** 
 *  Enemy Class - representation of a single Enemy, which 
 *  extends from Entity
 */
public class Enemy extends Entity {
  /** The item the enemy has */
  private Item item;

  /**
   * Enemy constructor create the enemy
   * @param enemyName is the name of the enemy
   * @param mHp is how much health the enemy has
   * @param enemyItem is the item that the enemy has
   */
  public Enemy( String enemyName, int mHp, Item enemyItem ) {
     super( enemyName, mHp );
     item = enemyItem;
  }
   
  /**
   * Gets the item that the enemy has
   * @return the enemy's item
   */
  public Item getItem() {
    return item;
  }

  /**
   * Attack the entity with a random physical damage
   * @param entity is the entity getting passed int
   * @return the physical attack info that the entity took
   */
  @Override
  public String attack( Entity entity ) {
    Random rand = new Random();

    int physicalDamage = rand.nextInt(5) + 1;

    String physical = super.getName() + " attacks " + entity.getName() 
                      + " for " + physicalDamage +  " damage.";

    entity.takeDamage(physicalDamage);
    return physical;
  }
}
