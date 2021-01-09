package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Grappler extends SubsystemBase {
  private final DoubleSolenoid mPiston = new DoubleSolenoid(Constants.GRAPPLER_SOLENOID_FORWARD, Constants.GRAPPLER_SOLENOID_REVERSE);

  public Grappler() {
  }

  @Override
  public void periodic() {
  }

  public void setPistonState(boolean pullPin) {
    if (pullPin) {
      mPiston.set(Value.kReverse);
    } else {
      mPiston.set(Value.kForward);
    }
  }
}
