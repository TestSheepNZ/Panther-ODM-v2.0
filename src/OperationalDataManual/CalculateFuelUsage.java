package OperationalDataManual;

import java.util.ArrayList;
import java.util.List;

public class CalculateFuelUsage {

    // Data
    private double fuelUsedLastManoeuvre;
    private double acAltitude;
    private double acWeight;

    // Fuel info
    private List<FuelRateData> fuelData;

    public CalculateFuelUsage() {
        fuelData = new ArrayList<FuelRateData>();
        acWeight = 6000.0;

        acAltitude = 0.0;
        fuelUsedLastManoeuvre = 0.0;

        initialiseFuelUsage();
    }

    // Set ac weight
    public boolean setAircraftWeight(double newWeight) {
        acWeight = newWeight;
        return true;
    }

    // Get value for fuel used last manoeuvre
    public double getFuelUsed() {
        return fuelUsedLastManoeuvre;
    }

    // Get the altitude
    public double getAltitude() {
        return acAltitude;
    }

    // Climb / dive fuel usage
    public boolean climb(double newAltitude) {
        double fuelUsed = 1 * (newAltitude - acAltitude) / 100.0;
        fuelUsedLastManoeuvre = fuelUsed;
        acAltitude = newAltitude;
        return true;
    }

    public boolean dive(double newAltitude) {
        acAltitude = newAltitude;
        fuelUsedLastManoeuvre = 0.0;
        return true;
    }

    // Fuel usage over a leg ...
    public boolean aircraftLeg(double speed, double distance) {
        double fuelUsage = 27.7; // Test data for now
        double fuelUsed;

        for (FuelRateData thisFuelData : fuelData) {
            if (thisFuelData.dataMatch(acAltitude, speed, acWeight)) {
                fuelUsage = thisFuelData.getFuelUsage();
            }
        }
        // System.out.println("Fuel usage " + fuelUsage);
        fuelUsed = fuelUsage * distance * 60.0 / speed;
        fuelUsedLastManoeuvre = fuelUsed;

        return true;
    }

    // Set up fuel usage data ...
    private void initialiseFuelUsage() {

        // 400kt table
        fuelData.add(new FuelRateData(100.0, 400.0, 7000.0, 26.2));
        fuelData.add(new FuelRateData(500.0, 400.0, 7000.0, 23.8));
        fuelData.add(new FuelRateData(2000.0, 400.0, 7000.0, 21.8));
        fuelData.add(new FuelRateData(8000.0, 400.0, 7000.0, 16.5));
        fuelData.add(new FuelRateData(16000.0, 400.0, 7000.0, 12.3));
        fuelData.add(new FuelRateData(32000.0, 400.0, 7000.0, 6.8));
        fuelData.add(new FuelRateData(100.0, 400.0, 8000.0, 27.1));
        fuelData.add(new FuelRateData(500.0, 400.0, 8000.0, 24.7));
        fuelData.add(new FuelRateData(2000.0, 400.0, 8000.0, 22.6));
        fuelData.add(new FuelRateData(8000.0, 400.0, 8000.0, 17.1));
        fuelData.add(new FuelRateData(16000.0, 400.0, 8000.0, 12.7));
        fuelData.add(new FuelRateData(32000.0, 400.0, 8000.0, 7));
        fuelData.add(new FuelRateData(100.0, 400.0, 9000.0, 28.1));
        fuelData.add(new FuelRateData(500.0, 400.0, 9000.0, 25.5));
        fuelData.add(new FuelRateData(2000.0, 400.0, 9000.0, 23.4));
        fuelData.add(new FuelRateData(8000.0, 400.0, 9000.0, 17.7));
        fuelData.add(new FuelRateData(16000.0, 400.0, 9000.0, 13.2));
        fuelData.add(new FuelRateData(32000.0, 400.0, 9000.0, 7.3));
        fuelData.add(new FuelRateData(100.0, 400.0, 10000.0, 29));
        fuelData.add(new FuelRateData(500.0, 400.0, 10000.0, 26.4));
        fuelData.add(new FuelRateData(2000.0, 400.0, 10000.0, 24.2));
        fuelData.add(new FuelRateData(8000.0, 400.0, 10000.0, 18.3));
        fuelData.add(new FuelRateData(16000.0, 400.0, 10000.0, 13.6));
        fuelData.add(new FuelRateData(32000.0, 400.0, 10000.0, 7.6));
        fuelData.add(new FuelRateData(100.0, 400.0, 11000.0, 30.1));
        fuelData.add(new FuelRateData(500.0, 400.0, 11000.0, 27.4));
        fuelData.add(new FuelRateData(2000.0, 400.0, 11000.0, 25.1));
        fuelData.add(new FuelRateData(8000.0, 400.0, 11000.0, 18.9));
        fuelData.add(new FuelRateData(16000.0, 400.0, 11000.0, 14.1));
        fuelData.add(new FuelRateData(32000.0, 400.0, 11000.0, 7.8));
        fuelData.add(new FuelRateData(100.0, 400.0, 12000.0, 31.1));
        fuelData.add(new FuelRateData(500.0, 400.0, 12000.0, 28.3));
        fuelData.add(new FuelRateData(2000.0, 400.0, 12000.0, 25.9));
        fuelData.add(new FuelRateData(8000.0, 400.0, 12000.0, 19.6));
        fuelData.add(new FuelRateData(16000.0, 400.0, 12000.0, 14.6));
        fuelData.add(new FuelRateData(32000.0, 400.0, 12000.0, 8.1));
        fuelData.add(new FuelRateData(100.0, 400.0, 13000.0, 32.2));
        fuelData.add(new FuelRateData(500.0, 400.0, 13000.0, 29.3));
        fuelData.add(new FuelRateData(2000.0, 400.0, 13000.0, 26.8));
        fuelData.add(new FuelRateData(8000.0, 400.0, 13000.0, 20.3));
        fuelData.add(new FuelRateData(16000.0, 400.0, 13000.0, 15.1));
        fuelData.add(new FuelRateData(32000.0, 400.0, 13000.0, 8.4));
        fuelData.add(new FuelRateData(100.0, 400.0, 14000.0, 33.4));
        fuelData.add(new FuelRateData(500.0, 400.0, 14000.0, 30.3));
        fuelData.add(new FuelRateData(2000.0, 400.0, 14000.0, 27.8));
        fuelData.add(new FuelRateData(8000.0, 400.0, 14000.0, 21));
        fuelData.add(new FuelRateData(16000.0, 400.0, 14000.0, 15.7));
        fuelData.add(new FuelRateData(32000.0, 400.0, 14000.0, 8.7));
        fuelData.add(new FuelRateData(100.0, 400.0, 15000.0, 34.5));
        fuelData.add(new FuelRateData(500.0, 400.0, 15000.0, 31.4));
        fuelData.add(new FuelRateData(2000.0, 400.0, 15000.0, 28.8));
        fuelData.add(new FuelRateData(8000.0, 400.0, 15000.0, 21.8));
        fuelData.add(new FuelRateData(16000.0, 400.0, 15000.0, 16.2));
        fuelData.add(new FuelRateData(32000.0, 400.0, 15000.0, 19));
        fuelData.add(new FuelRateData(100.0, 400.0, 16000.0, 35.7));
        fuelData.add(new FuelRateData(500.0, 400.0, 16000.0, 32.5));
        fuelData.add(new FuelRateData(2000.0, 400.0, 16000.0, 29.8));
        fuelData.add(new FuelRateData(8000.0, 400.0, 16000.0, 22.5));
        fuelData.add(new FuelRateData(16000.0, 400.0, 16000.0, 16.8));
        fuelData.add(new FuelRateData(32000.0, 400.0, 16000.0, 9.3));

        // 500kt table
        fuelData.add(new FuelRateData(100.0, 500.0, 7000.0, 36.8));
        fuelData.add(new FuelRateData(100.0, 500.0, 8000.0, 38.1));
        fuelData.add(new FuelRateData(100.0, 500.0, 9000.0, 39.5));
        fuelData.add(new FuelRateData(100.0, 500.0, 10000.0, 40.9));
        fuelData.add(new FuelRateData(100.0, 500.0, 11000.0, 42.3));
        fuelData.add(new FuelRateData(100.0, 500.0, 12000.0, 43.8));
        fuelData.add(new FuelRateData(100.0, 500.0, 13000.0, 45.3));
        fuelData.add(new FuelRateData(100.0, 500.0, 14000.0, 46.9));
        fuelData.add(new FuelRateData(100.0, 500.0, 15000.0, 48.6));
        fuelData.add(new FuelRateData(100.0, 500.0, 16000.0, 50.3));
        fuelData.add(new FuelRateData(500.0, 500.0, 7000.0, 33.5));
        fuelData.add(new FuelRateData(500.0, 500.0, 8000.0, 34.7));
        fuelData.add(new FuelRateData(500.0, 500.0, 9000.0, 35.9));
        fuelData.add(new FuelRateData(500.0, 500.0, 10000.0, 37.2));
        fuelData.add(new FuelRateData(500.0, 500.0, 11000.0, 38.5));
        fuelData.add(new FuelRateData(500.0, 500.0, 12000.0, 39.9));
        fuelData.add(new FuelRateData(500.0, 500.0, 13000.0, 41.3));
        fuelData.add(new FuelRateData(500.0, 500.0, 14000.0, 42.7));
        fuelData.add(new FuelRateData(500.0, 500.0, 15000.0, 44.2));
        fuelData.add(new FuelRateData(500.0, 500.0, 16000.0, 45.8));
        fuelData.add(new FuelRateData(2000.0, 500.0, 7000.0, 30.7));
        fuelData.add(new FuelRateData(2000.0, 500.0, 8000.0, 31.8));
        fuelData.add(new FuelRateData(2000.0, 500.0, 9000.0, 32.9));
        fuelData.add(new FuelRateData(2000.0, 500.0, 10000.0, 34.1));
        fuelData.add(new FuelRateData(2000.0, 500.0, 11000.0, 35.3));
        fuelData.add(new FuelRateData(2000.0, 500.0, 12000.0, 36.5));
        fuelData.add(new FuelRateData(2000.0, 500.0, 13000.0, 37.8));
        fuelData.add(new FuelRateData(2000.0, 500.0, 14000.0, 39.1));
        fuelData.add(new FuelRateData(2000.0, 500.0, 15000.0, 40.5));
        fuelData.add(new FuelRateData(2000.0, 500.0, 16000.0, 41.9));
        fuelData.add(new FuelRateData(8000.0, 500.0, 7000.0, 23.2));
        fuelData.add(new FuelRateData(8000.0, 500.0, 8000.0, 24));
        fuelData.add(new FuelRateData(8000.0, 500.0, 9000.0, 24.9));
        fuelData.add(new FuelRateData(8000.0, 500.0, 10000.0, 25.7));
        fuelData.add(new FuelRateData(8000.0, 500.0, 11000.0, 26.7));
        fuelData.add(new FuelRateData(8000.0, 500.0, 12000.0, 27.6));
        fuelData.add(new FuelRateData(8000.0, 500.0, 13000.0, 28.6));
        fuelData.add(new FuelRateData(8000.0, 500.0, 14000.0, 29.6));
        fuelData.add(new FuelRateData(8000.0, 500.0, 15000.0, 30.6));
        fuelData.add(new FuelRateData(8000.0, 500.0, 16000.0, 31.7));
        fuelData.add(new FuelRateData(16000.0, 500.0, 7000.0, 17.3));
        fuelData.add(new FuelRateData(16000.0, 500.0, 8000.0, 17.9));
        fuelData.add(new FuelRateData(16000.0, 500.0, 9000.0, 18.6));
        fuelData.add(new FuelRateData(16000.0, 500.0, 10000.0, 19.2));
        fuelData.add(new FuelRateData(16000.0, 500.0, 11000.0, 19.9));
        fuelData.add(new FuelRateData(16000.0, 500.0, 12000.0, 20.6));
        fuelData.add(new FuelRateData(16000.0, 500.0, 13000.0, 21.3));
        fuelData.add(new FuelRateData(16000.0, 500.0, 14000.0, 22.1));
        fuelData.add(new FuelRateData(16000.0, 500.0, 15000.0, 22.8));
        fuelData.add(new FuelRateData(16000.0, 500.0, 16000.0, 23.6));
        fuelData.add(new FuelRateData(32000.0, 500.0, 7000.0, 9.6));
        fuelData.add(new FuelRateData(32000.0, 500.0, 8000.0, 9.9));
        fuelData.add(new FuelRateData(32000.0, 500.0, 9000.0, 10.3));
        fuelData.add(new FuelRateData(32000.0, 500.0, 10000.0, 10.6));
        fuelData.add(new FuelRateData(32000.0, 500.0, 11000.0, 11));
        fuelData.add(new FuelRateData(32000.0, 500.0, 12000.0, 11.4));
        fuelData.add(new FuelRateData(32000.0, 500.0, 13000.0, 11.8));
        fuelData.add(new FuelRateData(32000.0, 500.0, 14000.0, 12.2));
        fuelData.add(new FuelRateData(32000.0, 500.0, 15000.0, 12.6));
        fuelData.add(new FuelRateData(32000.0, 500.0, 16000.0, 13.1));

        // 600kt table
        fuelData.add(new FuelRateData(100.0, 600.0, 7000.0, 55.3));
        fuelData.add(new FuelRateData(100.0, 600.0, 8000.0, 57.2));
        fuelData.add(new FuelRateData(100.0, 600.0, 9000.0, 59.2));
        fuelData.add(new FuelRateData(100.0, 600.0, 10000.0, 61.3));
        fuelData.add(new FuelRateData(100.0, 600.0, 11000.0, 63.5));
        fuelData.add(new FuelRateData(100.0, 600.0, 12000.0, 65.7));
        fuelData.add(new FuelRateData(100.0, 600.0, 13000.0, 68));
        fuelData.add(new FuelRateData(100.0, 600.0, 14000.0, 70.4));
        fuelData.add(new FuelRateData(100.0, 600.0, 15000.0, 72.9));
        fuelData.add(new FuelRateData(100.0, 600.0, 16000.0, 75.5));
        fuelData.add(new FuelRateData(500.0, 600.0, 7000.0, 50.3));
        fuelData.add(new FuelRateData(500.0, 600.0, 8000.0, 52.1));
        fuelData.add(new FuelRateData(500.0, 600.0, 9000.0, 53.9));
        fuelData.add(new FuelRateData(500.0, 600.0, 10000.0, 55.8));
        fuelData.add(new FuelRateData(500.0, 600.0, 11000.0, 57.8));
        fuelData.add(new FuelRateData(500.0, 600.0, 12000.0, 59.8));
        fuelData.add(new FuelRateData(500.0, 600.0, 13000.0, 61.9));
        fuelData.add(new FuelRateData(500.0, 600.0, 14000.0, 64.1));
        fuelData.add(new FuelRateData(500.0, 600.0, 15000.0, 66.3));
        fuelData.add(new FuelRateData(500.0, 600.0, 16000.0, 68.7));
        fuelData.add(new FuelRateData(2000.0, 600.0, 7000.0, 46.1));
        fuelData.add(new FuelRateData(2000.0, 600.0, 8000.0, 47.7));
        fuelData.add(new FuelRateData(2000.0, 600.0, 9000.0, 49.4));
        fuelData.add(new FuelRateData(2000.0, 600.0, 10000.0, 51.1));
        fuelData.add(new FuelRateData(2000.0, 600.0, 11000.0, 52.9));
        fuelData.add(new FuelRateData(2000.0, 600.0, 12000.0, 54.8));
        fuelData.add(new FuelRateData(2000.0, 600.0, 13000.0, 56.7));
        fuelData.add(new FuelRateData(2000.0, 600.0, 14000.0, 58.7));
        fuelData.add(new FuelRateData(2000.0, 600.0, 15000.0, 60.7));
        fuelData.add(new FuelRateData(2000.0, 600.0, 16000.0, 62.9));
        fuelData.add(new FuelRateData(8000.0, 600.0, 7000.0, 34.8));
        fuelData.add(new FuelRateData(8000.0, 600.0, 8000.0, 36));
        fuelData.add(new FuelRateData(8000.0, 600.0, 9000.0, 37.3));
        fuelData.add(new FuelRateData(8000.0, 600.0, 10000.0, 38.6));
        fuelData.add(new FuelRateData(8000.0, 600.0, 11000.0, 40));
        fuelData.add(new FuelRateData(8000.0, 600.0, 12000.0, 41.4));
        fuelData.add(new FuelRateData(8000.0, 600.0, 13000.0, 42.8));
        fuelData.add(new FuelRateData(8000.0, 600.0, 14000.0, 44.4));
        fuelData.add(new FuelRateData(8000.0, 600.0, 15000.0, 45.9));
        fuelData.add(new FuelRateData(8000.0, 600.0, 16000.0, 47.5));
        fuelData.add(new FuelRateData(16000.0, 600.0, 7000.0, 26));
        fuelData.add(new FuelRateData(16000.0, 600.0, 8000.0, 26.9));
        fuelData.add(new FuelRateData(16000.0, 600.0, 9000.0, 27.8));
        fuelData.add(new FuelRateData(16000.0, 600.0, 10000.0, 28.8));
        fuelData.add(new FuelRateData(16000.0, 600.0, 11000.0, 29.8));
        fuelData.add(new FuelRateData(16000.0, 600.0, 12000.0, 30.9));
        fuelData.add(new FuelRateData(16000.0, 600.0, 13000.0, 32));
        fuelData.add(new FuelRateData(16000.0, 600.0, 14000.0, 33.1));
        fuelData.add(new FuelRateData(16000.0, 600.0, 15000.0, 34.3));
        fuelData.add(new FuelRateData(16000.0, 600.0, 16000.0, 35.5));
        fuelData.add(new FuelRateData(32000.0, 600.0, 7000.0, 14.4));
        fuelData.add(new FuelRateData(32000.0, 600.0, 8000.0, 14.9));
        fuelData.add(new FuelRateData(32000.0, 600.0, 9000.0, 15.4));
        fuelData.add(new FuelRateData(32000.0, 600.0, 10000.0, 15.9));
        fuelData.add(new FuelRateData(32000.0, 600.0, 11000.0, 16.5));
        fuelData.add(new FuelRateData(32000.0, 600.0, 12000.0, 17.1));
        fuelData.add(new FuelRateData(32000.0, 600.0, 13000.0, 17.7));
        fuelData.add(new FuelRateData(32000.0, 600.0, 14000.0, 18.3));
        fuelData.add(new FuelRateData(32000.0, 600.0, 15000.0, 19));
        fuelData.add(new FuelRateData(32000.0, 600.0, 16000.0, 19.6));

    }
}
