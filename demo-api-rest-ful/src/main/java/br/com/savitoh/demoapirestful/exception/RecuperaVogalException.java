package br.com.savitoh.demoapirestful.exception;

public class RecuperaVogalException extends Exception {

    private static final String MSG_ERROR = "Não foi possivel recuperar vogal com as regras pedidas (:";

    public  RecuperaVogalException(){
        super(MSG_ERROR);
    }
}
