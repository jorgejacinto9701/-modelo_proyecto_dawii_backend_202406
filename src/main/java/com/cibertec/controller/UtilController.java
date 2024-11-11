package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entity.DataCatalogo;
import com.cibertec.entity.Pais;
import com.cibertec.entity.Ubigeo;
import com.cibertec.service.DataCatalogoService;
import com.cibertec.service.PaisService;
import com.cibertec.service.UbigeoService;
import com.cibertec.util.AppSettings;

@RestController
@RequestMapping("/url/util")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class UtilController {

	@Autowired
	private PaisService paisService;

	@Autowired
	private DataCatalogoService dataCatalogoService;

	@Autowired
	private UbigeoService ubigeoService;
	

	@GetMapping("/listaPais")
	@ResponseBody
	public List<Pais> listaPais() {
		return paisService.listaTodos();
	}
	
	@GetMapping("/listaTipoEntidadBancaria")
	@ResponseBody
	public List<DataCatalogo> listaTipoEntidadBancaria() {
		return dataCatalogoService.listaDataCatalogo(AppSettings.CATALOGO_01_TIPO_DE_ENDIDAD_BANCARIA);
	}
	
	@GetMapping("/listaTipoMoneda")
	@ResponseBody
	public List<DataCatalogo> listaTipoMoneda() {
		return dataCatalogoService.listaDataCatalogo(AppSettings.CATALOGO_02_TIPO_DE_MONEDA);
	}
	
	@GetMapping("/listaDiasPrestamo")
	@ResponseBody
	public List<DataCatalogo> listaDiasPrestamo() {
		return dataCatalogoService.listaDataCatalogo(AppSettings.CATALOGO_03_DIAS_DE_PRESTAMO);
	}
	
	@GetMapping("/listaEstadoSolicitud")
	@ResponseBody
	public List<DataCatalogo> listaGradoAutor() {
		return dataCatalogoService.listaDataCatalogo(AppSettings.CATALOGO_04_ESTADO_SOLICTUD_DE_PRESTAMO);
	}	
	
	@GetMapping("/listaDepartamentos")
	@ResponseBody
	public List<String> verDepartamentos() {
		return ubigeoService.listaDepartamentos();
	}

	@GetMapping("/listaProvincias/{paramDepar}")
	@ResponseBody
	public List<String> verProvincias(@PathVariable("paramDepar") String departamento) {
		return ubigeoService.listaProvincias(departamento);
	}

	@GetMapping("/listaDistritos/{paramDepar}/{paramProv}")
	@ResponseBody
	public List<Ubigeo> verDistritos(@PathVariable("paramDepar")String departamento, @PathVariable("paramProv")String provincia) {
		return ubigeoService.listaDistritos(departamento, provincia);
	}
	

	
}
