package br.com.ecad.sgaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ecad.sgaapi.model.TituloCobranca;

public interface TituloCobrancaRepository extends JpaRepository<TituloCobranca, Long>{
	
	@Query("select t from TituloCobranca t "
			+ " where t.idTituloCobranca =:nu ")
	TituloCobranca findByTituloBancario(@Param("nu") Long nu);

}
