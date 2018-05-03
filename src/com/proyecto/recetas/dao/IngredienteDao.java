package com.proyecto.recetas.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import com.proyecto.recetas.beans.Ingrediente;

public interface IngredienteDao {
	public void setTemplate(JdbcTemplate template); 
	public void save(Ingrediente i);
	public void update(Ingrediente i);
	public void delete(int id);
	public Ingrediente getIngredienteById(int id);
	public List<Ingrediente> getIngredientes();
}
