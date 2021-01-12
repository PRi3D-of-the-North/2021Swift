package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Grappler;

public class GrapplerSetState extends CommandBase {

  private boolean mPullPin;
  private final Grappler mGrappler;

  public GrapplerSetState(Grappler grappler, boolean pullPin) {
    mGrappler = grappler;
    mPullPin = pullPin;
    addRequirements(mGrappler);
  }

  @Override
  public void initialize() {
    mGrappler.setPistonState(mPullPin);
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
