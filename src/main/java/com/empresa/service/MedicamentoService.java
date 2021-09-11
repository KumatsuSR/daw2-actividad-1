package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.Medicamento;

public interface MedicamentoService {
	
	public abstract List<Medicamento> listarMedicamento();
	public abstract Medicamento registrarMedicamento(Medicamento obj);
	public abstract Optional<Medicamento> buscarMedicamento(int idMedicamento);
}
