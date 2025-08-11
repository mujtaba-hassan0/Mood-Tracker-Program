# Mood Tracker

The Mood Tracker is a Java console-based application that allows users to record their mood, along with the date and time, into a text file. It uses Java's modern Date-Time API and file handling features to store and format user input for later reference.

## Features
- Prompts the user to enter the date and time in a specific format.
- Accepts a mood description from the user.
- Formats the date and time using Java's `DateTimeFormatter`.
- Saves the recorded mood entry into a text file.
- Maintains a history of mood entries.

## Technologies Used
- **Java SE** (Core Java)
- **java.time** package for date and time handling
- **java.io** package for file writing

## How It Works
1. The program prompts the user for:
   - Date (in `dd-MM-yyyy` format)
   - Time (in `hh-mm a` format)
   - Mood description
2. It parses and formats the input using:
   - `LocalDate` and `LocalTime`
   - `DateTimeFormatter`
3. It stores the entry in a file (e.g., `mood_log.txt`) using:
   - `FileWriter`
   - `BufferedWriter` (for efficient writing)
4. Each entry is appended to the file, preserving past records.

## Example Usage
Enter Mood (Happy,Sad,Angry): Happy
Enter date (dd-MM-yyyy): 11-08-2025
Enter time (hh-mm am/pm): 10-50 AM
Enter your mood: Happy and productive

Mood saved successfully!


Saved in `mood_log.txt`:


## How to Run
1. Compile the program:
   ```bash
   javac MoodTracker.java
   java MoodTracker


