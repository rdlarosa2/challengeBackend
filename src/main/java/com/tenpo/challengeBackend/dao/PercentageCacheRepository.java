package com.tenpo.challengeBackend.dao;

import com.tenpo.challengeBackend.entity.Percentage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PercentageCacheRepository extends JpaRepository<Percentage, Integer> {

    Optional<Percentage> findById(long id);

    @Modifying
    @Query("update Percentage p set p.value = :newPercentage where p.id = 1")
    void update(@Param("newPercentage") double newPercentage);

    Percentage save(Percentage percentage);
}
