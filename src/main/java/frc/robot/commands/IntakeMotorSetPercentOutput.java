package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeMotor;

public class IntakeMotorSetPercentOutput extends CommandBase {

  private double mOutput;
  private final IntakeMotor mIntakeMotor;

  public IntakeMotorSetPercentOutput(IntakeMotor intakeMotor, double output) {
    mIntakeMotor = intakeMotor;
    mOutput = output;
    addRequirements(mIntakeMotor);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    mIntakeMotor.setPercentOutput(mOutput);
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}