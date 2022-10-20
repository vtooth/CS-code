public class MantoothV06
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
 private String LG;
 public Students()
 {
    ID = (int)(Math.random()*9000+1000); 
    Test1 = (int)(Math.random()*41+60);
    Test2 = (int)(Math.random()*41+60);
    Test3 = (int)(Math.random()*41+60);
    Avg = (Test1+Test2+Test3)/3;
    EC = (int)(Math.random()*5+1);
    if(Avg >= 90)
        LG = "A";
    if(80 <= Avg && Avg <= 89)
        LG = "B";
    if(75 <= Avg && Avg <= 79)
        LG = "C";
    if(70 <= Avg && Avg <= 74)
        LG = "D";
    if(Avg <= 70)
        LG = "F";
 }
 public void Display()
 {
    System.out.println(ID+" :  Test 1 : "+Test1+"   Test 2 : "+Test2+"  Test 3 : "+Test3+"   Avg. : "+Avg+"\t"+LG);
 }
 public void ECDisplay()
 {
    Avg = (Test1+Test2+Test3+EC)/3;
    System.out.println(ID+" :  Test 1 : "+Test1+"   Test 2 : "+Test2+"  Test 3 : "+(Test3+EC)+"   Avg. : "+Avg+"\t"+LG); 
 }
}
