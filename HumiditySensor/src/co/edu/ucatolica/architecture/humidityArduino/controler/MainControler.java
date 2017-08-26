package co.edu.ucatolica.architecture.humidityArduino.controler;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JOptionPane;

import co.edu.ucatolica.architecture.humidityArduino.model.City;
import co.edu.ucatolica.architecture.humidityArduino.model.Department;
import co.edu.ucatolica.architecture.humidityArduino.view.MainView;

public class MainControler implements ItemListener {

	/*
	 * Variable declaration starts
	 */
	// GUI, DB, and Arduino Communication
	public MainView window;
	private PostgreComm dbComm;
	private ArduinoComm arduino;
	// Local data management
	private List<Department> initialDepartments;
	private List<City> initialCitys;

	/* Variable definition ends */

	public MainControler() {
		window = new MainView();
		dbComm = new PostgreComm();
		arduino = new ArduinoComm();
		additionalBehaviors();
		arduino.HumidityReader();
	}

	public void additionalBehaviors() {
		loadLists();
		window.getCmbDepartments().addItemListener(this);
		window.getCmbCities().addItemListener(this);
		chargeCmbDepartament();
		JOptionPane.showMessageDialog(window.getFrame(),
				"Debe seleccionar una ciudad para que se carguen los datos a la base de datos, de lo contrario la captura de humedad será descartada",
				"Confirmación de ciudad", JOptionPane.WARNING_MESSAGE);		
		arduino.setDb(getDbComm());
		arduino.setToWrite(window.getLblReportedHumidity());
		window.getFrame().setVisible(true);
	}

	private void chargeCmbDepartament() {
		for (Department e : initialDepartments) {
			window.getCmbDepartments().addItem(e.getName());
		}
		window.getCmbDepartments().setSelectedIndex(-1);
		window.getCmbCities().setEnabled(false);
	}

	public void loadLists() {
		initialDepartments = dbComm.getDepartmentByNames();
		initialCitys = dbComm.getCityList();
	}

	public void chargeCmbCity(Object department) {
		for (City c : initialCitys) {
			if (c.getDepartment().getName() == department.toString()) {
				window.getCmbCities().addItem(c.getName());
			}
		}
		window.getCmbCities().setSelectedIndex(-1);
		window.getCmbCities().setEnabled(true);
	}

	public City getLoadedCity() {
		for (City c : initialCitys) {
			if (window.getCmbCities().getSelectedItem().toString().equals(c.getName())) {
				return c;
			}
		}
		return null;
	}

	public PostgreComm getDbComm() {
		return dbComm;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (e.getItemSelectable() == window.getCmbDepartments()) {
				System.out.println("Actualizando la lista de ciudades disponibles");
				try {
					window.getCmbCities().removeAllItems();
					chargeCmbCity(window.getCmbDepartments().getSelectedItem());
				} catch (Exception ex) {
					System.out.println(ex.toString());					
				}
			} else if (e.getItemSelectable() == window.getCmbCities()) {
				arduino.setCity(getLoadedCity());
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainControler controler = new MainControler();
	}

}
