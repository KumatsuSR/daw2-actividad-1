package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Medicamento;
import com.empresa.repository.MedicamentoRepository;

@Service
public class MedicamentoServiceImpl implements MedicamentoService{
	
	@Autowired
	MedicamentoRepository medicina;

	@Override
	public List<Medicamento> listarMedicamento() {
		return medicina.findAll();
	}

	@Override
	public Medicamento registrarMedicamento(Medicamento obj) {
		return medicina.save(obj);
	}

	@Override
	public Optional<Medicamento> buscarMedicamento(int idMedicamento) {
		return medicina.findById(idMedicamento);
	}

	@Override
	public Optional<Medicamento> medicamentoId(int idMedicamento) {
		return medicina.findById(idMedicamento);
	}

	@Override
	public List<Medicamento> medicamentoNombre(String texto) {
		return medicina.findByNombreLike(texto);
	}

	@Override
	public List<Medicamento> medicamentoStock(int stock) {
		return medicina.findByStock(stock);
	}

	@Override
	public List<Medicamento> medicamentoStockMayorA(int stock) {
		return medicina.findByStockGreaterThanEqual(stock);
	}

}
