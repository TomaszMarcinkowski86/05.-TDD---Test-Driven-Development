package foo.bar;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Period;

public class MoneySavingCalculator {

    public BigDecimal calculateSavings(
            SavingFrequency frequency,
            BigDecimal singleAmmount,
            Period duration  //klasa czasowa w java od-do
    ) {

        // 1. zamienić period na ilość dni
        // 2. ilość dni podzielić przez frequwncy.getDays - to nam da ilość tranzakcji
        // 3. ilość tranzakcji * singleAmmmount
        // 4.  *
        
         return singleAmmount.multiply(BigDecimal.valueOf(duration.getYears()));
    }
}
