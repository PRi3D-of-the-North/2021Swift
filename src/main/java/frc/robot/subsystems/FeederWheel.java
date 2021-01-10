package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.ControlType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FeederWheel extends SubsystemBase {
  private final int CURRENT_LIMIT = 30;
  private final CANSparkMax mMotor = new CANSparkMax(Constants.FEEDER_WHEEL_MOTOR, MotorType.kBrushless);
  private final CANEncoder mEncoder;
  private final CANPIDController mPIDController;

  public FeederWheel() {
    mMotor.restoreFactoryDefaults();
    mMotor.setMotorType(MotorType.kBrushless);
    mMotor.setInverted(true);
    mMotor.setIdleMode(IdleMode.kBrake);
    mMotor.setSmartCurrentLimit(CURRENT_LIMIT);
    mMotor.enableVoltageCompensation(12.0);

    mEncoder = mMotor.getEncoder();
    mPIDController = mMotor.getPIDController();

    mPIDController.setP(0.0); //TODO Tune
    mPIDController.setI(0.0);
    mPIDController.setD(0.0);
    mPIDController.setFF(0.000015);
    mPIDController.setOutputRange(0.0, 1.0);
    mMotor.burnFlash();
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Feeder Wheel RMP", getRPM());
    SmartDashboard.putNumber("Feeder Wheel Encoder Value", mEncoder.getCountsPerRevolution());
  }

  public void setPercentOutput(double output) {
    if (output > 1.0) {
      output = 1.0;
    } else if (output < -1.0) {
      output = -1.0;
    }

    mMotor.set(output);
  }

  public void setVelocity(double RPM) {
    double RPMAfterGearing = RPM * 3.0;
    SmartDashboard.putNumber("Feeder Wheel Target Velocity", RPMAfterGearing);
    mPIDController.setReference(RPMAfterGearing, ControlType.kVelocity);
  }

  public double getRPM() {
    double RPM = mEncoder.getVelocity() / 3.0;
    return RPM;
  }
}
