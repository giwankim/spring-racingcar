package racingcar.domain;

public class RacingCar {

  private final String name;
  private int position;

  public RacingCar(String name) {
    this(name, 0);
  }

  public RacingCar(String name, int position) {
    this.name = name;
    this.position = position;
  }

  public void move(int randomNumber) {
    if (randomNumber >= 4) {
      this.position += 1;
    }
  }

  public boolean isPosition(int position) {
    return this.position == position;
  }

  public String getName() {
    return name;
  }

  public int getPosition() {
    return position;
  }

  @Override
  public String toString() {
    return String.format("RacingCar{name='%s', position=%d}", name, position);
  }
}
