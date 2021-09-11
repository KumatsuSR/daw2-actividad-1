package com.empresa.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/id/{paramId}")
	@ResponseBody
	public ResponseEntity<Medicamento> buscarMedicamentoId(@PathVariable("paramId") int id){
		Optional<Medicamento> objTemp = servicio.buscarMedicamento(id);
		if(!objTemp.isPresent()) {
			return ResponseEntity.badRequest().build();
		}else {
			return ResponseEntity.ok(objTemp.get());
		}
	}
	
	@GetMapping("/nombre/{paramNombre}")
	@ResponseBody
	public ResponseEntity<List<Medicamento>> buscarMedicamentoNombre(@PathVariable("paramNombre") String nombre){
		List<Medicamento> temp = servicio.medicamentoNombre("%"+nombre+"%");
		if(CollectionUtils.isEmpty(temp)) {
			return ResponseEntity.badRequest().build();
		}else {
			return ResponseEntity.ok(temp);
		}
	}
	
	@GetMapping("stock/{paramStock}")
	public ResponseEntity<List<Medicamento>> buscarMedicamentoStock(@PathVariable("paramStock") int stock){
		List<Medicamento> listaTemp= servicio.medicamentoStock(stock);
		if(CollectionUtils.isEmpty(listaTemp)) {
			return ResponseEntity.badRequest().build();
		}else {
			return ResponseEntity.ok(listaTemp);
		}
	}
	
	@GetMapping("stockMayor/{paramStock}")
	public ResponseEntity<List<Medicamento>> buscarMedicamentoStockMayor(@PathVariable("paramStock") int stock){
		List<Medicamento> listaTemp= servicio.medicamentoStockMayorA(stock);
		if(CollectionUtils.isEmpty(listaTemp)) {
			return ResponseEntity.badRequest().build();
		}else {
			return ResponseEntity.ok(listaTemp);
		}
	}
}
