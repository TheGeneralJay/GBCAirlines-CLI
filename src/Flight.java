///  Author: Taylor Martin | 100849882
///  COMP 2130 | CRN: 15655
///  LAST EDITED DATE: 10/15/2023
///  Flight class for COMP 2130 Assignment 1

import java.time.LocalDate;

public class Flight {
    // Attributes
    String topLineDesign = ".--------------------------------------------------.";
    String bottomLineDesign = ".__________________________________________________.";

    String flightNumber;
    LocalDate date;
    String source;
    String destination;
    Passenger[] passengers;
    int maxPassenger;
    int currentCount;

    // CONSTRUCTOR \\
    // Main Action: Initialize variables in Flight Class
    Flight(String flightNumber, LocalDate date, String source, String destination, int maxPassenger) {
        this.flightNumber = flightNumber;
        this.date         = date;
        this.source       = source;
        this.destination  = destination;
        this.passengers   = new Passenger[maxPassenger];
        this.maxPassenger = maxPassenger;
        this.currentCount = 0;
    }

    // METHODS \\

    // ADDING NEW PASSENGER OBJECT TO ARRAY
    // Main Action: If/else condition that checks number of passengers against flight capacity
    // Adds passenger to system if condition is met, prints Error message if not met
    public void addPassenger(Passenger passenger) {

        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] != null) {
                if (passenger.passportID == passengers[i].passportID) {
                    System.out.println(topLineDesign);
                    System.out.println("This passenger has already been added to the flight\n" +
                                        "                    manifest");
                    System.out.println(bottomLineDesign);
                    return;
                }
            }
        }

        if(currentCount < maxPassenger) {
            passengers[currentCount] = passenger;
            currentCount++;
            System.out.println(topLineDesign);
            System.out.println("   Successfully added " + passenger.firstName + " to the flight manifest.");
            System.out.println(bottomLineDesign);
        } else {
            System.out.println(topLineDesign);
            System.out.println("Sorry, this flight has reached capacity.");
            System.out.println(bottomLineDesign);
        }
    }

    // BOOKING CONFIRMATION FOR PASSENGERS
    // Main Action: For Loop through array to check against condition
    // Condition checks passportID parameter against passportID inside passengers object
    // If passenger is in the system, System sets the booking confirmation to true
    // Accounts for null element in array to avoid crash from NullPointerException
    public void bookFlight(int passportID) {
        for(int i = 0; i < currentCount; i++) {
            if(passengers[i] != null && passengers[i].passportID == passportID){

                if (!passengers[i].hasBooked) {
                    System.out.println(topLineDesign);
                    System.out.println("     " + passengers[i].firstName + " " + passengers[i].lastName + "'s" + " booking has been confirmed.");
                    System.out.println(bottomLineDesign);
                    passengers[i].bookFlight();
                    return;
                }
                System.out.println(topLineDesign);
                System.out.println("  " + passengers[i].firstName + " " + passengers[i].lastName + "'s" + " flight has already been confirmed.");
                System.out.println(bottomLineDesign);
                return;
            }
        }
        System.out.println(topLineDesign);
        System.out.println(bottomLineDesign);
    }

    // CANCELLING FLIGHT FOR PASSENGERS (BOOKING CONFIRMATION = FALSE)
    // Main Action: For Loop through array to check against condition
    // If condition is met passenger flight is cancelled
    // Accounts for null element in array to avoid crash from NullPointerException
    public void cancelFlight(int passportID) {
        for(int i = 0; i < currentCount; i++){
            if(passengers[i] != null && passengers[i].passportID == passportID) {
                if (passengers[i].hasBooked) {
                    System.out.println(passengers[i].firstName + " " + passengers[i].lastName + "'s " + "booking confirmation has been cancelled.");
                    System.out.println(bottomLineDesign);
                    passengers[i].cancelFlight();
                    return;
                }
                System.out.println(topLineDesign);
                System.out.println(passengers[i].firstName + " " + passengers[i].lastName + " does not have a confirmed booking to cancel.");
                System.out.println(bottomLineDesign);
                return;
            }
        }
        System.out.println(topLineDesign);
        System.out.println("Sorry, the Passport ID you entered is not associated with a passenger on this flight.");
        System.out.println(bottomLineDesign);

    }

    // DISPLAYING PASSENGERS ADDED TO THE FLIGHT
    // Main Action: For Loop through array to print passenger information
    // Accounts for null element in array to avoid crash from NullPointerException
    public void displayAllPassengers() {
        System.out.println("     Passenger Manifest: Flight " + flightNumber + " to " + destination + "\n");
        for (int i = 0; i <= currentCount; i++) {
            if(passengers[i] != null) {
                System.out.println(passengers[i].ToString());
            }
        }
    }

    // OVERRIDE DEFAULT TO STRING METHOD
    // Main Action:Override default string representation of Flight Object
    public String toString() {
        return "            Flight Number: " + flightNumber +
               "\n            Date: " + date +
               "\n            Source: " + source +
               "\n            Destination: " + destination +
               "\n            Current Capacity: " + currentCount +
               "\n            Maximum Capacity: " + maxPassenger;
    }
}