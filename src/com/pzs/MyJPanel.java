package com.pzs;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;

public class MyJPanel extends JPanel {
     String p;
     JTextArea textArea = new JTextArea();
	/**
	 * Create the panel.
	 */
	public MyJPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5185\u5BB9");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(14, 88, 68, 33);
		add(lblNewLabel);
		
//		JTextArea textArea = new JTextArea();
		textArea.setBounds(84, 81, 164, 175);
		add(textArea);
		
		JLabel label = new JLabel("\u4F18\u5148\u7EA7");
		label.setBounds(36, 21, 54, 41);
		add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"----", "\u666E\u901A", "\u7D27\u6025"}));
		comboBox.setBounds(110, 31, 54, 21);
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox j = (JComboBox) e.getSource();
				p = (String) j.getSelectedItem();
				
			}
		});
		add(comboBox);

	}
	public String getTxt(){
		return  textArea.getText();
	}
	public String getp(){
		return p;
	}
}
