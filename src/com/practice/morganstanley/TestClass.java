package com.practice.morganstanley;


import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

import static com.practice.morganstanley.CurrencyConversionProblem.Currency;

public class TestClass {

    //@Test
    public void testCase1() {
        double maxCoversionValue = Q1.getMaxConvertedValue("EUR", "INR", 1);
        Assert.assertEquals(maxCoversionValue, 280D);
    }

    /**
     * Conversion Rate:
     * 1 USD = 70 INR
     * 1 AUD = 2 USD
     * 1 EUR = 1.5 USD
     * 1 EUR = 2 AUD
     * 1 DIN = 3 USD
     * 1 DIN = 2.5 EUR
     * <p>
     * <p>
     * Input 1 EUR = INR
     * Expected output  = 280 INR
     * <p>
     * 1 EUR = 2 AUD = 4 USD = 280 INR
     * 1 EUR = 1.5 USD = 105 INR
     */
    public static void main(String[] args) {
        Set<CurrencyConversionProblem.ConversionRate> conversionRates = new HashSet<>();
        conversionRates.add(new CurrencyConversionProblem.ConversionRate(Currency.USD, Currency.INR, 70D));
        conversionRates.add(new CurrencyConversionProblem.ConversionRate(Currency.AUD, Currency.USD, 2D));
        conversionRates.add(new CurrencyConversionProblem.ConversionRate(Currency.EUR, Currency.USD, 1.5D));
        conversionRates.add(new CurrencyConversionProblem.ConversionRate(Currency.EUR, Currency.AUD, 2D));
        conversionRates.add(new CurrencyConversionProblem.ConversionRate(Currency.DIN, Currency.USD, 3D));
        conversionRates.add(new CurrencyConversionProblem.ConversionRate(Currency.DIN, Currency.EUR, 2.5D));
        CurrencyConversionProblem ccp = new CurrencyConversionProblem(conversionRates);
    }
}
