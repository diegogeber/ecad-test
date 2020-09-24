package br.com.ecad.sgaapi;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.ecad.sgaapi.model.TituloCobranca;
import br.com.ecad.sgaapi.repository.TituloCobrancaRepository;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SgaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SgaApiApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner bookDemo(TituloCobrancaRepository rep) {
        return (args) -> {
            //salvando titulos em memoria
        	rep.save(new TituloCobranca(1L, "Diego", new Date(), new BigDecimal(1), Short.parseShort("1"), "S" , "Diego", "Test", null, Short.parseShort("1")));
        	rep.save(new TituloCobranca(2L, "Diego2", new Date(), new BigDecimal(2), Short.parseShort("2"), "S" , "Diego2", "Test2", null, Short.parseShort("2")));
        	rep.save(new TituloCobranca(3L, "Diego3", new Date(), new BigDecimal(3), Short.parseShort("3"), "S" , "Diego3", "Test3", null, Short.parseShort("3")));
        	rep.save(new TituloCobranca(4L, "Diego4", new Date(), new BigDecimal(4), Short.parseShort("4"), "S" , "Diego4", "Test4", null, Short.parseShort("4")));
        };	
        	
	}
	
	ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("SGA API ")
            .description("TESTE DE MIGRAÇÃO LEGADO PARA API REST")
            .license("")
            .licenseUrl("")
            .termsOfServiceUrl("")
            .version("1.0.0")
            .build();
    }
	
	@Bean
    public Docket productApi() {
      return new Docket(DocumentationType.SWAGGER_2).select()
         .apis(RequestHandlerSelectors.basePackage("br.com.ecad.sgaapi")).build().apiInfo(apiInfo());
    }
	
}	
	
