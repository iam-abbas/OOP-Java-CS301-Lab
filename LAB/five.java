import java.io.*;
import java.util.*;

class Teacher {
    String first_name;
    String last_name;
    String desg;
    String salary;

    void firstName(String fn) {
        first_name = fn;
    }

    void lastName(String ln) {
        last_name = ln;
    }

    void designation(String d) {
        desg = d;
    }

    void Salary(String s) {
        salary = s;
    }

    void storeData() {
        try {
            FileWriter teacherWrite = new FileWriter("teacher.txt", true);
            String[] newEntry = new String[3];
            String name = first_name + " " + last_name;
            newEntry[0] = name;
            newEntry[1] = desg;
            newEntry[2] = salary;
            String[] temp_array;
            String temp;
            List<String[]> existing = new ArrayList<String[]>();
            try {
                FileInputStream rf = new FileInputStream("teacher.txt");
                Scanner scan_file = new Scanner(rf).useDelimiter("\t");
                boolean added = false;
                if (scan_file.hasNext()) {
                    while (scan_file.hasNext()) {
                        temp = scan_file.nextLine();
                        temp_array = temp.split("\t");
                        if (temp_array[0].compareTo(name) >= 0 && added == false) {
                            System.out.println("Here");
                            existing.add(newEntry);
                            existing.add(temp_array);
                            added = true;
                            continue;
                        } else {
                            existing.add(temp_array);
                        }
                    }
                    if (added == false) {
                        existing.add(newEntry);
                    }
                } else {
                    existing.add(newEntry);
                }
                FileWriter emptyFile = new FileWriter("teacher.txt");
                emptyFile.write("");
                emptyFile.close();
                ListIterator<String[]> it = existing.listIterator();
                while (it.hasNext()) {
                    String tEntry = String.join("\t", it.next());
                    System.out.println(tEntry);
                    teacherWrite.write(tEntry + "\n");
                }
                teacherWrite.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void Display() {
        try {
            FileInputStream f = new FileInputStream("teacher.txt");
            Scanner scan = new Scanner(f).useDelimiter("\t");
            while (scan.hasNext()) {
                System.out.println(scan.nextLine());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

public class five {
    public static void NewTeacher() {
        Scanner user_input = new Scanner(System.in);
        Teacher entry = new Teacher();
        System.out.println("Enter First Name: ");
        entry.firstName(user_input.nextLine());
        System.out.println("Enter Last Name: ");
        entry.lastName(user_input.nextLine());
        System.out.println("Enter Designation: ");
        entry.designation(user_input.nextLine());
        System.out.println("Enter Salary: ");
        entry.Salary(user_input.nextLine());
        entry.storeData();
    }

    public static void main(String[] args) {
        Scanner user_scan = new Scanner(System.in);
        System.out.println("**********MENU**********");
        System.out.println("1. New Entry");
        System.out.println("2. Display Data");
        System.out.println("\n");
        int option = user_scan.nextInt();
        switch (option) {
            case 1:
                NewTeacher();
                break;
            case 2:
                Teacher t = new Teacher();
                t.Display();
        }

    }
}