import java.time.LocalDate;
import java.time.LocalTime;

public class Utils {
    // Utility methods for validation, parsing, etc.

    public static boolean isValidId(String id) {
        return id != null && !id.trim().isEmpty();
    }

    public static LocalDate parseDate(String dateStr) {
        return LocalDate.parse(dateStr);
    }

    public static LocalTime parseTime(String timeStr) {
        return LocalTime.parse(timeStr);
    }
}
