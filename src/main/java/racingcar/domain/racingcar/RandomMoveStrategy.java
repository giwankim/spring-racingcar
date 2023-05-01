package racingcar.domain.racingcar;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

  private static final int MAX_BOUND = 10;
  private static final int MOVE_THRESHOLD = 4;
  private static final Random RANDOM = new Random();

  @Override
  public boolean canMove() {
    return RANDOM.nextInt(MAX_BOUND) >= MOVE_THRESHOLD;
  }
}
