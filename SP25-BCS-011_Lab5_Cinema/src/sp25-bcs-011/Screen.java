package sp25_bcs_011;

public class Screen {
    private String name;
    private Seat[][] seats;

    public Screen(String name) {
        this.name = name;
        seats = new Seat[5][];
        for (int i = 0; i < 5; i++) {
            seats[i] = new Seat[10 + i];
            for (int j = 0; j < seats[i].length; j++) {
                String id = (i + 1) + "-" + String.format("%03d", j + 1);
                Seat.SeatType type;
                if (i == 0 || i == 1) type = Seat.SeatType.REGULAR;
                else if (i == 2) type = Seat.SeatType.PREMIUM;
                else if (i == 3) type = Seat.SeatType.VIP;
                else type = Seat.SeatType.RECLINER;
                seats[i][j] = new Seat(id, type);
            }
        }
    }

    public String getName() {
        return name;
    }

    public Seat findSeatById(String id) {
        for (Seat[] row : seats) {
            for (Seat seat : row) {
                if (seat.getId().equals(id)) return seat;
            }
        }
        return null;
    }

    public boolean bookSeat(String id) {
        Seat seat = findSeatById(id);
        return seat != null && seat.book();
    }

    public boolean cancelSeat(String id) {
        Seat seat = findSeatById(id);
        return seat != null && seat.cancel();
    }

    public int countTotalSeats() {
        int total = 0;
        for (Seat[] row : seats) total += row.length;
        return total;
    }

    public int countAvailableSeats() {
        int count = 0;
        for (Seat[] row : seats) {
            for (Seat seat : row) {
                if (seat.isAvailable()) count++;
            }
        }
        return count;
    }

    public void printCompactLayout() {
        System.out.println("Layout for " + name + ":");
        for (Seat[] row : seats) {
            for (Seat seat : row) {
                System.out.print(seat.isAvailable() ? "[O]" : "[X]");
            }
            System.out.println();
        }
    }

    public void printDetailedListing() {
        System.out.println("Detailed listing for " + name + ":");
        for (Seat[] row : seats) {
            for (Seat seat : row) {
                System.out.println(seat);
            }
        }
    }

    public Seat[] getAvailableSeatsByType(Seat.SeatType type) {
        int count = 0;
        for (Seat[] row : seats) {
            for (Seat seat : row) {
                if (seat.getType() == type && seat.isAvailable()) count++;
            }
        }

        Seat[] result = new Seat[count];
        int index = 0;
        for (Seat[] row : seats) {
            for (Seat seat : row) {
                if (seat.getType() == type && seat.isAvailable()) {
                    result[index++] = seat;
                }
            }
        }
        return result;
    }
}
