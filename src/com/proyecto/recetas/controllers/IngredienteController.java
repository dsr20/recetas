package com.proyecto.recetas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.recetas.beans.Ingrediente;
import com.proyecto.recetas.service.IngredienteService;

@RestController
public class IngredienteController {
	
	@Autowired
	IngredienteService dao;
	
	public void setIngredienteService(IngredienteService dao) {
		this.dao=dao;
	}
	
	@RequestMapping(value="/api/ingredientes/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Ingrediente obtenerIngredienteId(@PathVariable int id){
		return dao.getIngredienteById(id);
	}
	
	@RequestMapping(value="/api/ingredientes",method=RequestMethod.GET)
	@ResponseBody
	public List<Ingrediente> obtenerIngredientes(){
		return dao.getIngredientes();
	}
	
	@RequestMapping(value="/api/ingredientes",method=RequestMethod.POST)
	@ResponseBody
	public void insertaIngrediente(@RequestBody Ingrediente ingrediente) {
		dao.save(ingrediente);
	}
	
	@RequestMapping(value ="/api/ingredientes",method=RequestMethod.PUT)
	//@ResponseStatus(value = HttpStatus.OK)
	public void actualizaIngrediente(@RequestBody Ingrediente ingrediente) {
		
		dao.update(ingrediente);
		//return new ResponseEntity("Registro actualizado",HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/ingredientes/{id}",method=RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void borraIngrediente(@PathVariable int id) {
		dao.delete(id);
	}
	
}
