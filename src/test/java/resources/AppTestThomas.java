package resources;

import tpVol.dao.DaoClient;
import tpVol.dao.DaoClientFactory;
import tpVol.model.Adresse;
import tpVol.model.ClientPhysique;
import tpVol.model.TitrePhysique;
import tpVol.util.Context;

public class AppTestThomas {

	public static void main(String[] args) {
		
		DaoClient c1 = DaoClientFactory.getInstance();
		
		ClientPhysique client1 = new ClientPhysique();
		Adresse adresse1 = new Adresse(5,"Rue de la mer","56456","Flouville");
		client1.setAdresse(adresse1);
		client1.setNom("Paul");
		client1.setEmail("paul@gg");
		client1.setTitrePhysique(TitrePhysique.M);
		
		c1.insert(client1);
		
		ClientPhysique client2 = new ClientPhysique();
		Adresse adresse2 = new Adresse(6,"Rue de la Lune","56123","Poville");
		client2.setAdresse(adresse2);
		client2.setNom("Legrand");
		client2.setEmail("jj@gg");
		client2.setTitrePhysique(TitrePhysique.MME);
		c1.insert(client2);
		
//		c1.delete(client1);
		
		
		System.out.println(c1.findAll());
		System.out.println(c1.findByKey((long) 101));
		
		
		client2.setEmail("change@gg");
		c1.update(client2);
		
		
		
		
		Context.close();
		
		
//		DaoAdherent daoPersonne=DaoAdherentFactory.getInstance();
//		
//		Adherent clement= new Eleve("clement","vacca");
//		clement.setCivilite(Civilite.M);
//		
//		SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
//		try {
//			clement.setDateNaissance(sdf.parse("16/01/1995"));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		clement.setAdresse(new Adresse(6,"rue rougemont","75009","paris"));
//		daoPersonne.insert(new Formateur("olivier","gozlan",15,true));
//		
//		daoPersonne.insert(clement);
//		
//		Adherent recherche= daoPersonne.findByKey(100);
//		System.out.println(recherche);
//		
//		DaoFilm daoOrdinateur=DaoFilmFactory.getInstance();
//		Article ordi=new Article("368",16);
//		daoOrdinateur.insert(ordi);
//		
//		DaoCompetence daoCompetence=DaoCompetenceFactory.getInstance();
//		Competence comp=new Competence("JAVA");
//		daoCompetence.insert(comp);
//		
		
		
//		Context.close();
		
//		System.out.println("ok");
//		Personne clement = new Personne("clement", "vacca");
//		System.out.println(clement.getId());
//		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
//		// transaction pour ordre de modification
//		EntityTransaction tx = em.getTransaction();
//		try {
//			tx.begin();
//			// rendre un objet persistant--> avoir une version de l'objet en base (insert)
//			em.persist(clement);
//			clement.setPrenom("aze");
//			tx.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			tx.rollback();
//		}
//		em.close();
//		
//		Personne recherche=null;
//		em=Context.getEntityManagerFactory().createEntityManager();
//		tx=em.getTransaction();
//		tx.begin();
//		//recherche=em.find(Personne.class, 100);
//		recherche=new Personne("aaa","");
//		System.out.println("----------------");
//		
//		recherche.setNom("azerty");
//		em.merge(recherche); //
//		tx.commit();
		
	}

}
