import java.util.HashMap;

public class MaterialDatabase {

    private static HashMap<String, Double> materials = new HashMap<>();

    // Static block to store material properties
    static {
        materials.put("Steel", 250.0);      // MPa
        materials.put("Aluminum", 150.0);   // MPa
        materials.put("Titanium", 300.0);   // MPa
    }

    // Method to get allowable stress
    public static double getStress(String material) {

        if (materials.containsKey(material)) {
            return materials.get(material);
        } else {
            System.out.println("Material not found. Using default value (200 MPa).");
            return 200.0;
        }
    }
}
