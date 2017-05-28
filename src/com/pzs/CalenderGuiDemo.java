package com.pzs;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import java.awt.Color;

@SuppressWarnings({ "serial", "unchecked", "resource" })
public class CalenderGuiDemo extends JFrame {

	private JPanel contentPane;
	private int year ; 
	private int month;
	private int day;
	
	private JButton jb[] = new JButton[42];
	MyJPanel p  = new MyJPanel();
	JPanel panel_1 = new JPanel();
	JTextArea textArea = new JTextArea();
	static ArrayList<PIMEntity> list = new ArrayList<>();
	private String type;
	static File file =new File("PIM.txt");
	static{
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    else if(file.length()==0){
			
		}else{
			try {
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
			    list = (ArrayList<PIMEntity>) in.readObject();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalenderGuiDemo frame = new CalenderGuiDemo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({"rawtypes"})
	public CalenderGuiDemo() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CalenderGuiDemo.class.getResource("/javax/swing/plaf/metal/icons/ocean/error.png")));
		setFont(new Font("AngsanaUPC", Font.PLAIN, 30));
		setTitle("Calender");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 119, 486, 302);
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH)+1;
		for(int i=0 ;i< 42 ;i++){
			jb[i] = new JButton();
			jb[i].setFocusable(false);
			jb[i].setBackground(Color.WHITE);
			jb[i].setForeground(Color.BLACK);
			jb[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					textArea.setText("");
					panel_1.removeAll();
					panel_1.add(textArea);
					panel_1.updateUI();
					JButton j = (JButton) e.getSource();
					String d = j.getText();
					day = Integer.parseInt(d);
					String date = year+"/"+month+"/"+day;
					for(PIMEntity pim : list){
						if(pim instanceof PIMTodo){
							PIMTodo todo = (PIMTodo) pim;
							if(todo.getDate().equals(date)){
								textArea.setText(todo.getDate()+"\n"+todo.getPriority()+"\n"+todo.getTxt());
								break;
							}
						}
						if(pim instanceof PIMNote){
							PIMNote todo = (PIMNote) pim;
							if(todo.getDate().equals(date)){
								textArea.setText(todo.getDate()+"\n"+todo.getPriority()+"\n"+todo.getTxt());
								break;
							}
						}
						if(pim instanceof PIMAppointment){
							PIMAppointment todo = (PIMAppointment) pim;
							if(todo.getDate().equals(date)){
								textArea.setText(todo.getDate()+"\n"+todo.getPriority()+"\n"+todo.getTxt());
								break;
							}
						}
						
					}
				}
			});
			panel.add(jb[i]);
		}
		print(jb);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 7, 0, 0));
		
		
		JButton btnNewButton = new JButton("±£´æ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    writeToList(p.getTxt(),p.getp());
				panel_1.removeAll();
				panel_1.add(textArea);
				panel_1.updateUI();
			}
		});
		btnNewButton.setBounds(540, 398, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("É¾³ý");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				String date = year+"/"+month+"/"+day;
				Iterator<PIMEntity> it = list.iterator();
				while(it.hasNext()){
					PIMEntity pim = it.next();
					if(pim.getDate().equals(date)){
						it.remove();break;
					}
				}
			}
		});
		btnNewButton_1.setBounds(663, 398, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025"}));
		comboBox.setBounds(109, 20, 54, 21);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox_1.setBounds(222, 20, 38, 21);
		contentPane.add(comboBox_1);
		
		JLabel label = new JLabel("\u5E74");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(158, 23, 54, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u6708");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(270, 23, 54, 15);
		contentPane.add(label_1);
		
//		JPanel panel_1 = new JPanel();
		panel_1.setBounds(518, 119, 266, 264);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		textArea.setEditable(false);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 30));
		
//		JTextArea textArea = new JTextArea();
		panel_1.add(textArea, BorderLayout.CENTER);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"\u5907\u5FD8\u7C7B\u578B", "PIMTodo", "PIMAppointment", "PIMContact", "PIMNote"}));
		comboBox_2.setBounds(562, 20, 98, 23);
		comboBox_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			   JComboBox jc = (JComboBox) e.getSource();
			   type = (String) jc.getSelectedItem();
				
			}
		});
		contentPane.add(comboBox_2);
		
		JButton btnNewButton_2 = new JButton("\u6DFB\u52A0\u5907\u5FD8");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.textArea.setText("");
				panel_1.removeAll();
				panel_1.add(p);
				panel_1.updateUI();
				
			}
		});
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBounds(670, 19, 93, 23);
		contentPane.add(btnNewButton_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 64, 486, 48);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 7, 0, 0));
		
		JLabel lblNewLabel = new JLabel("\u661F\u671F\u5929");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u661F\u671F\u4E00");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u661F\u671F\u4E8C");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u661F\u671F\u4E09");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u661F\u671F\u56DB");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u661F\u671F\u4E94");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u661F\u671F\u516D");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_6);
		
		JButton button = new JButton("Ìø×ª");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String y = (String)comboBox.getSelectedItem();
				year = Integer.parseInt(y);
				String m = (String)comboBox_1.getSelectedItem();
				month = Integer.parseInt(m);
				print(jb);
			}
		});
		button.setBackground(Color.WHITE);
		button.setFocusable(false);
		button.setBounds(340, 19, 81, 23);
		contentPane.add(button);
		this.addWindowListener(new WindowAdapter() {     
			public void windowClosing(WindowEvent e) { 
				writeTofile();
				System.exit(0);    
				}      
				}
		); 
	}
	public void print(JButton jb[]){
		for(int i=0 ;i<42 ;i++){
			jb[i].setEnabled(true);
			jb[i].setText("");
		}
		Calendar cal =Calendar.getInstance();
		cal.set(Calendar.YEAR,year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DATE, 1);
		
		for(int i =0 ;i<cal.get(Calendar.DAY_OF_WEEK)-1;i++){
			jb[i].setEnabled(false);
		}
		for(int i = cal.get(Calendar.DAY_OF_WEEK)-1,j=1;j<=cal.getActualMaximum(Calendar.DAY_OF_MONTH);i++){
			jb[i].setText(""+j);
			j++;
		}
		for(int i =(cal.get(Calendar.DAY_OF_WEEK)+cal.getActualMaximum(Calendar.DAY_OF_MONTH)-1);i<42;i++){
			jb[i].setEnabled(false);
		}
		
	}
	public void writeToList(String txt,String p){
		String date = year+"/"+month+"/"+day;
		System.out.println(type);
		PIMNote note = new PIMNote();
		note.setDate(date);
		note.setPriority(p);
		note.setTxt(txt);
		list.add(note);
	}
	public void writeTofile(){
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(list);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
