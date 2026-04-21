public class InputValidator {

    public static boolean validateInputs(double P, double D, double sigma, double SF) {

        // Check for negative or zero values
        if (P <= 0) {
            System.out.println("Error: Pressure must be greater than 0.");
            return false;
        }

        if (D <= 0) {
            System.out.println("Error: Diameter must be greater than 0.");
            return false;
        }

        if (sigma <= 0) {
            System.out.println("Error: Allowable stress must be greater than 0.");
            return false;
        }

        if (SF <= 0) {
            System.out.println("Error: Safety factor must be greater than 0.");
            return false;
        }

        // Warning checks
        if (SF < 1) {
            System.out.println("Warning: Safety factor should be >= 1.");
        }

        if (sigma <= P) {
            System.out.println("Warning: Allowable stress should be greater than pressure.");
        }

        return true;
    }
}
