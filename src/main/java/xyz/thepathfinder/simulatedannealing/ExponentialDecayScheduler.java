package xyz.thepathfinder.simulatedannealing;

public class ExponentialDecayScheduler implements Scheduler {
    static final double EPSILON = 0.001;
    final double initialTemperature;
    final double decayRate;

    public ExponentialDecayScheduler(double initialTemperature, int totalSteps) {
        this.initialTemperature = initialTemperature;
        decayRate = Math.log(EPSILON / initialTemperature) / totalSteps;
    }

    @Override
    public double getTemperature(int steps) {
        double temperature = initialTemperature * Math.exp(decayRate * steps);
        return temperature < EPSILON ? 0 : temperature;
    }
}
