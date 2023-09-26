package com.inditex.price.application.ports.output;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.inditex.price.domain.model.Price;
import com.inditex.price.infrastructure.adapters.output.persistence.entity.PriceEntity;

public interface PriceDatabasePort {
    
	List<Price> getAllPrices();
	
	List<Price> getPricesByBrandIdAndProductId(Integer brandId, Integer productId);
	
	PriceEntity savePrice(PriceEntity price);
}
