package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCarGame {

  private static final Random RANDOM = new Random();
  private final List<RacingCar> racingCars;
  private final int rounds;

  public RacingCarGame(String names, int count) {
    this.rounds = count;
    this.racingCars = Arrays.stream(names.split(","))
        .map(name -> new RacingCar(name.trim()))
        .collect(Collectors.toUnmodifiableList());
  }

  public void play() {
    IntStream.range(0, rounds).forEach(i -> playRound());
  }

  private void playRound() {
    racingCars.forEach(racingCar -> racingCar.move(RANDOM.nextInt(10)));
  }

  public List<RacingCar> getWinners() {
    int winnerPosition = getWinnerPosition();
    return racingCars.stream()
        .filter(racingCar -> racingCar.isPosition(winnerPosition))
        .collect(Collectors.toUnmodifiableList());
  }

  private int getWinnerPosition() {
    OptionalInt winnerPositionOptional = racingCars.stream()
        .mapToInt(RacingCar::getPosition)
        .max();
    if (winnerPositionOptional.isEmpty()) {
      throw new NoSuchElementException();
    }
    return winnerPositionOptional.getAsInt();
  }

  public List<RacingCar> getRacingCars() {
    return racingCars;
  }
}
