package com.inditex.price.infrastructure.adapters.output.persistence;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inditex.price.application.ports.output.PriceDatabasePort;
import com.inditex.price.domain.model.Price;
import com.inditex.price.domain.ports.output.PriceDbPort;
import com.inditex.price.infrastructure.adapters.input.data.request.PriceRequest;
import com.inditex.price.infrastructure.adapters.input.data.respone.PriceResponse;
import com.inditex.price.infrastructure.adapters.output.persistence.entity.PriceEntity;
import com.inditex.price.infrastructure.adapters.output.persistence.mapper.PriceMapper;
import com.inditex.price.infrastructure.adapters.output.persistence.repository.PriceRepository;

@Repository
public class PriceDatabaseAdapter implements PriceDatabasePort {

	@Autowired
	private PriceRepository priceRepository;
	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	public List<Price> getAllPrices() {
		List<PriceEntity> records =  priceRepository.findAll();
        
        return
        		records.stream()
                .map(entity -> modelMapper.map(entity, Price.class))
                .toList();
	}
	
	@Override
	public PriceEntity savePrice(PriceEntity price) {
		return priceRepository.save(price);
	}

	@Override
	public List<Price> getPricesByBrandIdAndProductId(Integer brandId, Integer productId) {
		
		
		return priceRepository.findByBrandIdAndProductId(brandId, productId)
				.stream()
                .map(entity -> modelMapper.map(entity, Price.class))
                .collect(Collectors.toList());
	}

}
