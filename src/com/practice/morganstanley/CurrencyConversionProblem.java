package com.practice.morganstanley;

import java.util.Objects;
import java.util.Set;

public class CurrencyConversionProblem {

    private final double[][] conversionRates;

    public CurrencyConversionProblem(Set<ConversionRate> conversionRateSet) {
        this.conversionRates = init(conversionRateSet);
    }

    private static double[][] init(Set<ConversionRate> conversionRateSet) {
        double[][] conversionRates = new double[conversionRateSet.size()][conversionRateSet.size()];
        Currency[] currencies = Currency.values();
        int i = 0;
        for (Currency currency : currencies) {
            for (ConversionRate conversionRate : conversionRateSet) {
                if (currency.equals(conversionRate.getFromCurrency())) {
                    conversionRates[i][currency.getVal()] = 1;
                } else {
                    conversionRates[i][currency.getVal()] = conversionRate.getFromCurrency().equals(currency) ?
                            conversionRate.getConversionRate() :
                            conversionRate.getToCurrency().equals(currency) ?
                                    conversionRate.getReverseConversionRate() : -1;
                }
            }
            i++;
        }
        return conversionRates;
    }

    public static class ConversionRate {
        private final Currency fromCurrency;
        private final Currency toCurrency;
        private final double rate;

        public ConversionRate(Currency fromCurrency, Currency toCurrency, double conversionRate) {
            this.fromCurrency = fromCurrency;
            this.toCurrency = toCurrency;
            this.rate = conversionRate;
        }

        public Currency getFromCurrency() {
            return fromCurrency;
        }

        public Currency getToCurrency() {
            return toCurrency;
        }

        public double getConversionRate() {
            return rate;
        }

        public double getReverseConversionRate() {
            return 1.0D / rate;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ConversionRate)) return false;
            ConversionRate that = (ConversionRate) o;
            return Double.compare(that.rate, rate) == 0 &&
                    fromCurrency == that.fromCurrency &&
                    toCurrency == that.toCurrency;
        }

        @Override
        public int hashCode() {
            return Objects.hash(fromCurrency, toCurrency, rate);
        }
    }

    public enum Currency {
        USD(0), AUD(1), EUR(2), DIN(3), INR(4);
        private int val;

        Currency(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }
    }
}
