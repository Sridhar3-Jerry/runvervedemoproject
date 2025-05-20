package com.runverve.runvervedemoproject.service;

//import com.runverve.runvervedemoproject.dto.UserMetricsDTO;
import com.runverve.runvervedemoproject.model.User;
import com.runverve.runvervedemoproject.model.UserMetrics;
import com.runverve.runvervedemoproject.repository.UserMetricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserMetricService {

    @Autowired
    private UserMetricRepository userMetricRepository;

    // Get all metrics
    public List<UserMetrics> getAllPosts() {
        return userMetricRepository.findAll();
    }

    // Get metric by id
    public UserMetrics getUserMetricById(long id) {
        return userMetricRepository.findById(id).orElse(null);
    }

    // Add/save new metric
    public UserMetrics saveMetric(UserMetrics metric) {
        // You can add extra validations here if needed
        return userMetricRepository.save(metric);
    }

    // Update existing metric
    public UserMetrics updateMetric(UserMetrics metric) {
        if(metric.getId() == null || !userMetricRepository.existsById(metric.getId())) {
            // Metric not found or id is null, return null or throw exception
            return null;
        }
        // Optionally fetch existing and update fields selectively
        return userMetricRepository.save(metric);
    }

    // Delete metric by id
    public boolean deleteMetric(long id) {
        if(userMetricRepository.existsById(id)) {
            userMetricRepository.deleteById(id);
            return true;
        }
        return false;  // id not found
    }

    public List<UserMetrics> getMetricsByUserId(Long userId) {
        // Assuming you have a UserMetricsRepository that extends JpaRepository

        return userMetricRepository.findByUserUserId(userId);
    }

    public List<UserMetrics> getMetricsByUserAndDate(Long userId, Date date) {
        return  userMetricRepository.findByUserIdAndDate(userId, date);
    }


}
