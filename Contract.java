package taxcalculator;

public interface Contract {
    public String getName();

    public TaxBreakdown calculate(double grossIncome);
}
