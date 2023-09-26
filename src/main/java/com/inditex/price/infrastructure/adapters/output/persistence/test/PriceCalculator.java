package com.inditex.price.infrastructure.adapters.output.persistence.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {
    private List<PriceEntry> priceList;

    public PriceCalculator() {
        // Initialize with some sample price entries
        priceList = new ArrayList<>();
        priceList.add(new PriceEntry(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 3, 31), 10.0));
        priceList.add(new PriceEntry(LocalDate.of(2023, 4, 1), LocalDate.of(2023, 6, 30), 12.0));
        priceList.add(new PriceEntry(LocalDate.of(2023, 7, 1), LocalDate.of(2023, 9, 30), 15.0));
    }

    public double calculatePriceRate(LocalDate startDate, LocalDate endDate) {
        double totalPrice = 0.0;

        for (PriceEntry entry : priceList) {
            if (startDate.isBefore(entry.getEndDate()) && endDate.isAfter(entry.getStartDate())) {
                // Calculate the overlapping date range
                LocalDate rangeStartDate = startDate.isAfter(entry.getStartDate()) ? startDate : entry.getStartDate();
                LocalDate rangeEndDate = endDate.isBefore(entry.getEndDate()) ? endDate : entry.getEndDate();
                
                long daysBetween = rangeStartDate.until(rangeEndDate.plusDays(1)).getDays(); // +1 to include the endDate
                totalPrice += entry.getRate() * daysBetween;
            }
        }

        return totalPrice;
    }

    public static void main(String[] args) {
        PriceCalculator calculator = new PriceCalculator();

        LocalDate startDate = LocalDate.of(2023, 2, 15);
        LocalDate endDate = LocalDate.of(2023, 4, 15);

        double price = calculator.calculatePriceRate(startDate, endDate);
        System.out.println("Price for the date range: " + price);
    }
}
