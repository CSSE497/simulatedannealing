package xyz.thepathfinder.simulatedannealing;

public class LinearDecayScheduler implements Scheduler {
    final double initialTemperature;
    final int totalSteps;

    public LinearDecayScheduler(double initialTemperature, int totalSteps) {
        this.initialTemperature = initialTemperature;
        this.totalSteps = totalSteps;
    }

    @Override
    public double getTemperature(int steps) {
        return (1 - ((double) steps) / totalSteps) * initialTemperature;
    }
}
