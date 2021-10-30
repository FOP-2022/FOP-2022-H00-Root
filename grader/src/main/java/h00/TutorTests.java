package h00;

import fopbot.*;
import org.junit.jupiter.api.Test;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;

import java.util.ArrayList;

import static h00.Exercise.doExercise;
import static org.junit.jupiter.api.Assertions.*;

@TestForSubmission("h00")
public class TutorTests {

  private void setupWorld() {
    World.reset();
    World.setSize(5, 5);
    World.setDelay(0);
    World.setVisible(false);
  }

  public Field getFinalState(boolean b) {
    setupWorld();
    doExercise(b);
    final var states = World.getGlobalWorld().getEntityStates();
    assertNotNull(states);
    assertTrue(states.size() > 0);
    return states.get(states.size() - 1);
  }

  public Robot getRobotInFinalState(final boolean b) {
    final var endState = getFinalState(b);
    var robots = new ArrayList<Robot>();
    for (final var fieldEntity : endState) {
      if (fieldEntity instanceof Robot) {
        robots.add((Robot) fieldEntity);
      }
    }
    assertEquals(1, robots.size(), "Am Ende ist nicht genau ein Roboter vorhanden");
    return robots.get(0);
  }

  public void finalPositionCorrect(boolean b) {
    final var r = getRobotInFinalState(b);
    assertEquals(0, r.getX(), "X-Koordinate des Roboters inkorrekt");
    assertEquals(0, r.getY(), "Y-Koordinate des Roboters inkorrekt");
  }

  public void finalPositionAndDirectionCorrect(boolean b) {
    final var r = getRobotInFinalState(b);
    assertEquals(0, r.getX(), "X-Koordinate des Roboters inkorrekt");
    assertEquals(0, r.getY(), "Y-Koordinate des Roboters inkorrekt");
    assertEquals(Direction.UP, r.getDirection(), "Blickrichtung des Roboters inkorrekt");
  }

  @Test
  public void finalPositionCorrectWithTrue() {
    finalPositionCorrect(true);
  }

  @Test
  public void finalPositionCorrectWithFalse() {
    finalPositionCorrect(false);
  }

  @Test
  public void finalPositionAndDirectionCorrectWithTrue() {
    finalPositionAndDirectionCorrect(true);
  }

  @Test
  public void finalPositionAndDirectionCorrectWithFalse() {
    finalPositionAndDirectionCorrect(false);
  }

  @Test
  public void coinPlacementDecisionCorrectWithTrue() {
    final var finalState = getFinalState(true);
    var coins = new ArrayList<Coin>();
    for (final var fieldEntity : finalState) {
      if (fieldEntity instanceof Coin) {
        coins.add((Coin) fieldEntity);
      }
    }
    assertEquals(1, coins.size(), "Anzahl der Münzen im Endzustand inkorrekt für shouldPutCoin == true");
  }

  @Test
  public void coinPlacementDecisionCorrectWithFalse() {
    final var finalState = getFinalState(false);
    for (final var fieldEntity : finalState) {
      if (fieldEntity instanceof Coin) {
        fail("Im Endzustand liegt eine Münze, obwohl shouldPutCoin == false");
      }
    }
  }

  @Test
  public void coinPositionCorrect() {
    final var finalState = getFinalState(true);
    var coins = new ArrayList<Coin>();
    for (final var fieldEntity : finalState) {
      if (fieldEntity instanceof Coin) {
        coins.add((Coin) fieldEntity);
      }
    }
    assertEquals(1, coins.size(), "Anzahl der Münzen im Endzustand inkorrekt für shouldPutCoin == true");
    assertEquals(0, coins.get(0).getX(), "X-Koordinate der Münze inkorrekt");
    assertEquals(0, coins.get(0).getY(), "Y-Koordinate der Münze inkorrekt");
  }
}
