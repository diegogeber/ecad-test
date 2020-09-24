package br.com.ecad.sgaapi.controller;

import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecad.sgaapi.dto.ObjectResponseDTO;
import br.com.ecad.sgaapi.service.ConsultReturnService;

@RestController
@RequestMapping("/consult-return")
public class ConsultReturnController {
	
	public ConsultReturnService consultReturnService;
		
	public ConsultReturnController(ConsultReturnService consultReturnService) {
		super();
		this.consultReturnService = consultReturnService;
	}

	@GetMapping
	public List<ObjectResponseDTO> getReturn(
		@RequestParam(value = "startDate" , required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String startDate,
        @RequestParam(value = "endDate",required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String endDate,
        @RequestParam(value = "ourNumber",required = false) String ourNumber,
        @RequestParam(value = "unit",required = false) String unit,
        @RequestParam(value = "occurency",required = false) String ocurrency){		
		return consultReturnService.consultReturn(startDate, endDate, ourNumber, unit, ocurrency);
	}
}
