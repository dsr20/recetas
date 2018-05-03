package com.proyecto.recetas.dao;

import java.util.ArrayList;
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
public class RecetaIngredientesDaoImp implements RecetaIngredientesDao{
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
	public void save(List<RecetaIngredientes> r) {
		Session session = this.sessionFactory.getCurrentSession();
		for(RecetaIngredientes rI:r) {
			session.persist(rI);
		}
		
		/*if(!r.getRecetaIngredientes().isEmpty()) {
			for(RecetaIngredientes rI : r.getRecetaIngredientes()) {
				session.persist(rI);
			}
		}*/
		//session.save(r);
	}

	@Override
	public void update(RecetaIngredientes r) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(r);
	}

	@Override
	public void delete(int id) {
		
	}

	@Override
	public  RecetaIngredientes getIngredienteById(int id) {
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ingrediente> getIngredientesByReceta() {
		
		return null;
	}

}
