package com.ally.poc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ally.poc.exeception.RecordNotFoundException;
import com.ally.poc.model.Unicorn;
import com.ally.poc.model.UnicornResponse;
import com.ally.poc.repository.UnicornRepository;

@Service
public class UnicornService {
	
	@Autowired
	private UnicornRepository unicornRepository;
	
	@Autowired
	private UnicornServiceHelper unicornServiceHelper;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	/**
	 * This method is saving the unicorn data
	 * @param unicorn This is Unicorn payload data
	 * @return
	 */
	public UnicornResponse createUnicorn(Unicorn unicorn) {
		unicorn.setUnicornId(sequenceGeneratorService.generateSequence(Unicorn.SEQUENCE_NAME));
		return unicornServiceHelper.createUnicorn(unicornRepository.save(unicorn).getUnicornId());
	}
	
	/**
	 * THis method is get all unicorns
	 * @return
	 */
	public List<Unicorn> getAllUnicorns() {
		return unicornRepository.findAll();
	}
	
	/**
	 * THis method is to find unicorn by Id
	 * @param unicornId THis is unicorn id
	 * @return
	 */
	public Unicorn findUnicornById(long unicornId) {
		Unicorn unicorn =unicornRepository.findByUnicornId(unicornId);
		if(unicorn==null)
		{
			throw new RecordNotFoundException("Not Found");
		}
		return unicorn;
	}

	/**
	 * This method to update the unicorn by Id
	 * @param unicorn This is unicorn payload data 
	 * @param unicornId This is unicorn Id
	 * @return  
	 */
	public Unicorn updateUnicorn(Unicorn unicorn,long unicornId) {
		Unicorn unicornRes = findUnicornById(unicornId);
		return unicornRepository.save(unicornServiceHelper.updateUnicorn(unicorn,unicornRes));
	}
	

}
