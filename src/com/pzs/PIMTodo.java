package com.pzs;


public class PIMTodo extends PIMEntity implements Dateable {
	String txt;
	
	public PIMTodo(){
		super();
	}
	public PIMTodo(String priority){
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
		return "TODO "+Priority+" "+date+" "+txt;
	}
	public void setTodoDate(String date){
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
