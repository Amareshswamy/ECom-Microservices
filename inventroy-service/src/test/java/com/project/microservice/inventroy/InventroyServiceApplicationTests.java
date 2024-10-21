package com.project.microservice.inventroy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class InventroyServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
