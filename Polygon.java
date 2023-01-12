/*
======================================================================================================================
PROGRAM PURPOSE: The purpose of this program is to obtain information from the user about a polygon, the number
                of sides and a valid length of the sides. The number of sides can range from 3 to 10. Then, the program
                is to calculate and display the name of the polygon, the area, and the perimeter. Additionally, the
                program should prompt whether the user asking if they would like to enter another Polygon, exiting
                the program if the user enters a -1.
Name: John Daggs
Date: 2/4/2022
Section: CSC 331-002
======================================================================================================================
*/

//import statements:
import java.util.Scanner;
import java.lang.Integer;
import java.lang.Math;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class PolygonDaggsJohn {

        public static final DecimalFormat df = new DecimalFormat("0.00");

        public static void main(String[] args) {

            int columnHeading = 0;

            int answer = 1;  // initialize answer variable for program while-loop for additional calculations, initialized to zero so will run first time

            while (answer != -1){  // while variable answer is not equal to -1, the code in the loop will run

            Scanner input = new Scanner(System.in);  // declaring a new Scanner object input for obtaining input from user

            //get the user input for the number of sides of the polygon and the length of one side . . . limit number of sides to be between 3 and 10.
            System.out.print("Enter the number of sides of the Polygon: ");  // prompt user to enter number of sides of the Polygon
            int sides = input.nextInt();  // declaring sides variable and initializing it to the input given from user
            while (sides < 3||sides > 10){  // while the input given for the sides is less than 3 or more than 10,
                System.out.print("ERROR . . . Invalid number of sides. Enter the number of sides of the Polygon (between 3 and 10): ");  //user will continue to be prompted with error message and asked to enter number of sides of the Polygon
                sides = input.nextInt();  // initializing sides variable to new input entered from user
            }

            System.out.print("Enter the length of the sides of the Polygon: ");  // prompt user to enter the length of the sides of the Polygon
            double length = input.nextDouble();  // declaring and initializing variable length to the input given from the user
            while (length <=0 ){  // while the value for length entered is less than zero
                System.out.print("ERROR . . . Invalid length . . . Must be over Zero . . . Enter the length of the sides of the Polygon: ");  // user will continue to ne prompted with error message and asked to enter valid length
                length = input.nextDouble();  // initializing length variable to new input entered from user
            }

            //invoke area and perimeter methods to get their return values
            double area = area(sides, length);  // declaring and initializing area variable with call to the area method, passing sides and length variables through the parameters for sides and length
            double perimeter = perimeter(sides, length);  // declaring and initializing perimeter variable with call to the perimeter method, passing sides and length variables through the parameters for sides and length

            if (columnHeading == 0){ // if columnHeading variable is equal to zero . . . should equal zero first time through loop
                System.out.print("Format: \n" + "Name, " + " area, " + " perimeter \n" );
                columnHeading = 1;
            }

            //invoke polyName method to display the name of the polygon . . .
            polyName(sides);  // invoking polyName function, passing sides variable to it

            //display the area and the perimeter of the poly gon
            System.out.print(", " + df.format(area) + ", ");  // print the area value to the user
            System.out.print(perimeter);  // print the perimeter value to the user

            // use a loop to allow the user to continue entering information for differe polygons until -1 is entered
            System.out.print("\nWould you like to enter another Polygon? (Enter -1 to quit and 1 to do another): ");  // prompt user whether they would like to enter another polygon, and to enter -1 if they wish to quit
            answer = input.nextInt();  // initialize answer variable to the input given by the user . . . if 0 is entered, the while loop will loop through again . . .
            while (answer != 1 & answer != -1){ // while the answer given by the user is not 1 or -1

                System.out.print("\nWould you like to enter another Polygon? (Enter -1 to quit and 1 to do another): ");  // prompt user whether they would like to enter another polygon, and to enter -1 if they wish to quit
                answer = input.nextInt();  // initialize answer variable to the input given by the user . . . if 1 is entered, the while loop will loop through again . . .
            }
            System.out.print("\n");  // print new line
        }
        }

        public static double area(int sides, double length){  //parameters for number of sides and length
            //calculate and return the area using the formula: area = (number of sides * length of sides ^ 2)/ (4 * tan(pi/number of sides))
            return ((sides*(length*length)))/(4*Math.tan(3.14/sides));  // return statement with area formula using parameter values

        }

        public static double perimeter(int sides, double length){  //parameters for number of sides and length
            //calculate and return the perimeter = number of sides * length
            return sides*length;  // return statement with perimeter formula

        }

       public static void polyName(int sides){  //parameter for number of sides
            //use a switch statement to determine the name of the polygon
            //display the name of the polygon and do not return any values to the main method
            switch(sides)  // switch statement to take care of each case of sides
            {
                case (3):  // when sides == 3
                    System.out.print("Triangle");  // print Triangle to user
                    break;  // break
                case (4):  // when sides == 4
                    System.out.print("Square");  // print Square to user
                    break; // break
                case (5):  // when sides == 5
                    System.out.print("Pentagon");  // print Pentagon to user
                    break;  // break
                case (6):  // when sides == 6
                    System.out.print("Hexagon");  // print Hexagon to user
                    break;  // break
                case (7):  // when sides == 7
                    System.out.print("Heptagon");  // print Heptagon to user
                    break;  // break
                case (8):  // when sides == 8
                    System.out.print("Octagon");  // print Octagon to user
                    break;  // break
                case (9):  // when sides == 9
                    System.out.print("Nonagon");  // print Nonagon to user
                    break;  // break
                case (10):  // when sides == 10
                    System.out.print("Decagon"); // print Decagon to user
                    break; // break
            }

        }
    }
