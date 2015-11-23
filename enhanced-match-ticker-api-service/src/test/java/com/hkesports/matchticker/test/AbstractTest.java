package com.hkesports.matchticker.test;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hkesports.matchticker.config.PropertiesConfig;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@ContextConfiguration(locations = {"/spring-config.xml" })
@WebAppConfiguration
public abstract class AbstractTest {

	protected static final Logger logger = LoggerFactory.getLogger(AbstractTest.class); 
	
	@Resource(name = "dataSource")
	private ComboPooledDataSource dataSource;
	
	@Resource(name = "propertiesConfig")
	protected PropertiesConfig propertiesConfig;
	
	@Before
	public void testDataSourceUrl() {
		logger.info("DRIVER CALSS : " + dataSource.getDriverClass());
		logger.info("JDBC URL : " + dataSource.getJdbcUrl());
		logger.info("USERNAME PASSWORD : " + dataSource.getUser() + ", " + dataSource.getPassword());
		logger.info("PROPERTIES : " + dataSource.getProperties());
	}
}
