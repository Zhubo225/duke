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

        Scanner scan = new Scanner(System.in);

        String message = scan.nextLine();
        int number = scan.nextInt();

        System.out.println(message + number);
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
        level_3();
        //level_4();
    }
}


