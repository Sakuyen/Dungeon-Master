import java.util.Random;

/** 
 *  MagicalEnemy Class - representation of a single Magical Enemy, 
 *  which extends from Enemy and implements Magical
 */
public class MagicalEnemy extends Enemy implements Magical {
  /**
   * This constructor creates the Magical Enemy and also inherit from the Enemy Class
   * @param magicalEnemyName is the name of the Magical Enemy
   * @param mHp is the health the Magical Enemy has
   * @param magicalEnemyItem is the item the Magical Enemy has
   */
  public MagicalEnemy( String magicalEnemyName, int mHp, Item magicalEnemyItem ) {
    super( magicalEnemyName, mHp, magicalEnemyItem );
  }
  
  /**
   * Determine the random magical attack the Magical Enemy uses
   * @param entity is the Entity itself getting passed in to be attacked
   * @return the name of the magical attack info
   */
  public String attack( Entity entity ) {
    Random rand = new Random();
    int randNum = rand.nextInt(3);
    String attack = "";
    
    if( randNum == 0 ) {
      attack = magicMissile(entity);
    }

    else if( randNum == 1 ) {
      attack = fireball(entity);
    }

    else {
      attack = thunderclap(entity);
    }
    return attack;
  }
  
  /**
   * Magical Enemy choose a Magical attack magic missile that deals
   * a random amount of damage
   * @param entity is the entity getting passed in to take the damage
   * @return the magic missile attack info that the entity took
   */
  @Override
  public String magicMissile( Entity entity ) {
    Random rand = new Random();
    int randDamage = rand.nextInt(5) + 1;

    String magicMissile = super.getName() + " hits " + entity.getName() 
                          + " with Magic Missile for " + randDamage +  " damage.";

    entity.takeDamage(randDamage);
    return magicMissile;
  }

  /**
  * Magical Enemy choose a Magical attack fireball that deals
  * a random amount of damage
  * @param entity is the entity getting passed in to take the damage
  * @return the fireball attack info that the entity took
  */
  @Override
  public String fireball( Entity entity ) {
    Random rand = new Random();
    int randDamage = rand.nextInt(5) + 1;
    
    String fireball = super.getName() + " hits " + entity.getName() 
                      + " with Fireball for " + randDamage +  " damage.";
    
    entity.takeDamage(randDamage);
    return fireball;
  }

  /**
  * Magical Enemy choose a Magical attack thunderclap that deals
  * a random amount of damage
  * @param entity is the entity getting passed in to take the damage
  * @return the thunderclap attack info that the entity took
  */
  @Override
  public String thunderclap( Entity entity ) {
    Random rand = new Random();
    int randDamage = rand.nextInt(5) + 1;
    
    String thunderclap = super.getName() + " zaps " + entity.getName() 
                         + " with Thunderclap for " + randDamage +  " damage.";
    
    entity.takeDamage(randDamage);
    return thunderclap;
  }
}
