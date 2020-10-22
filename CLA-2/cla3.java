
import java.util.*;
import java.io.*;
class Fibonacci extends Thread
{
    private PipedWriter out = new PipedWriter();
    public PipedWriter getPipedWriter()
    {
        return out;
    }
    public void run()
    {
        Thread t = Thread.currentThread();
        t.setName("Fibonacci");
        System.out.println(t.getName() + " Thread processed");
        int fibo1=0,fibo2=1,fibo=0;
        while(true)
        {
            try
            {
                fibo = fibo1 + fibo2;
                if(fibo>1000)
                {
                    out.close();
                    break;
                }
                out.write(fibo);
                sleep(10);
            }
            catch(Exception e)
            {
                System.out.println("Fibonacci:"+e);
            }
            fibo1=fibo2;
            fibo2=fibo;
        }
        //System.out.println(t.getName() + " Thread exiting");
    }
}
class Prime extends Thread
{
    private PipedWriter out1 = new PipedWriter();
    public PipedWriter getPipedWriter()
    {
        return out1;
    }
    public void run()
    {
        Thread t= Thread.currentThread();
        t.setName("Prime");
        System.out.println(t.getName() + " Thread processed");
        int prime=1;
        while(true)
        {
            try
            {
                if(prime>1000)
                {
                    out1.close();
                    break;
                }
                if(isPrime(prime))
                out1.write(prime);
                prime++;
                sleep(0);
            }
            catch(Exception e)
            {
                System.out.println(t.getName() + " thread exiting.");
                System.exit(0);
            }
        }
    }
    public boolean isPrime(int n)
    {
        int m=(int)Math.round(Math.sqrt(n));
        if(n==1 || n==2)
        return true;
        for(int i=2;i<=m;i++)
        if(n%i==0)
        return false;
        return true;
    }
}
public class Main
{
    public static void main(String[] args) throws Exception
    {
        Thread t=Thread.currentThread();
        t.setName("Main");
        System.out.println(t.getName() + " thread Started...");
        Fibonacci fibonacci = new Fibonacci();
        Prime prime = new Prime();
        PipedReader fpr = new PipedReader(fibonacci.getPipedWriter());
        PipedReader ppr = new PipedReader(prime.getPipedWriter());
        fibonacci.start();
        prime.start();
        int fib=fpr.read(), prm=ppr.read();
        System.out.println("The numbers common to PRIME and FIBONACCI:");
        while((fib!=-1) && (prm!=-1))
        {
            while(prm<=fib)
            {
                if(fib==prm)
                System.out.println(prm);
                prm=ppr.read();
            }
            fib=fpr.read();
        }
        System.out.println(t.getName() + " thread exited");
    }
}