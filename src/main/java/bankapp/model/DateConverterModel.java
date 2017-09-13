package bankapp.model;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by andreikramchaninov on 13.09.2017.
 */

@Service
public class DateConverterModel {

    public Timestamp convertDateToTimestamp(String year, String month, String day) {
        String dateTime = year + "-" + month + "-" + day + "T00:00:00";
        return Timestamp.valueOf(LocalDateTime.parse(dateTime));
    }

    public boolean checkIncomingDate(String year, String month, String day) {
        return (isNotEmpty(year) && isNotEmpty(month) && isNotEmpty(day)
            && consistsOfDigits(year) && consistsOfDigits(month)
            && consistsOfDigits(day) && checkYearRange(year)
            && checkMonthRange(month) && checkDayRange(day));

    }

    private boolean isNotEmpty(String dateParam) {
        return (dateParam.length() != 0);
    }

    private boolean consistsOfDigits(String dateParam) {
        boolean allDigits = false;
        for(char c : dateParam.toCharArray()) {
            if(Character.isDigit(c)) {
                allDigits = true;
            } else {
                allDigits = false;
                break;
            }
        }
        return allDigits;
    }

    private boolean checkYearRange(String yearString) {
        int year = Integer.parseInt(yearString);
        return (year > 1900 && year <= Calendar.getInstance().get(Calendar.YEAR));
    }

    private boolean checkMonthRange(String monthString) {
        int month = Integer.parseInt(monthString);
        return (month > 0 && month <= 12);
    }

    private boolean checkDayRange(String dayString) {
        int day = Integer.parseInt(dayString);
        return (day > 0 && day <= 31);
    }

}
