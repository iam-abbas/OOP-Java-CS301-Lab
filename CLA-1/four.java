import java.io.*;
import java.util.*;

public class four {

  public static void main(String[] args) {
    try {
      FileInputStream fis = new FileInputStream("covid.txt");
      Scanner sc = new Scanner(fis).useDelimiter("\t");
      String[] covidArray;
      String a;
      Hashtable<String, String> patientList = new Hashtable<String, String>();
      ;
      Dictionary contacts = new Hashtable();
      Dictionary dates = new Hashtable();
      Dictionary places = new Hashtable();

      Scanner hms = new Scanner(System.in);
      int option;
      boolean cont = true;
      while (cont) {
        System.out.println("*********MENU*********");
        System.out.println("1. Enter New Patient");
        System.out.println("2. Trace Contacts");
        System.out.println("3. Exit");
        System.out.println("**********************");
        System.out.println("\n");

        option = hms.nextInt();
        switch (option) {
          case 1:
            FileWriter covidWriter = new FileWriter("covid.txt", true);
            List<String> newEntry = new ArrayList<String>();
            System.out.println("Enter Name of Patient: ");
            hms.nextLine();
            String name = hms.nextLine();
            if (!name.isEmpty()) {
              newEntry.add(name);
              for (int i = 0; i < 14; i++) {
                System.out.println("Enter Date on Day " + (i + 1));
                newEntry.add(hms.nextLine());
                System.out.println("Enter Place on Day " + (i + 1));
                newEntry.add(hms.nextLine());
                System.out.println("Enter Person Contacted on Day " + (i + 1));
                newEntry.add(hms.nextLine());
              }
              String csEntry = String.join("\t", newEntry);
              covidWriter.write(csEntry + "\n");
              covidWriter.close();
            }
            break;
          case 2:
            int count = 0;
            while (sc.hasNext()) {
              List<String> contactList = new ArrayList<String>();
              List<String> datesList = new ArrayList<String>();
              List<String> placesList = new ArrayList<String>();

              a = sc.nextLine();
              covidArray = a.split("\t");
              patientList.put(covidArray[0], String.valueOf(count));
              patientList.put(String.valueOf(count), covidArray[0]);

              contactList.add(covidArray[3]);
              contactList.add(covidArray[6]);
              contactList.add(covidArray[9]);
              contactList.add(covidArray[12]);
              contactList.add(covidArray[15]);
              contactList.add(covidArray[18]);
              contactList.add(covidArray[21]);
              contactList.add(covidArray[24]);
              contactList.add(covidArray[27]);
              contactList.add(covidArray[30]);
              contactList.add(covidArray[33]);
              contactList.add(covidArray[36]);
              contactList.add(covidArray[39]);
              contactList.add(covidArray[42]);

              datesList.add(covidArray[1]);
              datesList.add(covidArray[4]);
              datesList.add(covidArray[7]);
              datesList.add(covidArray[10]);
              datesList.add(covidArray[13]);
              datesList.add(covidArray[16]);
              datesList.add(covidArray[19]);
              datesList.add(covidArray[22]);
              datesList.add(covidArray[25]);
              datesList.add(covidArray[28]);
              datesList.add(covidArray[31]);
              datesList.add(covidArray[34]);
              datesList.add(covidArray[37]);
              datesList.add(covidArray[40]);

              placesList.add(covidArray[2]);
              placesList.add(covidArray[5]);
              placesList.add(covidArray[8]);
              placesList.add(covidArray[11]);
              placesList.add(covidArray[14]);
              placesList.add(covidArray[17]);
              placesList.add(covidArray[20]);
              placesList.add(covidArray[23]);
              placesList.add(covidArray[26]);
              placesList.add(covidArray[29]);
              placesList.add(covidArray[32]);
              placesList.add(covidArray[35]);
              placesList.add(covidArray[38]);
              placesList.add(covidArray[41]);

              contacts.put(count, contactList);
              dates.put(count, datesList);
              places.put(count, placesList);
              count++;
            }
            for (int i = 0; i < count; i++) {
              String name_check = (String) patientList.get(String.valueOf(i));
              List<String> contact_check = new ArrayList<String>();
              contact_check = (List<String>) contacts.get(i);
              for (int j = 0; j < 14; j++) {
                boolean contains = patientList.containsKey(contact_check.get(j));
                if (contains) {
                  String s = (String) patientList.get(contact_check.get(j));
                  int k = Integer.valueOf(s);
                  List<String> dt = new ArrayList<String>();
                  dt = (List<String>) dates.get(k);
                  List<String> pl = new ArrayList<String>();
                  pl = (List<String>) places.get(k);
                  System.out.println(name_check + " and " + contact_check.get(j) + " met each other on " + dt.get(j)
                      + " at " + pl.get(j) + "\n");
                }
              }
            }
            break;
          case 3:
            cont = false;
            break;
        }
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
