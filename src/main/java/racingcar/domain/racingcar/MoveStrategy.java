package racingcar.domain.racingcar;

@FunctionalInterface
public interface MoveStrategy {
  boolean canMove();
}
