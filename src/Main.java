import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== PRESSURE VESSEL DESIGN APPLICATION ===");

        // Inputs
        System.out.print("Enter Internal Pressure (MPa): ");
        double P = sc.nextDouble();

        System.out.print("Enter Diameter (mm): ");
        double D = sc.nextDouble();

        System.out.print("Enter Allowable Stress (MPa): ");
        double sigma;

        System.out.print("Choose Material (Steel/Aluminum/Titanium or Custom): ");
        String material = sc.next();

        if(material.equalsIgnoreCase("Steel")) {
            sigma = MaterialDatabase.getStress("Steel");
        } else if(material.equalsIgnoreCase("Aluminum")) {
            sigma = MaterialDatabase.getStress("Aluminum");
        } else if(material.equalsIgnoreCase("Titanium")) {
            sigma = MaterialDatabase.getStress("Titanium");
        } else {
            System.out.print("Enter Custom Allowable Stress: ");
            sigma = sc.nextDouble();
        }

        System.out.print("Enter Safety Factor: ");
        double SF = sc.nextDouble();

        // Validation
        if (!InputValidator.validateInputs(P, D, sigma, SF)) {
            System.out.println("Invalid inputs! Please check values.");
            return;
        }

        // Calculation
        PressureVesselCalculator calculator = new PressureVesselCalculator();
        calculator.calculate(P, D, sigma, SF);

        sc.close();
    }
}
