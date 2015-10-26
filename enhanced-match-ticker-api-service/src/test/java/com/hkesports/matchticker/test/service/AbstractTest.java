package com.hkesports.matchticker.test.service;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hkesports.matchticker.config.PropertiesConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@ContextConfiguration(locations = {"/spring-config.xml" })
@WebAppConfiguration
public abstract class AbstractTest {

	protected static final Logger logger = LoggerFactory.getLogger(AbstractTest.class); 
	
	@Resource(name = "propertiesConfig")
	protected PropertiesConfig propertiesConfig;
}
