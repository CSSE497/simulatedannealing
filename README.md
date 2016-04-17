# Simulated Annealing

A simple framework for solving optimization problems by simulated annealing.

## Why does this exist?

Pathfinder solves the k-Vehicle Routing Problem using simulated annealing at https://github.com/csse497/pathfinder-routing. We couldn't find any existing frameworks we liked and it was simple enough to implement, so we created our own.

## Install

Available on [Maven](http://mvnrepository.com/artifact/xyz.thepathfinder/simulatedannealing).

```xml
<dependency>
    <groupId>xyz.thepathfinder</groupId>
    <artifactId>simulatedannealing</artifactId>
    <version>0.0.3</version>
</dependency>
```

## Usage
You will need to implement the `SearchState<T>` interface. It defines only one method, `T step()`, which should return a randomly chosen deviation from the current state. Also, you will need to implement the `Problem<T>` interface, which initializes a state and evaluates the energey of states.

You will need to choose a `Scheduler` implenentation, which determines the speed and shape of the annealing process. We provide two built-in options, `LinearDecayScheduler` and `ExponentialDecayScheduler`.

Finally, just create a `Solver` and call solve!

```java
Scheduler scheduler = new LinearDecayScheduler(INITIAL_TEMPERATURE, NUMBER_OF_STEPS);
Problem<VRPSearchState> problem = new Problem(...);
Solver<VRPSearchState> solver = new Solver(problem, scheduler);
VRPSearchState solution = solver.solve();
```

## LICENSE

[MIT](https://raw.githubusercontent.com/CSSE497/simulatedannealing/master/LICENSE).
