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
		// TODO �Զ����ɵķ������
        this.txt=s;
	}

	@Override
	public String toString() {
		// TODO �Զ����ɵķ������
		return "APPIONTMENT "+Priority+" "+txt+" date:"+this.date;
	}
	public void setAppointmentDate(String date){
		this.date=date;
	}
	@Override
	public boolean formatDate() {
		// TODO �Զ����ɵķ������
		return false;
	}
	public String getTxt() {
		return txt;
	}
	public void setTxt(String txt) {
		this.txt = txt;
	}
	

}
