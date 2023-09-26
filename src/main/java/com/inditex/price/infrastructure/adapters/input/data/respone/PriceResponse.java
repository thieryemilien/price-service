package com.inditex.price.infrastructure.adapters.input.data.respone;

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
@AllArgsConstructor
public class PriceResponse {

	
	private Integer productId;
	private Integer brandId;
	private Double rate;
	private Double finalPrice;
	private LocalDateTime appDate;
	
	
}
