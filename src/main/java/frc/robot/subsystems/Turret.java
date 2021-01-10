package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Turret extends SubsystemBase {
  private final WPI_TalonSRX mMotor = new WPI_TalonSRX(Constants.TURRET_MOTOR);
  private final DigitalInput mLeftLimit = new DigitalInput(Constants.TURRET_LEFT_LIMIT);;
  private final DigitalInput mRightLimit = new DigitalInput(Constants.TURRET_RIGHT_LIMIT);

  public Turret() {
    mMotor.configFactoryDefault();
    mMotor.setInverted(false);
    mMotor.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void periodic() {
    SmartDashboard.putBoolean("Turret Left Limit", getLeftLimit());
    SmartDashboard.putBoolean("Turret Right Limit", getRightLimit());
  }

  public boolean getLeftLimit() {
    return !mLeftLimit.get();
  }

  public boolean getRightLimit() {
    return !mRightLimit.get();
  }

  public void setPercentOutput(double output) {
    if (output > 1.0) {
      output = 1.0;
    } else if (output < -1.0) {
      output = -1.0;
    }

    mMotor.set(output);
  }

  public double getMotorOutputVoltage() {
    return mMotor.getMotorOutputVoltage();
  }
}
