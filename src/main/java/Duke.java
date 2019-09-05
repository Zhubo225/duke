import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
//import MyPackage.Task;

public class Duke {

    public static void Duke_Master() throws DukeException, IOException {

        int i = 0;
        ArrayList<String> stored_list = new ArrayList<String>();
        ArrayList<Task> tasks = new ArrayList<Task>();
        ArrayList<Task> saved_tasks = new ArrayList<Task>();

        String file_name = "C:\\Users\\User\\Desktop\\Duke Master\\src\\main\\java\\duke.txt";
        Storage file = new Storage(file_name, saved_tasks);
        file.loadFile(file_name, saved_tasks);

        for (int j = 0; j < (file.updateTasks()).size(); j++) {
            tasks.add((file.updateTasks()).get(j));
        }

        while (true) {
            while (true) {
                Scanner scan = new Scanner(System.in);
                String message = scan.nextLine();
                Task task = new Task(message, "");
                String str1 = null;
                String check = null;

                if (message.contains(" ")) {
                    String[] str2 = task.description.split(" ", 2);
                    check = str2[0];
                    str1 = str2[1];
                }

                if (Objects.equals(task.description, "bye")) {
                    Storage.writeFile(file_name, tasks);
                    System.out.println("Bye. Hope to see you again soon!");
                    return;
                } else if (task.description.equals("todo")) {
                    System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
                } else if (task.description.equals("event")) {
                    System.out.println("Which event?");
                } else if (task.description.equals("deadline")) {
                    System.out.println("Deadline of what?");
                } else if (Objects.equals(task.description, "list")) {
                    if (i == 0) {
                        System.out.println("☹ OOPS!!! Empty list!");
                    } else {
                        for (int j = 0; j < stored_list.size(); ++j) {
                            System.out.println(j + 1 + "." + stored_list.get(j));
                        }
                    }
                } else if (Objects.equals(check, "done")) {
                    try {
                        int number = Integer.parseInt(str1) - 1;
                        tasks.get(number).markAsDone();
                        stored_list.set(number, tasks.get(number).toString());
                        System.out.println("Nice! I've marked this task as done:\n " + tasks.get(number));
                    } catch (IndexOutOfBoundsException ex) {
                        System.out.println("The task number do not exist!");
                    } catch (NumberFormatException ex) {
                        System.out.println("Oh no, invalid task number!");
                    }
                } else if (Objects.equals(check, "delete")) {
                    try {
                        i--;
                        int number = Integer.parseInt(str1) - 1;
                        String deleted_task = stored_list.get(number);
                        stored_list.remove(number);
                        System.out.println("Noted. I've removed this task:\n " + deleted_task + "\nNow you have " + stored_list.size() + " tasks in the list.");
                    } catch (IndexOutOfBoundsException ex) {
                        System.out.println("The task number do not exist!");
                    } catch (NumberFormatException ex) {
                        System.out.println("Oh no, invalid task number!");
                    }
                } else if (Objects.equals(check, "find")) {
                    int j = 0;
                    System.out.println("Here are the matching tasks in your list:");

                    for (String temp : stored_list) {
                        if (temp.contains(str1)) {
                            j++;
                            System.out.println(j + "." + temp);
                        }
                    }

                    if (j == 0) {
                        System.out.println("Oops, no matching found!");
                    }
                } else {
                    if (Objects.equals(check, "deadline")) {
                        try {
                            String[] str3 = str1.split("/", 2);
                            String str4 = str3[1].replace("by ", "");
                            Task info = new Task(str3[0], "D");
                            tasks.add(new Deadline(info.description, "D", str4));
                            stored_list.add(tasks.get(i).toString());
                            System.out.println("Got it. I've added this task:\n" + " " + stored_list.get(i) + "\n" + "Now you have " + stored_list.size() + " tasks in the list.");
                        } catch (IndexOutOfBoundsException | ParseException ex) {
                            System.out.println("When's the deadline? :o\n(Format of deadline: dd/mm/yyyy TIME)");
                        }
                    } else if (Objects.equals(check, "event")) {
                        try {
                            String[] str3 = str1.split("/", 2);
                            String str4 = str3[1].replace("at ", "");
                            Task info = new Task(str3[0], "E");
                            System.out.println(str3[0]);
                            tasks.add(new Event(info.description, "E", str4));
                            stored_list.add(tasks.get(i).toString());
                            System.out.println("Got it. I've added this task:\n" + " " + stored_list.get(i) + "\n" + "Now you have " + stored_list.size() + " tasks in the list.");
                        } catch (IndexOutOfBoundsException | ParseException ex) {
                            System.out.println("When's the event? :o\n(Format of event: dd/mm/yyyy TIME)");
                        }
                    } else if (Objects.equals(check, "todo")) {
                        Task info = new Task(str1, "T");
                        tasks.add(new ToDo(info.description, "T"));
                        stored_list.add(tasks.get(i).toString());
                        System.out.println("Got it. I've added this task:\n" + " " + stored_list.get(i) + "\n" + "Now you have " + stored_list.size() + " tasks in the list.");
                    } else {
                        --i;
                        try {
                            throw new DukeException("unknown");
                        } catch (DukeException ex) { }
                    }

                    ++i;
                }
            }
        }
    }


    public static void main(String[] args) throws DukeException, IOException {

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        Duke_Master();

    }

}


