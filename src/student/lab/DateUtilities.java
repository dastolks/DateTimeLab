package student.lab;

import java.text.DateFormat;
import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import javax.swing.text.DateFormatter;

/**
 * This is a class that is used for many date conversions by using JDK 8's new
 * implementation of how to create new dates.
 * 
 * 
 * @author Alec Schindler, aschindler1@my.wctc.edu
 * @version 1.00
 */
public class DateUtilities {
    private static DateUtilities instance;
    private final String HOURS = "Hours";
    private final String MINUTES = "Minutes";
    private final String DAYS = "Days";
    private final String WEEKS = "Weeks";
    private final String MONTHS = "Months";  
    
    private DateUtilities(){}
    
    /**
     * A static method that checks to see if there are any other instances of
     * the Date Utilities when you only need one.
     * 
     * @return the instance, which is usually itself.
     */
    public static DateUtilities getInstance() {
        if (instance == null) {
            instance = new DateUtilities();
        }

        return instance;
    }
    /**
     * Returns the current time now.
     * 
     * @return a <code>LocalDateTime</code> object with the time now. Mainly useless.
     */
    
    public LocalDateTime now(){
        return LocalDateTime.now();
    }
    /**
     * Returns a string of a <code>LocalDateTime</code> and is formatted automatically.
     * 
     * @param ldt the <code>LocalDateTime</code> object that is needed to convert
     * into a string.
     * @return A string that is formatted based on the default format.
     * @throws IllegalArgumentException if the <code>LocalDateTime</code> is
     * a null amount.
     */
    public String toString(LocalDateTime ldt) throws IllegalArgumentException{
        if(ldt == null){
           throw new IllegalArgumentException("LocalDateTime cannot be null!"); 
        }
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm:ss a");
        return ldt.format(format);
    }
    /**
     * Returns a string of a LocalDateTime that is formatted with a String that 
     * the user inputs themselves.
     * 
     * @param ldt the LocalDateTime object that is needed to convert to a String.
     * @param dtf the String that the LocalDateTime ldt uses.
     * @return A String of LocalDateTime ldt following the format from String dtf.
     * @throws IllegalArgumentException if LocalDateTime ldt or String dtf are null or no length.
     * @throws ParseException if String dtf does not have proper characters used in it. 
     */
    public String toString(LocalDateTime ldt, String dtf) throws ParseException, IllegalArgumentException{
        if(ldt == null){
           throw new IllegalArgumentException("LocalDateTime cannot be null!"); 
        }
        if(dtf == null || dtf == "" || dtf.trim().length() == 0){
           throw new IllegalArgumentException("DateTimeFormatter cannot be null!"); 
        }
        DateTimeFormatter format = DateTimeFormatter.ofPattern(dtf);
        return ldt.format(format);
    }
    /**
     * Gets the date that it can with the String provided by the user. Because this
     * has no extra parameters, it must follow a specific format. The format is:
     * MM dd yyyy HH:mm:ss
     * 
     * @param time The String used to determine what the time is.
     * @return A LocalDateTime that was created from the string. 
     * @throws IllegalArgumentException If String time is null or empty, and if it
     * doesn't follow the proper format.
     */
    public LocalDateTime getDateFromString(String time) throws IllegalArgumentException{
        if(time == null || time =="" || time.trim().length() == 0){
          throw new IllegalArgumentException("time cannot be null!");   
        }
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MM dd yyyy HH:mm:ss");
        if(!time.matches("\\d\\d \\d\\d \\d\\d\\d\\d \\d\\d:\\d\\d:\\d\\d")){
           throw new IllegalArgumentException("The String you've entered is not compatible with this method!"
                   + " Format is: MM dd yyyy HH:mm:ss");    
        }
        return LocalDateTime.parse(time, df);
    }
    /**
     * Gets the date that it can with the String and Format to follow provided
     * by the user.
     * 
     * @param time The String that has the current time in it.
     * @param dtf The String that is used for formatting the time. Must exactly match
     * the format that String time is in!
     * @return
     * @throws ParseException If String dtf cannot be parsed.
     * @throws IllegalArgumentException If either Strings are null/empty or unrecognized.
     */
    public LocalDateTime getDateFromString(String time, String dtf) throws ParseException, IllegalArgumentException{
        if(time == null || time == "" || time.trim().length() == 0){
          throw new IllegalArgumentException("The time string cannot be null!");   
        }
        if(time == null || time == "" || time.trim().length() == 0){
           throw new IllegalArgumentException("The format string cannot be null!");    
        }
        DateTimeFormatter format = DateTimeFormatter.ofPattern(dtf);
        return LocalDateTime.parse(time, format);
    }    
    /**
     * A method that gets the duration of two different LocalDateTimes.
     * 
     * @param start A LocalDateTime that is used as the starting point.
     * @param finish A LocalDateTime that is used as the ending point.
     * @return A Duration object so you can further extract variables like hours and days from it.
     * @throws IllegalArgumentException if either LocalDateTime parameters are null.
     */
    public Duration getDifferenceInTwoTimes(LocalDateTime start, LocalDateTime finish) throws IllegalArgumentException{
        if(start == null){
          throw new IllegalArgumentException("The start time cannot be null!");     
        }
        if(finish == null){
          throw new IllegalArgumentException("The finish time cannot be null!");     
        }
        return Duration.between(start, finish);
    }
//    public static void main(String[] args) throws ParseException, IllegalArgumentException{
//        DateUtilities du = DateUtilities.getInstance();
//        System.out.println(du.toString(LocalDateTime.now()));
//        System.out.println(du.toString(LocalDateTime.now(), "MMM dd yyyy"));
//        System.out.println(du.getDateFromString("10 03 1999 10:10:10"));
//        System.out.println(du.getDateFromString("10 03 1999 10:10:10", "MM dd yyyy HH:mm:ss"));
//        System.out.println(du.getDifferenceInTwoTimes(LocalDateTime.now().plusWeeks(1), LocalDateTime.now()).toHours());
//    }

    
}
