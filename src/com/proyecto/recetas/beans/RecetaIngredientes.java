package com.proyecto.recetas.beans;


import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="RECETA_INGREDIENTES")
public class RecetaIngredientes implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name="ID_RECETA")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="seq_bd_recetas")
	@SequenceGenerator(name = "seq_bd_recetas", sequenceName = "seq_bd_recetas", allocationSize = 1, initialValue = 1)
	private int idReceta;
	

	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ingrediente_id") 
	private	Ingrediente ingrediente;
	

	private int cantidad;
	
	@Transient
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_receta") 
	private Receta receta;
	
	public RecetaIngredientes() {
	}
	
	public int getCantidad() {
		return this.cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	

    public Receta getReceta() {
        return receta;
    }
	
	public void setReceta(Receta receta) {
		this.receta=receta;
	}
	
 
    public Ingrediente getIngrediente() {
        return ingrediente;
    }
	
	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente=ingrediente;
	}
}
