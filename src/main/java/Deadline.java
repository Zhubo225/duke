import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deadline extends Task {

    protected String by;
    SimpleDateFormat formatter;
    Date date;

    public Deadline(String description, String by) throws ParseException {
        super(description);
        this.by = by;
        formatter = new SimpleDateFormat("dd/MM/yyyy HHmm");
        date = formatter.parse(by);
    }

    @Override
    public String toString() {
        return "[D][" + getStatusIcon() + "] " + description + "(by: " + date + ")";
    }
}
