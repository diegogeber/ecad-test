package br.com.ecad.sgaapi.integration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

/**
 * 
 * @author Diego Rosa
 * Mock do retorno ejb
 *
 */
@Service
public class BradescoEAO {
	public List<ReturnBradescoDTO> getReturns(){
		List<ReturnBradescoDTO> list = new ArrayList<ReturnBradescoDTO>();
		IntStream.range(1, 5).forEach(id -> list.add(new ReturnBradescoDTO(Long.valueOf(id))));
		return list;
	}
}
