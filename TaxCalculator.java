package taxcalculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class TaxCalculator {

	private static final DecimalFormat TWO_DECIMALS = new DecimalFormat("#.00");
	private static final DecimalFormat NO_DECIMALS = new DecimalFormat("#");

	public static void main(String[] args) {
		double grossIncome;
		char contractType;
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);

			System.out.print("Enter income: ");
			grossIncome = Double.parseDouble(br.readLine());

			System.out.print("Contract Type: (E)mployment, (C)ivil: ");
			String typeLine = br.readLine();
			if (typeLine == null || typeLine.isEmpty()) {
				System.out.println("Incorrect");
				return;
			}
			contractType = Character.toUpperCase(typeLine.charAt(0));
		} catch (Exception ex) {
			System.out.println("Incorrect");
			System.err.println(ex.getMessage());
			return;
		}

		Contract contract = createContract(contractType);
		if (contract == null) {
			System.out.println("Unknown type of contract!");
			return;
		}

		TaxBreakdown result = contract.calculate(grossIncome);
		displayResults(result);
	}

	private static Contract createContract(char type) {
		switch (type) {
			case 'E':
				return new EmploymentContract();
			case 'C':
				return new CivilContract();
			default:
				return null;
		}
	}

	private static void displayResults(TaxBreakdown r) {
		System.out.println(r.contractLabel);
		System.out.println("Gross income: " + TWO_DECIMALS.format(r.grossIncome));
		System.out.println("Pension insurance (9.76%): " + TWO_DECIMALS.format(r.socialSecurityTax));
		System.out.println("Disability insurance (1.5%): " + TWO_DECIMALS.format(r.socialHealthSecurityTax));
		System.out.println("Sickness insurance (2.45%): " + TWO_DECIMALS.format(r.socialSicknessSecurityTax));
		System.out.println("Income basis for health insurance: " + TWO_DECIMALS.format(r.healthBase));
		System.out.println("Health insurance 9%: " + TWO_DECIMALS.format(r.health9Tax)
				+ "  | deductible 7.75%: " + TWO_DECIMALS.format(r.health775Tax));
		System.out.println("Tax deductible expenses: " + TWO_DECIMALS.format(r.taxDeductibleExpenses));
		System.out.println("Tax base: " + TWO_DECIMALS.format(r.taxedIncomeBeforeRounding)
				+ " | rounded: " + NO_DECIMALS.format(r.taxedIncomeRounded));
		System.out.println("Advance tax 18%: " + TWO_DECIMALS.format(r.advanceTax));
		System.out.println("Tax-free amount: " + TWO_DECIMALS.format(r.taxFree));
		System.out.println("Reduced tax (advance - tax-free): " + TWO_DECIMALS.format(r.reducedTax));
		System.out.println("Advance tax due (advance - deductible health - tax-free): "
				+ TWO_DECIMALS.format(r.advancePaid) + " | rounded: " + NO_DECIMALS.format(r.advancePaidRounded));
		System.out.println();
		System.out.println("Net income: " + TWO_DECIMALS.format(r.netIncome));
	}
}
