package com.inditex.price.application.ports.input;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.inditex.price.domain.model.Price;
import com.inditex.price.infrastructure.adapters.input.data.respone.PriceResponse;

public interface GetPriceUseCase {
	List<Price> getAllPrices();
	
	PriceResponse getPrice(Integer brandId, Integer productId, LocalDateTime appDate);

	
}
