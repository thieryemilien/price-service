package com.inditex.price.infrastructure.adapters.output.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inditex.price.infrastructure.adapters.output.persistence.entity.PriceEntity;

public interface PriceRepository extends JpaRepository<PriceEntity, Integer>{
	
	List<PriceEntity> findByBrandIdAndProductId(Integer brandId, Integer productId);

}
