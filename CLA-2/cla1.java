/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*;
public class Main
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int n;
        int[] arr;
        System.out.println("Enter array size");
        String input = sc.nextLine();
        try 
        {
            n = Integer.parseInt( input);
            arr = new int[n];
        } 
        catch (NegativeArraySizeException e) 
        {
            System.out.println("Negative size of array canntot be created " +e);
            System.out.println("Array wasn't created");
            return;
        } 
        catch (NumberFormatException e) 
        {
            System.out.println("Error in numeric format " +e);
            System.out.println("Array wasn't created");
            return;
        }
        System.out.println("Array created succesuful. Enter values in the array");
        for (int i = 0; i < n; i++)
        arr[i] = sc.nextInt();
        System.out.println("Enter index number");
        n = sc.nextInt();
        try 
        {
            System.out.println("The element present at this index is:");
            System.out.println(arr[n - 1]);
        } 
        catch (ArrayIndexOutOfBoundsException e) 
        {
            System.out.println("Index exceeded size " +e);
        }
    }
}