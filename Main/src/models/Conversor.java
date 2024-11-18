package models;

import java.math.BigInteger;

public abstract class Conversor {
    private BigInteger valor;

    public Conversor(BigInteger valor) {
        this.valor = valor;
    }

    public BigInteger getValor() {
        return valor;
    }

    public void setValor(BigInteger valor) {
        this.valor = valor;
    }

    // Método abstrato para implementar o polimorfismo
    public abstract String converter();
}
