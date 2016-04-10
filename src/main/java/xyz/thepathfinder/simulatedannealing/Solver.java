package xyz.thepathfinder.simulatedannealing;

import java.util.Random;

public class Solver {
    final Scheduler scheduler;
    final Random random = new Random();

    public Solver(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public <T> SearchState<T> solve(SearchState<T> currentState) {
        SearchState<T> minState = currentState;
        int steps = 0;
        while (true) {
            double temperature = scheduler.getTemperature(steps++);
            if (temperature <= 0.0) {
                return minState;
            }
            SearchState<T> nextState = currentState.step();
            double energyChange = nextState.energy() - currentState.energy();
            if (accept(temperature, energyChange)) {
                currentState = nextState;
                if (currentState.energy() < minState.energy()) {
                    minState = currentState;
                }
            }
        }
    }

    /** Always accept changes that decrease energy. Otherwise, use the simulated annealing. */
    private boolean accept(double temperature, double energyChange) {
        if (energyChange > 0.0) {
            return true;
        } else {
            return random.nextDouble() <= Math.exp(energyChange / temperature);
        }
    }
}
