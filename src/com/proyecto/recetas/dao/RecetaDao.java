package com.proyecto.recetas.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import com.proyecto.recetas.beans.Ingrediente;
import com.proyecto.recetas.beans.Receta;

public interface RecetaDao {
	public void setTemplate(JdbcTemplate template); 
	public void save(Receta r);
	public void update(Receta r);
	public void delete(int id);
	public Receta getRecetaById(int id);
	public List<Receta> getRecetas();
}
