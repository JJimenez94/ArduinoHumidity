package co.edu.ucatolica.architecture.humidityArduino.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the capturedhumidity database table.
 * 
 */
@Entity
@NamedQuery(name="Capturedhumidity.findAll", query="SELECT c FROM Capturedhumidity c")
public class Capturedhumidity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id", insertable=false)
	private Integer id;

	@Column(name="captured_timestamp", insertable=false)
	private Timestamp capturedTimestamp;

	@Column(name="humidity_percent")
	private Integer humidityPercent;

	//bi-directional many-to-one association to City
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;

	public Capturedhumidity() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getCapturedTimestamp() {
		return this.capturedTimestamp;
	}

	public void setCapturedTimestamp(Timestamp capturedTimestamp) {
		this.capturedTimestamp = capturedTimestamp;
	}

	public Integer getHumidityPercent() {
		return this.humidityPercent;
	}

	public void setHumidityPercent(Integer humidityPercent) {
		this.humidityPercent = humidityPercent;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}