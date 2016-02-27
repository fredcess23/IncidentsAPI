package com.maranatha.rest;

import static com.jayway.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.maranatha.config.Application;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class UserRestControllerTest {
	
    RestTemplate restTemplate = new TestRestTemplate();

    

	@Before
    public void setUp() {
        //person1 = new User(100,"Terry","Cruz","fredyman","daysyman","Victim",1,1);
        //person2 = new User(1,"Daysy","Alvarez","daysy","daysyman","Victim",30,1);

		//RestAssured.port = port;
		//userDAOmpl.addUser(person1);
    }

	@Test
	public void canFetchUser(){
		
		expect().
			statusCode(200).
			body("id",equalTo(100)).
			body("name",equalTo("Terry")).
			body("lastName",equalTo("Cruz")).
			body("username",equalTo("fredyman")).
			body("password",equalTo("daysyman")).
			body("type",equalTo("Victim")).
			body("age",equalTo(1)).
			body("locationId",equalTo(1)).
			when().
			get("/users/{username}", "fredyman");
		
		
		
		
	}
	
	




}
