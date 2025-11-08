- Renamed variables for clarity based on the description of the variable printed to console in the original program
- Removed static variables
- Contract interface with Civil and Employment implementations
- TaxBreakdown as basically dataclass + output string method to pass it around the various methods
- Double.parseDouble(df.format(...)) becomes Math.round and Math.floor
- Separate class from main one for handling console input
- No hardcoded contract types in ConsoleInputReader but defined programmatically in a Map in main class for easy extension
  - Handling this new map in ConsoleInputReader as well to print options and recognize them
  - Why not make the letter to type the first letter of the contract name (e.g. 'C'ivil)? Because otherwise
    it would not be possible to have two contract types starting with the same letter,
    it would lead to conflict in the recognition of the input,
    while now it's as well more enforced since a Map cannot have duplicate keys.
- I decided not to make a class to handle output from main class because it would be one line long (lazy class, just System.out.println(r.getBreakdownString());)
- Moved contract-specific constants into their respective classes and the rest in TaxConstants
