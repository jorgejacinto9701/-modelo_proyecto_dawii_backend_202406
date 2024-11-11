package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Opcion;
import com.cibertec.entity.Rol;
import com.cibertec.entity.Usuario;
import com.cibertec.repository.UsuarioRepository;


@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public List<Opcion> traerEnlacesDeUsuario(int idUsuario) {
		return repository.traerEnlacesDeUsuario(idUsuario);
	}

	@Override
	public List<Rol> traerRolesDeUsuario(int idUsuario) {
		return repository.traerRolesDeUsuario(idUsuario);
	}

	@Override
	public Usuario buscaPorLogin(String login) {
		return repository.findByLogin(login);
	}

	@Override
	public List<Usuario> listaJefePrestamistaTotales() {
		return repository.listaJefePrestamistaTotales();
	}

	@Override
	public List<Usuario> listaPrestamistaDeUnJefe(int idUsuario) {
		return repository.listaPrestamistaDeUnJefe(idUsuario);
	}

	@Override
	public List<Usuario> listaPrestamistariosDeUnPrestamista(int idUsuario) {
		return repository.listaPrestamistariosDeUnPrestamista(idUsuario);
	}

}
