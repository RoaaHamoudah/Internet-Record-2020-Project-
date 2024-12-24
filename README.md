# Internet-Record-2020-Project
This project focuses on a graphical interface for managing internet usage data in 2020. Using an array-based list structure,
users can load data from a file, insert or delete country records, search by name, and display countries exceeding a specified internet usage percentage. 

Note: The system can be utilized for data from years other than 2020.

## Features
### File Screen
- load CSV File
   - Use a file chooser to select the electricity data file and load it into the application.
<br>

### Management Screen
- Insert a New Record
- Update or Delete electricity record
- Search for a Record by Date
<br>

### Statistics Screen
1) Daily Electricity Data
   - View specific electricity statistics (e.g., total, average, maximum, minimum) for a given day across all months and years.
     
2) Monthly Electricity Data
   - View specific electricity statistics (e.g., total, average, maximum, minimum) for a given month across all days and years.
     
3) Yearly Electricity Data
   - View specific electricity statistics (e.g., total, average, maximum, minimum) for a given year across all days and months.
     
4) Total Statistics for All Data
   - Maximum, Minimum: For Israeli_Lines_MWs, Gaza_Power_Plant_MWs, and Egyptian_Lines_MWs.
   - Total, Maximum, Minimum, Average: For Total_daily_Supply_available_in_MWs, Overall_demand_in_MWs, Power_Cuts_hours_day_400mg, and Temp.
<br>

### Save Screen
- Save the updated linked lists back to a new CSV file in the same format, separated by commas (,).
- Use a file chooser to select the folder where the file will be saved.
<br>

## Project Structure 
- Data Structure: Combined sorted linked lists to manage and process electricity data.
- Input Data: A CSV file containing daily electricity records, including the following fields:
   - Date
   - Israeli_Lines_MWs
   - Gaza_Power_Plant_MWs
   - Egyptian_Lines_MWs
   - Total_daily_Supply_available_in_MWs
   - Overall_demand_in_MWs
   - Power_Cuts_hours_day_400mg
   - Temp
- GUI: JavaFX-based interface for choosing the CSV file, managing records, viewing statistics, and saving data.
