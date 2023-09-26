package com.inditex.price.domain.model;

import java.io.Serializable;

import java.time.Instant;
import java.time.LocalDateTime;

import com.inditex.price.domain.enums.Currency;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class Price {
	private Integer priceList;
	private Integer brandId;
	private Integer productId;
	private Double price;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Integer priority;
	
	private Currency curr;
	
}
