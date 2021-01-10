package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

  public class Shooter extends SubsystemBase {
    private final double RAMP_RATE = 0.2;
    private final SupplyCurrentLimitConfiguration CURRENT_LIMIT = new SupplyCurrentLimitConfiguration (true, 40.0, 60.0, 1.0);
    
    private WPI_TalonSRX mMotor1 = new WPI_TalonSRX(Constants.SHOOTER_MOTOR_1);
    private WPI_VictorSPX mMotor2 = new WPI_VictorSPX(Constants.SHOOTER_MOTOR_2);

  public Shooter() {
    mMotor1.configFactoryDefault();
    mMotor2.configFactoryDefault();

    mMotor2.follow(mMotor1);

    mMotor1.setInverted(false);
    mMotor2.setInverted(InvertType.FollowMaster);
  
    mMotor1.setNeutralMode(NeutralMode.Coast);
    mMotor2.setNeutralMode(NeutralMode.Coast);

    mMotor1.configClosedLoopPeakOutput(0, 1.0);
    mMotor2.configClosedLoopPeakOutput(0, 1.0);
  
    mMotor1.configSupplyCurrentLimit(CURRENT_LIMIT);

    mMotor1.configOpenloopRamp(RAMP_RATE);
    mMotor2.configOpenloopRamp(RAMP_RATE);

    mMotor1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, Constants.TIMEOUT_MS);
    mMotor1.setSensorPhase(true);

    mMotor1.config_kF(0, 0.5, Constants.TIMEOUT_MS);
    mMotor1.config_kP(0, 0.0, Constants.TIMEOUT_MS);
		mMotor1.config_kI(0, 0.0, Constants.TIMEOUT_MS);
    mMotor1.config_kD(0, 0.0, Constants.TIMEOUT_MS);

    mMotor1.configVoltageCompSaturation(12.0);
    mMotor1.enableVoltageCompensation(true);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Shooter RMP", getRPM());
    SmartDashboard.putNumber("Shooter Encoder Value", mMotor1.getSelectedSensorPosition());
  }

  public void setPercentOutput(double output) {
    if (output > 1.0) {
      output = 1.0;
    } else if (output < -1.0) {
      output = -1.0;
    }
    
    mMotor1.set(output);
  }

  public void setVelocity(double RPM) {
    int velocityInSRXUnits = (int) (RPM / 600.0 * Constants.COUNTS_PER_REVOLUTION_ENCODER);
    mMotor1.set(ControlMode.Velocity, velocityInSRXUnits);
  }

  public double getRPM() {
    double RPM = mMotor1.getSelectedSensorVelocity() * 600.0 / Constants.COUNTS_PER_REVOLUTION_ENCODER;
    return RPM;
  }
}
