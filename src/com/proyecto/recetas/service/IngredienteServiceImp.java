package com.proyecto.recetas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.proyecto.recetas.beans.Ingrediente;
import com.proyecto.recetas.dao.IngredienteDao;

@Transactional
public class IngredienteServiceImp implements IngredienteService{
	
	@Autowired
	private IngredienteDao ingDao;
	
	public void setIngDao(IngredienteDao ingDao) {
		this.ingDao = ingDao;
	}
	
	@Override
	public void save(Ingrediente i) {
		ingDao.save(i);
	}

	@Override
	public void update(Ingrediente i) {
		ingDao.update(i);
	}

	@Override
	public void delete(int id) {
		ingDao.delete(id);
	}

	@Override
	public Ingrediente getIngredienteById(int id) {
		return ingDao.getIngredienteById(id);
	}

	@Override
	public List<Ingrediente> getIngredientes() {
		return ingDao.getIngredientes();
	}

}
