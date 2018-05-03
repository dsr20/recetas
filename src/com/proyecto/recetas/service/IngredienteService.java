package com.proyecto.recetas.service;

import java.util.List;

import com.proyecto.recetas.beans.Ingrediente;

public interface IngredienteService {
	public void save(Ingrediente i);
	public void update(Ingrediente i);
	public void delete(int id);
	public Ingrediente getIngredienteById(int id);
	public List<Ingrediente> getIngredientes();
}
