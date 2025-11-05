- Renamed variables for clarity based on the description of the variable printed to console in the original program
- Contract interface with Civil and Employment implementations
- TaxBreakdown as basically dataclass + output string method to pass it around the various methods
- Double.parseDouble(df.format(...)) becomes Math.round and Math.floor
- Separate class from main one for handling console input
- No hardcoded contract types in ConsoleInputReader but defined programmatically in a Map in main class for easy extension
  - Handling this new map in ConsoleInputReader as well to print options and recognize them
  - Why not compute the letter to type from the contract name? Because otherwise
    it would not be possible to have two contract types starting with the same letter,
    it would lead to conflict in the recognition of the input
- Class to handle output formatting not made because it would be one line long
