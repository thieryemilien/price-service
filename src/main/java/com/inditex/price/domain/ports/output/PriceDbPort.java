package com.inditex.price.domain.ports.output;

import java.util.List;

import com.inditex.price.domain.model.Price;

public interface PriceDbPort {
	List<Price> getAllPrices();
}
