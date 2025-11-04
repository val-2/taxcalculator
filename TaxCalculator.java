package taxcalculator;

import java.util.Map;

public class TaxCalculator {

	private static ConsoleInputReader inputReader = new ConsoleInputReader();
	private static Map<Character, Contract> contractMap = new java.util.LinkedHashMap<>(
			Map.of(
					'E', new EmploymentContract(),
					'C', new CivilContract()));

	public static void main(String[] args) {

		double grossIncome = inputReader.readIncome();

		char selectedContractClass = inputReader.readContractType(contractMap);

		Contract contract = createContract(selectedContractClass);

		TaxBreakdown result = contract.calculate(grossIncome);
		displayResults(result);
	}

	private static Contract createContract(char contractType) {
		Contract contractInstance = contractMap.get(contractType);
		return contractInstance;
	}

	private static void displayResults(TaxBreakdown r) {
		System.out.println(r.getBreakdown());
	}
}
