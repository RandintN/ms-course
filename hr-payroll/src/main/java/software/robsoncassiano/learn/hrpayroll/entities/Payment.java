package software.robsoncassiano.learn.hrpayroll.entities;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Payment {

    private String name;
    private Double dailyIncome;
    private Integer days;

    public Payment() {
    }

    public Payment(String name, Double dailyIncome, Integer days) {
        this.name = name;
        this.dailyIncome = dailyIncome;
        this.days = days;
    }

    public Double getTotal() {
        final double total = this.days * this.dailyIncome;
        return BigDecimal.valueOf(total)
                .setScale(3, RoundingMode.HALF_UP)
                .doubleValue();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDailyIncome() {
        return dailyIncome;
    }

    public void setDailyIncome(Double dailyIncome) {
        this.dailyIncome = dailyIncome;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

}
