package educationCenter;

public class Lesson {
    private String name;
    private int duration;
    private double price;
    private String LecturerName;

    public Lesson(String name, int duration, double price, String lecturerName) {
        this.name = name;
        this.duration = duration;
        this.price = price;
        LecturerName = lecturerName;
    }
    public Lesson(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLecturerName() {
        return LecturerName;
    }

    public void setLecturerName(String lecturerName) {
        LecturerName = lecturerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lesson lesson = (Lesson) o;

        if (duration != lesson.duration) return false;
        if (Double.compare(lesson.price, price) != 0) return false;
        if (name != null ? !name.equals(lesson.name) : lesson.name != null) return false;
        return LecturerName != null ? LecturerName.equals(lesson.LecturerName) : lesson.LecturerName == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + duration;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (LecturerName != null ? LecturerName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                ", price=" + price +
                ", LecturerName='" + LecturerName + '\'' +
                '}';
    }
}

