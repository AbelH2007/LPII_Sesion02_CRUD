package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Estudiante;

public class ActualizarEst {
	
	static EntityManagerFactory factory;
	static EntityManager em;
	
	public static void actualizarEstudiante(int idEst, Estudiante data) throws Exception {
		factory = Persistence.createEntityManagerFactory("LPII_Sesion03_CRUD");
		em = factory.createEntityManager ();
		em.getTransaction ().begin ();
		Estudiante e = em.find(Estudiante.class, idEst);
		if(e==null)
			System.out.println("Estudiante con id: " +idEst + " no existe, no se pudo actualizar");
		else {
			e.setNombreApe(data.getNombreApe());
			e.setTipoDocumento(data.getTipoDocumento());
			e.setNroDocumento(data.getNroDocumento());
			e.setTelefono(data.getTelefono());
			e.setCarrera(data.getCarrera());
			em.merge(e);
			em.getTransaction().commit();
			System.out.println("Estudiante con id: " +idEst + " fue actualizado correctamente");
		}
		em.close();
		factory.close();
		
	}
	
	public static void main(String[]args) {
		ActualizarEst p = new ActualizarEst ();
		try {
			Estudiante student = new Estudiante();
			student.setNombreApe("Mario Vargas");
			student.setTipoDocumento("DNI");
			student.setNroDocumento("12345678");
			student.setTelefono("930796867");
			student.setCarrera("Logistica");
			p.actualizarEstudiante(2,student);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
