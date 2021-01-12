package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
  private final int CURRENT_LIMIT = 30;
  private final CANSparkMax mMotor = new CANSparkMax(Constants.CLIMBER_MOTOR, MotorType.kBrushless);
  
  public Climber() {
    mMotor.restoreFactoryDefaults();
    mMotor.setMotorType(MotorType.kBrushless);
    mMotor.setInverted(true);
    mMotor.setIdleMode(IdleMode.kBrake);
    mMotor.setSmartCurrentLimit(CURRENT_LIMIT);
    mMotor.enableVoltageCompensation(12.0);
    mMotor.burnFlash();
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
