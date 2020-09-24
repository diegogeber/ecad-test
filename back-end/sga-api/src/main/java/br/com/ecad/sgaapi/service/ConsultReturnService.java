package br.com.ecad.sgaapi.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ecad.sgaapi.dto.BradescoControl;
import br.com.ecad.sgaapi.dto.ObjectResponseDTO;
import br.com.ecad.sgaapi.integration.BradescoEAO;
import br.com.ecad.sgaapi.integration.ReturnBradescoDTO;
import br.com.ecad.sgaapi.integration.TituloCobrancaEAO;
import br.com.ecad.sgaapi.model.TituloCobranca;
import exception.InvalidRequestException;

@Service
public class ConsultReturnService {
	
	private BradescoEAO bradescoEAO;
	private TituloCobrancaEAO tituloCobrancaEAO;
		
	public ConsultReturnService(BradescoEAO bradescoEAO,
								TituloCobrancaEAO tituloCobrancaEAO) {
		super();
		this.bradescoEAO = bradescoEAO;
		this.tituloCobrancaEAO = tituloCobrancaEAO;
	}

	public List<ObjectResponseDTO> consultReturn(String startDate,String endDate,
							String ourNumber,String unit,String occurrence){
		
	  //codUser mock 
	  Long codUser = 1L;
	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	  validateParams(LocalDate.parse(startDate, formatter), LocalDate.parse(endDate, formatter), ourNumber, unit, occurrence, codUser);
	  List<ReturnBradescoDTO> returnBradesco = bradescoEAO.getReturns();
	  BradescoControl control = new BradescoControl();	  
	  List<ObjectResponseDTO> obj = new ArrayList<ObjectResponseDTO>();
	  for(ReturnBradescoDTO ret : returnBradesco){ 
		  BradescoControl controleBradesco = control.getBradescoControl(ret); 
		  try { 
			TituloCobranca tituloCobranca =  tituloCobrancaEAO.getTituloCobrancaByIdTituloBancario(Long.valueOf(controleBradesco.getSlipNumber()));
		    
			obj.add(new ObjectResponseDTO(tituloCobranca.getUsuario(), tituloCobranca.getIdTituloCobranca() + "465578570" + tituloCobranca.getIdTituloCobranca() ,
					  String.valueOf(tituloCobranca.getIdTituloCobranca()), tituloCobranca.getVlrCobranca().toString() , "Test", tituloCobranca.getDtCompetencia()));
		  } catch (Exception e) { 
			  System.out.println("Não foi encontrado titulo:" + controleBradesco.getSlipNumber());
		  } 
	  }
	  return obj;
	}
	
	private void validateParams(LocalDate startDate,LocalDate endDate,String ourNumber,String unit,String ocurrency, Long codUser){
		if( !(ourNumber != null) && !(startDate != null) && !(endDate != null) && !(unit != null && !unit.equals("T"))){
			throw new InvalidRequestException("É nescessário preencher a Data Inicial e Data Final ou o Nosso Número ou a unidade.");
		}
		
		if(!(startDate != null) && !(endDate != null) && !(unit != null && !unit.equals("T"))){
			throw new InvalidRequestException("É nescessário preencher a Data Inicial e Data Final e a unidade");
		}
		
		if(startDate!=null && endDate!=null){
			if(startDate.isAfter(endDate)){
				throw new InvalidRequestException("A data inicial não pode ser maior que a data final.");
			}
		}
		
		if ((codUser == null) && (ocurrency == null) && (startDate == null) && (endDate == null)) { 
			throw new InvalidRequestException("No mínimo 1 parâmetro deve ser informado para realizar a pesquisa.");
	   }
	}
	
}
