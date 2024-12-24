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
<br>

## Screenshots
### File Screen
![Screenshot (1594)](https://github.com/user-attachments/assets/e33c4973-794c-4cd4-be70-f70b483f23db)

### Management Screen
![Screenshot (1595)](https://github.com/user-attachments/assets/155fd61e-e1f7-43c6-ae11-00b235039734)

![Screenshot (1596)](https://github.com/user-attachments/assets/e555b96c-e554-4834-992a-5fc8a2c02483)

![Screenshot (1597)](https://github.com/user-attachments/assets/186c6b2d-0ddf-4ed9-ad6c-0aa8bb68c95b)

![Screenshot (1598)](https://github.com/user-attachments/assets/c11d534b-d4d3-4e45-bd40-fa54e6897eb8)

### Statistics Screen
![Screenshot (1605)](https://github.com/user-attachments/assets/5a597fd9-41d0-4636-9ff5-496a3922a11d)

![Screenshot (1600)](https://github.com/user-attachments/assets/541b7da0-f1a5-40b9-ba02-fe9f35329e88)

![Screenshot (1601)](https://github.com/user-attachments/assets/0577cf16-a64d-451a-859d-4c1172627576)

![Screenshot (1602)](https://github.com/user-attachments/assets/057eab09-3140-40e2-a6fb-342827feb506)

![Screenshot (1603)](https://github.com/user-attachments/assets/6f236883-1ec0-476a-bc52-4daa9f07de6d)

### Save Screen
![Screenshot (1604)](https://github.com/user-attachments/assets/1aba6735-3676-42a1-add6-96df00147164)
