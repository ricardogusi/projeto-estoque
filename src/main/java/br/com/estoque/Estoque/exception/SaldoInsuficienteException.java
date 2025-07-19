package br.com.estoque.Estoque.exception;

public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException(final String msg) {
        super(msg);
    }
}

