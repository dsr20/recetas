package com.proyecto.recetas.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Ingredientes")
public class Ingrediente implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_INGREDIENTE")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="seq_bd_ingredientes")
	@SequenceGenerator(name = "seq_bd_ingredientes", sequenceName = "seq_bd_ingredientes", allocationSize = 1, initialValue = 1)
	private int Id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="tipo")
	private String tipo;

	
	@ManyToMany(mappedBy = "ingrediente",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<Receta> receta = new HashSet<Receta>();

	public Ingrediente() {}
	
	public Ingrediente(String nombre,String tipo) {
		this.nombre=nombre;
		this.tipo=tipo;
	}
	
	@Override
	public String toString() {
		return "Ingrediente [Id=" + Id + ", nombre=" + nombre + ", tipo=" + tipo + ", receta="
				+ receta + "]";
	}

	public Ingrediente(String nombre,String tipo,Set<Receta> receta) {
		this.nombre=nombre;
		this.tipo=tipo;
		this.receta=receta;
	}
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre=nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

	/*public Set<receta> getreceta(){
		return receta;
	}
	
	public void setreceta(Set<receta> receta) {
		this.receta=receta;
	}*/
	
	
	public Set<Receta> getreceta() {
        return receta;
    }
 
    public void setreceta(Set<Receta> receta) {
        this.receta = receta;
    }
     
    public void addreceta(Receta receta) {
        this.receta.add(receta);
    }
	
}
