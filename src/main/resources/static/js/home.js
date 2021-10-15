$(document).ready(function(){

    function atualizarNome(){
        $("#nomeDoUsuario").text('Usuário teste');
    }

    function atualizarHorasTrabalhadasHoje(){

        var dateObj = new Date();
        var month = dateObj.getUTCMonth() + 1; //months from 1-12
        var day = dateObj.getUTCDate();
        var year = dateObj.getUTCFullYear();

        newdate = year + "-" + month + "-" + day;


        $.get( "/consultar/hora/trabalhadas?data="+ newdate +"&id_func=1")
            .done(function( data ) {
                $(".horasTrabalhadas").text(data);
            });

        $.get( "/consultar/hora/compensadas?data="+ newdate +"&id_func=1")
            .done(function( data ) {
                $(".horasCompensar").text(data);
            });


    }

    function atualizarHoraAtual() {
        const options = {
            timeZone: 'America/Sao_Paulo',
            hour: 'numeric',
            minute: 'numeric',
            second: 'numeric',
        };
        const date = new Intl.DateTimeFormat([], options);
        $("#infoHorarioAtual").text(date.format(new Date()))
    }

    function registrarPonto(funcionario,empresa){
        $.get( "/registrar/hora?id_func="+ funcionario +"&id_empresa=" + empresa)
            .done(function( data ) {
                alert(data);
            });
    }


    $("#btnRegistrarHorario").click(function(){
        registrarPonto(1, 1);
    });


    atualizarHorasTrabalhadasHoje();
    atualizarNome();
    setInterval(atualizarHoraAtual, 1000);
  });