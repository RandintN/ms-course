package software.robsoncassiano.learn.hrworker.entities;

import java.util.Objects;

public class Payment {

    private Long id;
    private Double dailyIncome;
    private Integer days;
    private Double total;

    private Double getTotal(Integer days, Double dailyIncome) {
        return this.total = days * dailyIncome;
    }

    public Payment(Double dailyIncome, Integer days, Double total) {
        this.dailyIncome = dailyIncome;
        this.days = days;
        this.total = total;
    }

    public Long getId() {
        return id;
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id) && Objects.equals(dailyIncome, payment.dailyIncome) && Objects.equals(days, payment.days) && Objects.equals(total, payment.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dailyIncome, days, total);
    }
}
