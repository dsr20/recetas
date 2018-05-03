package com.proyecto.recetas.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.proyecto.recetas.beans.Ingrediente;
import com.proyecto.recetas.beans.RecetaIngredientes;
import com.proyecto.recetas.beans.Receta;

@Repository
public class RecetaDaoImp implements RecetaDao{
	@Autowired
	JdbcTemplate template;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	public void save(Receta r) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(r);
		/*if(!r.getRecetaIngredientes().isEmpty()) {
			for(RecetaIngredientes rI : r.getRecetaIngredientes()) {
				session.persist(rI);
			}
		}*/
		//session.save(r);
	}

	@Override
	public void update(Receta r) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(r);
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Receta r = (Receta)session.load(Receta.class, new Integer(id));
		if(r!=null) {
			session.delete(r);
		}
	}

	@Override
	public Receta getRecetaById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Receta r = (Receta)session.get(Receta.class, new Integer(id));
		return r;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Receta> getRecetas() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Receta> recetasList = session.createQuery("from Recetas").list();
		return recetasList;
	}

}
