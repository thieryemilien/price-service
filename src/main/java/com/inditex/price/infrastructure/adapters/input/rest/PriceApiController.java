package com.inditex.price.infrastructure.adapters.input.rest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.price.application.ports.input.GetPriceUseCase;
import com.inditex.price.infrastructure.adapters.input.data.respone.PriceResponse;

@RestController
@RequestMapping(value = "/api/v1/price")
public class PriceApiController {
	
	@Autowired
	private GetPriceUseCase getPriceUseCase;

    @GetMapping(value = "/get-price", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PriceResponse> getAll(
    		@RequestParam String appDate, 
    		@RequestParam Integer productId, 
    		@RequestParam Integer brandId
    		)
    {
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm a");
    	formatter = formatter.withLocale( Locale.US );  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
        LocalDateTime localTime = LocalDateTime.parse(appDate, formatter);
    	
    	PriceResponse response = getPriceUseCase.getPrice(brandId, productId, localTime);
    	
    	return new ResponseEntity<>(response, HttpStatus.OK);
    	
    }
    	
}
