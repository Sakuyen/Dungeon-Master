/** Entity is an Abstract Representation of an Entity */
public abstract class Entity {
  /** The name of an Entity */
  private String name;
  
  /** The max health this Entity can have */
  private int maxHp;

  /** The health the Entity starts with */
  private int hp;

  /**
   * This constructor creates the Entity
   * @param entityName is the name of this Entity
   * @param mHp is the max health the Entity starts with
   */
  public Entity( String entityName, int mHp ) {
    name = entityName;
    maxHp = mHp;
    hp = mHp;
  }

  /** 
   * Determine what attack the Entity uses
   * @param entity is the Entity itself getting passed in
   * @return the name of the Entity's attack
   */
  public abstract String attack( Entity entity );

  /**
   * Retrieve the Entity's name
   * @return the name of the Entity
   */
  public String getName() {
    return name;
  }

  /**
   * Retrieve the Entity's health
   * @return the health of the Entity
   */
  public int getHp() {
    return hp;
  }

  /**
   * Retrieve the Entity's max health can have
   * @return the max health the Entity
   */
  public int getMaxHp() {
    return maxHp;
  }

  /**
   * Heals the Entity
   * @param health the amount of health Entity gets healed with
   */
  public void heal( int health ) {
    hp = health;
  }

  /**
   * The damage the Entity takes
   * @param damage is the amount of damage the Entity gets dealt with
   */
  public void takeDamage( int damage ) {
    hp = hp - damage;
  }
  
  /**
   * String representation of the Entity object
   * @return string representation of this Entity
   */
  @Override
  public String toString() {
    String info = name;
    info += "\nHP: " + hp + "/" + maxHp;
    return info;
  }
}
