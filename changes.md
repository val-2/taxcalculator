- Renamed variables for clarity based on the description of the variable printed to console in the original program
- Moved static variables that represented the result of the calculations into TaxBreakdown
  To have a more cohesive representation of the tax breakdown
- Created Contract interface with Civil and Employment implementations
- Replaced cursed way of rounding "Double.parseDouble(df.format(...))" with "Math.round(...)"
- Created class, separate from main one, to handle console input
- No hardcoded contract types in ConsoleInputReader but defined programmatically in a Map in main class for easy extension
  - Handling this new map in ConsoleInputReader as well to print options and recognize them
  - Why not make the letter to type the first letter of the contract name (e.g. 'C'ivil)? Because otherwise
    it would not be possible to have two contract types starting with the same letter,
    it would lead to conflict in the recognition of the input,
    while now it's as well more enforced since a Map cannot have duplicate keys.
- I decided not to make a class to handle output from main class because it would be one line long (lazy class, with one method that just calls System.out.println(r.getBreakdownString());)
- Moved contract-specific constants into their respective classes and the rest in TaxConstants
