package racingcar;

public class RacingCar {
  private final String name;
  private int position;

  public RacingCar(String name) {
    this(name, 0);
  }

  private RacingCar(String name, int position) {
    this.name = name;
    this.position = position;
  }

  public static RacingCar of(String name, int position) {
    return new RacingCar(name, position);
  }

  public String getName() {
    return name;
  }

  public int getPosition() {
    return position;
  }

  public void move(int randomNumber) {
    if (randomNumber >= 4) {
      this.position += 1;
    }
  }

  @Override
  public String toString() {
    return "RacingCar{" +
        "name='" + name + '\'' +
        ", position=" + position +
        '}';
  }
}
