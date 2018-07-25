package DatabaseTesting.DatabaseExposure;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;


public class DatabaseTesting {

public static void main(String[] args) throws ClassNotFoundException, SQLException, UnknownHostException 
{
	int count=0;
	String[]row = new String[count];
	Connection m_Connection;
    if(Inet4Address.getLocalHost().getHostAddress().equals("172.31.21.89"))
    {
    	 m_Connection = DriverManager.getConnection(
    	        "jdbc:sqlserver://localhost;DatabaseName=MEDarchon", "sa", "sql@123");

    }
    else
    {
    	 m_Connection = DriverManager.getConnection(
    	        "jdbc:sqlserver://localhost;DatabaseName=MEDarchon", "sa", "sql@123");

    	//fileName = System.getProperty("user.dir") + "/testData/AutomationReport.html";
    }
	   
    Statement m_Statement = m_Connection.createStatement();
    String query = "/****** Script for SelectTopNRows command from SSMS  ******/\r\n" + 
    		"SELECT  [Id]\r\n" + 
    		"      ,[StaffId]\r\n" + 
    		"      ,[Name]\r\n" + 
    		"      ,[FirstName]\r\n" + 
    		"      ,[LastName]\r\n" + 
    		"      ,[Title]\r\n" + 
    		"      ,[Email]\r\n" + 
    		"      ,[Phone]\r\n" + 
    		"      ,[OfficePhone]\r\n" + 
    		"      ,[Pager]\r\n" + 
    		"      ,[LastModified]\r\n" + 
    		"      ,[Created]\r\n" + 
    		"      ,[UserLastSeenTimestamp]\r\n" + 
    		"      ,[DisabledFromAd]\r\n" + 
    		"      ,[DisabledFromQuarc]\r\n" + 
    		"      ,[OnlineStatus]\r\n" + 
    		"      ,[WizardCompletedDate]\r\n" + 
    		"  FROM [MEDarchon].[readmodels].[UserInfo]";

    ResultSet m_ResultSet = m_Statement.executeQuery(query);
    Random random = new Random();
    ArrayList<String> ar=new ArrayList<String>();

    while (m_ResultSet.next())
    {
    ar.add(m_ResultSet.getString(3));
    System.out.println("Value Captured:    " + ar.get(count++));
    }
    
    int randomIdx = random.nextInt(count);
    System.out.println("Test Data Value"  + ar.get(randomIdx));
         
            
}}