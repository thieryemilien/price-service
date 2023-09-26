package com.inditex.price.infrastructure.adapters.input.data.request;

import java.time.Instant;
import com.inditex.price.domain.enums.Currency;
import lombok.Data;

@Data
public class PriceRequest {
		private Integer priceList;
		private Integer brandId;
		private Integer productId;
		private Double price;
		private Instant startDate;
		private Instant endDate;
		private Integer priority;
		private Currency curr;

}
