package com.example.companiescrudms.services.interfaces;

import java.util.Map;
import java.util.Objects;

public interface IExceptionService {
    public abstract Map<String, Object> generateExcetionMessage(String message, String messageException);
}
