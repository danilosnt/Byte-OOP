package models;

import java.math.BigInteger;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ConversorBytes extends Conversor {
    private static final String[] UNITS = {"bytes", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB"};
    private static final BigInteger ONE_KB = new BigInteger("1024");

    public ConversorBytes(BigInteger valor) {
        super(valor);
    }

    @Override
    public String converter() {
        BigInteger bytes = getValor();
        int unitIndex = 0;
        BigDecimal value = new BigDecimal(bytes);

        while (value.compareTo(new BigDecimal(ONE_KB)) >= 0 && unitIndex < UNITS.length - 1) {
            value = value.divide(new BigDecimal(ONE_KB), 2, RoundingMode.HALF_UP);
            unitIndex++;
        }

        return value.toString().replace(".", ",") + " " + UNITS[unitIndex];
    }
}
