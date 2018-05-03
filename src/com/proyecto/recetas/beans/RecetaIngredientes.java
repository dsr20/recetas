package com.proyecto.recetas.beans;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RECETA_INGREDIENTES")
public class RecetaIngredientes implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name="ID_RECETA")
	private int receta;
	
	@Id
	@Column(name="ID_INGREDIENTE")
	private int ingrediente;

	private int cantidad;
	
	public RecetaIngredientes() {
	}
	
	public int getCantidad() {
		return this.cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	

    public int getReceta() {
        return receta;
    }
	
	public void setReceta(int receta) {
		this.receta=receta;
	}
	
 
    public int getIngrediente() {
        return ingrediente;
    }
	
	public void setIngrediente(int ingrediente) {
		this.ingrediente=ingrediente;
	}
}
