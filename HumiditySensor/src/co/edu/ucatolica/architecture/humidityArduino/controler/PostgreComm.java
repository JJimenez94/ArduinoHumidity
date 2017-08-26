package co.edu.ucatolica.architecture.humidityArduino.controler;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import co.edu.ucatolica.architecture.humidityArduino.model.*;

public class PostgreComm {

	public EntityManagerFactory factory = Persistence.createEntityManagerFactory("HumiditySensor");
	// public EntityManager manager = null;

	public List<Department> getDepartmentList() {
		EntityManager entityManager = factory.createEntityManager();
		List<Department> result = entityManager.createNamedQuery("Department.findAll", Department.class)
				.getResultList();
		return result;
	}

	public List<Department> getDepartmentByNames() {
		EntityManager entityManager = factory.createEntityManager();
		List<Department> result = entityManager
				.createQuery("SELECT d FROM Department d ORDER BY d.name", Department.class).getResultList();
		return result;
	}

	public List<City> getCityList() {
		EntityManager entityManager = factory.createEntityManager();
		List<City> result = entityManager.createNamedQuery("City.findAll", City.class).getResultList();
		return result;
	}

	public boolean insertHumidity(Integer data, City city) {
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getEntityManagerFactory().getCache().evictAll();
		entityManager.getTransaction().begin();

		Capturedhumidity capturedhumidity = new Capturedhumidity();

		capturedhumidity.setHumidityPercent(data);
		capturedhumidity.setCity(city);

		entityManager.persist(capturedhumidity);
		entityManager.getTransaction().commit();
		entityManager.close();

		return true;
	}
}
