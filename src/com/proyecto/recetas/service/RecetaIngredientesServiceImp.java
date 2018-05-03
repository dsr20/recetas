package com.proyecto.recetas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.proyecto.recetas.beans.Ingrediente;
import com.proyecto.recetas.beans.RecetaIngredientes;
import com.proyecto.recetas.dao.IngredienteDao;
import com.proyecto.recetas.dao.RecetaIngredientesDao;

@Transactional
public class RecetaIngredientesServiceImp implements RecetaIngredientesService{
	
	@Autowired
	private RecetaIngredientesDao recIngDao;
	
	public void setrecIngDao(RecetaIngredientesDao recIngDao) {
		this.recIngDao = recIngDao;
	}
	
	@Override
	public void save(RecetaIngredientes i) {
		recIngDao.save(i);
	}

	@Override
	public void update(RecetaIngredientes i) {
		recIngDao.update(i);
	}

	@Override
	public void delete(int id) {
		recIngDao.delete(id);
	}

	@Override
	public RecetaIngredientes getIngredienteById(int id) {
		return recIngDao.getIngredienteById(id);
	}

	@Override
	public List<Ingrediente> getIngredientesByReceta() {
		return recIngDao.getIngredientesByReceta();
	}

}
