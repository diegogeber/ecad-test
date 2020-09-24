package br.com.ecad.sgaapi.integration;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.ecad.sgaapi.model.TituloCobranca;
import br.com.ecad.sgaapi.repository.TituloCobrancaRepository;

@Service
public class TituloCobrancaEAO {
	
	private TituloCobrancaRepository repository;
	
	public TituloCobrancaEAO(TituloCobrancaRepository repository) {
		super();
		this.repository = repository;
	}

	public TituloCobranca getTituloCobrancaByIdTituloBancario(Long nroBoleto) {
		return repository.findByTituloBancario(nroBoleto);
	}
}
