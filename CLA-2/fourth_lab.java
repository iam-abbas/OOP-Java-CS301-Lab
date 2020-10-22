import java.io.*;
import java.util.*;

class Employee {

  public static void main(String args[]) {
    String name;
    int age;
    System.out.println("-----ENTER EMPLOYEE DETAILS-----");
    Scanner s = new Scanner(System.in);

    try {
      System.out.print("Enter Name:");
      name = s.nextLine();
      if (!(name.matches("[a-zA-Z]+"))) {
        System.out.println("Name is number Exception");
        throw new IOException();
      }
      System.out.print("Enter age:");
      age = s.nextInt();
      if (age > 50) {
        System.out.println("Age greater than 50 Exception");
        throw new Exception();
      }

      Employee x = new Employee();
      System.out.println("-----Object Created-----");
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
