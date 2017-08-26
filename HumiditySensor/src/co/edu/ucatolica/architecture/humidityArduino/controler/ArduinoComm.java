package co.edu.ucatolica.architecture.humidityArduino.controler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class ArduinoComm implements SerialPortEventListener {

	/*
	 * Variable definition start
	 */
	// Ports used by Arduino to establish SO connection
	private static final String PORT_NAMES[] = { "/dev/tty.usbserial-A9007UX1", // Mac OS X
			"/dev/ttyACM0", // Raspberry Pi
			"/dev/ttyUSB0", // Linux
			"COM3", // Windows
	};
	// Buffers used for rw operation to the Arduino port
	private BufferedReader input;
	private OutputStream output;
	// TimeOut value for the communication
	private static final int TIME_OUT = 2000;
	// Bits per second used in the communication process with Arduino.
	private static final int DATA_RATE = 9600;
	// save the used port
	private SerialPort usedPort;

	/* Variable definition ends */

	private void HumidityReader() {
		CommPortIdentifier portId = null;
		Enumeration<CommPortIdentifier> portEnum = CommPortIdentifier.getPortIdentifiers();
		System.out.println("Validando los puertos disponibles");
		while (portEnum.hasMoreElements()) {
			CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
			for (String portName : PORT_NAMES) {
				if (currPortId.getName().equals(portName)) {
					portId = currPortId;
					break;
				}
			}
			System.out.println("placa Arduino encontrada en el puerto serial: " + currPortId.getName());
		}
		if (portId == null) {
			System.out.println("No se encontr� la placa, por favor verifique la conexi�n");
			System.out.println("Finalizando la ejecuci�n del programa");
			System.exit(1);
			return;
		}
		try {
			// open serial port, and use class name for the appName.
			usedPort = (SerialPort) portId.open(this.getClass().getName(), TIME_OUT);
			// set port parameters
			usedPort.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
					SerialPort.PARITY_NONE);
			// Setting up timeOut
			usedPort.enableReceiveTimeout(3000);
			usedPort.enableReceiveThreshold(0);
			// open the streams
			input = new BufferedReader(new InputStreamReader(usedPort.getInputStream()));
			output = usedPort.getOutputStream();

			// add event listeners
			usedPort.addEventListener(this);
			usedPort.notifyOnDataAvailable(true);
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}

	public synchronized void close() {
		if (usedPort != null) {
			usedPort.removeEventListener();
			usedPort.close();
		}
	}

	@Override
	public synchronized void serialEvent(SerialPortEvent oEvent) {
		if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
				String humidity = input.readLine();
				System.out.println(humidity);
			} catch (Exception e) {
				System.err.println(e.toString());
			}
		}
	}

}