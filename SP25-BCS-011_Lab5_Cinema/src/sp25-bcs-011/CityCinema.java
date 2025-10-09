package sp25_bcs_011;

public class CityCinema {
    private String cityName;
    private Cinema[] cinemas;
    private int cinemaCount;

    public CityCinema(String cityName, int defaultCinemas) {
        this.cityName = cityName;
        cinemas = new Cinema[defaultCinemas];
        cinemaCount = 0;
    }

    public void addCinema(Cinema cinema) {
        if (cinemaCount == cinemas.length) {
            Cinema[] newArray = new Cinema[cinemas.length + 5];
            for (int i = 0; i < cinemas.length; i++) {
                newArray[i] = cinemas[i];
            }
            cinemas = newArray;
        }
        cinemas[cinemaCount++] = cinema;
    }

    public Cinema getCinemaByIndex(int index) {
        if (index >= 0 && index < cinemaCount) return cinemas[index];
        return null;
    }

    public Cinema getCinemaByName(String name) {
        for (int i = 0; i < cinemaCount; i++) {
            if (cinemas[i].getName().equals(name)) return cinemas[i];
        }
        return null;
    }

    public boolean bookSeat(int cinemaIndex, int screenIndex, String seatId) {
        Cinema cinema = getCinemaByIndex(cinemaIndex);
        return cinema != null && cinema.bookSeat(screenIndex, seatId);
    }

    public boolean cancelSeat(int cinemaIndex, int screenIndex, String seatId) {
        Cinema cinema = getCinemaByIndex(cinemaIndex);
        return cinema != null && cinema.cancelSeat(screenIndex, seatId);
    }

    public void printCityLayouts() {
        System.out.println("City: " + cityName);
        for (int i = 0; i < cinemaCount; i++) {
            cinemas[i].printLayouts();
        }
    }

    public String findFirstAvailableVIP() {
        for (int i = 0; i < cinemaCount; i++) {
            Seat vip = cinemas[i].findFirstAvailableVIP();
            if (vip != null) {
                return cinemas[i].getName() + " > " + vip.toString();
            }
        }
        return "No VIP seat available in " + cityName;
    }

    public String getCityName() {
        return cityName;
    }
}
