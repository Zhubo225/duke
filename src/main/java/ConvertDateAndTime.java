import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertDateAndTime {

    private static String str;

    public ConvertDateAndTime (String str){
        ConvertDateAndTime.str = str;
    }

    public static void main(String[] argv) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy Hm");
        try {
            Date date = formatter.parse(str);
            System.out.println(date);
            System.out.println(formatter.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}