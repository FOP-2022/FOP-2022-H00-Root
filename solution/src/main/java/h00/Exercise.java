package h00;

import static fopbot.Direction.*;

import java.util.concurrent.ThreadLocalRandom;

import fopbot.Robot;
import fopbot.World;

public class Exercise {

  /**
   * @return a random boolean value
   */
  public static boolean getRandomBoolean() {
    return ThreadLocalRandom.current().nextBoolean();
  }

  public static void main(String[] args) {
    final int worldSize = 5;
    World.setSize(worldSize, worldSize);
    World.setDelay(200);
    World.setVisible(true);
    final boolean shouldPutCoin = getRandomBoolean();
    final String message = shouldPutCoin ? "Es soll eine Münze gelegt werden" : "Es soll keine Münze gelegt werden";
    System.out.println(message);
    doExercise(shouldPutCoin);
  }

  /**
   *
   * @param shouldPutCoin a coin should be put at the bottom left position, iff this is true
   *
   */
  public static void doExercise(final boolean shouldPutCoin) {
    Robot r = new Robot(4, 4, UP, 1);
    // TODO H00 Implement your solution here:
    for (int i = 0; i < 2; i++) {
      r.turnLeft();
      for (int j = 0; j < 4; j++) r.move();
    }
    r.turnLeft();
    r.turnLeft();
    if (shouldPutCoin) r.putCoin();
  }
}
