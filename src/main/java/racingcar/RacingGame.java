package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {

  private static final Random RANDOM = new Random();
  private final int count;
  private final List<RacingCar> racingCars;

  public RacingGame(String names, int count) {
    this.count = count;
    this.racingCars = Arrays.stream(names.split(","))
        .map(name -> new RacingCar(name.trim()))
        .collect(Collectors.toList());
  }

  public void play() {

  }

  public List<RacingCar> getWinners() {
    // 1. find max position
    // 2. find all racing cars with position == max position
    return null;
  }

  public int getCount() {
    return count;
  }

  public List<RacingCar> getRacingCars() {
    return racingCars;
  }

  @Override
  public String toString() {
    return "RacingGame{" +
        "count=" + count +
        ", racingCars=" + racingCars +
        '}';
  }
}
