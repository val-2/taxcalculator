package taxcalculator;

public class TaxBreakdown {
    final String contractLabel;

    final double grossIncome;
    final double socialSecurityTax;
    final double socialHealthSecurityTax;
    final double socialSicknessSecurityTax;

    final double healthBase;
    final double health9Tax; // 9%
    final double health775Tax; // 7.75%

    final double taxDeductibleExpenses;
    final double taxedIncomeBeforeRounding;
    final long taxedIncomeRounded;

    final double advanceTax; // 18%
    final double taxFree;
    final double reducedTax; // advance - taxFree
    final double advancePaid; // advance - deductibleHealth - taxFree
    final long advancePaidRounded;

    final double netIncome;

    TaxBreakdown(
            String contractLabel,
            double grossIncome,
            double socialSecurityTax,
            double socialHealthSecurityTax,
            double socialSicknessSecurityTax,
            double healthBase,
            double health9Tax,
            double health775Tax,
            double taxDeductibleExpenses,
            double taxedIncomeBeforeRounding,
            long taxedIncomeRounded,
            double advanceTax,
            double taxFree,
            double reducedTax,
            double advancePaid,
            long advancePaidRounded,
            double netIncome) {
        this.contractLabel = contractLabel;
        this.grossIncome = grossIncome;
        this.socialSecurityTax = socialSecurityTax;
        this.socialHealthSecurityTax = socialHealthSecurityTax;
        this.socialSicknessSecurityTax = socialSicknessSecurityTax;
        this.healthBase = healthBase;
        this.health9Tax = health9Tax;
        this.health775Tax = health775Tax;
        this.taxDeductibleExpenses = taxDeductibleExpenses;
        this.taxedIncomeBeforeRounding = taxedIncomeBeforeRounding;
        this.taxedIncomeRounded = taxedIncomeRounded;
        this.advanceTax = advanceTax;
        this.taxFree = taxFree;
        this.reducedTax = reducedTax;
        this.advancePaid = advancePaid;
        this.advancePaidRounded = advancePaidRounded;
        this.netIncome = netIncome;
    }
}
