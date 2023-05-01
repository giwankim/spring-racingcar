package racingcar.controller;

import static java.util.stream.Collectors.joining;

import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarGame;

public class RaceResultDto {

  private String winners;
  private List<RacingCar> racingCars;

  private RaceResultDto(String winners, List<RacingCar> racingCars) {
    this.winners = winners;
    this.racingCars = racingCars;
  }

  public static RaceResultDto of(RacingCarGame racingCarGame) {
    String winners = racingCarGame.getWinners()
        .stream()
        .map(RacingCar::getName)
        .collect(joining(", "));
    return new RaceResultDto(winners, racingCarGame.getRacingCars());
  }

  public String getWinners() {
    return winners;
  }

  public void setWinners(String winners) {
    this.winners = winners;
  }

  public List<RacingCar> getRacingCars() {
    return racingCars;
  }

  public void setRacingCars(List<RacingCar> racingCars) {
    this.racingCars = racingCars;
  }
}
