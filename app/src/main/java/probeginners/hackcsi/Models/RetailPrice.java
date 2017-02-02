package probeginners.hackcsi.Models;

import java.math.BigDecimal;

/**
 * Created by rishabhshukla on 02/02/17.
 */

public class RetailPrice {
    BigDecimal amount;
    String currencyCode;

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }
}
