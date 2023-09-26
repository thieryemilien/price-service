package com.inditex.price.domain.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.price.application.ports.input.GetPriceUseCase;
import com.inditex.price.application.ports.output.PriceDatabasePort;
import com.inditex.price.domain.model.Price;
import com.inditex.price.infrastructure.adapters.input.data.respone.PriceResponse;
import com.inditex.price.infrastructure.adapters.output.persistence.test.Student;

@Service
public class PriceService implements GetPriceUseCase {

	@Autowired
    private PriceDatabasePort priceDatabasePort;
    
	@Override
	public List<Price> getAllPrices() {
		return priceDatabasePort.getAllPrices(); 
	}

	@Override
	public PriceResponse getPrice(Integer brandId, Integer productId, LocalDateTime appDate) {
		List<Price> priceList = priceDatabasePort.getPricesByBrandIdAndProductId(brandId, productId);
		
		Double rate = calculatePrice(priceList, productId, appDate);
		Double finalPrice = calculatePrice(priceList, productId, appDate);
		
		return new PriceResponse(productId, brandId, rate, finalPrice, appDate);
	}
	

	public Double calculatePrice(List<Price> priceList, Integer productId,  LocalDateTime appDate) {
				
		Double finalPrice = priceList.stream()
			    	//.filter(entry -> appDate.isBefore(entry.getEndDate()) && appDate.isAfter(entry.getStartDate()))
			        .collect(Collectors.groupingBy(
			            l -> l.getProductId() + "-"+ l.getPrice(),
			            Collectors.collectingAndThen(
			                Collectors.maxBy(Comparator.comparingInt(l -> l.getPriority())), 
			                Optional::get
			            )
			        ))
			        .values()
			        .stream()
			        .peek(price -> {
			    		LocalDateTime rangeStartDate = appDate.isAfter(price.getStartDate()) ? appDate : price.getStartDate();
	            		LocalDateTime rangeEndDate = appDate.isBefore(price.getEndDate()) ? appDate : price.getEndDate();
	                    
	            		long daysBetween = rangeStartDate.until(rangeEndDate.plusDays(1), ChronoUnit.DAYS); //.getDays(); 
	                    
	                    price.setPrice(price.getPrice() * daysBetween);
			    	}).mapToDouble(o->o.getPrice()).sum();
		 
		 return finalPrice;
        
	}
	

}
