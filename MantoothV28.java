import java.util.*;
import core.data.*;
// find the difference w/ a loop w/ min & max, user input, display stations with same temperature
public class MantoothV28
{
//	static WeatherStation[] stations;
	public static void main(String[] args)
	{
		ArrayList<WeatherStation> stations = new ArrayList<WeatherStation>();
		ArrayList<String> station_urls = getStationList();

		Scanner numbers = new Scanner(System.in);
		Scanner words = new Scanner(System.in);

		long startTime = System.currentTimeMillis();
		System.out.println("There are "+station_urls.size()+" available North American weather stations.");
		System.out.print("Loading stations -----\tThis could take several minutes   ");

		for(int a=2375;a<2560;a++)//this is roughly the range of Texas Stations, the entire list takes about 20 minutes to read
		{
			try{stations.add(createStation(station_urls.get(a)));} catch(Exception e){}
		}
		startTime = System.currentTimeMillis()-startTime;
		System.out.println("\nLoad time :"+(startTime/1000)+" seconds");
      
      
		//start your code here
      
      double min = stations.get(0).getTemp();
      double max = 0;
      double difference = 0;
      for(int i = 0; i<stations.size(); i++)
      {
         if(stations.get(i).getTemp()>max)
            max = stations.get(i).getTemp();
         else if(stations.get(i).getTemp()<min)
            min = stations.get(i).getTemp();
      }
      difference = max - min;
      System.out.println("There is a "+ difference +" degree difference in reported Texas temperatures");
      System.out.println("\n\nAvailable stations: \n\n");
      for(int i = 1; i<stations.size()+1; i++)
      {
         System.out.print(stations.get(i-1));
         if(i%5 == 0)
         {
         System.out.println("\n");
         }
      }
      int index = -1;
      while(index == -1)
      {
         System.out.println("Select a station \t");
         String station = words.nextLine();
         for(int i = 0; i<stations.size(); i++)
         {
            if(stations.get(i).getID().equals(station))
               index = i;
         }
      }
      for(int i = 0; i<stations.size(); i++)
      {
         if(stations.get(i).getTemp() == stations.get(index).getTemp())
         {
            System.out.println(stations.get(i).getID() +" \t "+ stations.get(i).getTemp()+"      "+stations.get(i).getName());
         }
      }
      
	}
	/* Creates and returns an ArrayList of Strings representing
	 * the websites for all available weather station xml files
	 * @return 	a reference to an ArrayList containing String representations
	 *			of the websites for all available weather station xml files
	 */
	public static ArrayList<String> getStationList()
	{
		DataSource ds1 = DataSource.connect("https://w1.weather.gov/xml/current_obs/index.xml");
		ds1.setCacheTimeout(15 * 60);
      	ds1.load();
      	return ds1.fetchList("String","station/xml_url");
	}
	/* Creates and returns a WeatherStation object.
	 * The method returns null to avoid compile errors, you will have
	 * to change this.
	 * @param 	stationAddress  the website for the xml file
	 * @return 	a reference to the WeatherStation object found at the
	 *			parameter stationAddress
	 */
	public static WeatherStation createStation(String stationAddress)
	{
		DataSource ds1 = DataSource.connect(stationAddress);
		ds1.setCacheTimeout(15 * 60);
      	ds1.load();
      String ID = ds1.fetch("String","station_id");
      double temp = ds1.fetch("double","temp_f");
      String name = ds1.fetch("String","location");
      WeatherStation station = new WeatherStation(ID, name, temp);
		//create and return the WeatherStation object here

		return station;
	}
}
class WeatherStation
{
   private String ID, Name;
   private double Temp;
   public WeatherStation(String I, String N, double T)
   {
      ID = I;
      Name = N;
      Temp = T;
   }
   public String toString()
   {
      return ID + " "; 
   }
   public double getTemp()
   {
      return Temp;
   }
   public String getName()
   {
      return Name;
   }
   public String getID()
   {
      return ID;
   }
}
