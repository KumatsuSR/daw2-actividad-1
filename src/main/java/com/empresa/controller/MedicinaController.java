package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Medicamento;
import com.empresa.service.MedicamentoServiceImpl;

@RestController
@RequestMapping("/rest/medicina")
public class MedicinaController {
	
	@Autowired
	MedicamentoServiceImpl servicio;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Medicamento>> listaMedicamento(){
		List<Medicamento> temp = servicio.listarMedicamento();
		return ResponseEntity.ok(temp);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Medicamento> registrarMedicamento(@RequestBody Medicamento obj){
		if(obj==null) {
			return ResponseEntity.noContent().build();
		}else {
			if(servicio.buscarMedicamento(obj.getIdMedicamento()).isPresent()) {
				Medicamento salida = servicio.registrarMedicamento(obj);
				return ResponseEntity.ok(salida);
			}else {
				obj.setIdMedicamento(0);
				Medicamento salida = servicio.registrarMedicamento(obj);
				return ResponseEntity.ok(salida);
			}
			
		}
	}
}
