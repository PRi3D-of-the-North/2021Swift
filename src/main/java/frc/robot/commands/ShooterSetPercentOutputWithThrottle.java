package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class ShooterSetPercentOutputWithThrottle extends CommandBase {

  private Joystick mJoystick;
  private final Shooter mShooter;

  public ShooterSetPercentOutputWithThrottle(Shooter shooter, Joystick joystick) {
    mShooter = shooter;
    mJoystick = joystick;
    addRequirements(mShooter);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    double mSpeed = (-mJoystick.getRawAxis(3) + 1.0) / 2.0; //1 to -1 --> 0 to 1
    
    mShooter.setPercentOutput(mSpeed);
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}