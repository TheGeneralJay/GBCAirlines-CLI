///  Author: Ethan Sylvester | 101479568
///  COMP 2130 | CRN: 15655
///  LAST EDITED DATE: 10/09/2023
///  FrequentFlyerPassenger class for COMP 2130 Assignment 1

public class FrequentFlyerPassenger extends Passenger{
    int frequentFlyerNumber;
    int milesCollected = 0;

    public FrequentFlyerPassenger(int ID, String fName, String lName, String age, String fare, boolean booked, int freqFlyNumber, int miles) {
        super(ID, fName, lName, age, fare, booked);
        frequentFlyerNumber = freqFlyNumber;
        milesCollected = miles;
    }

    @Override
    final public String ToString() {
        return String.format(
                "Passenger name:          " + firstName + " " + lastName + "\n" +
                        "Passenger ID:            " + passportID + "\n" +
                        "Passenger Age:           " + age + "\n" +
                        "Flight Fare:             " + flightFare + "\n" +
                        "Booked Flight:           " + hasBooked + " \n" +
                        "Frequent Flyer Number:   " + frequentFlyerNumber + "\n" +
                        "Miles Collected:         " + milesCollected
        );
    }
}