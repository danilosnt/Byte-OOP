package models;
import java.math.BigInteger;

public abstract class Convert {
    private BigInteger value;

    public Convert(BigInteger value) {
        this.value = value;
    }

    public BigInteger getValue() {
        return value;
    }

    public void setValue(BigInteger value) {
        this.value = value;
    }

    public abstract String converter();
}