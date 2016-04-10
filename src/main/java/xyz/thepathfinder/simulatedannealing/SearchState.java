package xyz.thepathfinder.simulatedannealing;

public interface SearchState<T extends SearchState<T>> {
    T step();
}
