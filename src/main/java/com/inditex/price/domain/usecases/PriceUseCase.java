package com.inditex.price.domain.usecases;
import java.util.List;

import com.inditex.price.domain.model.Price;

public interface PriceUseCase {
	List<Price> getAllPrices();
}
