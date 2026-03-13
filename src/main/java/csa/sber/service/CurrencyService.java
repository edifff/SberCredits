package csa.sber.service;

import csa.sber.dto.CbrResponseDTO;
import csa.sber.dto.CurrencyRate;
import csa.sber.entity.enums.Currency;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@AllArgsConstructor
public class CurrencyService {

    private final CbrClient cbrClient;

    @Cacheable("exchangeRates")
    public CbrResponseDTO getRates() {
        return cbrClient.getRates();
    }

    public BigDecimal getRate(Currency currency){

        if(currency == Currency.RUB){
            return BigDecimal.ONE;
        }
        CurrencyRate currencyRate = getRates().getValute().get(currency.name());
        if (currencyRate == null) throw new IllegalArgumentException("Unsupported currency: " + currency);

        return currencyRate.getValute();
    }

    public BigDecimal convertFromRub(BigDecimal amount, Currency currency){
        if(currency == Currency.RUB){
            return amount;
        }
        BigDecimal rate = this.getRate(currency);
        return amount.divide(rate, 2, RoundingMode.HALF_UP);
    }
}
