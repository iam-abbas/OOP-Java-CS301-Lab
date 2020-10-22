import java.util.*;
import java.lang.*;
class Dequeue {
    ArrayDeque <String> A = new ArrayDeque <> ();

    void insert_front(String i){
        A.addFirst(i);
    }

    void insert_back(String j){
        A.addLast(j);
    }

    void del_front(){
        A.removeFirst();
    }

    void del_back(){
        A.removeLast();
    }

    void display_front(){
        Iterator <String> itr = A.iterator();
        while(itr.hasNext()) {
            System.out.print(itr.next());
            System.out.print(", ");
            
        }
    }


    void display_back(){
        Iterator <String> ditr = A.descendingIterator();
        while(ditr.hasNext()) {
            System.out.print(ditr.next());
            System.out.print(", ");
          

        }

    }
}

public class Dequeue_Test{
    public static void main(String [] args){
        Dequeue A = new Dequeue ();
        Scanner s = new Scanner(System.in);
        String n;
        do{
        System.out.println("MENU\n");
        System.out.println("1.Insert from front");
        System.out.println("2.Insert from back");
        System.out.println("3.Delete from front");
        System.out.println("4.Delete from back");
        System.out.println("5.Display from front to back");
        System.out.println("6.Display from back to front");
        System.out.println("7.Exit\n");
        
        System.out.print("Enter your choice:");
        n = s.next();
        
        switch(n){
            case "1": {
                String a;
                System.out.print("Enter the string you want to add in front:");
                a = s.next();
                A.insert_front(a);
            }
                break;

            case "2" :{
                String b;
                System.out.print("Enter the string you want to add at back:");
                b  = s.next();
                A.insert_back(b);
            }
            break;

            case "3":{
                A.del_front();
                
            }
            break;

            case "4":{
                A.del_back();

            }
            break;

            case "5":{
                System.out.print("FRONT TO BACK -->");
                A.display_front();
                System.out.println();
            }
            break;

            case "6":{
                System.out.print("BACK TO FRONT -->");
                A.display_back();
                System.out.println();
            }
            break;

            case "7":{
                System.exit(0);
            }
            break;

            default:
            {
                System.out.println("Wrong Choice");
                System.out.println();
            }
            break;
        }

      }while(n!="7");
    }
}