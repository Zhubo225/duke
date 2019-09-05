import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event extends Task {

    protected String at;
    SimpleDateFormat formatter;
    Date date;

    public Event(String description, String type, String at) throws ParseException {
        super(description, type);
        this.at = at;
        formatter = new SimpleDateFormat("dd/MM/yyyy HHmm");
        date = formatter.parse(at);
    }

    @Override
    public String toString() {
        return "[E][" + getStatusIcon() + "] " + description + "(at: " + date + ")";
    }

    public String savedDescription() {
        return description;
    }

    public String savedDate() {
        return at;
    }
}