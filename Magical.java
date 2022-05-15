/** Interface Magical Class - representation of the magical attacks */
public interface Magical {
  /** The magical attack names */
  public static final String MAGIC_MENU = "1. Magic Missile\n2. Fireball\n3. Thunderclap";
  
  /** 
   * Method to make the object use the magic missile attack 
   * @param is the entity being passed in to be attacked
   */
  public String magicMissile( Entity entity );

  /** 
   * Method to make the object use the fireball attack 
   * @param is the entity being passed in to be attacked
   */
  public String fireball( Entity entity );

  /** 
   * Method to make the object use the thunderclap attack 
   * @param is the entity being passed in to be attacked
   */
  public String thunderclap( Entity entity );
}