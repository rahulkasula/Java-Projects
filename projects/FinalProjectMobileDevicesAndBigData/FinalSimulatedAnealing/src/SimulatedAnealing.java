import java.awt.List;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import com.mysql.jdbc.PreparedStatement;

public class SimulatedAnealing {
	static double randomRPS[]=new double[30];
	static String appliance[]=new String[100];
	 static ArrayList<ApplianceDetails> intial=new ArrayList<>();
	static ArrayList<ApplianceDetails> finalSchedule=new ArrayList<>();
	static ArrayList<ApplianceDetails> powerExtra=new ArrayList<>();
    static double  sum = 0;
    static double intialDev;
    static double finalDev;
    static double avgPower=0;
    static double idealPowerDiff;
    int parameter;
    static int countWhile;
    static int rps;
  static int count1=0;
    //static int[] startTime=new int[30];
    static double modifiedAvgPower=0;
    static ArrayList<Integer> startTime=new ArrayList<>();
    static double powerDiff[]=new double[100];
	public static void main(String[] args){
	countWhile=3;
		while(countWhile>0){
			intial.clear();
			finalSchedule.clear();
			powerExtra.clear();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/rahul", "root", "1234");
			//Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/rahul", "root", "1234");
			java.sql.Statement st =  con.createStatement();
			String sql = ("SELECT * from utility;");
			ResultSet rs = ((java.sql.Statement) st).executeQuery(sql);
			while(rs.next()) { 
				ApplianceDetails temp=new ApplianceDetails();
				finalSchedule.add(temp);
				intial.add(temp);		
			}
			con.close();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/rahul", "root", "1234");
			//Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/rahul", "root", "1234");
		
		    java.sql.Statement stmt =  con.createStatement();

		    // Use TRUNCATE
		    String sql = "TRUNCATE temp";
		    // Execute deletion
		    stmt.executeUpdate(sql);
		    con.close();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		
		
		
finalDev=0;
rps=6000;

		for(int i=0;i<10000;i++){
			double t=1000000;
			generateRPS(rps);

//Collections.sort(intial, ApplianceDetails.class);
idealPowerDiff=(avgPower)-(rps)/intial.size();
    Collections.sort(intial);
startTime.clear();
for(int j=0;j<intial.size();j++){
    //	System.out.println("please"+intial.get(j).getStart());
    	System.out.println("please"+intial.get(j).getStart());
    	startTime.add(intial.get(j).getStart());
    	
    }

			for(int j=0;j<intial.size();j++){
				Random rand=new Random();
				System.out.println("idealpower  "+idealPowerDiff);
				if((powerDiff[j]<idealPowerDiff)&&powerDiff[j]>0){
				System.out.println("Inside loop optimisedPower");
			finalSchedule.get(j).setPowerConsumption(powerDiff[j]);
			finalSchedule.get(j).setApplianceName(appliance[j]);
			finalSchedule.get(j).setStart(startTime.get(j));
		
			
			}else{
				double decider=rand.nextDouble();
				double diff=(powerDiff[j]-idealPowerDiff)/t;
				double exp=Math.pow(2.712, diff);
				//System.out.println("Outside loop decider  "+decider);
				//System.out.println("Outside loop exp "+exp);
				if(decider<1/(exp)){
					System.out.println("Inside loop decider  "+decider);
					System.out.println("Inside loop exp "+exp);
					finalSchedule.get(j).setPowerConsumption(powerDiff[j]);
					finalSchedule.get(j).setApplianceName(appliance[j]);
					finalSchedule.get(j).setStart(startTime.get(j));
				}
				//intial.get(j).getStart()
			}
				}
		t=0.0001*t;
		
		}
		
	 // for(int i=0;i<randSum(4,1).length;i++){
		//  System.out.println(randSum(4,2)[i]);
	 // }
		count1=0;
	for(int i=0;i<finalSchedule.size();i++){
		System.out.println("testing"+finalSchedule.get(i).getPowerConsumption());
		System.out.println("testingStart "+finalSchedule.get(i).getStart());
		int temp2=finalSchedule.get(i).getStart()+1;
	
				//SET UNIQUE_CHECKS=0;
		
		try {
			 Class.forName("com.mysql.jdbc.Driver").newInstance();
	         String url = "jdbc:mysql://localhost/rahul"; 
	         Connection conn = DriverManager.getConnection(url,"root","1234"); 
	         java.sql.Statement stmt =  conn.createStatement();

			    // Use TRUNCATE
			    String sql = "SET UNIQUE_CHECKS=0;";
			    // Execute deletion
			    

	         String query = " insert into temp (appliance, powerconsumption, start, end, username)"
	        	        + " values (?, ?, ?, ?, ?)";
	        	 
	        	      // create the mysql insert preparedstatement
	        	      java.sql.PreparedStatement preparedStmt = conn.prepareStatement(query);
	        	      preparedStmt.setString (1, finalSchedule.get(i).getApplianceName());
	     if(finalSchedule.get(i).getPowerConsumption()<idealPowerDiff){
	        	      preparedStmt.setDouble (2, (int)finalSchedule.get(i).getPowerConsumption());
	        	      
	     }
	     else{
	    	 ApplianceDetails temp=new ApplianceDetails();
				powerExtra.add(temp);
				powerExtra.get(count1).setPowerConsumption(finalSchedule.get(i).getPowerConsumption()-idealPowerDiff);
				powerExtra.get(count1).setApplianceName(finalSchedule.get(i).getApplianceName());
				powerExtra.get(count1).setStart(finalSchedule.get(i).getStart());
				count1++;
	    	 preparedStmt.setDouble (2, (int)idealPowerDiff);
	    	 
	     }
	        	      preparedStmt.setInt   (3, finalSchedule.get(i).getStart());
	        	      preparedStmt.setInt(4, temp2);
	        	      preparedStmt.setString    (5, "rahul");
	        	 
	        	      // execute the preparedstatement
	        	      stmt.executeUpdate(sql);
	        	      preparedStmt.execute();
	         conn.close(); 
	     } catch (Exception e) { 
	         System.err.println("Got an exception! "); 
	         System.err.println(e.getMessage()); 
	     } 
		

		//statement.executeUpdate("INSERT temp " + "VALUES (1002, 'McBeal', 'Ms.', 'Boston', 2004)");
	}
	
	for(int i=0;i<powerExtra.size();i++){
		ArrayList<Integer> choose=new ArrayList<>();
for(int j=0;j<24;j++){
	choose.add(j+1);
	if(j<powerExtra.size()){
	if(powerExtra.get(j).getStart()==j+1){
		choose.remove(j+1);}}

}
		int index = new Random().nextInt(choose.size());
		Integer randomValue = choose.get(index);		
		
		try {
			 Class.forName("com.mysql.jdbc.Driver").newInstance();
	         String url = "jdbc:mysql://localhost/rahul"; 
	         Connection conn = DriverManager.getConnection(url,"root","1234"); 
	        // java.sql.Statement stmt =  conn.createStatement();

			    // Use TRUNCATE
			   // String sql = "SET UNIQUE_CHECKS=0;";
			    // Execute deletion
			    

	         String query = " insert into temp (appliance, powerconsumption, start, end, username)"
	        	        + " values (?, ?, ?, ?, ?)";
	        	 
	        	      // create the mysql insert preparedstatement
	        	      java.sql.PreparedStatement preparedStmt = conn.prepareStatement(query);
	        	      preparedStmt.setString (1, powerExtra.get(i).getApplianceName());
	     
	        	      preparedStmt.setDouble (2, (int)powerExtra.get(i).getPowerConsumption());
	        	      
	     
	     System.out.println("powerExtra"+powerExtra.get(i).getPowerConsumption());
	                  
	     
	     
	                  preparedStmt.setInt   (3, randomValue);
	        	      preparedStmt.setInt(4, randomValue+1);
	        	      preparedStmt.setString    (5, "rahul");
	        	 
	        	      // execute the preparedstatement
	        	      //stmt.executeUpdate(sql);
	        	      preparedStmt.execute();
	         conn.close(); 
	     } catch (Exception e) { 
	         System.err.println("Got an exception! "); 
	         System.err.println(e.getMessage()); 
	     } 		
		
	}
	

	
	
	
	
	
	
	 	
	for(int i=0;i<finalSchedule.size()-1;i++){
		finalDev=finalDev+(finalSchedule.get(i+1).getPowerConsumption()-finalSchedule.get(i).getPowerConsumption());
		System.out.println("finalDev  "+finalDev);
		//System.out.println("powerAppliances"+intial.get(i).getPowerConsumption());
	}
	
	countWhile--;
	try {
		Thread.sleep(300000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	                                 }	
	}
	}

	private static double[] randSum(int n, double m,double rps) {
		Random rand = new Random();    
		sum=0;
		double randNums[] = new double[n];
	    for (int i = 0; i < randNums.length; i++) {
	        randNums[i] = rand.nextDouble();
	        sum =sum+ randNums[i];
	        System.out.println(sum);
	        System.out.println("initial "+randNums[i]);
	   
	        
	    }

	    for (int i = 0; i < randNums.length; i++) {
	        randNums[i] = (randNums[i]/sum) * m*rps;
	        System.out.println("final "+randNums[i]);
	 
	    }

	    return randNums;
	}

	 static void generateRPS(double rps){
		avgPower=0;
		intialDev=0;
		int count=0;
double[] temp=randSum(intial.size(),1,rps);

try {
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/rahul", "root", "1234");
	//Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/rahul", "root", "1234");
	java.sql.Statement st =  con.createStatement();
	String sql = ("SELECT * from utility;");
	ResultSet rs = ((java.sql.Statement) st).executeQuery(sql);
	while(rs.next()) { 
		String appliance=rs.getString("appliance");
	 int powerconsumption = rs.getInt("powerconsumption"); 
	 String start = rs.getString("start");
	 intial.get(count).setPowerConsumption(powerconsumption);
	 intial.get(count).setStart(Integer.parseInt(start));
	 int temp3=Integer.parseInt(start)+1;
	 
	 //intial.get(count).setEnd(Integer.parseInt(start));;
	 intial.get(count).setApplianceName(appliance);
	 System.out.println("start "+start);
	count++;
	}
	con.close();
} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}



//intial.get(0).setPowerConsumption(45);
//intial.get(0).setApplianceName("AC");
//intial.get(1).setPowerConsumption(55);
//intial.get(1).setApplianceName("TV");
//intial.get(2).setPowerConsumption(90);
//intial.get(2).setApplianceName("cooler");

for(int i=0;i<intial.size()-1;i++){
	intialDev=intialDev+(intial.get(i+1).getPowerConsumption()-intial.get(i).getPowerConsumption());
	System.out.println("intialDev  "+intialDev);
	System.out.println("powerAppliances"+intial.get(i).getPowerConsumption());
}

	for(int i=0;i<intial.size();i++){
			
			randomRPS[i]=temp[i];
			
				appliance[i]=intial.get(i).getApplianceName(); 
				powerDiff[i]=intial.get(i).getPowerConsumption()-randomRPS[i];
				modifiedAvgPower=modifiedAvgPower+powerDiff[i];
				avgPower=(avgPower+intial.get(i).getPowerConsumption());
				if(i==(intial.size()-1)){
					avgPower=avgPower/intial.size();
					
				}
				System.out.println("avgPower"+avgPower);
				System.out.println("powerconsumed"+intial.get(i).getPowerConsumption());
			System.out.println("RandomRPS at "+i+" "+randomRPS[i]);			
		}
	}		
}
