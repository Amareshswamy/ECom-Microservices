package com.project.microservices.product;

import io.restassured.RestAssured;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;

import static org.hamcrest.Matcher.*;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {

	@ServiceConnection
	static MongoDBContainer mongoDbContainer = new MongoDBContainer("mongo:7.0.5");


	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	static {
		mongoDbContainer.start();

	}


	@Test
	void shouldCreateProduct()
	{
		String requestBody = """
				{
				    "name":"iphone 13",
				    "description":"Smart phone but older",
				    "price":"490000"
				}""";

		RestAssured.given().contentType("application/json")
				.body(requestBody)
				.when()
				.post("/api/product")
				.then()
				.statusCode(201)
				.body("id",Matchers.notNullValue())
				.body("name", Matchers.equalTo("iphone 13"))
				.body("description",Matchers.equalTo("Smart phone but older"))
				.body("price",Matchers.equalTo(490000));
	}

}
