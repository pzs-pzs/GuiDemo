package com.pzs;

public class PIMAppointment extends PIMEntity implements Dateable{
	String txt;

	public PIMAppointment(){
		super();
	}
	public PIMAppointment(String priority){
		super(priority);
	}
	@Override
	public void fromString(String s) {
		// TODO 自动生成的方法存根
        this.txt=s;
	}

	@Override
	public String toString() {
		// TODO 自动生成的方法存根
		return "APPIONTMENT "+Priority+" "+txt+" date:"+this.date;
	}
	public void setAppointmentDate(String date){
		this.date=date;
	}
	@Override
	public boolean formatDate() {
		// TODO 自动生成的方法存根
		return false;
	}
	public String getTxt() {
		return txt;
	}
	public void setTxt(String txt) {
		this.txt = txt;
	}
	

}
