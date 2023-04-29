package com.sqhg.exception;

public class QuestionarioNaoEncontradoException extends RuntimeException {
    public QuestionarioNaoEncontradoException(String mensagem) {
        super(mensagem);
    }   
}