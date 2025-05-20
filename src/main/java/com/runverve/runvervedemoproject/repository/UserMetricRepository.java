package com.runverve.runvervedemoproject.repository;

import com.runverve.runvervedemoproject.model.UserMetrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserMetricRepository extends JpaRepository<UserMetrics, Long> {
    List<UserMetrics> findAll();


    List<UserMetrics> findByUserUserId(Long userId);

    @Query("SELECT u FROM UserMetrics u WHERE u.user.id = :userId AND DATE(u.localDate) = DATE(:date)")
    List<UserMetrics> findByUserIdAndDate(@Param("userId") Long userId, @Param("date") Date date);

}
