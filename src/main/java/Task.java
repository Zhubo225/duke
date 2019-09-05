public class Task {
    protected String description, type;
    protected boolean isDone;

    public Task(String description, String type) {
        this.description = description;
        this.isDone = false;
        this.type = type;
    }

    public boolean markAsDone() {
        return isDone = true;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public int savedStatusIcon() {
        return (isDone ? 1 : 0);
    }
}