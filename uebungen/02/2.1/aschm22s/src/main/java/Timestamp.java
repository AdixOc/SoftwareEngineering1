public class Timestamp {
    int hours;
    int minutes;

    public Timestamp(int hours, int minutes) {
        this.hours = 0;
        this.minutes = 0;
        this.add(hours * 60 + minutes);
    }

    public void add(int minutes) {
        this.minutes += minutes;
        this.hours += this.minutes / 60;
        this.minutes = this.minutes % 60;
    }

    public void add(Timestamp t) {
        this.minutes += t.minutes;
        this.hours += this.minutes / 60;
        this.hours += t.hours;
        this.minutes = this.minutes % 60;
    }

    public void subtract(int minutes) {
        this.minutes -= minutes;
        if (this.minutes < 0) {
            this.hours--;
            this.minutes += 60;
        }
    }

    public void subtract(Timestamp t) {
        this.minutes -= t.minutes;
        this.hours -= t.hours;
        if (this.minutes < 0) {
            this.hours--;
            this.minutes += 60;
        }
    }

    public int getHours() {
        return this.hours;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public String toString() {
        return String.format("%02d:%02d", this.hours, this.minutes);
    }
}
