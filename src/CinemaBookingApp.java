// Define a class Movie
class Movie {
    private String title;
    private int availableSeats;

    // Constructor to initialize the Movie object with title and available seats
    public Movie(String title, int availableSeats) {
        this.title = title;
        this.availableSeats = availableSeats;
    }

    // the method for  the number of available seats
    public int availableSeat() {
        return availableSeats;
    }

    // the method to book a seat
    public void bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
            System.out.println("Booking successful of " + Thread.currentThread().getName());
        } else {
            System.out.println("Booking failed of " + Thread.currentThread().getName());
        }
    }
}

// Define a class Bookingthread extends from thread
class BookingThread extends Thread {
    private Movie movie;

    // Constructor to initialize the thread
    public BookingThread(Movie movie) {
        this.movie = movie;
    }

    // Override the run method
    @Override
    public void run() {
        movie.bookSeat();
    }
}

// create Main class Cinema Booking App
public class CinemaBookingApp {
    public static void main(String[] args) {
        // Create a Movie object with  available seats
        Movie movie = new Movie("Aveter", 4);

        // Create BookingThread objects
        BookingThread[] threads = new BookingThread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new BookingThread(movie);
            threads[i].start();
        }

        // threads to complete
        for (BookingThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Display the numbers of available seats and complete booking
        System.out.println("All booking are completed.");
        System.out.println("Available seats: " + movie.availableSeat());

    }
}
