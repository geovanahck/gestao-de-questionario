package com.sqhg.SQHG;

import org.assertj.core.api.ErrorCollector;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Role;

import com.sqhg.entities.Administrador;

@SpringBootTest
class SqhgApplicationTests {


	@Role
	public ErrorCollector error = new ErrorCollector();

	@Test
	void contextLoads() throws Exception {

		Administrador administrador = new Administrador();

		
	}

}
