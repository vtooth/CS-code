import java.util.Scanner;
public class MantoothV02
{
    public static void main(String args[])
    {
        Scanner numbers = new Scanner(System.in);
        int Test1Score;
        int Test1Questions;
        int Test2Score;
        int Test2Questions;
        int Test3Score;
        int Test3Questions;
        int Test1;
        int Test2;
        int Test3;
        int TestAverage;
        System.out.println("\nViolet Mantooth");
        System.out.println("Lab 02");
        
        System.out.println("\nHow many did you get right on the first test? \t");
        Test1Score = numbers.nextInt();
        System.out.println("How many questions were on the first test? \t");
        Test1Questions = numbers.nextInt();
        System.out.println("How many did you get right on the second test? \t");
        Test2Score = numbers.nextInt();
        System.out.println("How many questions were on the second test? \t");
        Test2Questions = numbers.nextInt();
        System.out.println("How many did you get right on the third test? \t");
        Test3Score = numbers.nextInt();
        System.out.println("How many questions were on the third test? \t");
        Test3Questions = numbers.nextInt();
        System.out.println("--------------");
        Test1 = Test1Score*100/Test1Questions;
        System.out.println("Test 1 : "+Test1+"%");
        Test2 = Test2Score*100/Test2Questions;
        System.out.println("Test 2 : "+Test2+"%");
        Test3 = Test3Score*100/Test3Questions;
        System.out.println("Test 3 : "+Test3+"%");
        System.out.println("--------------");
        TestAverage = (Test1+Test2+Test3)/3;
        System.out.println("Test Average : "+TestAverage+"%");
      
    }
}