/** Item Class - representation of a single item */
public class Item {
  /** The name of the item */
  private String name;

  /**
   * The constructor that creates the item
   * @param itemName is the name of the item
   */
  public Item( String itemName ) {
    name = itemName;
  }

  /**
   * Retrieve the name of the item
   * @return the item's name
   */
  public String getName() {
    return name;
  }
}
