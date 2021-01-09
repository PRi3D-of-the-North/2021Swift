package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DrivetrainShifting extends SubsystemBase {
  private final DoubleSolenoid mPistons = new DoubleSolenoid(Constants.DRIVETRAIN_SHIFTING_SOLENOID_FORWARD, Constants.DRIVETRAIN_SHIFTING_SOLENOID_REVERSE);

  public DrivetrainShifting() {
  }

  @Override
  public void periodic() {
  }

  public void setPistonsState(boolean highGear) {
    if (highGear) {
      mPistons.set(Value.kReverse);
    } else {
      mPistons.set(Value.kForward);
    }
  }
}
