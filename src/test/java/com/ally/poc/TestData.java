package com.ally.poc;

import java.util.ArrayList;
import java.util.List;

import com.ally.poc.model.Unicorn;
import com.ally.poc.model.UnicornResponse;

public class TestData {

	public static Unicorn createUnicorn()
	{
		Unicorn unicorn =new Unicorn();
		unicorn.setUnicornId(1);
		return unicorn;
	}
	
	public static UnicornResponse createUnicornRes()
	{
		UnicornResponse unicornResponse =new UnicornResponse();
		unicornResponse.setUnicornId(1);
		return unicornResponse;
	}
	
	public static List<Unicorn> getUnicorns()
	{
		List<Unicorn> unicorns =new ArrayList<>();
		unicorns.add(createUnicorn());
		return unicorns;
	}
}
