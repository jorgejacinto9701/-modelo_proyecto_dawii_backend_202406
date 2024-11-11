package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Ejemplo;
import com.cibertec.repository.EjemploRepository;

@Service
public class EjemploServiceImp implements EjemploService {

	@Autowired	
	private EjemploRepository repository;

	@Override
	public Ejemplo insertaActualizaEjemplo(Ejemplo obj) {
		return repository.save(obj);
	}
	
	@Override
	public List<Ejemplo> listaEjemplo() {
		return repository.findAll();
	}

	@Override
	public List<Ejemplo> listaEjemploPorDescripcionIgual(String descripcion) {
		return repository.listaEjemploPorDescripcionIgual(descripcion);
	}
	
}
