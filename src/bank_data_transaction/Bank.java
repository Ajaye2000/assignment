package bank_data_transaction;

class Bank {
 private int transid;
 private long accno;
 private String clientname;
 private String transactiontype;
 private double transactionamount;
 private String creditordebit;
 public Bank(int transid,String clientname,long accno,String transactiontype,double transactionamount,String creditordebit) {
	 this.transid=transid;
	 this.accno=accno;
	 this.clientname=clientname;
	 this.transactiontype=transactiontype;
	 this.transactionamount=transactionamount;
	 this.creditordebit=creditordebit;
	 
 }
 public int gettransid() {
	 return this.transid;
 }
 public long getaccno() {
	 return this.accno;
 }
 public String getclientname() {
	 return this.clientname;
 }
 public String gettransactiontype() {
	 return this.transactiontype;
 }
public String getcreditordebit() {
	 return this.creditordebit;
 }
public  double gettransanctionamount() {
	 return this.transactionamount;
}
public int settransid(int transid) {
	  this.transid=transid;
	  return this.transid;
}
public long setaccno(long accno) {
	this.accno=accno;
	 return this.accno;
}
public String setclientname(String clientname) {
	this.clientname=clientname;
	 return this.clientname;
}
public String settransactiontype(String transactiontype) {
	 this.transactiontype=transactiontype;
	 return this.transactiontype;
}
public String setcreditordebit(String creditordebit) {
	this.creditordebit=creditordebit;
	 return this.creditordebit;
}
public  double settransanctionamount(double transactionamount) {
	this.transactionamount=transactionamount;
	 return this.transactionamount;
}

}
