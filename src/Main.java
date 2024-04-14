///  Authors: Amanda Gurney | 101443253
///  COMP-2130 | CRN: 15655
///  LAST EDITED DATE: 10/15/2023
///  Main Program for COMP 2130 Assignment 1

import java.util.Scanner;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


    // Design Methods
    // ************************
    static void topLineDesign() {
        System.out.println(".--------------------------------------------------.");
    }

    static void bottomLineDesign() {
        System.out.println(".__________________________________________________.");
    }

    // Design for the menu.
    static void menuDesign(Flight flight) {
        topLineDesign();
        System.out.println("       GBC AIRLINES FLIGHT MANAGEMENT SYSTEM");
        System.out.println("               CURRENT FLIGHT: " + flight.flightNumber);
        System.out.println();
        System.out.println("             Welcome, Administrator!");
        bottomLineDesign();

        topLineDesign();
        System.out.println("          (1) -> Add New Passenger to System");
        System.out.println("          (2) -> Add Passenger to Flight Manifest");
        System.out.println("          (3) -> Passenger Booking Confirmation");
        System.out.println("          (4) -> Cancel Booking Confirmation");
        System.out.println("          (5) -> Print Flight Manifest");
        System.out.println("          (6) -> View Bookings From Last 7 Days");
        System.out.println("          (7) -> Exit System");

        bottomLineDesign();
        topLineDesign();
        System.out.print("  Option: ");
    }

    // Design for spacing out the program. Credit: Generic 4 engine Jet by Paul Tomblin
    static void spaceDesign() {
        bottomLineDesign();
        System.out.println();
        System.out.println("                       __|__\n" + //
                           "                --------(_)--------\n" + //
                           "                  O  O       O  O");
        System.out.println();
    }
    // Give the option to view all passengers.
    // Aids with adding passengers so that the list is right here.
    static void menuDisplay(Passenger[] allPassengers, Flight flight1, int passengerCount) {

                    topLineDesign();
                    System.out.println("                EXISTING PASSENGERS IN SYSTEM");
                    bottomLineDesign();

                    topLineDesign();
                    for (int i = 0; i < passengerCount; i++) {
                        System.out.println("            (ID: " + allPassengers[i].passportID + ") -> " +
                                allPassengers[i].firstName + " " + allPassengers[i].lastName);
                    }
                    bottomLineDesign();

    }

    // ************************
    // Utility Methods
    // ************************

    public static String stringInput(Scanner userInput) {
        // Loop control variable.
        boolean inputContinue = false;
        String returnString = "";

        Pattern acceptableChars = Pattern.compile("^[A-Za-z]+(['-][A-Za-z]+)*$");

        while (!inputContinue) {
            returnString = userInput.next();

            if (acceptableChars.matcher(returnString).matches()) {
                inputContinue = true;
            } else {
                System.out.print("Please use a valid name: ");
            }
        }

        return returnString;
    }

    public static String ageInput(Scanner userInput) {
        // Loop control variable.
        boolean inputContinue = false;
        String returnAge = "";

        while (!inputContinue) {
            // If input exists and starts with a number...
            if (userInput.hasNextLine() && userInput.hasNextInt()) {
                returnAge = userInput.next();

                inputContinue = true;
            } else {
                System.out.print("Please use a valid age: ");
                userInput.next();
            }
        }
        return returnAge;
    }

    public static String fareInput(Scanner userInput) {
        // Loop control variable.
        boolean inputContinue = false;
        String returnFare = "";

        while (!inputContinue) {
            // If input exists and starts with a number...
            if (userInput.hasNextLine() && userInput.hasNextInt()) {
                returnFare = "$" + userInput.next();

                inputContinue = true;
            } else {
                System.out.print("Please use a valid fare: ");
                userInput.next();
            }
        }
        return returnFare;
    }

    public static int intInput(Scanner userInput, Passenger[] array, int count) {
        // Loop control variable.
        boolean inputContinue = false;
        int returnInt = 0;

        while (!inputContinue) {
            int invalidCount = 0;

            // If input is a number...
            if (userInput.hasNextInt()) {
                returnInt = userInput.nextInt();

                for (int i = 0; i < count; i++) {
                    if (returnInt ==  array[i].passportID) {
                        System.out.print("That ID is taken, please enter a unique ID: ");
                        invalidCount++;
                    }
                }

                if (invalidCount == 0) {
                    inputContinue = true;
                }

            } else {
                System.out.print("Please enter a valid ID: ");
                userInput.next();
            }
        }
        return returnInt;
    }

    public static boolean boolInput(Scanner userInput) {
        // Loop control variable.
        boolean inputContinue = false;
        boolean returnBool = false;

        while (!inputContinue) {
            // If input is a boolean...
            if (userInput.hasNextBoolean()) {
                returnBool = userInput.nextBoolean();

                inputContinue = true;
            } else {
                System.out.print("Please enter 'true' or 'false': ");
                userInput.next();
            }
        }
        return returnBool;
    }

    public static Passenger[] addToPassArray(Passenger[] passArray, Passenger passObj, int passengerCount) {
        for (int i = passengerCount; i < passArray.length; i++) {

            passArray[passengerCount] = passObj;
            i = passArray.length;

        }

        return passArray;
    }

    // Allows user to press enter before being thrown back into the main menu.
    static void pressEnter(Scanner userInput) {
        topLineDesign();
        System.out.print("             Press enter to continue...\n");
        bottomLineDesign();
        userInput.nextLine();
        userInput.nextLine();
    }


    public static void main(String[] args) {

        // ************************
        // Variables
        // ************************
        int menuOption;
        boolean menuContinue = false;
        boolean confirmContinue = false;
        int confirmChoice = 0;

        // User input
        Scanner userInput = new Scanner(System.in);
        int passengerOption1,
            passengerOption2;
        String enterPress;

        // Pre-made passengers.
        Passenger pass1 = new Passenger(101, "John", "Smith", "47", "$500", false);
        Passenger pass2 = new Passenger(201, "Sarah", "Thomas", "34", "$500", false);
        Passenger pass3 = new Passenger(301, "Joel", "Covenant", "72", "$750", false);
        Passenger pass4 = new Passenger(401, "Theodore", "Pascal", "23", "$750", false);
        Passenger pass5 = new Passenger(501, "Violet", "Lysandra", "22", "$800", false);

        // Passenger array.
        Passenger[] allPassengers = new Passenger[100];
        allPassengers[0] = pass1;
        allPassengers[1] = pass2;
        allPassengers[2] = pass3;
        allPassengers[3] = pass4;
        allPassengers[4] = pass5;

        // Passenger count.
        int passCount = 5;
        int flightPassCount = 0;
        int prevFlightPassCount = 0;
        int bookPassCount = 0;
        int prevBookPassCount = 0;

        // Flight object.
        Flight flight1 = new Flight("001", LocalDate.of(2023, 10, 8), "Toronto", "New York", 25);

        // User-created passengers.
        int passPassportID = 0;
        String passFirstName = "";
        String passLastName = "";
        String passAge = "";
        String passFlightFare = "";
        boolean passHasBooked = false;

        // ************************
        // Program
        // ************************

        // Menu loop, exit will break the loop.
        while (!menuContinue) {

            // Display menu.
            spaceDesign();
            menuDesign(flight1);

            // If userInput is an int, proceed to menu. Else, prompt for integer input.
            if (userInput.hasNextInt()) {

                menuOption = userInput.nextInt();

                // Execute code according to menu input.
                switch (menuOption) {
                    case 1 -> {
                        spaceDesign();
                        topLineDesign();
                        System.out.println("        OPTION 1: ADD NEW PASSENGER TO SYSTEM");
                        bottomLineDesign();

                        // Passport ID.
                        System.out.print("Passport ID: ");
                        passPassportID = intInput(userInput, allPassengers, passCount);

                        // First Name.
                        System.out.print("First Name: ");
                        passFirstName = stringInput(userInput);

                        // Last Name.
                        System.out.print("Last Name: ");
                        passLastName = stringInput(userInput);

                        // Age.
                        System.out.print("Age: ");
                        passAge = ageInput(userInput);

                        // Flight Fare.
                        System.out.print("Flight Fare: ");
                        passFlightFare = fareInput(userInput);

                        // Has Booked.
                        System.out.print("Has Customer Confirmed Booking? (True or False): ");
                        passHasBooked = boolInput(userInput);

                        confirmContinue = false;

                        while (!confirmContinue) {
                            spaceDesign();
                            topLineDesign();
                            System.out.println("            Is this information correct?");
                            System.out.println("                    (1) -> Yes");
                            System.out.println("                    (2) -> No");
                            bottomLineDesign();
                            topLineDesign();
                            System.out.print("  Option: ");

                            if (userInput.hasNextInt()) {
                                confirmChoice = userInput.nextInt();

                                if (confirmChoice == 1) {
                                    bottomLineDesign();
                                    Passenger newPass =  new Passenger(passPassportID, passFirstName, passLastName, passAge, passFlightFare, passHasBooked);
                                    newPass.setBookDate();
                                    addToPassArray(allPassengers, newPass, passCount);
                                    passCount++;
                                    flight1.addPassenger(allPassengers[passCount - 1]);

                                    pressEnter(userInput);
                                    confirmContinue = true;
                                    confirmChoice = 0;
                                } else if (confirmChoice == 2) {
                                    bottomLineDesign();
                                    topLineDesign();
                                    System.out.println("Reverting additions...");
                                    bottomLineDesign();
                                    pressEnter(userInput);
                                    confirmContinue = true;
                                    confirmChoice = 0;

                                } else {
                                    userInput.next();
                                    System.out.println("Please enter a valid option.");
                                    bottomLineDesign();
                                }

                            } else {
                                userInput.next();
                                System.out.println("Please enter a valid option.");
                                bottomLineDesign();
                            }
                        }

                    }


                    case 2 -> {
                        spaceDesign();

                        topLineDesign();
                        System.out.println("     OPTION 2: ADD PASSENGER TO FLIGHT MANIFEST");
                        bottomLineDesign();


                        menuDisplay(allPassengers, flight1, passCount);

                        topLineDesign();
                        System.out.println("    Please enter the passport ID of the passenger\n" +
                                           "            that you would like to add. ");
                        bottomLineDesign();

                        topLineDesign();
                        System.out.print("Passport ID: ");

                        if (userInput.hasNextInt()) {
                            passengerOption1 = userInput.nextInt();

                            // Check for existing passenger.
                            for (int i = 0; i < passCount; i++) {
                                if (passengerOption1 == allPassengers[i].passportID) {
                                    bottomLineDesign();


                                    topLineDesign();
                                    flight1.addPassenger(allPassengers[i]);
                                    bottomLineDesign();

                                    pressEnter(userInput);

                                    flightPassCount++;
                                }
                            }

                            // Check for no match.
                            if (flightPassCount == prevFlightPassCount) {
                                System.out.println("Passport ID not found, please try again!");
                                bottomLineDesign();

                                pressEnter(userInput);
                            } else {
                                prevFlightPassCount++;
                            }
                        }

                    } // case 2

                    case 3 -> {
                        spaceDesign();
                        topLineDesign();
                        System.out.println("            OPTION 3: PASSENGER BOOKING CONFIRMATION");
                        bottomLineDesign();

                        if (flight1.passengers[0] != null) {
                            flight1.displayAllPassengers();

                            topLineDesign();
                            System.out.println("         Please enter the passport ID for the\n" +
                                    "        passenger booking you'd like to confirm. ");
                            bottomLineDesign();

                            boolean passengerFound = false;

                            while (!passengerFound) {
                                topLineDesign();
                                System.out.print("Passport ID: ");

                                if (userInput.hasNextInt()) {
                                    passengerOption2 = userInput.nextInt();

                                    // Check for existing passenger.
                                    for (int i = 0; i < passCount; i++) {
                                        if (passengerOption2 == allPassengers[i].passportID) {
                                            bottomLineDesign();
                                            flight1.bookFlight(allPassengers[i].passportID);
                                            bookPassCount++;
                                            pressEnter(userInput);
                                            passengerFound = true;
                                            break;
                                        }
                                    }

                                    if (!passengerFound) {
                                        System.out.println("Passport ID not found, please try again!");
                                        userInput.nextLine();
                                    }
                                } else {
                                    System.out.println("Please enter a valid Passport ID.");
                                    userInput.nextLine();
                                }
                            }
                        } else {
                            System.out.println("No passengers currently registered on the manifest.");
                            pressEnter(userInput);
                        }
                    }

                    // case 3

                    case 4 -> {
                        spaceDesign();

                        topLineDesign();
                        System.out.println("            OPTION 4: CANCEL BOOKING CONFIRMATION");
                        bottomLineDesign();
                        if (flight1.passengers[0] != null) {
                            flight1.displayAllPassengers();

                            topLineDesign();
                            System.out.println("         Please enter the passport ID of the booking\n" +
                                    "        confirmation that you would like to cancel. ");
                            bottomLineDesign();


                            topLineDesign();
                            System.out.print("Passport ID: ");

                            if (userInput.hasNextInt()) {
                                passengerOption2 = userInput.nextInt();

                                // Check for existing passenger.
                                for (int i = 0; i < passCount; i++) {
                                    if (passengerOption2 == allPassengers[i].passportID) {
                                        bottomLineDesign();
                                        flight1.cancelFlight(allPassengers[i].passportID);


                                        bookPassCount++;

                                        pressEnter(userInput);
                                    }
                                }

                                // Check for no match.
                                if (bookPassCount == prevBookPassCount) {
                                    System.out.println("Passport ID not found, please try again!");
                                } else {
                                    prevBookPassCount++;
                                }
                            }
                        }  else {
                            System.out.println("No passengers currently registered on the manifest.");
                        }
                        

                    } // case 4

                    case 5 -> {
                        spaceDesign();

                        topLineDesign();
                        System.out.println("            OPTION 5: PRINT FLIGHT MANIFEST");
                        bottomLineDesign();

                        topLineDesign();
                        flight1.displayAllPassengers();
                        bottomLineDesign();

                        pressEnter(userInput);

                    } // case 5
                    case 6 -> {
                        LocalDate currentDate = LocalDate.now();
                        spaceDesign();

                        topLineDesign();
                        System.out.println("       OPTION 6: VIEW BOOKINGS FROM LAST 7 DAYS");
                        bottomLineDesign();

                        for (Passenger pass : flight1.passengers) {
                            if (pass != null) {
                                if (pass.getBookDate().isAfter(currentDate.minusDays(7))) {
                                    pass.displayInfo();
                                }
                            }

                        }

                        bottomLineDesign();
                        pressEnter(userInput);

                    } // case 6

                    case 7 -> {
                        spaceDesign();

                        topLineDesign();
                        System.out.println("OPTION 6: EXIT SYSTEM");
                        bottomLineDesign();
                        
                        topLineDesign();
                        System.out.println("            Now exiting the system...");
                        bottomLineDesign();

                        menuContinue = true;
                    } // case 7

                    default -> {
                        spaceDesign();
                        
                        topLineDesign();
                        System.out.println("Invalid input!");
                        bottomLineDesign();

                    } // default

                } // switch


            } else {
                bottomLineDesign();
                topLineDesign();
                System.out.println("   Please enter a valid menu option.");
                bottomLineDesign();

                pressEnter(userInput);
            }

        } // while (!menuContinue)
    }
}