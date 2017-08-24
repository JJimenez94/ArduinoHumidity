package co.edu.ucatolica.architecture.humidityArduino.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class MainView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		//frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 386, 157);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		Button btnChargeDB = new Button("Cargar a la BD");
		btnChargeDB.setBounds(72, 102, 84, 22);
		panel.add(btnChargeDB);
		
		Button btnExit = new Button("Salir");
		btnExit.setBounds(228, 102, 84, 22);
		panel.add(btnExit);
		
		JLabel lblHumedadCapturada = new JLabel("Humedad Capturada:");
		lblHumedadCapturada.setBounds(19, 11, 164, 14);
		panel.add(lblHumedadCapturada);
		
		JComboBox cmbDepartments = new JComboBox();
		cmbDepartments.setBounds(202, 36, 164, 20);
		panel.add(cmbDepartments);
		
		JLabel lblCapturedDepartment = new JLabel("Departamento de captura:");
		lblCapturedDepartment.setBounds(19, 39, 164, 14);
		panel.add(lblCapturedDepartment);
		
		JLabel lblCapturedCity = new JLabel("Ciudad de captura:");
		lblCapturedCity.setBounds(19, 70, 164, 14);
		panel.add(lblCapturedCity);
		
		JComboBox cmbCities = new JComboBox();
		cmbCities.setBounds(202, 67, 164, 20);
		panel.add(cmbCities);
		
		JLabel lblLblreportedhumidity = new JLabel("");
		lblLblreportedhumidity.setBounds(202, 11, 164, 14);
		panel.add(lblLblreportedhumidity);
		btnChargeDB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	}
}
