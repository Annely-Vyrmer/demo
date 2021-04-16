package ee.bcs.valiit.Udemy;

public class SpeedConverter {

    public static void main(String[] args) {
        System.out.println(toMilesPerHour(-5.0));
        printConversion(5);
    }
    //This method needs to return the rounded value of the calculation of type long.
    //TODO:1: If parameter kilometerPerHour is less than 0, return -1 to indicate invalid value
    //TODO:2: Calculate the value of miles per hour, round it and return it.
    public static long toMilesPerHour(double kilometersPerHour) {
        if (kilometersPerHour < 0) {
            return -1;
        }
        return Math.round(kilometersPerHour / 1.609);
    }

    public static void printConversion(double kilometersPerHour) {
        if (kilometersPerHour < 0) {
            System.out.println("Invalid Value");
        } else {
            long milesPerHour = toMilesPerHour(kilometersPerHour);  //Use function toMilesPerHour
            System.out.println(kilometersPerHour + " km/h = " + milesPerHour + " mi/h");
        }
    }
}

