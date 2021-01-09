package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Hopper extends SubsystemBase {
  private WPI_TalonSRX mMotor = new WPI_TalonSRX(Constants.HOPPER_MOTOR);
  
  public Hopper() {
    mMotor.configFactoryDefault();
    mMotor.setInverted(false);
    mMotor.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void periodic() {
  }

  public void setPercentOutput(double output) {
    if (output > 1.0) {
      output = 1.0;
    } else if (output < -1.0) {
      output = -1.0;
    }

    mMotor.set(output);
  }
}
