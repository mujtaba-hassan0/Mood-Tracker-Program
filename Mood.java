public class Mood{
    private String name;
    private String date;
    private String time;
    private String notes;

    public Mood(String name, String date, String time, String notes) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getNotes() {
        return notes;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setNotes(String notes) {
        this.notes = this.notes+" "+notes;
    }

    public String toString() {
        return"name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", notes='" + notes + '\'';
    }

}