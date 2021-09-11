package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.Medicamento;

public interface MedicamentoService {
	
	public abstract List<Medicamento> listarMedicamento();
	public abstract Medicamento registrarMedicamento(Medicamento obj);
	public abstract Optional<Medicamento> buscarMedicamento(int idMedicamento);
	
	//Consulta de Medicamento por ID
	public abstract Optional<Medicamento> medicamentoId(int idMedicamento);
	
	//Consulta de Medicamento por Nombre use LIke
	public abstract List<Medicamento> medicamentoNombre(String texto); 
	
	//Consulta de Medicamento por Stock
	public abstract List<Medicamento> medicamentoStock(int stock);
	
	//Consulta de Medicamento por Stock mayor a
		public abstract List<Medicamento> medicamentoStockMayorA(int stock);
}
