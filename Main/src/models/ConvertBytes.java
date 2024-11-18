package models;

import java.math.BigInteger;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ConvertBytes extends Convert {
    private static final String[] UNITS = {"bytes", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB"};
    private static final BigInteger ONE_KB = new BigInteger("1024");

    public ConvertBytes(BigInteger value) {
        super(value);
    }

    @Override
    public String converter() {
        BigInteger bytes = getValue();
        int unitIndex = 0;
        BigDecimal value = new BigDecimal(bytes);

        while (value.compareTo(new BigDecimal(ONE_KB)) >= 0 && unitIndex < UNITS.length - 1) {
            value = value.divide(new BigDecimal(ONE_KB), 2, RoundingMode.HALF_UP);
            unitIndex++;
        }

        return value.toString().replace(".", ",") + " " + UNITS[unitIndex];
    }
}