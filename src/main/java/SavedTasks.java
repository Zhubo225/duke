import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SavedTasks {


    public SavedTasks(String[] saved_tasks) throws IOException {
        FileWriter fileWriter = new FileWriter("C:/Users/User/Desktop/Duke Master/Data/Duke.txt", true); //Set true for append mode
        PrintWriter printWriter = new PrintWriter(fileWriter);
        for (int i = 1; i <= saved_tasks.length; i ++) {
            String textToAppend = saved_tasks[i];
            printWriter.println(textToAppend);  //New line
        }
    }
}