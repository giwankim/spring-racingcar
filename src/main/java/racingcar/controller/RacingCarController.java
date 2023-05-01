package racingcar.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import racingcar.domain.RacingCarGame;
import racingcar.service.RacingCarGameService;

@RestController
public class RacingCarController {

  private final RacingCarGameService racingCarGameService;

  public RacingCarController(RacingCarGameService racingCarGameService) {
    this.racingCarGameService = racingCarGameService;
  }

  @PostMapping(value = "plays")
  public ResponseEntity<RaceResultDto> plays(
      @RequestBody PlayRacingCarGameDto playRacingCarGameDto) {
    RacingCarGame racingCarGame = racingCarGameService.play(
        playRacingCarGameDto.getNames(),
        playRacingCarGameDto.getCount());
    return ResponseEntity.ok()
        .body(RaceResultDto.of(racingCarGame));
  }
}
