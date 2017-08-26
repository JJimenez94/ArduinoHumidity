package co.edu.ucatolica.architecture.humidityArduino.view;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainView {

	private JFrame frame;
	private JPanel panel;
	private JLabel lblHumedadCapturada, lblCapturedDepartment, lblCapturedCity, lblReportedHumidity, lblTimer;
	private JComboBox<String> cmbDepartments, cmbCities;

	/**
	 * Accessibility methods.
	 */
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JLabel getLblHumedadCapturada() {
		return lblHumedadCapturada;
	}

	public void setLblHumedadCapturada(JLabel lblHumedadCapturada) {
		this.lblHumedadCapturada = lblHumedadCapturada;
	}

	public JLabel getLblCapturedDepartment() {
		return lblCapturedDepartment;
	}

	public void setLblCapturedDepartment(JLabel lblCapturedDepartment) {
		this.lblCapturedDepartment = lblCapturedDepartment;
	}

	public JLabel getLblCapturedCity() {
		return lblCapturedCity;
	}

	public void setLblCapturedCity(JLabel lblCapturedCity) {
		this.lblCapturedCity = lblCapturedCity;
	}

	public JLabel getLblReportedHumidity() {
		return lblReportedHumidity;
	}

	public void setLblReportedHumidity(JLabel lblReportedHumidity) {
		this.lblReportedHumidity = lblReportedHumidity;
	}

	public JLabel getLblTimer() {
		return lblTimer;
	}

	public void setLblTimer(JLabel lblTimer) {
		this.lblTimer = lblTimer;
	}

	public JComboBox<String> getCmbDepartments() {
		return cmbDepartments;
	}

	public void setCmbDepartments(JComboBox<String> cmbDepartments) {
		this.cmbDepartments = cmbDepartments;
	}

	public JComboBox<String> getCmbCities() {
		return cmbCities;
	}

	public void setCmbCities(JComboBox<String> cmbCities) {
		this.cmbCities = cmbCities;
	}

	private void initComponents() {
		System.out.println("Creando componentes gráficos");
		if (this.getFrame() == null) {
			frame = new JFrame();
			frame.setTitle("Modulo de captura de humedad");
			frame.getContentPane().setLayout(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setFrame(frame);
		} else {
			this.getFrame();
		}
		if (this.getPanel() == null) {
			panel = new JPanel();
			panel.setLayout(null);
			this.setPanel(panel);
		} else {
			this.getPanel();
		}
		if (this.getLblHumedadCapturada() == null) {
			lblHumedadCapturada = new JLabel("Humedad Capturada:");
			this.setLblHumedadCapturada(lblHumedadCapturada);
		} else {
			this.getLblHumedadCapturada();
		}
		if (this.getLblCapturedDepartment() == null) {
			lblCapturedDepartment = new JLabel("Departamento de captura:");
			this.setLblCapturedDepartment(lblCapturedDepartment);
		} else {
			this.getLblCapturedDepartment();
		}
		if (this.getLblCapturedCity() == null) {
			lblCapturedCity = new JLabel("Ciudad de captura:");
			this.setLblCapturedCity(lblCapturedCity);
		} else {
			this.getLblCapturedCity();
		}
		if (this.getLblReportedHumidity() == null) {
			lblReportedHumidity = new JLabel("Esperando datos");
			this.setLblReportedHumidity(lblReportedHumidity);
		} else {
			this.getLblReportedHumidity();
		}
		if (this.getLblTimer() == null) {
			lblTimer = new JLabel("Tiempo restante para la siguiente captura de datos:");
			this.setLblTimer(lblTimer);
		} else {
			this.getLblTimer();
		}
		if (this.getCmbDepartments() == null) {
			cmbDepartments = new JComboBox<String>();
			this.setCmbDepartments(cmbDepartments);
		} else {
			this.getCmbDepartments();
		}
		if (this.getCmbCities() == null) {
			cmbCities = new JComboBox<String>();
			this.setCmbCities(cmbCities);
		} else {
			this.getCmbCities();
		}
		System.out.println("Finaliza el proceso de instaciación de objetos gráficos");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Create all the graphic components
		initComponents();
		// Adding graphic components to GUI
		this.getFrame().getContentPane().add(this.getPanel());
		this.getPanel().add(this.getLblHumedadCapturada());
		this.getPanel().add(this.getLblReportedHumidity());
		this.getPanel().add(this.getLblCapturedDepartment());
		this.getPanel().add(this.getCmbDepartments());
		this.getPanel().add(this.getLblCapturedCity());
		this.getPanel().add(this.getCmbCities());
		this.getPanel().add(this.getLblTimer());
		// Setting position to components
		this.getFrame().setLocationRelativeTo(null);
		this.getFrame().setBounds(100, 100, 417, 174);
		this.getPanel().setBounds(0, 0, 401, 135);
		this.getLblHumedadCapturada().setBounds(14, 17, 164, 14);
		this.getLblReportedHumidity().setBounds(192, 17, 193, 14);
		this.getLblCapturedDepartment().setBounds(14, 48, 164, 14);
		this.getCmbDepartments().setBounds(192, 45, 193, 20);
		this.getLblCapturedCity().setBounds(14, 79, 164, 14);
		this.getCmbCities().setBounds(192, 76, 193, 20);
		this.getLblTimer().setBounds(14, 104, 367, 20);		
	}	

	/**
	 * Create an instance of the GUI - Constructor method.
	 */
	public MainView() {
		initialize();
	}
}
