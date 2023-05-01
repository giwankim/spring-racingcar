package racingcar.service;

import java.util.List;
import org.springframework.stereotype.Service;
import racingcar.domain.RacingCarGame;
import racingcar.domain.racingcar.MoveStrategy;

@Service
public class RacingCarGameService {

  private final MoveStrategy moveStrategy;

  public RacingCarGameService(MoveStrategy moveStrategy) {
    this.moveStrategy = moveStrategy;
  }

  public RacingCarGame play(List<String> driverNames, int rounds) {
    RacingCarGame racingCarGame = RacingCarGame.of(driverNames, rounds);
    racingCarGame.play(this.moveStrategy);
    return racingCarGame;
  }
}
