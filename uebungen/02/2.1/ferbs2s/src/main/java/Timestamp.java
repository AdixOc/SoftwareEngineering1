public class Timestamp {
    private int hour;
    private int minute;

    public Timestamp(int hour, int minute) {
        this.hour = hour%23;
        this.minute = minute%59;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void substract(Timestamp ts){
        // Hour would be negative then set it to zero
        if (this.getHour() - ts.getHour() < 0){
            this.setHour(0);
            this.setMinute(0);
        }else {
            this.setHour(this.hour - ts.getHour());
        }

        if (this.minute - ts.getMinute() < 0){
            int tmp = this.getMinute() - ts.getMinute();
            tmp = Math.abs(tmp); // Make tmp positive
            this.setHour(this.hour - ((tmp/59)+1));
            this.setMinute(60 - (tmp%59));
        }else {
            this.setMinute(this.getMinute() - ts.getMinute());
        }
    }

    public void add(Timestamp ts){
        if (this.getMinute() + ts.getMinute() > 59){
            this.setMinute((this.getMinute() + ts.getMinute())%60);
            this.setHour(this.getHour() + (this.getMinute() + ts.getMinute())/60);
        }

        this.setHour(Math.min(ts.getHour() + this.hour, 23));
    }

    @Override
    public String toString() {
        return this.hour + ":" + String.format("%02d",this.minute) + " Uhr";
    }
}
