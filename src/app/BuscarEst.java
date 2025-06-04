package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Estudiante;

public class BuscarEst {

	static EntityManagerFactory factory;
	static EntityManager em;
	

	
	public static void buscarTodos () {
		factory = Persistence.createEntityManagerFactory("LPII_Sesion03_CRUD");
		em = factory.createEntityManager ();
		em.getTransaction ().begin ();
		TypedQuery<Estudiante> q = em.createQuery("select e from Estudiante e",
				                                                  Estudiante.class);
		List<Estudiante> res = q.getResultList();
		for(Estudiante item : res) {
			System.out.println("IdEst: "+ String.valueOf(item.getIdEst())+ ",nombreApe: "
					                                              + item.getNombreApe());
		}
		em.getTransaction() .commit();
		em.close();
		factory.close();
		
	}
	 public void buscarEstudianteById(int idEst) {
		 factory = Persistence.createEntityManagerFactory("LPII_Sesion03_CRUD");
			em = factory.createEntityManager ();
			em.getTransaction ().begin ();
			
		Estudiante e =em.find(Estudiante.class, idEst);
		if (e==null) {
			System.out.println("Estudiante con id: " + String.valueOf(idEst) + " no encontrado");
		}else {
			System.out.println("Estudiainte con id: " + String.valueOf(idEst) + " encontrado");
		}
		em.getTransaction() .commit();
		em.close();
		factory.close();
		 
	 }
	 
	 public static void main(String[] args) {
		 BuscarEst p = new BuscarEst ();
		 try {
			 System.out.println("-----------LISTA DE TODOS LOS ESTUDIANTES--------");
			 BuscarEst.buscarTodos();
			 System.out.println("");
			 System.out.println("-----------COMPROBACION DE ESTUDIANTES");
			 p.buscarEstudianteById(1);
			 p.buscarEstudianteById(2);
			 p.buscarEstudianteById(3);
		 }
		 catch (Exception e) {
			 e.printStackTrace();
		 }
	 }
}
