public class Train {
    private int trainNumber;
    private String trainName;
    private String source;
    private String destination;
    private int totalSeats;
    private double fare;

    public Train(int trainNumber, String trainName, String source, String destination, int totalSeats, double fare) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.fare = fare;
    }

    public int getTrainNumber() { return trainNumber; }
    public String getTrainName() { return trainName; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public int getTotalSeats() { return totalSeats; }
    public double getFare() { return fare; }

    public boolean bookSeat() {
        if (totalSeats > 0) {
            totalSeats--;
            return true;
        }
        return false;
    }

    public void cancelSeat() {
        totalSeats++;
    }
}
