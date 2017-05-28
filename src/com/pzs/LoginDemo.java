package com.pzs;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import javax.swing.JRadioButton;

import javax.swing.JPasswordField;
import javax.swing.JLabel;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;


@SuppressWarnings("serial")
public class LoginDemo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginDemo frame = new LoginDemo();
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
	public LoginDemo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginDemo.class.getResource("/com/sun/java/swing/plaf/windows/icons/Error.gif")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel user = new JLabel("user");
		user.setFont(new Font("свт╡", Font.BOLD | Font.ITALIC, 15));
		user.setHorizontalAlignment(SwingConstants.LEFT);
		user.setBounds(98, 32, 70, 32);
		contentPane.add(user);
		
		textField = new JTextField();
		textField.setBounds(178, 38, 170, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setFont(new Font("свт╡", Font.BOLD, 15));
		lblPassword.setBounds(98, 74, 89, 32);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(178, 80, 170, 21);
		contentPane.add(passwordField);
		
		JRadioButton rdbtnRemember = new JRadioButton("\u8BB0\u4F4F\u5BC6\u7801");
		rdbtnRemember.setFont(new Font("свт╡", Font.BOLD, 15));
		rdbtnRemember.setBounds(178, 120, 201, 23);
		contentPane.add(rdbtnRemember);
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.setFocusable(false);
		btnNewButton.setSelectedIcon(null);
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("свт╡", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println(passwordField.getPassword());
				new CalenderGuiDemo().setVisible(true);
				LoginDemo.this.dispose();

			}
		});
		btnNewButton.setBounds(98, 161, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6CE8\u518C");
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setFont(new Font("свт╡", Font.BOLD, 12));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
			}
		});
		btnNewButton_1.setBounds(255, 160, 93, 23);
		contentPane.add(btnNewButton_1);
	}
}
