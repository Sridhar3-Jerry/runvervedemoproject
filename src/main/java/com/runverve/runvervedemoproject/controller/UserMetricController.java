package com.runverve.runvervedemoproject.controller;

//import com.runverve.runvervedemoproject.dto.UserMetricsDTO;
import com.runverve.runvervedemoproject.model.User;
import com.runverve.runvervedemoproject.model.UserMetrics;
import com.runverve.runvervedemoproject.service.UserMetricService;
import com.runverve.runvervedemoproject.service.UserService;
import jakarta.xml.bind.SchemaOutputResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/metrics")
public class UserMetricController {

    @Autowired
    private UserMetricService userMetricService;

    @Autowired
    private UserService userService;

    // Get all metrics (admin only)
    @GetMapping
    public List<UserMetrics> getAllPosts(Authentication auth) {

        if (!isAdmin(auth)) {
            System.out.println("Access denied for user with authorities: " + auth.getAuthorities());
            throw new RuntimeException("Access denied: Only admin can access all data");
        }
        return userMetricService.getAllPosts();
    }

//    // Get metric by id
//    @GetMapping("/{id}")
//    public ResponseEntity<UserMetrics> getMetricById(@PathVariable long id, Authentication auth) {
//        UserMetrics metric = userMetricService.getUserMetricById(id);
//        if (metric == null) return ResponseEntity.notFound().build();
//
//        if (!isAdmin(auth) && !isOwner(auth, metric)) {
//            return ResponseEntity.status(403).build();
//        }
//
//        return ResponseEntity.ok(metric);
//    }


//    @GetMapping("/my")
//    public ResponseEntity<List<UserMetrics>> getMyMetrics(Authentication auth) {
//        Long currentUserId = getCurrentUserId(auth);  // your helper method to get current user ID
//        List<UserMetrics> myMetrics = userMetricService.getMetricsByUserId(currentUserId);
//        return ResponseEntity.ok(myMetrics);
//    }

    @GetMapping("/{id:\\d+}")
    public ResponseEntity<List<UserMetrics>> getMetricsByUserId(@PathVariable long id) {
        List<UserMetrics> userMetrics = userMetricService.getMetricsByUserId(id);
        return ResponseEntity.ok(userMetrics);
    }


    @GetMapping("/by-user-and-date")
    public ResponseEntity<List<UserMetrics>> getByUserAndDate(
            @RequestParam Long userId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date
    ) {
        List<UserMetrics> list = userMetricService.getMetricsByUserAndDate(userId, date);
        return ResponseEntity.ok(list);
    }




    // Add new metric
    @PostMapping("/addmetric")
    public ResponseEntity<UserMetrics> addMetric(@RequestBody UserMetrics userMetrics, Authentication auth) {
        Long currentUserId = getCurrentUserId(auth);
        if (currentUserId == null) {
            return ResponseEntity.status(403).build();
        }

        User currentUser = userService.getUserById(currentUserId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userMetrics.setUser(currentUser);

        UserMetrics savedMetric = userMetricService.saveMetric(userMetrics);

        return ResponseEntity.ok(savedMetric);
    }



    @PutMapping("/update/{id}")
        public ResponseEntity<UserMetrics> updateMetric(@PathVariable long id,
                                                        @RequestBody UserMetrics metric,
                                                        Authentication auth) {
            // 1. Get existing metric
            UserMetrics existingMetric = userMetricService.getUserMetricById(id);
            if (existingMetric == null) return ResponseEntity.notFound().build();

            // 2. Permission check (admin or owner only)
            if (!isAdmin(auth) && !isOwner(auth, existingMetric)) {
                return ResponseEntity.status(403).build();
            }

            // 3. Set the ID and user manually (do NOT trust user data from request)
            metric.setId(id);
            metric.setUser(existingMetric.getUser());  // This is what you're missing

            // 4. Save and return updated data
            UserMetrics updatedMetric = userMetricService.updateMetric(metric);
            return ResponseEntity.ok(updatedMetric);
        }



    // Delete metric
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> deleteMetric(@PathVariable long id, Authentication auth) {
        UserMetrics existingMetric = userMetricService.getUserMetricById(id);
        if (existingMetric == null) return ResponseEntity.notFound().build();

        if (!isAdmin(auth) && !isOwner(auth, existingMetric)) {
            return ResponseEntity.status(403).build();
        }

        userMetricService.deleteMetric(id);
        return ResponseEntity.noContent().build();
    }

    // Helper permission checks
    private boolean isAdmin(Authentication auth) {
        return auth.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
    }

    private boolean isOwner(Authentication auth, UserMetrics metric) {
        Long currentUserId = getCurrentUserId(auth);
        return metric.getUser().getUserId().equals(currentUserId);
    }
    private Long getCurrentUserId(Authentication auth){
        String email = auth.getName();
        System.out.println("Email from auth: " + email); // Add this for debugging

        return userService.getUserByEmail(email)
                .map(User::getUserId)
                .orElseThrow(() -> new RuntimeException("User not found for email: " + email));
    }
}
