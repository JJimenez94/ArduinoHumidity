package co.edu.ucatolica.architecture.humidityArduino.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the city database table.
 * 
 */
@Entity
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="city_id")
	private Integer cityId;

	private String name;

	//bi-directional many-to-one association to Capturedhumidity
	@OneToMany(mappedBy="city")
	private List<Capturedhumidity> capturedhumidities;

	//bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;

	public City() {
	}

	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Capturedhumidity> getCapturedhumidities() {
		return this.capturedhumidities;
	}

	public void setCapturedhumidities(List<Capturedhumidity> capturedhumidities) {
		this.capturedhumidities = capturedhumidities;
	}

	public Capturedhumidity addCapturedhumidity(Capturedhumidity capturedhumidity) {
		getCapturedhumidities().add(capturedhumidity);
		capturedhumidity.setCity(this);

		return capturedhumidity;
	}

	public Capturedhumidity removeCapturedhumidity(Capturedhumidity capturedhumidity) {
		getCapturedhumidities().remove(capturedhumidity);
		capturedhumidity.setCity(null);

		return capturedhumidity;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}