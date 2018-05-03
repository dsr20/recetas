package com.proyecto.recetas.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Recetas")
public class Receta implements java.io.Serializable {

	@Id 
	@Column(name="ID_RECETA")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="seq_bd_recetas")
	@SequenceGenerator(name = "seq_bd_recetas", sequenceName = "seq_bd_recetas", allocationSize = 1, initialValue = 1)
	private int Id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="pasos")
	private String pasos;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="receta_ingredientes", 
				joinColumns=@JoinColumn(name="id_receta"), 
				inverseJoinColumns=@JoinColumn(name="id_ingrediente")) 

	private Set<Ingrediente> ingrediente = new HashSet<Ingrediente>();
	
	@Override
	public String toString() {
		return "Recetas [Id=" + Id + ", nombre=" + nombre + ", pasos=" + pasos + ", ingrediente="
				+ ingrediente + "]";
	}

	public Receta() {}
	
	public Receta(String nombre,String pasos) {
		this.nombre=nombre;
		this.pasos=pasos;
	}
	
	public Receta(String nombre,String pasos,Set<Ingrediente> ingrediente) {
		this.nombre=nombre;
		this.pasos=pasos;
		this.ingrediente=ingrediente;
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
		this.nombre = nombre;
	}

	public String getPasos() {
		return pasos;
	}

	public void setPasos(String pasos) {
		this.pasos = pasos;
	}
	
	/*@OneToMany(fetch = FetchType.LAZY,mappedBy="pk.receta",cascade = CascadeType.ALL)
	public Set<ingrediente> getingrediente(){
		return ingrediente;
	}
	
	public void setingrediente(Set<ingrediente> ingrediente) {
		this.ingrediente=ingrediente;
	}*/
	
	public Set<Ingrediente> getIngrediente() {
        return ingrediente;
    }
 
    public void setingrediente(Set<Ingrediente> ingrediente) {
        this.ingrediente = ingrediente;
    }
     
    public void addingrediente(Ingrediente ingrediente) {
        this.ingrediente.add(ingrediente);
    } 
}
