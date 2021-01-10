package frc.robot.commands.automated;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hopper;

public class HopperSpinToLimit extends CommandBase {

  private double mOutput;
  private final Hopper mHopper;

  public HopperSpinToLimit(Hopper hopper, double output) {
    mHopper = hopper;
    mOutput = output;
    addRequirements(mHopper);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (mHopper.getLimit()) {
      mOutput = 0.0;
    }
    
    mHopper.setPercentOutput(mOutput);
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}