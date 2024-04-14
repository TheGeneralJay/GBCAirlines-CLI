///  Author: Ethan Sylvester | 101479568
///  COMP 2130 | CRN: 15655
///  LAST EDITED DATE: 10/13/2023
///  Passenger class for COMP 2130 Assignment 1

import java.time.LocalDate;
public class Passenger {
    int passportID;
    String firstName;
    String lastName;
    String age;
    String flightFare;
    boolean hasBooked;
    LocalDate bookDate = LocalDate.now().minusMonths(1);

    String upperDecoration = ".--------------------------------------------------.";
    String lowerDecoration = ".__________________________________________________.";


    // Constructor
    Passenger(int ID, String fName, String lName, String age, String fare, boolean booked) {
        passportID = ID;
        firstName = fName;
        lastName = lName;
        this.age = age;
        flightFare = fare;
        hasBooked = booked;
    }

    public void bookFlight() {
        hasBooked = true;
        bookDate = LocalDate.now();
        System.out.println(upperDecoration);
        System.out.println("Flight successfully booked at \n" + bookDate);
        System.out.println(lowerDecoration);
    }

    public void setBookDate() {
        bookDate = LocalDate.now();
        System.out.println(upperDecoration);
        System.out.println("Flight successfully booked at \n" + bookDate);
        System.out.println(lowerDecoration);
    }

    public LocalDate getBookDate() {
        return bookDate;
    }

    public void cancelFlight() {
        bookDate = null;
        hasBooked = false;
    }

    public void displayInfo() {
        // leverages the custom ToString method to organize the data.
        System.out.println(this.ToString());
    }

    public String ToString() {
        return String.format(
                upperDecoration + "\n" +
                "Passenger name:          " + firstName + " " + lastName + "\n" +
                        "Passport ID:             " + passportID + "\n" +
                        "Passenger Age:           " + age + "\n" +
                        "Flight Fare:             " + flightFare + "\n" +
                        "Booking Confirmation:    " + hasBooked + "\n" +
                        "Booked Date:             " + bookDate + "\n" +
                        lowerDecoration
        );

    }
}


