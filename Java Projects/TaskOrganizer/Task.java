 /*
  * Hadeem Secka	
  */

	public class Task {
    private int priority;
    private String action;

    public Task(int priority, String action) {
        this.priority = priority >= 0 && priority <= 4 ? priority : 4;
        this.action = action != null ? action : "none";
    }

    public int getPriority() {
        return priority;
    }

    public String getAction() {
        return action;
    }

    @Override
    public String toString() {
        return "[Task] Priority: " + priority + " Task: " + action;
    }

    public String toFileString() {
        return priority + "," + action;
    }

    public static Task fromFileString(String fileString) {
        String[] parts = fileString.split(",");
        int priority = Integer.parseInt(parts[0].trim());
        String action = parts[1].trim();
        return new Task(priority, action);
    }
}
