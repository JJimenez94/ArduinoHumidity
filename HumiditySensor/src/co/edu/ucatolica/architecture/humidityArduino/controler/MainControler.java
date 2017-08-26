package co.edu.ucatolica.architecture.humidityArduino.controler;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

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
	}

	public void additionalBehaviors() {
		window.getCmbDepartments().addItemListener(this);
		// window.getCmbCities().addItemListener(this);
		chargeCmbDepartament();
		loadCities();
		window.getFrame().setVisible(true);
	}

	private void chargeCmbDepartament() {
		initialDepartments = dbComm.getDepartmentByNames();
		for (Department e : initialDepartments) {
			window.getCmbDepartments().addItem(e.getName());
		}
		window.getCmbDepartments().setSelectedIndex(-1);
		window.getCmbCities().setEnabled(false);
	}

	public void loadCities() {
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

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			System.out.println(e.getClass());
			System.out.println(e.getItemSelectable());
			System.out.println(e.getItem());
			if (e.getItemSelectable() == window.getCmbDepartments()) {
				System.out.println("Cambia la selección de departamentos el departamento seleccionado es: "
						+ window.getCmbDepartments().getSelectedItem());
				System.out.println("Actualizando la lista de ciudades disponibles");
				try {
					window.getCmbCities().removeAllItems();
					chargeCmbCity(window.getCmbDepartments().getSelectedItem());
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainControler controler = new MainControler();
	}

}
