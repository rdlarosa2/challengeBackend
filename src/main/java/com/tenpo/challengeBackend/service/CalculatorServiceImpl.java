package com.tenpo.challengeBackend.service;

import com.tenpo.challengeBackend.entity.Percentage;
import com.tenpo.challengeBackend.service.exceptions.NoPercentageStoredRecentlyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Optional;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    private PercentageService percentageService = null ;

    private PercentageCacheService percentageCacheService = null ;

    @Autowired
    public CalculatorServiceImpl(PercentageService percentageService , PercentageCacheService percentageCacheService ) {
        this.percentageService = percentageService;
        this.percentageCacheService = percentageCacheService ;
    }

    public double suma(double num1, double num2) throws NoPercentageStoredRecentlyException {
        double percentage = 20.0 ;
        try {
            percentage = this.percentageService.getPercentage(num1);

            this.percentageCacheService.updatePercentageCache(percentage);
        }
        catch(Exception e) {

            Optional<Percentage> optPercentage = this.percentageCacheService.findById(1L);

            if ( optPercentage.isPresent() ) {
                Percentage percentageObj = optPercentage.get() ;

                if ( dateAfterLast30minutes( percentageObj.getDate() )) {
                    percentage = percentageObj.getValue();
                }
                else {
                    throw new NoPercentageStoredRecentlyException("No percentages stored recently");
                }
            }
        }

        return ( num1 + num2 ) * percentage / 100.0 ;
    }

    boolean dateAfterLast30minutes(Date aDate) {
        Date now = new Date();
        //  120000L = 2 min ,  1800000L = 30 m
        long millisecondsADate = now.getTime() - 1800000L ; //
        return aDate.getTime() > millisecondsADate ;
    }

}

