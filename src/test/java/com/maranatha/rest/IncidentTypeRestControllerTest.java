package com.maranatha.rest;

import static com.jayway.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.maranatha.config.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class IncidentTypeRestControllerTest {
	
	@Before
    public void setUp() {
    }

	@Test
	public void canFetchType(){
		
		expect().
			statusCode(200).
			body("id",equalTo(1)).
			body("name",equalTo("Kidnapping")).
			body("description",equalTo("Kidnapping")).
			body("nombre",equalTo("Secuestro")).
			when().
			get("/incident/type/{name}", "Kidnapping");
		
	}

}
