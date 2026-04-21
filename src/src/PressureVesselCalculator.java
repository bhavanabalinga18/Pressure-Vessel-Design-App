public class PressureVesselCalculator {

    public void calculate(double P, double D, double sigma, double SF) {

        // Step 1: Calculate allowable stress
        double sigma_allow = sigma / SF;

        // Step 2: Thin vessel thickness formula
        double t_thin = (P * D) / (2 * sigma_allow);

        System.out.println("\n===== DESIGN RESULTS =====");

        // Step 3: Check thin vessel condition
        if (t_thin < D / 20) {

            System.out.println("Vessel Type: THIN PRESSURE VESSEL");
            System.out.printf("Required Thickness: %.2f mm\n", t_thin);

            // Safety check
            if (sigma_allow > P) {
                System.out.println("Design Status: SAFE ✅");
            } else {
                System.out.println("Design Status: UNSAFE ❌");
            }

            // Explanation
            System.out.println("Explanation:");
            System.out.println("Thickness is less than D/20 → Thin vessel assumption is valid.");
            System.out.println("Hoop stress formula used.");

        } else {

            // Step 4: Thick vessel calculation using Lame's equation
            double ri = D / 2;
            double ro = ri * Math.sqrt((sigma_allow + P) / (sigma_allow - P));
            double t_thick = ro - ri;

            System.out.println("Vessel Type: THICK PRESSURE VESSEL");
            System.out.printf("Required Thickness: %.2f mm\n", t_thick);

            // Safety check
            if (sigma_allow > P) {
                System.out.println("Design Status: SAFE ✅");
            } else {
                System.out.println("Design Status: UNSAFE ❌");
            }

            // Explanation
            System.out.println("Explanation:");
            System.out.println("Thickness exceeds D/20 → Thin assumption invalid.");
            System.out.println("Lame's equation applied for thick cylinder.");
        }
    }
}
