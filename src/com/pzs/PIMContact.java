package com.pzs;


public class PIMContact extends PIMEntity {
	String txt;
	String firsetName;
	String lastName;
	String emailAdress;
	public PIMContact(){
		super();
	}
	public PIMContact(String priority){
		super(priority);
	}
	@Override
	public void fromString(String s) {
		
       this.txt=s;
	}

	@Override
	public String toString() {
		
		return "CONTACT "+Priority+" "+firsetName+" "+lastName+"'s EmailAdress£º "+emailAdress;
	}
	public void setFirstName(String firsetName){
		this.firsetName=firsetName;
	}
	public void setLastName(String lastName){
		this.lastName=lastName;
	}
	public void setEmailAdress(String emailAdress){
		this.emailAdress=emailAdress;
	}
	public String getTxt() {
		return txt;
	}
	public void setTxt(String txt) {
		this.txt = txt;
	}
	public String getFirsetName() {
		return firsetName;
	}
	public void setFirsetName(String firsetName) {
		this.firsetName = firsetName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmailAdress() {
		return emailAdress;
	}


}
