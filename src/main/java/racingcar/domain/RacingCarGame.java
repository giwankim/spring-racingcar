package racingcar.domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.domain.racingcar.MoveStrategy;
import racingcar.domain.racingcar.RacingCar;

public class RacingCarGame {

  private final List<RacingCar> racingCars;
  private final int rounds;

  public RacingCarGame(List<RacingCar> racingCars, int rounds) {
    this.racingCars = racingCars;
    this.rounds = rounds;
  }

  public static RacingCarGame of(List<String> driverNames, int rounds) {
    List<RacingCar> racingCars = driverNames.stream()
        .map(RacingCar::new)
        .collect(Collectors.toList());
    return new RacingCarGame(racingCars, rounds);
  }

  public void play(MoveStrategy moveStrategy) {
    IntStream.range(0, rounds).forEach(i -> playRound(moveStrategy));
  }

  private void playRound(MoveStrategy moveStrategy) {
    racingCars.forEach(racingCar -> racingCar.move(moveStrategy));
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
