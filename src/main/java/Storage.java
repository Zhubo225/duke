import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

public class Storage {
    private ArrayList<Task> tasks;

    public Storage (String filename, ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void loadFile (String file_name, ArrayList<Task> tasks) {
        try {
            String line = null;
            FileReader fr = new FileReader(file_name);
            BufferedReader br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {
                String[] str = line.split("|", 5);
                switch (str[0]) {
                    case "D":
                        Deadline str2 = new Deadline(str[1], "D", str[2]);
                        if (str[2].equals("1")) str2.markAsDone();
                        tasks.add(str2);
                        break;
                    case "E":
                        Event str3 = new Event(str[1], "E", str[2]);
                        if (str[2].equals("1")) str3.markAsDone();
                        tasks.add(str3);
                        break;
                    case "T":
                        ToDo str4 = new ToDo(str[1], "T");
                        if (str[2].equals("1")) str4.markAsDone();
                        tasks.add(str4);
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found !!!");
        } catch (IOException | ParseException e) {
            System.out.println("Error reading file !!!");
        }
    }

    public static void writeFile (String file_name, ArrayList<Task> tasks) throws IOException {
        FileWriter fw = new FileWriter(file_name);
        BufferedWriter bw = new BufferedWriter(fw);

        for (Task list : tasks) {
            switch (list.type) {
                case "D":
                    bw.write(list.type + " " + "|" + " " + list.savedStatusIcon() + ((Deadline) list).savedDescription() + " " + "|" + " "  + ((Deadline) list).savedDate() + "\n");
                    break;
                case "E":
                    bw.write(list.type + " " + "|" + " "  + list.savedStatusIcon() + ((Event) list).savedDescription() + " " + "|" + " "  + ((Event) list).savedDate() + "\n");
                    break;
                case "T":
                    bw.write(list.type + " " + "|" + " "  + list.savedStatusIcon() + ((ToDo) list).savedDescription() + "\n");
                    break;
            }
        }
    }

    public ArrayList<Task> updateTasks () {
        return tasks;
    }
}
