package com.pzs;


public class PIMNote extends PIMEntity {
	String txt;
	public PIMNote(){
		super();
	}
	public PIMNote(String priority){
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
		return "NOTE "+Priority+" "+txt;
	}
	public String getTxt() {
		return txt;
	}
	public void setTxt(String txt) {
		this.txt = txt;
	}

}
