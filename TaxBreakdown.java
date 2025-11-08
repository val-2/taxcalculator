package taxcalculator;

import java.text.DecimalFormat;

public class TaxBreakdown {
        final String contractLabel;

        final double grossIncome;
        final double socialSecurityTax;
        final double socialHealthSecurityTax;
        final double socialSicknessSecurityTax;

        final double healthBase;
        final double health9Tax;
        final double health775Tax;

        final double taxDeductibleExpenses;
        final double taxedIncomeBeforeRounding;
        final long taxedIncomeRounded;

        final double advanceTax;
        final double taxFree;
        final double reducedTax;
        final double advancePaid;
        final long advancePaidRounded;

        final double netIncome;

        static final DecimalFormat TWO_DECIMALS = new DecimalFormat("#.00");

        public TaxBreakdown(
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

        public String getBreakdownString() {

                StringBuilder sb = new StringBuilder();

                sb.append("Contract type: ").append(contractLabel).append("\n");

                sb.append("Social security tax: ").append(formatNumber(socialSecurityTax))
                                .append("\n");

                sb.append("Health security tax: ").append(formatNumber(socialHealthSecurityTax))
                                .append("\n");

                sb.append("Sickness security tax: ").append(formatNumber(socialSicknessSecurityTax))
                                .append("\n");

                sb.append("Income for calculating health security tax: ").append(formatNumber(healthBase))
                                .append("\n");

                sb.append("Health security tax 9%: ").append(formatNumber(health9Tax))
                                .append(" 7.75%: ").append(formatNumber(health775Tax))
                                .append("\n");

                sb.append("Tax deductible expenses: ").append(taxDeductibleExpenses).append("\n");

                sb.append("Tax base: ").append(formatNumber(taxedIncomeBeforeRounding))
                                .append(" | rounded: ").append(taxedIncomeRounded).append("\n");

                sb.append("Advance tax 18%: ").append(advanceTax).append("\n");

                sb.append("Tax-free amount: ").append(taxFree).append("\n");

                sb.append("Reduced tax: ").append(reducedTax).append("\n");

                sb.append("Already paid advance tax: ").append(formatNumber(advancePaid))
                                .append(" | rounded: ").append(advancePaidRounded).append("\n");

                sb.append("Net income: ").append(formatNumber(netIncome)).append("\n");
                return sb.toString();
        }

        public String formatNumber(double number) {
                return TWO_DECIMALS.format(number);
        }
}
