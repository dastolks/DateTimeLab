package student.lab;

import java.text.DateFormat;
import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
    
    /**
     * Default constructor, does not pass any parameters nor does it perform anything.
     * 
     */
    public DateUtilities(){
    
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
     * Gets a LocalDate object from a String. Must be in MM dd yyyy format.
     * 
     * @param time The String needed to format to.
     * @return A LocalDate object with the date from the string.
     * @throws IllegalArgumentException if String time is null or zero length or it does not match the default behavior.
     * @throws ParseException if String time is out of bounds (ie 13th month, 32nd day etc)
     */
    public LocalDate getDateFromString(String time) throws IllegalArgumentException, ParseException{
        if(time == null || time =="" || time.trim().length() == 0){
          throw new IllegalArgumentException("time cannot be null!");   
        }
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MM dd yyyy");
        if(!time.matches("\\d\\d \\d\\d \\d\\d\\d\\d")){
           throw new IllegalArgumentException("The String you've entered is not compatible with this method!"
                   + " Format is: MM dd yyyy");    
        }
        return LocalDate.parse(time, df);
    }
    /**
     * Gets a LocalDate from the created String using a specific format. Use this if your date
     * does not have a time attached to it. Remember you must at least have hours and minutes!
     * 
     * @param time A String which is used for the time.
     * @param dtf A String which is used for formatting the time.
     * @return A LocalDate object of the String implemented, but will not print in the format of the String entered.
     * @throws ParseException If the String cannot be converted into a LocalDate.
     * @throws IllegalArgumentException if either strings are empty or null.
     */
    public LocalDate getDateFromString(String time, String dtf) throws ParseException, IllegalArgumentException{
        if(time == null || time == "" || time.trim().length() == 0){
          throw new IllegalArgumentException("The time string cannot be null!");   
        }
        if(time == null || time == "" || time.trim().length() == 0){
           throw new IllegalArgumentException("The format string cannot be null!");    
        }
        DateTimeFormatter format = DateTimeFormatter.ofPattern(dtf);
        return LocalDate.parse(time, format);
    }  
    /**
     * A LocalTime is created from a String entered by the user. Use the format: HH mm ss 
     * 
     * @param time The String used to get the time from.
     * @return A LocalTime object made with said String.
     * @throws IllegalArgumentException if the String is null or empty.
     * @throws ParseException if the time in the String is out of bounds (ie 61 minutes, or 25 hours).
     */
    public LocalTime getTimeFromString(String time) throws IllegalArgumentException, ParseException{
        if(time == null || time =="" || time.trim().length() == 0){
          throw new IllegalArgumentException("time cannot be null!");   
        }
        DateTimeFormatter df = DateTimeFormatter.ofPattern("HH mm ss");
        if(!time.matches("\\d\\d \\d\\d \\d\\d")){
           throw new IllegalArgumentException("The String you've entered is not compatible with this method!"
                   + " Format is: HH mm ss");    
        }
        return LocalTime.parse(time, df);
    }    
    /**
     * A LocalTime that is created from a string entered by the user and the format also entered
     * by the user.
     * 
     * @param time the time String entered by the user.
     * @param dtf the format String entered by the user.
     * @return A LocalTime object that was made using the time String.
     * @throws ParseException When the string cannot be properly parsed (ie 32nd day, 13th month etc).
     * @throws IllegalArgumentException When either string is null or empty.
     */
    public LocalTime getTimeFromString(String time, String dtf) throws ParseException, IllegalArgumentException{
        if(time == null || time == "" || time.trim().length() == 0){
          throw new IllegalArgumentException("The time string cannot be null!");   
        }
        if(time == null || time == "" || time.trim().length() == 0){
           throw new IllegalArgumentException("The format string cannot be null!");    
        }
        DateTimeFormatter format = DateTimeFormatter.ofPattern(dtf);
        return LocalTime.parse(time, format);
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
    public LocalDateTime getDateTimeFromString(String time) throws IllegalArgumentException{
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
    public LocalDateTime getDateTimeFromString(String time, String dtf) throws ParseException, IllegalArgumentException{
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
//        DateUtilities du = new DateUtilities();
//        System.out.println(du.toString(LocalDateTime.now()));
//        System.out.println(du.toString(LocalDateTime.now(), "MMM dd yyyy"));
//        System.out.println(du.getDateTimeFromString("10 03 1999 10:10:10"));
//        System.out.println(du.getDateTimeFromString("07 01 2000 10:10:10", "MM dd yyyy HH:mm:ss"));
//        System.out.println(du.getDateFromString("07 01 2000"));
//        System.out.println(du.getDateFromString("Jul 01 2000", "MMM dd yyyy"));
//        System.out.println(du.getTimeFromString("23 40 20"));
//        System.out.println(du.getTimeFromString("23 40", "HH mm"));  
//        System.out.println(LocalDateTime.of(du.getDateFromString("07 01 2000"), du.getTimeFromString("23 40", "HH mm")));
//        System.out.println(du.getDifferenceInTwoTimes(LocalDateTime.now().plusWeeks(1), LocalDateTime.now()).toHours());
//    }

    
}
