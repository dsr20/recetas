package com.proyecto.recetas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import com.proyecto.recetas.beans.Receta;
import com.proyecto.recetas.dao.RecetaDao;

@Transactional
public class RecetaServiceImp implements RecetaService{
	
	@Autowired
	private RecetaDao recDao;
	
	public void setRecDao(RecetaDao recDao) {
		this.recDao = recDao;
	}
	@Override
	public void save(Receta r) {
		recDao.save(r);
	}

	@Override
	public void update(Receta r) {
		recDao.update(r);
	}

	@Override
	public void delete(int id) {
		recDao.delete(id);
	}

	@Override
	public Receta getRecetaById(int id) {
		return recDao.getRecetaById(id);
	}

	@Override
	public List<Receta> getRecetas() {
		return recDao.getRecetas();
	}

}
