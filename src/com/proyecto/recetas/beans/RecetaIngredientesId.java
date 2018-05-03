package com.proyecto.recetas.beans;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Embeddable
public class RecetaIngredientesId implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Receta receta;
	
	private Ingrediente ingrediente;
	
	@ManyToOne
	public Receta getReceta() {
		return receta;
	}
	
	public void setReceta(Receta receta) {
		this.receta=receta;
	}
	
	@ManyToOne
	public Ingrediente getIngrediente() {
		return ingrediente;
	}
	
	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente=ingrediente;
	}
}
