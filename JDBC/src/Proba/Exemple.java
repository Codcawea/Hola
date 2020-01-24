package Proba;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;
import java.io.IOException;
import java.sql.*;

public class Exemple {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/proba";
	   static final String USER = "root";
	   static final String PASS = "";   
	   public static void main(String[] args) {
	   Connection conn = null;
	   Statement stmt = null;
	   
	   try{
		      Class.forName("com.mysql.jdbc.Driver");
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      stmt = conn.createStatement();
		      String sql = "SELECT topo, ta, madre FROM numeros";
		      ResultSet rs = stmt.executeQuery(sql);
		      
		      while(rs.next()){
		    	  int topo = rs.getInt("topo");
		    	  int ta = rs.getInt("ta");
		    	  int madre = rs.getInt("madre");
		    	  System.out.println("Topo = " +topo+" ,Ta = " + ta +" ,Madre = " + madre);
		       }
		      System.out.println("En quina taula vols fer la inserió de valors");
		      Scanner lector = new Scanner(System.in);
		      String taulaform = lector.nextLine();
		      switch(taulaform)
		      {
		      case "Insert":
		    	  String sql1 = "INSERT INTO dades(Edad, ID, Nom, Cognomm) VALUES (?,?,?,?)";
		    	  stmt.executeUpdate(sql1);
		    	  System.out.println("Introdueix el Edad: ");
		    	  boolean Edad = lector.hasNextInt();
		    	  System.out.println("Introdueix el ID: ");
		    	  boolean Id = lector.hasNextInt();
		    	  System.out.println("Introdueix el Nom: ");
		    	  String nom = lector.nextLine();
		    	  System.out.println("Introdueix el Cognom: ");
		    	  String cognom = lector.nextLine();        
		      }
		      {
		      case "Update":
		    	  
		      }
		      stmt.executeUpdate(sql);
		      System.out.println("Inserted records into the table");
		      
		      stmt=conn.createStatement();
		      
		      sql = "UPDATE dades SET edad = 26 WHERE id in (3, 4)";
		      stmt.executeUpdate(sql);
		      
		      sql = "SELECT edad, nom, cognom, id FROM dades";
		      ResultSet qs = stmt.executeQuery(sql);
		      
		      while(qs.next()) {
		    	  int edad = rs.getInt("edad");
		    	  String nom = rs.getString("nom");
		    	  String cognom = rs.getString("cognom");
		    	  int id = rs.getInt("id");
		    	  
		    	  System.out.println("Edad: " + edad + " ,Nom: "+ nom + " ,Cognom: " + cognom + " ,ID: " +id);
		      }
		      
		      rs.close();
		      qs.close();
		      stmt.close();
		      conn.close();
	   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }
		   System.out.println("Goodbye!");
		}
}
