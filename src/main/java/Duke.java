import java.util.Objects;
import java.util.Scanner;

public class Duke {

    public static void level_1() {
        System.out.println("Hello! I'm Duke \n" + "What can I do for you?");

        for (;;) {
            Scanner scan = new Scanner(System.in);

            String message = scan.nextLine();

            if (Objects.equals(message, "bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }

            System.out.println(message);
        }
    }

    public static void level_2() {
        int i = 0;
        String[] stored_list = new String[100];

        for (;;) {
            Scanner scan = new Scanner(System.in);

            String message = scan.nextLine();

            if (Objects.equals(message, "bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }

            i++;

            if (Objects.equals(message, "list")) {
                for (int j = 1; j < i; j++) {
                    System.out.println(j + ". " + stored_list[j]);
                }

                i--;
            } else {
                stored_list[i] = message;

                System.out.println("added: " + message);
            }
        }
    }

    public static void level_3() {
        int i = 0;
        String[] stored_list = new String[100];
        String[] stored_message = new String[100];

        for (;;) {
            Scanner scan = new Scanner(System.in);

            String message = scan.nextLine();

            int number = 0;
            String str1 = null;
            String check = null;

            if (message.contains(" ")) {
                String[] str2 = message.split(" ", 2);
                check = str2[0];
                str1 = str2[1];
            }

            if (Objects.equals(message, "bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }

            i++;

            if (Objects.equals(message, "list")) {
                for (int j = 1; j < i; j++) {
                    System.out.println(stored_list[j]);
                }

                i--;
            } else if (Objects.equals(check, "done")) {
                number = Integer.parseInt(str1);

                stored_list[number] = number + "." + "[\u2713]" + " " + stored_message[number];

                i--;

                System.out.println("Nice! I've marked this task as done:\n" + "[\u2713]" + " " + stored_message[number]);
            } else {
                stored_message[i] = message;
                stored_list[i] = i + "." + "[\u2718]" + " " + message;

                System.out.println("added: " + message);
            }
        }
    }

    public static void level_4() {
        int i = 0;
        String[] stored_list = new String[100];
        String[] stored_message = new String[100];
        String[] tasks = new String[100];

        for (;;) {
            Scanner scan = new Scanner(System.in);

            String message = scan.nextLine();

            int number = 0;
            String str1 = null;
            String check = null;

            if (message.contains(" ")) {
                String[] str2 = message.split(" ", 2);
                check = str2[0];
                str1 = str2[1];
            }

            if (Objects.equals(message, "bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }

            i++;

            if (Objects.equals(message, "list")) {
                for (int j = 1; j < i; j++) {
                    System.out.println(j + "." + (stored_list[j]));
                }

                i--;
            } else if (Objects.equals(check, "done") && Integer.parseInt(str1) < i && Integer.parseInt(str1) != 0) {
                number = Integer.parseInt(str1);

               // stored_list[number] = tasks[i] + "[\u2713]" + " " + stored_message[number];
                stored_list[number] = stored_list[number].replace("[\u2718]", "[\u2713]");

                System.out.println("Nice! I've marked this task as done:\n" +  stored_list[number]);

                i--;
            } else {

                if (Objects.equals(check, "deadline")) {
                    String[] str3 = str1.split("/", 2);
                    String str4 = str3[1].replace("by", "by:");
                    stored_message[i] = str3[0] + "(" + str4 + ")";
                    tasks[i] = "[D]";
                    stored_list[i] = tasks[i] + "[\u2718]" + " " + stored_message[i];
                    System.out.println("Got it. I've added this task:\n" + " " + stored_list[i] + "\n" + "Now you have " + i + " tasks in the list.");
                } else if (Objects.equals(check, "event")) {
                    String[] str3 = str1.split("/", 2);
                    String str4 = str3[1].replace("at", "at:");
                    stored_message[i] = str3[0] + "(" + str4 + ")";
                    tasks[i] = "[E]";
                    stored_list[i] = tasks[i] + "[\u2718]" + " " + stored_message[i];
                    System.out.println("Got it. I've added this task:\n" + " " + stored_list[i] + "\n" + "Now you have " + i + " tasks in the list.");
                } else if (Objects.equals(check, "todo")) {
                    stored_message[i] = str1;
                    tasks[i] = "[T]";
                    stored_list[i] = tasks[i] + "[\u2718]" + " " + stored_message[i];
                    System.out.println("Got it. I've added this task:\n" + " " + stored_list[i] + "\n" + "Now you have " + i + " tasks in the list.");
                } else {
                    i--;
                }
            }
        }
    }

    public static void level_5() {
        int i = 0;
        String[] stored_list = new String[100];
        String[] stored_message = new String[100];
        String[] tasks = new String[100];

        for (;;) {
            Scanner scan = new Scanner(System.in);

            String message = scan.nextLine();

            int number = 0;
            int flag = 1;
            String str1 = null;
            String check = null;


            if (message.contains(" ")) {
                String[] str2 = message.split(" ", 2);
                check = str2[0];
                str1 = str2[1];
            } else {
                flag = 0;
            }

            if (Objects.equals(message, "bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }

            i++;

            if (Objects.equals(message, "list")) {
                for (int j = 1; j < i; j++) {
                    System.out.println(j + "." + (stored_list[j]));
                }

                i--;
            } else if (Objects.equals(check, "done") && Integer.parseInt(str1) < i && Integer.parseInt(str1) != 0) {
                number = Integer.parseInt(str1);

                // stored_list[number] = tasks[i] + "[\u2713]" + " " + stored_message[number];
                stored_list[number] = stored_list[number].replace("[\u2718]", "[\u2713]");

                System.out.println("Nice! I've marked this task as done:\n" +  stored_list[number]);

                i--;
            } else if (flag == 1) {

                if (Objects.equals(check, "deadline")) {
                    String[] str3 = str1.split("/", 2);
                    String str4 = str3[1].replace("by", "by:");
                    stored_message[i] = str3[0] + "(" + str4 + ")";
                    tasks[i] = "[D]";
                    stored_list[i] = tasks[i] + "[\u2718]" + " " + stored_message[i];
                    System.out.println("Got it. I've added this task:\n" + " " + stored_list[i] + "\n" + "Now you have " + i + " tasks in the list.");
                } else if (Objects.equals(check, "event")) {
                    String[] str3 = str1.split("/", 2);
                    String str4 = str3[1].replace("at", "at:");
                    stored_message[i] = str3[0] + "(" + str4 + ")";
                    tasks[i] = "[E]";
                    stored_list[i] = tasks[i] + "[\u2718]" + " " + stored_message[i];
                    System.out.println("Got it. I've added this task:\n" + " " + stored_list[i] + "\n" + "Now you have " + i + " tasks in the list.");
                } else if (Objects.equals(check, "todo")) {
                    stored_message[i] = str1;
                    tasks[i] = "[T]";
                    stored_list[i] = tasks[i] + "[\u2718]" + " " + stored_message[i];
                    System.out.println("Got it. I've added this task:\n" + " " + stored_list[i] + "\n" + "Now you have " + i + " tasks in the list.");
                } else {
                    i--;
                }
            } else {
                if (Objects.equals(message, "todo")) {
                    System.out.println("☹ OOPS!!! The description of a " + message + " cannot be empty.");
                } else if (Objects.equals(message, "deadline")) {
                    System.out.println("☹ OOPS!!! The description of a " + message + " cannot be empty.");
                } else if (Objects.equals(message, "event")) {
                    System.out.println("☹ OOPS!!! The description of a " + message + " cannot be empty.");
                } else {
                    System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            }
        }
    }





    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        //level_1();
        //level_2();
        //level_3();
        //level_4();
        level_5();
    }
}


