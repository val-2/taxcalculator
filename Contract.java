package taxcalculator;

public interface Contract {
    TaxBreakdown calculate(double grossIncome);
}
