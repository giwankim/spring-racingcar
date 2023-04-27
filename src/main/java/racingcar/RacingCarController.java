package racingcar;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RacingCarController {

  @PostMapping(value = "plays")
  public ResponseEntity<RaceResult> plays(@RequestBody PlayRacingCarGameDto playRacingCarGameDto) {
    RacingGame racingGame = new RacingGame(playRacingCarGameDto.getNames(),
        playRacingCarGameDto.getCount());
    racingGame.play();
    return ResponseEntity.ok()
        .body(new RaceResult("워니",
            List.of(RacingCar.of("워니", 9), RacingCar.of("제이슨", 7), RacingCar.of("브라운", 3))));
  }
}
