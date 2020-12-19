package cn.tx.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.tx.springboot.dao")
@SpringBootApplication
public class TxSysApplication {

	public static void main(String[] args) {
		SpringApplication.run(TxSysApplication.class, args);
	}

}
