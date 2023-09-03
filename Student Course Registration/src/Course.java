public class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private int availableSlots;
    private String schedule;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.availableSlots = capacity;
        this.schedule = schedule;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getAvailableSlots() {
        return availableSlots;
    }

    public String getSchedule() {
        return schedule;
    }

    public boolean registerStudent() {
        if (availableSlots > 0) {
            availableSlots--;
            return true;
        }
        return false;
    }

    public void dropStudent() {
        availableSlots++;
    }
}
