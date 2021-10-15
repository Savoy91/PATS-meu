$(document).ready(function(){


    $("#btnFazerLogin").click(function(){
        if($('#btnFazerLogin').text() == "ENTRAR"){

            $.get( "/consultar/funcionario?id="+ $("#id").val() + "&pin=" + $("#pin").val())
                .done(function( data ) {
                    if(data == "01"){
                        window.location = "home";
                    }else{
                        alert("Usuário ou Pin inválidos, por favor digite novamente.")
                    }
                });


        }else if($('#btnFazerLogin').text() == "FAZER LOGIN"){
            $("#bemvindo").css({"margin-top":"-100px","transform":"scale(0.6)"});
            $("#loginBox").css({"visibility":"visible"});
            $("#loginBox").css({"opacity":"100%"});
            $( "#loginBox input" ).prop( "disabled", false );
            $("#btnFazerLogin").html("ENTRAR");
        }
        else{

        }
        
    });
  });