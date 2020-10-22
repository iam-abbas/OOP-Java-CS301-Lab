import java.util.*;
import java.util.ArrayList;

public class two {
    public static void main(String args[]) {
        ArrayList<String> arr = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        arr.add("Abbas");
        arr.add("Abrar");
        arr.add("Jai");
        arr.add("Deep");
        arr.add("AB");
        arr.add("Rar");
        arr.add("Abs");
        arr.add("Cool");
        arr.add("Man");
        arr.add("Boy");
        ArrayList<String> phones = new ArrayList<String>();
        phones.add("73892022");
        phones.add("345678902");
        phones.add("345678909");
        phones.add("34567890");
        phones.add("234567890");
        phones.add("876543222");
        phones.add("564783933");
        phones.add("5647839875");
        phones.add("9348746372");
        phones.add("14382900");
        int size = arr.size();
        while (size <= 20) {
            System.out.print("Enter A Name: ");
            String S1 = sc.next();
            if (S1.equals("q")) {
                break;
            } else {
                boolean found = arr.contains(S1);
                int x = arr.indexOf(S1);
                if (found) {
                    System.out.println(phones.get(x));
                } else {
                    System.out.println("Enter The Phone No. ");
                    String mob = sc.next();
                    phones.add(mob);
                    arr.add(S1);
                }
            }
        }
        for (int i = 0; i < size; i++) {
            System.out.println(arr.get(i) + '\t' + phones.get(i));
        }

    }
}