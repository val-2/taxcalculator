package taxcalculator;

class EmploymentContract implements Contract {

    @Override
    public TaxBreakdown calculate(double grossIncome) {
        double socialSecurityTax = grossIncome * TaxConstants.SOCIAL_SECURITY_RATE;
        double socialHealthSecurityTax = grossIncome * TaxConstants.SOCIAL_HEALTH_SECURITY_RATE;
        double socialSicknessSecurityTax = grossIncome * TaxConstants.SOCIAL_SICKNESS_SECURITY_RATE;

        double healthBase = grossIncome - (socialSecurityTax + socialHealthSecurityTax + socialSicknessSecurityTax);

        double health9Tax = healthBase * TaxConstants.HEALTH_SECURITY_9_RATE;
        double health775Tax = healthBase * TaxConstants.HEALTH_SECURITY_775_RATE;

        double taxDeductibleExpenses = TaxConstants.EMPLOYMENT_TAX_DEDUCTIBLE_EXPENSES;
        double taxedIncomeBeforeRounding = healthBase - taxDeductibleExpenses;
        long taxedIncomeRounded = Math.round(Math.floor(taxedIncomeBeforeRounding));

        double advanceTax = taxedIncomeRounded * TaxConstants.ADVANCE_TAX_RATE;
        double taxFree = TaxConstants.EXPLOYMENT_TAX_FREE_INCOME;
        double reducedTax = advanceTax - taxFree;

        double advancePaid = advanceTax - health775Tax - taxFree;
        long advanceDueRounded = Math.round(Math.floor(advancePaid));

        double netIncome = healthBase - (socialSecurityTax + socialHealthSecurityTax + socialSicknessSecurityTax)
                - health9Tax - advanceDueRounded;

        return new TaxBreakdown(
                "EMPLOYMENT",
                grossIncome,
                socialSecurityTax,
                socialHealthSecurityTax,
                socialSicknessSecurityTax,
                healthBase,
                health9Tax,
                health775Tax,
                taxDeductibleExpenses,
                taxedIncomeBeforeRounding,
                taxedIncomeRounded,
                advanceTax,
                taxFree,
                reducedTax,
                advancePaid,
                advanceDueRounded,
                netIncome);
    }
}
