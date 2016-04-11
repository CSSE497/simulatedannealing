package xyz.thepathfinder.simulatedannealing;

public interface Problem<T extends SearchState<T>> {
    T initialState() throws InfeasibleProblemException;
    double energy(T searchState);
}
