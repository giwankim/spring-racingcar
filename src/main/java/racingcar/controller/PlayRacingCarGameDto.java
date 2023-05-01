package racingcar.controller;

public class PlayRacingCarGameDto {

  private String names;
  private int count;

  public PlayRacingCarGameDto(String names, int count) {
    this.names = names;
    this.count = count;
  }

  public String getNames() {
    return names;
  }

  public void setNames(String names) {
    this.names = names;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }
}
