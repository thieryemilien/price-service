package com.inditex.price.infrastructure.adapters.output.persistence.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.inditex.price.domain.model.Price;
import com.inditex.price.infrastructure.adapters.output.persistence.entity.PriceEntity;

public class PriceMapper {
	
	@Autowired
    private ModelMapper mapper;

    public Price covertToPrice(PriceEntity entity){
        return mapper.map(entity, Price.class);
    }
    
    public PriceEntity convertToEntity(Price price){
        return mapper.map(price, PriceEntity.class);
    }


}
