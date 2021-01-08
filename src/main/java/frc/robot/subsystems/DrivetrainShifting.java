package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DrivetrainShifting extends SubsystemBase {
  private Solenoid mPistons = new Solenoid(Constants.DRIVETRAIN_SHIFTING_SOLENOID);

  public DrivetrainShifting() {
  }

  @Override
  public void periodic() {
  }

  public void setPistonsState (boolean highGear) {
    if (highGear) {
      mPistons.set(false);
    } else {
      mPistons.set(true);
    }
  }
}
