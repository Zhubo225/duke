public class DukeException extends Exception {

    String str;

    public DukeException(String str)
    {
        try {
            switch (str) {
                case "empty":
                    throw new DukeException("☹ OOPS!!! Instructions cannot be empty.");
                case "empty todo":
                    throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
                case "empty event":
                    throw new DukeException("☹ OOPS!!! The description of a event cannot be empty.");
                case "empty deadline":
                    throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
                case "unknown":
                    throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
        } catch (DukeException ex) {
            System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }

}