package racingcar.service;

import org.springframework.stereotype.Service;
import racingcar.domain.RacingCarGame;

@Service
public class RacingCarGameService {
  public RacingCarGame play(String names, int rounds) {
    RacingCarGame racingCarGame = new RacingCarGame(names, rounds);
    racingCarGame.play();
    return racingCarGame;
  }
}
