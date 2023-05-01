package racingcar.controller;

import static java.util.stream.Collectors.joining;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.RacingCarGame;
import racingcar.domain.racingcar.RacingCar;

public class RaceResultDto {

  public static final String COMMA_SPACE_DELIMITER = ", ";
  private String winners;
  private List<RacingCarDto> racingCars;

  private RaceResultDto(String winners, List<RacingCarDto> racingCars) {
    this.winners = winners;
    this.racingCars = racingCars;
  }

  public static RaceResultDto of(RacingCarGame racingCarGame) {
    String winners = racingCarGame.getWinners().stream().map(RacingCar::getName)
        .collect(joining(COMMA_SPACE_DELIMITER));
    List<RacingCarDto> racingCars = racingCarGame.getRacingCars().stream().map(RacingCarDto::new)
        .collect(Collectors.toList());
    return new RaceResultDto(winners, racingCars);
  }

  public String getWinners() {
    return winners;
  }

  public void setWinners(String winners) {
    this.winners = winners;
  }

  public List<RacingCarDto> getRacingCars() {
    return racingCars;
  }

  public void setRacingCars(List<RacingCarDto> racingCars) {
    this.racingCars = racingCars;
  }

  private static class RacingCarDto {

    private String name;
    private int position;

    public RacingCarDto(String name, int position) {
      this.name = name;
      this.position = position;
    }

    public RacingCarDto(RacingCar racingCar) {
      this(racingCar.getName(), racingCar.getPosition());
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getPosition() {
      return position;
    }

    public void setPosition(int position) {
      this.position = position;
    }
  }
}
