import java.util.ArrayList;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

/** ItemGenerator Class - representation of an item being created  */
public class ItemGenerator {
  /** The different number of items getting stored into an Arraylist */
  private ArrayList<Item> itemList;
  
  /**
   * Default Constructor - creates an item from getting the item from a txt file
   * and then adding it to the itemList which is an ArrayList
   * Also checks if the file is found or not
   * @throws FileNotFoundException when the text file is not found
   */
  public ItemGenerator() {
    itemList = new ArrayList<Item>();
    try {
      Scanner read = new Scanner(new File("ItemList.txt"));
      while( read.hasNext() ) {
        String line = read.nextLine();
        Item artifact = new Item(line);
        itemList.add(artifact);
      }
      read.close();

    }
    catch( FileNotFoundException fnf ) {
      System.out.println("File was not found");
    }
  }

  /**
   * Generate a random item from the ArrayList of itemList
   * @return a random item from the itemList
   */
  public Item generateItem() {
    Random rand = new Random();
    int randNum = rand.nextInt(itemList.size());
    return itemList.get(randNum);
  }
}
