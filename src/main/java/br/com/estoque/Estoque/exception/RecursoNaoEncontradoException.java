package br.com.estoque.Estoque.exception;

public class RecursoNaoEncontradoException extends RuntimeException {
    public RecursoNaoEncontradoException(final String msg) {
        super(msg);
    }
}

