package com.proyecto.recetas.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.proyecto.recetas.beans.Ingrediente;

@Repository
public class IngredienteDaoImp implements IngredienteDao{
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
	public void save(Ingrediente i) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(i);
	}

	@Override
	public void update(Ingrediente i) {
		Session session =  this.sessionFactory.getCurrentSession();
		session.update(i);
		
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Ingrediente i = (Ingrediente)session.load(Ingrediente.class, new Integer(id));
		if(i!=null) {
			session.delete(i);
		}
	}

	@Override
	public Ingrediente getIngredienteById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Ingrediente ingrediente = (Ingrediente)session.get(Ingrediente.class,new Integer(id));
		return ingrediente;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ingrediente> getIngredientes() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Ingrediente> ingredientesList = session.createQuery("from Ingredientes").list();
		return ingredientesList;
	}

}
