package com.ally.poc.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ally.poc.TestData;
import com.ally.poc.exeception.RecordNotFoundException;
import com.ally.poc.model.Unicorn;
import com.ally.poc.model.UnicornResponse;
import com.ally.poc.repository.UnicornRepository;

@RunWith(SpringRunner.class)
public class UnicornServiceTest {

	@TestConfiguration
	static class UnicornServiceTestConfig {
		@Bean
		public UnicornService unicornService() {
			return new UnicornService();
		}
		@Bean
		public UnicornServiceHelper unicornServiceHelper() {
			return new UnicornServiceHelper();
		}
	}
	
	@Autowired
	UnicornService unicornService;
	
	@Autowired
	UnicornServiceHelper unicornServiceHelper;
	
	@MockBean
	private UnicornRepository unicornRepository;
	
	@MockBean
	private SequenceGeneratorService sequenceGeneratorService;
	
	
	@Test
	public void testCreateUnicorn()
	{
		Unicorn unicorn = TestData.createUnicorn();
		when(this.unicornRepository.save(unicorn)).thenReturn(unicorn);
		UnicornResponse  unicornRes =unicornService.createUnicorn(unicorn);
		assertNotNull(unicornRes);
	}
	
	@Test
	public void testFindUnicornById()
	{
		Unicorn unicorn = TestData.createUnicorn();
		when(this.unicornRepository.findByUnicornId(anyLong())).thenReturn(unicorn);
		Unicorn  unicornRes=unicornService.findUnicornById(unicorn.getUnicornId());
		assertNotNull(unicornRes);
	}
	
	@Test(expected = RecordNotFoundException.class)
	public void testFindUnicornByIdWithNegative()
	{
		Unicorn unicorn = TestData.createUnicorn();
		when(this.unicornRepository.findByUnicornId(anyLong())).thenReturn(null);
		Unicorn  unicornRes=unicornService.findUnicornById(unicorn.getUnicornId());
		assertNotNull(unicornRes);
	}
	
	@Test
	public void testGetAllUnicorns()
	{
		List<Unicorn> unicorns = TestData.getUnicorns();
		when(this.unicornRepository.findAll()).thenReturn(unicorns);
		List<Unicorn>  unicornRes=unicornService.getAllUnicorns();
		assertNotNull(unicornRes);
	}
	
	@Test
	public void testUpdateUnicorn()
	{
		Unicorn unicorn = TestData.createUnicorn();
		when(this.unicornRepository.save(unicorn)).thenReturn(unicorn);
		when(this.unicornRepository.findByUnicornId(anyLong())).thenReturn(unicorn);
		Unicorn  unicornRes =unicornService.updateUnicorn(unicorn, unicorn.getUnicornId());
		assertNotNull(unicornRes);
	}
}
