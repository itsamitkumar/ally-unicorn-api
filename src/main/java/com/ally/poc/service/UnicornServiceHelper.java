package com.ally.poc.service;

import org.springframework.stereotype.Service;

import com.ally.poc.model.Unicorn;
import com.ally.poc.model.UnicornResponse;

@Service
public class UnicornServiceHelper {
	

	public UnicornResponse createUnicorn(long unicornId) {
		UnicornResponse unicornResponse = new UnicornResponse();
		unicornResponse.setUnicornId(unicornId);
		return unicornResponse;
	}

	public Unicorn updateUnicorn(Unicorn unicorn, Unicorn unicornRes) {
		unicornRes.setName(unicorn.getName());
		unicornRes.setHairColor(unicorn.getHairColor());
		unicornRes.setHornLength(unicorn.getHornLength());
		unicornRes.setHornColor(unicorn.getHornColor());
		unicornRes.setEyeColor(unicorn.getEyeColor());
		unicornRes.setHeight(unicorn.getHeight());
		unicornRes.setHeightUnit(unicorn.getHeightUnit());
		unicornRes.setWeight(unicorn.getWeight());
		unicornRes.setWeightUnit(unicorn.getWeightUnit());
		unicornRes.setIdentifiableMarks(unicorn.getIdentifiableMarks());
		return unicornRes;
	}

}
