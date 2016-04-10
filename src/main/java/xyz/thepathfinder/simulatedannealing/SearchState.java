package xyz.thepathfinder.simulatedannealing;

public interface SearchState<T> {
    SearchState<T> step();
    double energy();
}
