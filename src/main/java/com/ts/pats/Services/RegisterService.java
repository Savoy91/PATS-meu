package com.ts.pats.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RegisterService {


    @Autowired
    private JdbcTemplate jdbcTemplate;


    //Registrar Funcionário
    @GetMapping("/registrar/funcionario")
    @ResponseBody
    public String registrarFuncionario(
            @RequestParam(required = true) String pin_func,
            @RequestParam(required = true) String nome_func,
            @RequestParam(required = true) String cargo,
            @RequestParam(required = true) String id_emp,
            @RequestParam(required = true) String endereco_func,
            @RequestParam(required = true) String cep_func
    ){
        String sql = "INSERT INTO `funcionario` (`pin`, `nome`, `cargo`, `id_empresa`, `endereco`, `cep`) VALUES (?, ?, ?, ?, ?, ?)";
        int result = jdbcTemplate.update(sql,
                pin_func,
                nome_func,
                cargo,
                id_emp,
                endereco_func,
                cep_func
        );
        if(result > 0)
            return "Funcionário Registrado.";

        return "Ocorreu um erro ao registrar o funcionário.";
    }

    //Registrar Empresa
    @GetMapping("/registrar/empresa")
    @ResponseBody
    public String registrarEmpresa(
            @RequestParam(required = true) String nome_empresa
    ){
        String  sql = "INSERT INTO `empresa` (`nome`) VALUES (?)";
        int result = jdbcTemplate.update(sql, nome_empresa);
        if(result > 0)
            return "Empresa Registrado.";

        return "Ocorreu um erro ao registrar a empresa.";
    }

    //Registrar Horário
    @GetMapping("/registrar/hora")
    @ResponseBody
    public String registrarHoras(
            @RequestParam(required = true) String id_func,
            @RequestParam(required = true) String id_empresa
    ){
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat formatadorData = new SimpleDateFormat("yyyy-MM-dd");


        String  sql = "INSERT INTO `ponto` (`horario_entrada`, `id_func`, `data`, `statusPonto`, `id_empresa`) VALUES (?, ?, ?, 0, ?)";
        int result = jdbcTemplate.update(sql, formatador.format(new Date()), id_func, formatadorData.format(new Date()), id_empresa);
        if(result > 0)
            return "Ponto Registrado.";

        return "Ocorreu um erro ao registrar o ponto";
    }

}
