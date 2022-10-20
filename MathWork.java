import java.util.*;
public class MathWork
{
   public static Student person = new Student();
   public static void main(String[]args)
   {
   int choice = 0;
   Scanner input = new Scanner(System.in);
      while(choice !=8)
      {
         menu();
         choice = input.nextInt();
         if(choice == 1)
         {
           // if i have extra time use user input to ask for range and if use int or double
            int rand1 = (int)(Math.random()*500+1);
            int rand2 = (int)(Math.random()*500+1);
            System.out.println(rand1);
            System.out.println("+");
            System.out.println(rand2);
            int ans = rand1 + rand2;
            System.out.print("answer : ");
            int answer = input.nextInt();
            if(answer == ans)
            {System.out.println("correct\n\n");
            person.Add(true);}
            else
            {System.out.println("incorrect\n\n");
            person.Add(false);}
        
         }
         
         if(choice == 2)
         {
            int rand1 = (int)(Math.random()*500+1);
            int rand2 = (int)(Math.random()*500+1);
            System.out.println(rand1);
            System.out.println("-");
            System.out.println(rand2);
            int ans = rand1 - rand2;
            System.out.print("answer : ");
            int answer = input.nextInt();
            if(answer == ans)
            {System.out.println("correct\n\n");
            person.Subtract(true);}
            else
            {System.out.println("incorrect\n\n");
            person.Subtract(false);}
         }
         
         if(choice == 3)
         {
            int rand1 = (int)(Math.random()*20+1);
            int rand2 = (int)(Math.random()*20+1);
            System.out.println(rand1+" * "+ rand2);
            int ans = rand1 * rand2;
            System.out.print("answer : ");
            int answer = input.nextInt();
            if(answer == ans)
            {System.out.println("correct\n\n");
            person.Multiply(true);}
            else
            {System.out.println("incorrect\n\n");
            person.Multiply(false);}
         }
         
         if(choice == 4)
         {
            int rand1 = (int)(Math.random()*20+1);
            int rand2 = (int)(Math.random()*20+1);
            System.out.println(rand1+" / "+ rand2);
            double ans = (double)(rand1) / (double)(rand2);
            ans = (int)(ans*100);
            ans /=100.0;
            System.out.print("answer (use to 2 decimal places. Don't round): ");
            double answer = input.nextDouble();
            if(answer == ans)
            {System.out.println("correct\n\n");
            person.Divide(true);}
            else
            {System.out.println("incorrect\n\n");
            person.Divide(false);}

         }
         
         if(choice == 5)
         {
         int rand = (int)(Math.random()*4+1);
         if(rand == 1)
         {
            System.out.println("ADDITION");
            int rand1 = (int)(Math.random()*500+1);
            int rand2 = (int)(Math.random()*500+1);
            System.out.println(rand1);
            System.out.println("+");
            System.out.println(rand2);
            int ans = rand1 + rand2;
            System.out.print("answer : ");
            int answer = input.nextInt();
            if(answer == ans)
            {System.out.println("correct\n\n");
            person.Add(true);}
            else
            {System.out.println("incorrect\n\n");
            person.Add(false);}
         }
         
         if(rand == 2)
         {
            System.out.println("SUBTRACTION");
            int rand1 = (int)(Math.random()*500+1);
            int rand2 = (int)(Math.random()*500+1);
            System.out.println(rand1);
            System.out.println("-");
            System.out.println(rand2);
            int ans = rand1 - rand2;
            System.out.print("answer : ");
            int answer = input.nextInt();
            if(answer == ans)
            {System.out.println("correct\n\n");
            person.Subtract(true);}
            else
            {System.out.println("incorrect\n\n");
            person.Subtract(false);}
            
         }
         
         if(rand == 3)
         {
            System.out.println("MULTIPLICATION");
            int rand1 = (int)(Math.random()*20+1);
            int rand2 = (int)(Math.random()*20+1);
            System.out.println(rand1+" * "+ rand2);
            int ans = rand1 * rand2;
            System.out.print("answer : ");
            int answer = input.nextInt();
            if(answer == ans)
            {System.out.println("correct\n\n");
            person.Multiply(true);}
            else
            {System.out.println("incorrect\n\n");
            person.Multiply(false);}
         }
         
         if(rand == 4)
         {
            System.out.println("DIVISION");
            int rand1 = (int)(Math.random()*20+1);
            int rand2 = (int)(Math.random()*20+1);
            System.out.println(rand1+" / "+ rand2);
            double ans = rand1 / rand2;
            ans *=100;
            ans = (int)(ans);
            ans /=100.0;
            System.out.print("answer (round to 2 decimal places): ");
            double answer = input.nextDouble();
            if(answer == ans)
            {System.out.println("correct\n\n");
            person.Divide(true);}
            else
            {System.out.println("incorrect\n\n");
            person.Divide(false);}
         }
         
         }
         
         if(choice == 6)
         {
         person.PrintScore();
         }
         
         if(choice == 7)
         {
         person.reset();
         }
         
      }
   }
   
   public static void menu()
   {
   System.out.println("1) Addition Problem");
   System.out.println("2) Subtraction Problem");
   System.out.println("3) Multiplication Problem");
   System.out.println("4) Division Problem");
   System.out.println("5) Random Problem");
   System.out.println("6) See Stats");
   System.out.println("7) Reset Stats");
   System.out.println("8) Exit");
   System.out.println("Pick an option : \t");
   }
}

class Student
{
   private int P, M, D, A, S;
   private double MP,DP,AP,SP,PP;
   
   public Student()
   {
   P = 0;
   M = 0;
   D = 0;
   A = 0;
   S = 0;
   PP = 0;
   MP = 0;
   DP = 0;
   AP = 0;
   SP = 0;
   }
   
   public void Add(boolean correct)
   {
   double temp = AP*A/100;
   double temp2 = PP*P / 100;
   if(correct)
   {temp++;
     temp2++;}
   P++;
   A++;
   AP = (temp / A) *100;
   PP = (temp2 / P) *100;
   }
   
   public void Subtract(boolean correct)
   {
   double temp = SP*S/100;
   double temp2 = PP*P/100;
   if(correct)
   {temp++;
     temp2++;}
   S++;
   P++;
   SP = (temp / S) *100;
   PP = (temp2 / P) *100;
   }
   
   public void Multiply(boolean correct)
   {
   double temp = MP*M/100;
   double temp2 = PP*P/100;
   if(correct)
   {temp++;
     temp2++;}
   M++;
   P++;
   MP = (temp / M) *100;
   PP = (temp2 / P) *100;
   }
   
   public void Divide(boolean correct)
   {
   double temp = DP*D/100;
   double temp2 = PP*P/100;
   if(correct)
   {temp++;
     temp2++;}
   D++;
   P++;
   DP = (temp / D) *100;
   PP = (temp2 / P) *100;
   }
   
   public void PrintScore()
   {
   double Ptemp = (int)(PP *100);
   Ptemp /=100.0;
   double Atemp = (int)(AP *100);
   Atemp /=100.0;
   double Stemp = (int)(SP *100);
   Stemp /=100.0;
   double Mtemp = (int)(MP *100);
   Mtemp /=100.0;
   double Dtemp = (int)(DP *100);
   Dtemp /=100.0;
   System.out.println("Number of Problems Solved : "+P+"\tPercent Correct : "+Ptemp+"%");
   System.out.println("\nYou answered "+Atemp+"% of addition problems correctly");
   System.out.println("You answered "+Stemp+"% of subtraction problems correctly");
   System.out.println("You answered "+Mtemp+"% of multiplication problems correctly");
   System.out.println("You answered "+Dtemp+"% of division problems correctly");
   }
   
   public void reset()
   {
      P = 0;
      M = 0;
      D = 0;
      A = 0;
      S = 0;
      PP = 0;
      MP = 0;
      DP = 0;
      AP = 0;
      SP = 0;
   }
   
}