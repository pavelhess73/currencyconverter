package cz.itnetwork.currencyconverter.controller;

import cz.itnetwork.currencyconverter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/v1/currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/corvert")
    public double convertCurrency(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam double amount) {

        return currencyService.convertCurrency(from, to, amount);
    }
}
