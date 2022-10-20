public class MantoothV05
{
    public static void main (String []args)
    {
        //Getting info for the students 
        Students a = new Students();
        Students b = new Students();
        Students c = new Students();
        //Printing info
        System.out.println("\n\n");
        a.Display();
        b.Display();
        c.Display();
        System.out.println("\n\n");
        System.out.println("Grades after extra credit");
        a.ECDisplay();
        b.ECDisplay();
        c.ECDisplay();
    }
}
class Students
{
 private int ID, Test1, Test2,Test3, Avg, EC, ECAvg;
 public Students()
 {
    ID = (int)(Math.random()*9000+1000); 
    Test1 = (int)(Math.random()*41+60);
    Test2 = (int)(Math.random()*41+60);
    Test3 = (int)(Math.random()*41+60);
    Avg = (Test1+Test2+Test3)/3;
    EC = (int)(Math.random()*5+1);
    ECAvg = (Test1+Test2+Test3+EC)/3;
 }
 public void Display()
 {
    System.out.println(ID+" :  Test 1 : "+Test1+"   Test 2 : "+Test2+"  Test 3 : "+Test3+"   Avg. : "+Avg);
 }
 public void ECDisplay()
 {
    System.out.println(ID+" :  Test 1 : "+Test1+"   Test 2 : "+Test2+"  Test 3 : "+(Test3+EC)+"   Avg. : "+ECAvg); 
 }
}
