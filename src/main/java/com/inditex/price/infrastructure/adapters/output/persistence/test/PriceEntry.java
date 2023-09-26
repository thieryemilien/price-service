package com.inditex.price.infrastructure.adapters.output.persistence.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class PriceEntry {
    private LocalDate startDate;
    private LocalDate endDate;
    private double rate;

    public PriceEntry(LocalDate startDate, LocalDate endDate, double rate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.rate = rate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public double getRate() {
        return rate;
    }
}
