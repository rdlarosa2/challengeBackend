package com.tenpo.challengeBackend.service;

import com.tenpo.challengeBackend.entity.Percentage;

import java.util.Optional;

public interface PercentageCacheService {

    void updatePercentageCache(double percentage);

    Optional<Percentage> findById(long id);
}
