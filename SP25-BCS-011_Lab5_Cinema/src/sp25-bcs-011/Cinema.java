package sp25_bcs_011;

public class Cinema {
    private String name;
    private Screen[] screens;
    private int screenCount;

    public Cinema(String name, int defaultScreens) {
        this.name = name;
        screens = new Screen[defaultScreens];
        screenCount = 0;
        for (int i = 0; i < defaultScreens; i++) {
            addScreen("Screen-" + (i + 1), new int[]{10 + i});
        }
    }

    public void addScreen(String screenName, int[] rowLengths) {
        if (screenCount == screens.length) {
            Screen[] newScreens = new Screen[screens.length + 5];
            for (int i = 0; i < screens.length; i++) {
                newScreens[i] = screens[i];
            }
            screens = newScreens;
        }
        screens[screenCount++] = new Screen(screenName);
    }

    public Screen getScreenByIndex(int index) {
        if (index >= 0 && index < screenCount) return screens[index];
        return null;
    }

    public Screen getScreenByName(String name) {
        for (int i = 0; i < screenCount; i++) {
            if (screens[i].getName().equals(name)) return screens[i];
        }
        return null;
    }

    public boolean bookSeat(int screenIndex, String seatId) {
        Screen screen = getScreenByIndex(screenIndex);
        return screen != null && screen.bookSeat(seatId);
    }

    public boolean cancelSeat(int screenIndex, String seatId) {
        Screen screen = getScreenByIndex(screenIndex);
        return screen != null && screen.cancelSeat(seatId);
    }

    public void printLayouts() {
        System.out.println("Cinema: " + name);
        for (int i = 0; i < screenCount; i++) {
            screens[i].printCompactLayout();
        }
    }

    public void printDetails() {
        System.out.println("Cinema: " + name);
        for (int i = 0; i < screenCount; i++) {
            screens[i].printDetailedListing();
        }
    }

    public String toString() {
        int total = 0, available = 0;
        for (int i = 0; i < screenCount; i++) {
            total += screens[i].countTotalSeats();
            available += screens[i].countAvailableSeats();
        }
        return name + " | Screens: " + screenCount + " | Total Seats: " + total + " | Available: " + available;
    }

    public Seat findFirstAvailableVIP() {
        for (int i = 0; i < screenCount; i++) {
            Seat[] vipSeats = screens[i].getAvailableSeatsByType(Seat.SeatType.VIP);
            if (vipSeats.length > 0) return vipSeats[0];
        }
        return null;
    }

    public String getName() {
        return name;
    }
}
