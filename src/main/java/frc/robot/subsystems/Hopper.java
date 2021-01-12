package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Hopper extends SubsystemBase {
  private final WPI_TalonSRX mMotor = new WPI_TalonSRX(Constants.HOPPER_MOTOR);
  private final DigitalInput mLimit = new DigitalInput(Constants.HOPPER_LIMIT_SWITCH);
  
  public Hopper() {
    mMotor.configFactoryDefault();
    mMotor.setInverted(false);
    mMotor.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void periodic() {
    SmartDashboard.putBoolean("Hopper Limit Switch", getLimit());
  }

  public void setPercentOutput(double output) {
    if (output > 1.0) {
      output = 1.0;
    } else if (output < -1.0) {
      output = -1.0;
    }

    mMotor.set(output);
  }

  public boolean getLimit() {
    return !mLimit.get();
  }
}
