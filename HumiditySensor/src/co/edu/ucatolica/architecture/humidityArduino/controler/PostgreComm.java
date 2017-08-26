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
		List<Department> result = entityManager.createNamedQuery("Department.findAll", Department.class).getResultList();
		return result;
	}
	
	public List<Department> getDepartmentByNames() {		
		EntityManager entityManager = factory.createEntityManager();		
		List<Department> result = entityManager.createQuery("SELECT d FROM Department d ORDER BY d.name", Department.class).getResultList();		
		return result;
	}
	
	public List<City> getCityList() {		
		EntityManager entityManager = factory.createEntityManager();		
		List<City> result = entityManager.createNamedQuery("City.findAll", City.class).getResultList();
		return result;
	}

	/*public Boolean insert(Double humidity) {
		EntityManager implManager = factory.createEntityManager();
		implManager.getEntityManagerFactory().getCache().evictAll();
		implManager.getTransaction().begin();		
		TypedQuery<Capturedhumidity> query = implManager.createQuery("SELECT c FROM Capturedhumidity c", Capturedhumidity.class);
		List<CapturedHumidity> result = query.getResultList();
		for(Capturedhumidity c : result)
	}*/

}
