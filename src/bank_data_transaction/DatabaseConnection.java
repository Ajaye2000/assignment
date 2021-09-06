
package bank_data_transaction;
import java.sql.*;
import java.io.*;
import java.util.Properties;



class DatabaseConnection {
    Connection con=null;
	public DatabaseConnection() throws Exception{
		
		Properties prop=new Properties();
		prop.load(new FileInputStream("config.properties"));
		Class.forName("com.mysql.cj.jdbc.Driver");
	    con=DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("user"),prop.getProperty("password"));
	    System.out.println("Connected to Database");
	}
	public Bank[] getAllTableData()throws Exception {
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs=st.executeQuery("select * from bank_data_transaction");
	    int count=0;
	    while(rs.next()) {
	    	count++;
	    }
	    rs.beforeFirst();
		Bank[] obj=new Bank[count];
		int index=0;
		while(rs.next()) {
			
			obj[index++]=new Bank(rs.getInt(1),rs.getString(2),rs.getLong(3),rs.getString(4),rs.getDouble(6),rs.getString(5));
		
		}
		st.close();
		return obj;
	   }
	public Bank[] getTableDataForClientName(String clientname)throws Exception {
	Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	ResultSet rs=st.executeQuery("select * from bank_data_transaction where client_name='"+clientname +"'");
    int count=0;
    while(rs.next()) {
    	count++;
    }
    rs.beforeFirst();
	Bank[] obj=new Bank[count];
	int index=0;
	while(rs.next()) {
		
		obj[index++]=new Bank(rs.getInt(1),rs.getString(2),rs.getLong(3),rs.getString(4),rs.getDouble(6),rs.getString(5));
	
	}
	st.close();
	return obj;
   }
	public int insertTableData(int transid,String clientname,long accno,String transactiontype,double transactionamount,String creditordebit)throws Exception {
		PreparedStatement st=con.prepareStatement("insert into bank_data_transaction values(?,?,?,?,?,?)");
		st.setString(2,clientname);
		st.setInt(1,transid);
		st.setLong(3, accno);
		st.setString(4,transactiontype);
		st.setDouble(6,transactionamount);
		st.setString(5,creditordebit);
		int count=st.executeUpdate();
		st.close();
	    return count;
		
		
	}
	public int updateTableDataForTransId(int transid,String clientname)throws Exception {
		PreparedStatement st=con.prepareStatement("update bank_data_transaction set client_name=? where trans_id=?");
		st.setString(1,clientname);
		st.setInt(2,transid);
		int count=st.executeUpdate();
		st.close();
	    return count;
		
		
	}
	public int deleteTableDataForTransId(int transid)throws Exception {
		Statement st=con.createStatement();
		int count=st.executeUpdate("delete from bank_data_transaction where trans_id="+transid);
		st.close();
	    return count;
		
		
	}
	public void closeConnection()throws Exception {
		con.close();
		System.out.println("Disconnected from Database");
	}

	
}


