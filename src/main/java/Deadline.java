import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deadline extends Task {

    protected String by;
    SimpleDateFormat formatter;
    Date date;

    public Deadline(String description, String type, String by) throws ParseException {
        super(description, type);
        this.by = by;
        formatter = new SimpleDateFormat("dd/MM/yyyy HHmm");
        date = formatter.parse(by);
    }

    @Override
    public String toString() {
        return "[D][" + getStatusIcon() + "] " + description + "(by: " + date + ")";
    }

    public String savedDescription() {
        return description;
    }

    public String savedDate() {
        return by;
    }
}
