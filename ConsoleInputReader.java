package taxcalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class ConsoleInputReader {

    private final BufferedReader reader;

    public ConsoleInputReader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public double readIncome() {
        double grossIncome;
        String incomeLine;
        while (true) {
            System.out.print("Enter income: ");
            try {
                incomeLine = reader.readLine();
                if (incomeLine == null || incomeLine.trim().isEmpty()) {
                    System.out.println("Insert again.");
                    continue;
                }
                grossIncome = Double.parseDouble(incomeLine.trim());
                if (grossIncome < 0) {
                    System.out.println("Income cannot be negative.");
                    continue;
                }
                break;
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid value.");
            } catch (IOException ioe) {
                System.out.println("Error reading input.");
            }
        }
        return grossIncome;
    }

    public char readContractType(Map<Character, Contract> contractMap) {
        String prompt = getContractsString(contractMap);

        char contractType;
        String typedLine;
        while (true) {
            System.out.print(prompt);
            try {
                typedLine = reader.readLine();
                if (typedLine == null || typedLine.trim().isEmpty()) {
                    System.out.println("Insert again.");
                    continue;
                }
                contractType = typedLine.trim().toUpperCase().charAt(0);
                if (!contractMap.containsKey(contractType)) {
                    System.out.println("Unknown type of contract");
                    continue;
                }
                break;
            } catch (IOException ioe) {
                System.out.println("Error reading input.");
            }
        }
        return contractType;
    }

    public String getContractsString(Map<Character, Contract> contractMap) {
        StringBuilder prompt = new StringBuilder("Contract Type: ");
        boolean first = true;
        for (var entry : contractMap.entrySet()) {
            if (!first) {
                prompt.append(", ");
            }
            prompt.append('(')
                    .append(entry.getKey());
            prompt.append(") ")
                    .append(entry.getValue().getName());
            first = false;
        }
        prompt.append(": ");

        return prompt.toString();

    }

}
