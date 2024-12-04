package cz.itnetwork.currencyconverter.service;


import cz.itnetwork.currencyconverter.model.ExchangeResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyService {

    @Value("${exchange.api.url}")
    private String apiUrl;

    @Value("${exchange.api.url}")
    private String apiKey;

    public double convertCurrency(String from, String to, double amount) {
        RestTemplate restTemplate = new RestTemplate();

        String url = apiUrl + "?access_key" + "&base=" + from + "&symbols=" + to;

        ExchangeResponse response = restTemplate.getForObject(url, ExchangeResponse.class);

        if (response != null && response.getRates().containsKey(to)) {
            double rate = response.getRates().get(to);
            return amount * rate;
        }

        throw new IllegalArgumentException("Invalid currency");
    }
}
