import java.util.*;

public class one {

  public static void main(String[] args) {
    int num;

    num = (int) (Math.random() * (50 + 1));

    Scanner scan = new Scanner(System.in);

    int guessed;
    int attempts;
    int n = 0;
    System.out.println("Enter the number of attempts");
    attempts = scan.nextInt();
    do {
      System.out.print("Guess a number between 1-50: ");
      guessed = scan.nextInt();
      n++;
      if (guessed == num) System.out.println("Your guessed right!"); else if (
        guessed < num
      ) System.out.println(
        "Your guess is smaller than the number."
      ); else if (guessed > num) System.out.println(
        "Your guess is greater than the number."
      );
    } while (guessed != num && n != attempts);
  }
}
