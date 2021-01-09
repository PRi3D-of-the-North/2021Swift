package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.FeederWheel;

public class FeederWheelSetPercentOutput extends CommandBase {

  private double mOutput;
  private final FeederWheel mFeederWheel;

  public FeederWheelSetPercentOutput(FeederWheel feederWheel, double output) {
    mFeederWheel = feederWheel;
    mOutput = output;
    addRequirements(mFeederWheel);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    mFeederWheel.setPercentOutput(mOutput);
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}