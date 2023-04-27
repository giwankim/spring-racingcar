package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceResult {

  private final String winners;
  private final List<RacingCar> racingCars;

  public RaceResult(String winners, List<RacingCar> racingCars) {
    this.winners = winners;
    this.racingCars = racingCars;
  }

  public static RaceResult of(RacingGame racingGame) {
    // TODO: implement
    return new RaceResult("", new ArrayList<>());
  }

  public String getWinners() {
    return winners;
  }

  public List<RacingCar> getRacingCars() {
    return racingCars;
  }
}
