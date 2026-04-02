package com.example.companiescrudms.services;

import com.example.companiescrudms.services.interfaces.IExceptionService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ExceptionService implements IExceptionService {
    @Override
    public Map<String, Object> generateExcetionMessage(String message, String messageException) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("error", messageException);

        return map;
    }
}
