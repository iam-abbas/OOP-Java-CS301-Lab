import java.util.Random;

class RandomNumberThread extends Thread {

  public void run() {
    Random random = new Random();
    for (int i = 0; i < 10; i++) {
      int randomInteger = random.nextInt(100);
      System.out.println("Random Integer generated : " + randomInteger);
      if ((randomInteger % 2) == 0) {
        SquareThread sThread = new SquareThread(randomInteger);
        sThread.start();
      } else {
        ValThread vThread = new ValThread(randomInteger);
        vThread.start();
      }
      try {
        Thread.sleep(1000);
      } catch (InterruptedException ex) {
        System.out.println(ex);
      }
    }
  }
}

class SquareThread extends Thread {
  int number;

  SquareThread(int randomNumbern) {
    number = randomNumbern;
  }

  public void run() {
    System.out.println("Square of " + number + " = " + (number * number));
  }
}

class ValThread extends Thread {
  int number;

  ValThread(int randomNumber) {
    number = randomNumber;
  }

  public void run() {
    System.out.println(
      " Cube value of " + number + " = " + (number * number * number)
    );
  }
}

public class MultiThreadingTest {

  public static void main(String args[]) {
    RandomNumberThread rnThread = new RandomNumberThread();
    rnThread.start();
  }
}
