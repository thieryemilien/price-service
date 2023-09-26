package com.inditex.price.infrastructure.adapters.output.persistence.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

import com.inditex.price.domain.enums.Currency;
import com.inditex.price.domain.model.Price;

public class MainTest {

	public static void main(String[] args) {
		
		List<Price> priceList = getPrices();
		
		Double totalPrice = 0.0;
		
		Integer productId = 35455;
		Integer brandId = 1;
		
		LocalDateTime appDate = LocalDateTime.of(2020, 06, 15, 10, 00, 00, 00);
		
		
		Double rate = priceList.stream()
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
	                    //totalPrice += price.getPrice() * daysBetween;
	                    
	                    //price.setPrice(price.getPrice() * daysBetween);
	                    price.setPrice(price.getPrice() * daysBetween);
			    	}).mapToDouble(o->o.getPrice()).sum();
			        
			//);
		
		System.out.println(rate);
		

    	//2 - specific date time pattern
    	//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
    	
    	//DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive()
          //      .append(DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss")).toFormatter();
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm a");
    	formatter = formatter.withLocale( Locale.US );  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
        LocalDateTime date = LocalDateTime.parse("2019-03-27 10:00 AM", formatter);
        System.out.println(date);
        
        
    	//String time1 = "2019-03-27 10:15:30 AM";
    	//LocalDateTime localTime = LocalDateTime.parse(time1, formatter);
    	
    	//System.out.println(localTime);
		

	}
	
	public static List<Price> getPrices() {
		List<Price> priceList = new ArrayList<>();
		
		Price price1 = new Price();
		price1.setBrandId(1);
		price1.setProductId(35455);
		price1.setPrice(35.50);
		price1.setStartDate(LocalDateTime.of(2020, 06, 14, 00, 00, 00, 00));
		price1.setPriceList(1);
		price1.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59, 00));
		price1.setCurr(Currency.EUR);
		price1.setPriority(0);
		
		
		Price price2 = new Price();
		price2.setProductId(35455);
		price2.setPrice(25.45);
		price2.setBrandId(1);
		price2.setPriceList(2);
		price2.setStartDate(LocalDateTime.of(2020, 06, 14, 15, 00, 00, 00));
		price2.setEndDate(LocalDateTime.of(2020, 06, 14, 18, 30, 00, 00)); 
		price2.setCurr(Currency.EUR);
		price2.setPriority(1);
		
		
		Price price3 = new Price();
		price3.setPriceList(3);
		price3.setBrandId(1);
		price3.setProductId(35455);
		price3.setPrice(30.50);
		price3.setStartDate(LocalDateTime.of(2020, 06, 15, 00, 00, 00, 00));
		price3.setEndDate(LocalDateTime.of(2020, 06, 15, 11, 00, 00, 00));
		price3.setCurr(Currency.EUR);
		price3.setPriority(1);
		
		
		Price price4 = new Price();
		price4.setPriceList(4);
		price4.setBrandId(1);
		price4.setProductId(35455);
		price4.setPrice(318.95);
		price4.setStartDate(LocalDateTime.of(2020, 06, 15, 15, 00, 00, 00));
		price4.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59, 00));
		price4.setCurr(Currency.EUR);
		price4.setPriority(1);
				
		priceList.add(price1);
		priceList.add(price2);
		priceList.add(price3);
		priceList.add(price4);
		
		return priceList;
	}

}
