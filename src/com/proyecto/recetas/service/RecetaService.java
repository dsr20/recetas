package com.proyecto.recetas.service;

import java.util.List;

import com.proyecto.recetas.beans.Ingrediente;
import com.proyecto.recetas.beans.Receta;

public interface RecetaService {
	public void save(Receta r);
	public void update(Receta r);
	public void delete(int id);
	public Receta getRecetaById(int id);
	public List<Receta> getRecetas();
}
