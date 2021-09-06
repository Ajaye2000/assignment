package bank_data_transaction;
import java.util.Scanner;
import java.io.*;
public class MainClass {
  public  static void main(String[] args)throws Exception {
	  DatabaseConnection dbcon=new DatabaseConnection();
	  Scanner sc=new Scanner(System.in);
	  System.out.println("1.Type 1 to display all the row/s in table");
	  System.out.println("2.Type 2 to display all row/s corresponding to client name");
	  System.out.println("3.Type 3 to add new row to the table");
	  System.out.println("4.Type 4 to update row/s corresponding to transid");
	  System.out.println("5.Type 5 to delete row/s corresponding to transid");
	  boolean flag=true;
	  while(flag) {
	  System.out.print("Enter number between 0 and 6:");
	  int no=sc.nextInt();
	  sc.nextLine();
	  if(no>5 || no<1) {
		  System.out.println("Invalid number..Type number between 0 and 6");
		  continue;
	  }
	  else if(no==1) {
		  BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Users\\Ajaye\\Documents\\output\\javaoutput1.csv"));
		  
		  Bank b[]=dbcon.getAllTableData();
		  if(b.length<1) {
			  System.out.println("No rows to display");
		  }
		  for(int i=0;i<b.length;i++) {
			  
		      bw.write(b[i].gettransid()+","+b[i].getclientname()+","+b[i].getaccno()+","+b[i].gettransactiontype()+","+b[i].getcreditordebit()+","+b[i].gettransanctionamount()+"\n");
		      
		  }
		  System.out.println("Data successfully written into javaoutput1 csv file");
		  bw.close();
		  
	  }
	  else if(no==2) {
      BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Users\\Ajaye\\Documents\\output\\javaoutput2.csv"));
      System.out.print("Enter client name whose row/s to display :");
	  String clientname=sc.nextLine();
	  Bank b1[]=dbcon.getTableDataForClientName(clientname);
	  if(b1.length<1) {
		  System.out.println("Invalid client name");
	  }
	  for(int i=0;i<b1.length;i++) {
		  
		  bw.write(b1[i].gettransid()+","+b1[i].getclientname()+","+b1[i].getaccno()+","+b1[i].gettransactiontype()+","+b1[i].getcreditordebit()+","+b1[i].gettransanctionamount()+"\n");
	  }
	  System.out.println("Data successfully written into javaoutput2 csv file");
	  bw.close();
	  }
	  else if(no==3) {
		  System.out.print("Enter all values line by line for inserting new row:");
		  int transid=sc.nextInt();
		  sc.nextLine();
		  long accno=sc.nextLong();
		  sc.nextLine();
		  String clientname=sc.nextLine();
		  String transactiontype=sc.nextLine();
		  double transactionamount=sc.nextDouble();
		  sc.nextLine();
		  String creditordebit=sc.nextLine();
		  int count=dbcon.insertTableData(transid, clientname, accno, transactiontype, transactionamount,creditordebit);
		  
		  System.out.println(count+" row/s affected");
		  
		  
	  }
	  else if(no==4) {
		  System.out.print("Enter transid whose row/s to update:");
		  int id=sc.nextInt();
		  sc.nextLine();
		  System.out.print("Enter client name to update in corresponding transid row/s provided");
		  String clientname=sc.nextLine();
		  int count1=dbcon.updateTableDataForTransId(id,clientname);
		  if(count1<1) {
			  System.out.println("No row/s available for the given transid");
			  
		  }
		  else {
			  System.out.println(count1+" row/s affected");
		  }
	  }
	  else if(no==5) {
		  System.out.print("Enter transid whose row/s to delete :");
		  int id=sc.nextInt();
		  int count2=dbcon.deleteTableDataForTransId(id);
		  if(count2<1) {
			  System.out.println("No row/s available for the given transid");
			  
		  }
		  else {
			  System.out.println(count2+" row/s affected");
		  }
	  }
	  System.out.println("Do you want to continue (type yes/no)");
	  String choice=sc.nextLine();
	  if(choice.equals("no")) {
		  dbcon.closeConnection();
		  flag=false;
		  

	  }
	  }
  }
}
	  
	  
	  
  
	  
  


