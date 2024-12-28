# Internet-Record-2020-Project

## Project Overview
This project focuses on a graphical interface for managing internet usage data in 2020. Using an array-based list structure,
users can load data from a file, insert or delete country records, search by name, and display countries exceeding a specified internet usage percentage. 

Note: The system can be utilized for data from years other than 2020.

## Features
1. **Custom List Implementation**:
    - The list is implemented using an array with an initial size of 16.
    - The list resizes dynamically by doubling its size when needed.
    - Use of `ArrayList` or similar library classes is not allowed.

2. **Graphical User Interface (GUI)**:
    - Built using JavaFX (Scene Builder is not allowed).
    - Includes a file chooser for loading the `internet_2020.csv` file.
    - Provides options for various operations on the list.
  
3. **Functionalities**:
    - **Insert**: Add a new country record to the list (e.g., add Palestine).
    - **Delete**: Remove a country record from the list by country name (e.g., delete Finland).
    - **Search**: Find a specific country record by its name.
    - **Display**: Show all countries where the percentage of individuals using the internet exceeds a user-specified threshold. Results are displayed in a table.

## File Structure
- **`internet_2020.csv`**: The input file containing country records. Each line contains the country name and the percentage of individuals using the internet.
    
  Examples:
  Afghanistan,18.4
  <br>
  Albania,72.2
  <br>
  Algeria,62.9



 



