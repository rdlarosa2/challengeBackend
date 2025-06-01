package com.tenpo.challengeBackend.service;

import com.tenpo.challengeBackend.dao.PercentageCacheRepository;
import com.tenpo.challengeBackend.entity.Percentage;
import jakarta.transaction.Transactional;
import org.hibernate.StaleObjectStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Optional;

@Service
public class PercentageCacheServiceImpl implements PercentageCacheService {

    private PercentageCacheRepository percentageCacheRepository = null ;

    @Autowired
    public PercentageCacheServiceImpl(PercentageCacheRepository percentageCacheRepository) {
        this.percentageCacheRepository = percentageCacheRepository;
    }

    @Override
    @Transactional
    public void updatePercentageCache(double percentageParam) {

        Optional<Percentage> optPercentage = this.percentageCacheRepository.findById(1L);

        if (optPercentage.isPresent()) {
            try {

                this.percentageCacheRepository.update(percentageParam);

            }
            catch (InvalidDataAccessApiUsageException ite) {
                System.out.println("PercentageCacheServiceImpl:updatePercentageCache: exception name >" + ite.getClass().getName() + "<");
                System.out.println("PercentageCacheServiceImpl:updatePercentageCache: message >" + ite.getMessage() + "<");
                ite.printStackTrace();
            }
            catch (Exception ite) {
                System.out.println("PercentageCacheServiceImpl:updatePercentageCache: exception name >" + ite.getClass().getName() + "<");
                System.out.println("PercentageCacheServiceImpl:updatePercentageCache: message >" + ite.getMessage() + "<");
            }
        }
        else {
            Date date = new Date();
            Percentage percentage = new Percentage(0L, percentageParam, date);
            try {
               this.percentageCacheRepository.save(percentage);
            }
            catch(StaleObjectStateException ite) {
               ite.printStackTrace();
            }

        }
    }

    public Optional<Percentage> findById(long id) {
       return this.percentageCacheRepository.findById(id);
    }
}
