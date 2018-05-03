package com.proyecto.recetas.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.recetas.beans.Ingrediente;
import com.proyecto.recetas.beans.Receta;
import com.proyecto.recetas.beans.RecetaIngredientes;
import com.proyecto.recetas.service.IngredienteService;
import com.proyecto.recetas.service.RecetaIngredientesService;
import com.proyecto.recetas.service.RecetaService;

@RestController
public class RecetaController {
	
	@Autowired
	RecetaService dao;
	
	@Autowired
	RecetaIngredientesService daoRI;
	
	public void setRecetaService(RecetaService dao) {
		this.dao=dao;
	}
	
	public void setRecetaIngredientesService(RecetaIngredientesService daoRI) {
		this.daoRI=daoRI;
	}
	@RequestMapping(value="/api/recetas/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Receta obtenerRecetaId(@PathVariable int id){
		return dao.getRecetaById(id);
	}
	
	@RequestMapping(value="/api/recetas",method=RequestMethod.GET)
	@ResponseBody
	public List<Receta> obtenerRecetas(){
		return dao.getRecetas();
	}
	
	@RequestMapping(value="/api/recetas",method=RequestMethod.POST)
	@ResponseBody
	public void insertaReceta(@RequestBody Receta receta,HttpServletRequest request) {
		
		System.out.println(receta.toString());
		/*for(RecetaIngredientes r:receta.getRecetaIngredientes() ) {
			RecetaIngredientes rI = new RecetaIngredientes();
			//rI.setReceta(r.getReceta());
			rI.setCantidad(r.getCantidad());
			rI.setIngrediente(r.getIngrediente());
			daoRI.save(rI);
			
		}*/
		
		dao.save(receta);
		//request.getParameter(arg0)
		//System.out.println(recetaIngredientes.getIngrediente()+" "+recetaIngredientes.getReceta() );
	}
	
	@RequestMapping(value="/api/recetas",method=RequestMethod.DELETE)
	@ResponseBody
	public void actualizaRecetas(@RequestBody Receta receta) {
		dao.update(receta);
	}
	
	@RequestMapping(value="/api/recetas",method=RequestMethod.PUT)
	@ResponseBody
	public void borraRecetas(@PathVariable int id) {
		dao.delete(id);
	}
}
