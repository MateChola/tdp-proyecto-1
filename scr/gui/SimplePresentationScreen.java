package gui;

//import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;

import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField textField_GitHubURL;
	private JTextField textField_LU;
	private JTextField textField_Apellido;
	private JTextField textField_Nombre;
	private JTextField textField_Email;
	private JLabel lblNewLabel;

	public SimplePresentationScreen(Student studentData) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(644, 285));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		contentPane.setLayout(null);
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 430, 212);
		tabInformation = new JPanel();
		tabInformation.setBackground(new Color(192, 192, 192));
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		tabInformation.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("LU");
		lblNewLabel_1.setBounds(26, 13, 45, 13);
		tabInformation.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setBounds(26, 49, 70, 13);
		tabInformation.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Nombre");
		lblNewLabel_3.setBounds(26, 85, 45, 13);
		tabInformation.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("E-mail");
		lblNewLabel_4.setBounds(26, 121, 45, 13);
		tabInformation.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Github URL");
		lblNewLabel_5.setBounds(26, 157, 70, 13);
		tabInformation.add(lblNewLabel_5);
		
		textField_LU = new JTextField();
		textField_LU.setEditable(false);
		textField_LU.setBounds(138, 10, 238, 19);
		tabInformation.add(textField_LU);
		textField_LU.setColumns(10);
		textField_LU.setText(""+studentData.getId());
		
		textField_Apellido = new JTextField();
		textField_Apellido.setEditable(false);
		textField_Apellido.setBounds(138, 46, 238, 19);
		tabInformation.add(textField_Apellido);
		textField_Apellido.setColumns(10);
		textField_Apellido.setText(studentData.getLastName());
		
		textField_Nombre = new JTextField();
		textField_Nombre.setEditable(false);
		textField_Nombre.setBounds(138, 82, 238, 19);
		tabInformation.add(textField_Nombre);
		textField_Nombre.setColumns(10);
		textField_Nombre.setText(studentData.getFirstName());
		
		textField_Email = new JTextField();
		textField_Email.setEditable(false);
		textField_Email.setBounds(138, 118, 238, 19);
		tabInformation.add(textField_Email);
		textField_Email.setColumns(10);
		textField_Email.setText(studentData.getMail());
		
		textField_GitHubURL = new JTextField();
		textField_GitHubURL.setEditable(false);
		textField_GitHubURL.setBounds(138, 154, 238, 19);
		tabInformation.add(textField_GitHubURL);
		textField_GitHubURL.setColumns(10);
		textField_GitHubURL.setText(studentData.getGithubURL());
		contentPane.add(tabbedPane);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(462, 38, 155, 155);
		lblNewLabel.setIcon(new ImageIcon(SimplePresentationScreen.class.getResource(studentData.getPathPhoto())));
		contentPane.add(lblNewLabel);
		
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter hora = DateTimeFormatter.ofPattern("HH:mm:ss");
		JLabel lblNewLabel_6 = new JLabel("Esta ventana fue generada el "+fecha.format(LocalDateTime.now())+" a las: "+hora.format(LocalDateTime.now()));
		lblNewLabel_6.setBackground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(15, 227, 363, 13);
		contentPane.add(lblNewLabel_6);
	}
}
