package com.ts.pats.Services;

import com.ts.pats.Model.Funcionario;
import com.ts.pats.Model.Ponto;
import com.ts.pats.utils.utilsF;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Controller
public class ConsultService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    //Consultar Funcionário
    @GetMapping("/consultar/funcionario")
    @ResponseBody
    public String registrarFuncionario(
            @RequestParam(required = true) String id,
            @RequestParam(required = true) int pin
    ){

        String sql = "SELECT * FROM funcionario WHERE id = ? AND pin = ?";

            var rm = (RowMapper<Funcionario>) (ResultSet result, int rowNum) -> {
                var func = new Funcionario();
                func.setId(result.getInt("id"));
                func.setPin(result.getInt("pin"));
                func.setNome(result.getString("nome"));
                func.setCargo(result.getString("cargo"));
                func.setId_empresa(result.getInt("id_empresa"));
                func.setEndereco(result.getString("endereco"));
                func.setCep(result.getInt("cep"));
                return func;
            };


        var funcionario = new Funcionario();
        try {
            funcionario = (Funcionario) jdbcTemplate.queryForObject(sql, new Object[]{id,pin}, rm);
        }catch (Exception ignored){

        }

        if(funcionario.getNome() != null)
            return "01";


        return "00";
    }

    //Consultar Horas Trabalhadas
    @GetMapping("/consultar/hora/trabalhadas")
    @ResponseBody
    public String consultarHoraTrabalhadas(
            @RequestParam(required = true) String data,
            @RequestParam(required = true) String id_func
    ) throws ParseException {

        String sql = "SELECT * FROM ponto WHERE data = ? AND id_func = ?";

        var rm = (RowMapper<Ponto>) (ResultSet result, int rowNum) -> {
            var ponto = new Ponto();
            ponto.setHorario_entrada(result.getString("horario_entrada"));
            ponto.setHorario_saida(result.getString("horario_saida"));
            return ponto;
        };


        var ponto = new Ponto();
        try {
            ponto = (Ponto) jdbcTemplate.queryForObject(sql, new Object[]{data,id_func}, rm);
        }catch (Exception ignored){

        }
        utilsF util = new  utilsF();
        Date atual = new Date();
        Date pegandoDataEntrada;
        Date pegandoDataSaida;

        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse();
        if(ponto.getHorario_saida() == null && ponto.getHorario_entrada() != null){
            //retornar Diferença do Horario de entrada - o horário atual
            return util.findDifference(ponto.getHorario_entrada(), formatador.format(new Date()));
        }else if(ponto.getHorario_saida() != null && ponto.getHorario_entrada() != null){
            //retornar Diferença do Horario de entrada - o Horario de saida
            return util.findDifference(ponto.getHorario_entrada(), ponto.getHorario_saida());
        }
        else{
            return "00:00:00";
        }
    }

    //Consultar Horas Compensadas
    @GetMapping("/consultar/hora/compensadas")
    @ResponseBody
    public String consultarHoraCompensadas(
            @RequestParam(required = true) String data,
            @RequestParam(required = true) String id_func
    ) throws ParseException {

        String sql = "SELECT * FROM ponto WHERE data = ? AND id_func = ?";

        var rm = (RowMapper<Ponto>) (ResultSet result, int rowNum) -> {
            var ponto = new Ponto();
            ponto.setHorario_entrada(result.getString("horario_entrada"));
            ponto.setHorario_saida(result.getString("horario_saida"));
            return ponto;
        };


        var ponto = new Ponto();
        try {
            ponto = (Ponto) jdbcTemplate.queryForObject(sql, new Object[]{data, id_func}, rm);
        } catch (Exception ignored) {

        }
        utilsF util = new utilsF();
        Date atual = new Date();
        Date pegandoDataEntrada;
        Date pegandoDataSaida;

            return "00:00:00";

    }
}
