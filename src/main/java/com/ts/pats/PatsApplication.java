package com.ts.pats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class PatsApplication implements CommandLineRunner {

    //@Autowired
    //private JdbcTemplate jdbcTemplate;



    public static void main(String[] args) {
        SpringApplication.run(PatsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //String sql = "INSERT INTO `empresa` (`id_emp`, `nome_emp`) VALUES (?, ?)";
        //int result = jdbcTemplate.update(sql, "4","Thiago Souza's");
        //if(result > 0){
        //    System.out.println("Uma nova linha foi inserida");
       // }
        //else{
        //    System.out.println("ERRO - PATS");
        //}
    }
}
