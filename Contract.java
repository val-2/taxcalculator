package taxcalculator;

public interface Contract {
    String getName();

    TaxBreakdown calculate(double grossIncome);
}
