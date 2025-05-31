package com.tenpo.challengeBackend.service;

import org.springframework.stereotype.Service;

@Service
public class PercentageServiceImpl implements PercentageService {

    private double percentage = 50.0 ;

    @Override
    public double getPercentage(double num1) throws Exception {

        if ( (num1 > 157.5) && ( num1 < 158.5 ) ) {
             throw new Exception("Service failed");
        }

        return percentage ;
    }

    public double updatePercentage(double percentage) {
        this.percentage = percentage ;
        return this.percentage ;
    }
}
