package com.ally.poc.utils;

import com.ally.poc.exeception.JsonException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {

	public static <T> String asJsonString(final T Obj)
	{
		try {
			return new ObjectMapper().writeValueAsString(Obj);
		} catch (Exception e) {
			throw new JsonException(e.getMessage());
		}
	}
}
