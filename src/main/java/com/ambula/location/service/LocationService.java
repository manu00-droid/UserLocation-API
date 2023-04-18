package com.ambula.location.service;

import java.util.List;

import com.ambula.location.entity.UserLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ambula.location.repository.LocationRepository;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;
    
    public List<String> getNUsers(int n) {
        return locationRepository.getNUsers(n);
    }

    public void putUser(UserLocation userLocation){
        locationRepository.save(userLocation);
    }
}
