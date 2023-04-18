package com.ambula.location.controller;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ambula.location.entity.UserLocation;
import com.ambula.location.service.LocationService;

@RestController
@RequestMapping("")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @Autowired
    private EntityManager entityManager;

    @PostMapping("/create_data")
    public ResponseEntity<String> createTable() {
        String tableName = "user_location";
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " ("
                + "id BIGINT PRIMARY KEY AUTO_INCREMENT,"
                + "username VARCHAR(255),"
                + "email VARCHAR(255)"
                + ")";
        Query query = entityManager.createNativeQuery(sql);
        query.executeUpdate();
        return ResponseEntity.ok("Table created successfully");
    }

    @PostMapping(value = "update_data")
    public void updateUsers(@RequestBody String name, @RequestBody double lat, @RequestBody double lng) {
        UserLocation userLocation = new UserLocation();
        userLocation.setLat(lat);
        userLocation.setLng(lng);
        userLocation.setName(name);
        locationService.putUser(userLocation);
    }

    @GetMapping(value = "get_users/{N}")
    public List<String> getUsers(@PathVariable String N) {
        int n = Integer.valueOf(N);
        return locationService.getNUsers(n);
    }


}
