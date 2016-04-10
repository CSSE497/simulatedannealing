package xyz.thepathfinder.simulatedannealing;

public interface Problem<T extends SearchState<T>> {
    T initialState();
    double energy(T searchState);
}
