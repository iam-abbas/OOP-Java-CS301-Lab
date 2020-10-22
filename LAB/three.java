import java.io.*;
import java.lang.*;
import java.util.*;

class Teacher {
  String teacher_name;
  String sec;
  String subject_1;
  String subject_2;

  Teacher(String teacher_name, String sec, String subject_1, String subject_2) {
    this.teacher_name = teacher_name;
    this.sec = sec;
    this.subject_1 = subject_1;
    this.subject_2 = subject_2;
  }
}

class Student {
  String rollno;
  String name2;
  String subject1, subject2, subject3, subject4;

  Student(
    String rollno,
    String name2,
    String subject1,
    String subject2,
    String subject3,
    String subject4
  ) {
    this.rollno = rollno;
    this.subject1 = subject1;
    this.subject2 = subject2;
    this.subject3 = subject3;
    this.subject4 = subject4;
  }
}

public class three {

  public static void main(String[] args) {
    List<Teacher> t = new ArrayList<Teacher>();
    ArrayList<Student> s = new ArrayList<Student>();

    try {
      File fis = new File("teachers.txt");
      File fis1 = new File("students.txt");

      Scanner file = new Scanner(fis).useDelimiter("\\s+");
      Scanner file1 = new Scanner(fis1).useDelimiter("\\s+");
      while (file1.hasNext()) {
        String data1 = file1.nextLine();
        String[] a1 = data1.split("\\s+");

        // Storing data from student.txt into ArrayList
        s.add(new Student(a1[0], a1[1], a1[2], a1[3], a1[4], a1[5]));
      }
      while (file.hasNext()) {
        String data = file.nextLine();
        String[] a = data.split("\\s+");
        t.add(new Teacher(a[0], a[1], a[2], a[3]));
      }
      Iterator itr = t.iterator();

      while (itr.hasNext()) {
        Teacher T = (Teacher) itr.next();
        if ((T.subject_1.equals("OOPS")) && (T.subject_2.equals("MATHS"))) {
          System.out.println(T.teacher_name);
        }
      }

      file.close();
      file1.close();
    } catch (FileNotFoundException e) {
      System.out.println(e);
    }
  }
}
