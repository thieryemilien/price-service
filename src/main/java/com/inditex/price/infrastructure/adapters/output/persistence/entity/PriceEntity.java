package com.inditex.price.infrastructure.adapters.output.persistence.entity;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;

import com.inditex.price.domain.enums.Currency;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "PRICES")
public class PriceEntity {

	@Id
	@Column(name = "PRICE_LIST")
	private Integer priceList;
	
	@Column(name = "BRAND_ID")
	private Integer brandId;
	
	@Column(name = "PRODUCT_ID")
	private Integer productId;
	
	@Column(name = "PRICE", length = 20, precision = 2)
	private Double price;
	
	@Column(name = "START_DATE")
	private LocalDateTime startDate;
	
	@Column(name = "END_DATE")
	private LocalDateTime endDate;
	
	@Column(name = "PRIORITY")
	private Integer priority;
	
	@Column(name = "CURR")
	@Enumerated(EnumType.STRING)
	private Currency curr;
	
}
