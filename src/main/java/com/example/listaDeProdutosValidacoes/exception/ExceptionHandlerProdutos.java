package com.example.listaDeProdutosValidacoes.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice // Acessa essa classe primeiro antes de acessar os outros controllers
public class ExceptionHandlerProdutos extends ResponseEntityExceptionHandler {

    @Autowired
    MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String mensagemUser = messageSource.getMessage("mensagem.invalida", null, null);
        String mensagemDev = ex.getCause().toString(); // Para saber a causa da exce��o e passar para String
        // Para o usu�rio ver apenas a mensagem dedidacada para ele                                                                                      //Locale: Tipo da linguagem da mensagem
        return handleExceptionInternal(ex, new MensagemErro(mensagemUser, mensagemDev), headers, HttpStatus.BAD_REQUEST, request);
        // Para o usu�rio ver apenas a mensagem dedidacada para ele
        // E pro desenvolvedor a mesma coisa
    }


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MensagemErro {

        private String mensagemDoUsuario;
        private String mensagemDoDeveloper;
    }

}


//Primeira forma de se fazer
//Trata somente mensagens que ele n�o conseguiu ler
//  @ExceptionHandler(HttpMessageNotReadableException.class) // M�todo de exce��o
//public ResponseEntity<String> exceptioHandlerCampoInvalido(HttpMessageNotReadableException exception, HttpServletRequest request){
// HttpServletRequest: nos permite pegar o body do tipo da requisi��o post
// return new ResponseEntity<>("O campo inserido, � inv�lido", HttpStatus.BAD_REQUEST); // Vai pegar algo e dar uma nova resposta para o usu�rio

//}
