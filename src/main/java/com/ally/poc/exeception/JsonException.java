package com.ally.poc.exeception;

public class JsonException extends RuntimeException
{
  private static final long serialVersionUID = 1L;
 
  public JsonException(String message) {
        super(message);
    }
}