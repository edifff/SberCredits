package csa.sber.service;

import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.UUID;

@Service
public class NumberGenerator {
    public String generateDeal(){
        return "SBER-"+ Year.now()+"-"+ UUID.randomUUID().toString().substring(0,6).toUpperCase();
    }

    public String generatePayment(){
        return "PAY-"+Year.now()+"-"+UUID.randomUUID().toString().substring(0,9).toUpperCase();
    }
}
