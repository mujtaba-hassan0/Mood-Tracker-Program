import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.imageio.IIOException;

public class MoodTracker{
    public static void main(String[] args) {
       List<Mood> moods = new ArrayList<>();
       Scanner sc = new Scanner(System.in);
       
       while(true){
          System.out.println("\n=== Mood Tracker Menu ===");
            System.out.println("1. Add Mood");
            System.out.println("2. Delete Mood");
            System.out.println("3. Edit Mood Notes");
            System.out.println("4. Search Mood");
            System.out.println("5. Write Mood Journal");
            System.out.println("6. View Mood");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            String choice = sc.nextLine();

        if(choice.equals("1")){
            System.out.print("Enter mood (happy, sad, angry, etc.): ");
            String mood = sc.nextLine();

            System.out.println("Enter Date (dd-MM-yyyy): ");
            String date = sc.nextLine();

            LocalDate objDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));//Create a date String into date object 
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("EEEE MMM dd, yyyy"); // set date object as like given format
            String formattedDate = objDate.format(dateFormat); // format date object into String


            System.out.print("Enter time (hh-mm AM/PM): ");
            String time = sc.nextLine();

            DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("hh-mm a"); // Define the input format for time
            LocalTime newTime = LocalTime.parse(time, inputFormat); // Create a time String into time object
            DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh-mm a"); // set time object as like given format
            String formattedTime = newTime.format(timeFormat); // format time object into String

            System.out.print("Enter notes: ");
            String notes = sc.nextLine();

            boolean moodVal = true;
            for(Mood m : moods){
                if(m.getName().equalsIgnoreCase(mood) && m.getDate().equals(formattedDate) && m.getTime().equals(formattedTime)){
                    System.out.println("Sorry, this mood entry already exists.");
                    moodVal = false;
                    return;
                }
            }
            if(moodVal) {
            moods.add(new Mood(mood, formattedDate, formattedTime, notes));
            System.out.println("Mood Added Successfully");}
        
        }
        


        else if(choice.equals("2")){
            if(moods.isEmpty()){
                System.out.println("No moods to delete.");
                continue;
            }
            
            while(true){
            System.out.println("Select in which way you want to delete mood."+
            "\nPress 1 for Delete by Name."+
            "\nPress 2 for Delete by Date."+
            "\nPress 3 Delete by Time."+
            "\nPress 4 for Delete by All Details."+
            "\nPress any other key to exit from delete mood option");
            String delChoice = sc.nextLine();
            
            if(delChoice.equals("1")){
                System.out.println("Enter the mood name you want to delete");
                String moodName = sc.nextLine();

                boolean moodFound = false;
                for(Mood m : moods){
                    if(m.getName().equalsIgnoreCase(moodName)){
                        moods.remove(m);
                        System.out.println("Mood Deleted Successfully");
                        moodFound = true;
                        break;
                    }
                }
                if(!moodFound) {
                    System.out.println("No mood found");
                }
            }


            else if(delChoice.equals("2")){
                System.out.println("Enter the date (dd-MM-yyyy) for delete all the tasks having this date:");
                String date = sc .nextLine();

            LocalDate objDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("EEEE MMM dd, yyyy");
            String formattedDate = objDate.format(dateFormat);

                boolean moodFound = false;
                for(Mood m : moods){
                    if(m.getDate().equals(formattedDate)){
                        moods.remove(m);
                        System.out.println("Mood Deleted Successfully");
                        moodFound = true;
                    }
                    else{
                        continue;
                    }
                }
                if(!moodFound){
                    System.out.println("No mood found with the specified date.");
                }
            }
            
            else if(delChoice.equals("3")){
                System.out.println("Enter the time (hh-mm):");
                String time = sc.nextLine();

            DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("hh-mm a");
            LocalTime newTime = LocalTime.parse(time, inputFormat);
            DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh-mm a");
            String formattedTime = newTime.format(timeFormat);

            boolean moodFound = false;
                for(Mood m : moods){
                    if(m.getTime().equals(formattedTime)){
                        moods.remove(m);
                        System.out.println("Mood Deleted Successfully");
                        moodFound = true;
                    }
                    else{
                        continue;
                    }
                }
                if(!moodFound){
                    System.out.println("No mood found with the specified time.");
                }
            }
        
        
            else if (delChoice.equals("4")) {
                System.out.println("Enter the mood name:");
                String moodName = sc.nextLine();

                System.out.println("Enter the date (dd-MM-yyyy):");
                String date = sc.nextLine();

                LocalDate objDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("EEEE MMM dd, yyyy");
                String formattedDate = objDate.format(dateFormat);

                System.out.println("Enter the time (hh-mm):");
                String time = sc.nextLine();

              DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("hh-mm a");
            LocalTime newTime = LocalTime.parse(time, inputFormat); 
            DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh-mm a"); 
            String formattedTime = newTime.format(timeFormat); 

                boolean moodFound = false;
                for(Mood m : moods){
                    if(m.getName().equalsIgnoreCase(moodName) && m.getDate().equals(date) && m.getTime().equals(time)){
                        moods.remove(m);
                        System.out.println("Mood Deleted Successfully");
                        moodFound = true;
                        break;
                    }
                }
                if(!moodFound) {
                    System.out.println("No mood found with the specified details.");
                }
            }
        
            else{
                System.out.println("Invalid choice.Exiting Delete Mood");
                break;
            }
        }
    }
        
        
        else if(choice.equals("3")){
            System.out.println("Enter the Mood name:");
            String moodName = sc.nextLine();
            System.out.println("Enter the date of mood in this format(dd-mm-yyyy)");
            String date = sc.nextLine();

            LocalDate objDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("EEEE MMM dd, yyyy");
            String formattedDate = objDate.format(dateFormat);

            System.out.println("Enter the time of mood in this format(hh-mm)");
            String time = sc.nextLine();

            DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("hh-mm a");
            LocalTime newTime = LocalTime.parse(time, inputFormat); 
            DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh-mm a"); 
            String formattedTime = newTime.format(timeFormat); 

            boolean moodFound = false;
            for(Mood m : moods){
                if(m.getName().equalsIgnoreCase(moodName) && m.getDate().equals(formattedDate) && m.getTime().equals(formattedTime)){
                    System.out.println("Mood Found write the notes you want to edit: ");
                    String newNotes = sc.nextLine();

                    m.setNotes(newNotes);
                    System.out.println("Mood updated successfully.");
                    moodFound = true;
                    break;
                }
            }
            if(!moodFound) {
                System.out.println("No mood found with the specified details.");
                continue;
            }
        }
    
        else if(choice.equals("4")){
            System.out.println("Select the Search method.");
            System.out.println("1. Search by All Details");
            System.out.println("2. Search by Date");
            String searchChoice = sc.nextLine();

            if(moods.isEmpty()){
                System.out.println("No moods available for search.");
                continue;
            }

            if(searchChoice.equals("1")){
                System.out.println("Enter the mood name:");
                String moodName = sc.nextLine();
                
                System.out.println("Enter the date (dd-mm-yyyy):");
                String date = sc.nextLine();

                LocalDate objDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("EEEE MMM dd, yyyy");
                String formattedDate = objDate.format(dateFormat);

                System.out.println("Enter the time (hh-mm):");
                String time = sc.nextLine();

                DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("hh-mm a");
                LocalTime newTime = LocalTime.parse(time, inputFormat); 
                DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh-mm a"); 
                String formattedTime = newTime.format(timeFormat); 
                
                boolean moodFound = false;
                for(Mood m : moods){
                    if(m.getName().equalsIgnoreCase(moodName) && m.getDate().equals(formattedDate) && m.getTime().equals(formattedTime)){
                        System.out.println("Mood Found:");
                        System.out.println(m);
                        moodFound = true;
                    }
                }
                if(!moodFound) {
                    System.out.println("No mood found with the specified details.");
                }
            }

            else if(searchChoice.equals("2")){
                System.out.println("Enter the date (dd-mm-yyyy):");
                String date = sc.nextLine();

                LocalDate objDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("EEEE MMM dd, yyyy");
                String formattedDate = objDate.format(dateFormat);

                boolean moodFound = false;
                for(Mood m : moods){
                    if(m.getDate().equals(formattedDate)){
                        System.out.println("Mood Found:");
                        System.out.println(m);
                        moodFound = true;
                    }
                }
                if(!moodFound) {
                    System.out.println("No mood found with the specified date.");
                }
            }

            else {
                System.out.println("Exiting from Search Mood");
                continue;
            }
        }
            
        else if(choice.equals("5")){
            int count =1;

        try{
            FileWriter writer = new FileWriter("MoodJournal.txt");
            for(Mood m : moods){
            writer.write("Mood " + count + ". "+m.toString() + "\n");
            count++;
            }
            writer.close();
        }

            catch (IOException e) {
                System.out.println("Something went wrong...."+e.getMessage());
            }
         
        }

        else if(choice.equals("6")){
            int count =1;
            if(moods.isEmpty()){
                System.out.println("No moods available to view.");
            } else {
                System.out.println("Moods:");
                for(Mood m : moods){
                    System.out.println("Mood "+ count + ". " + m);
                    count++;
                }
            }
        }
        
        else{
            System.out.println("Invalid choice.");
            sc.close();
            break;
        }

        }

        }
}

                    
      
