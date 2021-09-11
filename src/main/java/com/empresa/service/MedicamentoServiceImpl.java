package com.empresa.service;

import java.util.List;

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

}
