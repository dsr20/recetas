package com.proyecto.recetas.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import com.proyecto.recetas.beans.Ingrediente;
import com.proyecto.recetas.beans.Receta;
import com.proyecto.recetas.beans.RecetaIngredientes;

public interface RecetaIngredientesDao {
	public void setTemplate(JdbcTemplate template); 
	public void save(RecetaIngredientes r);
	public void update( RecetaIngredientes r);
	public void delete(int id);
	public RecetaIngredientes getIngredienteById(int id);
	public List<Ingrediente> getIngredientesByReceta();
}
