package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Estudiante;

public class InsertaEst {
	 static EntityManagerFactory factory;
	 static EntityManager em;

	public  void registrarEstudiante(Estudiante data) throws Exception {
		factory = Persistence.createEntityManagerFactory("LPII_Sesion03_CRUD");
		em = factory.createEntityManager ();
		em.getTransaction ().begin ();
		em.persist(data);
		em.getTransaction().commit();
		System.out.println("Estudiante registardo correctamente");
		em.close();
		factory.close();
		
	}
	
	public static void main(String[] args) {
		InsertaEst p = new InsertaEst ();
		try {
			Estudiante student = new Estudiante();
			student.setNombreApe("Ricardo Luna");
			student.setTipoDocumento("CEX");
			student.setNroDocumento("012345678");
			student.setTelefono("987796867");
			student.setCarrera("Contabilidad");
			p.registrarEstudiante(student);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
