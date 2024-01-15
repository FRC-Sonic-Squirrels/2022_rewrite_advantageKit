package frc.robot.subsystems.intake;

import org.littletonrobotics.junction.LogTable;
import org.littletonrobotics.junction.inputs.LoggableInputs;

public interface IntakeIO {
  /** Contains all of the input data received from hardware. */
  public static class IntakeIOInputs implements LoggableInputs {
    public double velocityRPM = 0.0;

    public void toLog(LogTable table) {
      table.put("velocityRPM", velocityRPM);
    }

    public void fromLog(LogTable table) {
      velocityRPM = table.get("velocityRPM", velocityRPM);
    }
  }

  /** Updates the set of loggable inputs. */
  public default void updateInputs(IntakeIOInputs inputs) {}

  public default void setPercentOut(double percent) {}
}
