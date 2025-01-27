package Attribute;

public class TheaterPlay {
    private String name;
    private double duration;

    private static final double MAX_DURATION = 180;
    private static final double MIN_DURATION = 45;

    public TheaterPlay(String name, double duration) {
        this.name = name;
        setDuration(duration);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        if (duration > MAX_DURATION) {
            throw new Error("The maximum duration of the performance must be less than " + MAX_DURATION + " minutes");
        }

        if (duration < MIN_DURATION) {
            throw new Error("The minimum duration of the performance must be more than " + MIN_DURATION + " minutes");
        }

        this.duration = duration;
    }

    @Override
    public String toString() {
        return "TheaterPlay{" +
                "name='" + name + '\'' +
                ", duration=" + duration + " minutes" +
                '}';
    }
}
