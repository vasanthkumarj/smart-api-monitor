package com.example.smart_api_monitor.services.impl;

import com.example.smart_api_monitor.services.AlertService;
import org.springframework.stereotype.Service;

@Service
public class DefaultAlertService implements AlertService {
    @Override
    public void alert(String message) {
        System.out.println(message);
    }
}
