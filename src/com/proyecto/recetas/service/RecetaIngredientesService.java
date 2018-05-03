package com.proyecto.recetas.service;

import java.util.ArrayList;
import java.util.List;

import com.proyecto.recetas.beans.Ingrediente;
import com.proyecto.recetas.beans.RecetaIngredientes;

public interface RecetaIngredientesService {
	public void save(List<RecetaIngredientes> i);
	public void update(RecetaIngredientes  i);
	public void delete(int id);
	public RecetaIngredientes  getIngredienteById(int id);
	public List<Ingrediente> getIngredientesByReceta();
}
