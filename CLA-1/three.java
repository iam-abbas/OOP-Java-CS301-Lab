import java.io.*;
import java.util.*;

public class three {

  public static void main(String args[]) {
    try {
      FileInputStream f = new FileInputStream("file.txt");
      Scanner scan = new Scanner(f).useDelimiter("\t");
      Hashtable<String, String> phoneBook = new Hashtable<String, String>();
      String[] strarray;
      String a, str;
      while (scan.hasNext()) {
        a = scan.nextLine();
        strarray = a.split("\t");
        phoneBook.put(strarray[0], strarray[1]);
      }
      Scanner scan_new = new Scanner(System.in);
      System.out.println("Enter a Name to search Phone Book");
      str = scan_new.next();
      if (phoneBook.containsKey(str)) {
        System.out.println("Phone No. " + phoneBook.get(str));
      } else {
        System.out.println("Entry does not exist");
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
