package racingcar.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import racingcar.domain.RacingCarGame;
import racingcar.service.RacingCarGameService;
import utils.StringUtils;

@RestController
public class RacingCarController {

  private final RacingCarGameService racingCarGameService;

  public RacingCarController(RacingCarGameService racingCarGameService) {
    this.racingCarGameService = racingCarGameService;
  }

  @PostMapping(value = "plays")
  public ResponseEntity<RaceResultDto> plays(
      @RequestBody PlayRacingCarGameDto playRacingCarGameDto) {
    List<String> driverNames = StringUtils.split(playRacingCarGameDto.getNames());
    int rounds = playRacingCarGameDto.getCount();
    RacingCarGame racingCarGame = racingCarGameService.play(driverNames, rounds);
    return ResponseEntity.ok().body(RaceResultDto.of(racingCarGame));
  }
}
