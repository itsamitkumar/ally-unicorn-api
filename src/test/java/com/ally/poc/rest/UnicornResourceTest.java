package com.ally.poc.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ally.poc.TestData;
import com.ally.poc.UnicornApplication;
import com.ally.poc.service.UnicornService;
import com.ally.poc.utils.Utils;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK,classes = {UnicornApplication.class})
public class UnicornResourceTest {

	private String baseUrl= "/api";
	private String uri;
	@MockBean
	private MockHttpServletRequestBuilder mockHttpServletRequestBuilder;
	private MockMvc mockMvc;
	@Autowired
	WebApplicationContext webApplicationContext;
	@MockBean
	UnicornService unicornService;
	
	@Before
	public void before ()
	{
		mockMvc =MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	
	@Test
	public void testGetUnicorns() throws Exception
	{
		this.uri ="/unicorns";
		MvcResult mvcResult =this.mockMvc.perform(get(this.baseUrl+this.uri).
				contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andReturn();
		int status =mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}
	
	@Test
	public void testUpdateUnicorn() throws Exception
	{
		long unicornId=1;
		this.uri ="/unicorns/{unicornId}";
		MvcResult mvcResult =this.mockMvc.perform(post(this.baseUrl+this.uri,unicornId).content(Utils.asJsonString(TestData.createUnicorn())).
				contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andReturn();
		int status =mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}
	
	
}
