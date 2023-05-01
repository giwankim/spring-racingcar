package racingcar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import racingcar.domain.racingcar.MoveStrategy;
import racingcar.domain.racingcar.RandomMoveStrategy;

@Configuration
public class RandomMoveConfig {

  @Bean
  public MoveStrategy moveStrategy() {
    return new RandomMoveStrategy();
  }
}
