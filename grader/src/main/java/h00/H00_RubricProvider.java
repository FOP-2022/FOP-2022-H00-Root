package h00;

import org.sourcegrade.jagr.api.rubric.*;

@RubricForSubmission("h00")
public class H00_RubricProvider implements RubricProvider {

  public static final Criterion finalPositionCorrect = Criterion.builder()
    .shortDescription("Die Endposition des Robotors ist immer exakt korrekt.")
    .grader(
      Grader.testAwareBuilder()
        .requirePass(JUnitTestRef.ofMethod(() -> TutorTests.class.getMethod("finalPositionCorrectWithTrue")))
        .requirePass(JUnitTestRef.ofMethod(() -> TutorTests.class.getMethod("finalPositionCorrectWithFalse")))
        .pointsPassedMax()
        .pointsFailedMin()
        .build()
    ).build();

  public static final Criterion finalPositionAndDirectionCorrect = Criterion.builder()
    .shortDescription("Die Endposition und die Blickrichtung des Robotors ist immer exakt korrekt.")
    .grader(
      Grader.testAwareBuilder()
        .requirePass(JUnitTestRef.ofMethod(() -> TutorTests.class.getMethod("finalPositionAndDirectionCorrectWithTrue")))
        .requirePass(JUnitTestRef.ofMethod(() -> TutorTests.class.getMethod("finalPositionAndDirectionCorrectWithFalse")))
        .pointsPassedMax()
        .pointsFailedMin()
        .build()
    ).build();

  public static final Criterion coinPlacementDecisionCorrect = Criterion.builder()
    .shortDescription("Es wird immer korrekt entschieden, ob eine Münze gelegt wird.")
    .grader(
      Grader.testAwareBuilder()
        .requirePass(JUnitTestRef.ofMethod(() -> TutorTests.class.getMethod("coinPlacementDecisionCorrectWithTrue")))
        .requirePass(JUnitTestRef.ofMethod(() -> TutorTests.class.getMethod("coinPlacementDecisionCorrectWithFalse")))
        .pointsPassedMax()
        .pointsFailedMin()
        .build()
    ).build();

  public static final Criterion coinPositionCorrect = Criterion.builder()
    .shortDescription("Die Münze wird an der korrekten Stelle platziert.")
    .grader(
      Grader.testAwareBuilder()
        .requirePass(JUnitTestRef.ofMethod(() -> TutorTests.class.getMethod("coinPositionCorrect")))
        .pointsPassedMax()
        .pointsFailedMin()
        .build()
    ).build();

  public static final Criterion H3 = Criterion.builder()
    .shortDescription("H3 Erste Schritte mit FOPBot")
    .addChildCriteria(finalPositionCorrect, finalPositionAndDirectionCorrect, coinPlacementDecisionCorrect, coinPositionCorrect)
    .build();

  public static final Rubric RUBRIC = Rubric.builder()
    .title("H00")
    .addChildCriteria(H3)
    .build();

  @Override
  public Rubric getRubric() {
    return RUBRIC;
  }
}
