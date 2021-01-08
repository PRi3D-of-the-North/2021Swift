package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  private final double RAMP_RATE = 0.3;

  private final WPI_TalonFX leftMotor1 = new WPI_TalonFX(Constants.DRIVETRAIN_LEFT_MOTOR_1);
  private final WPI_TalonFX leftMotor2 = new WPI_TalonFX(Constants.DRIVETRAIN_LEFT_MOTOR_2);
  private final WPI_TalonFX leftMotor3 = new WPI_TalonFX(Constants.DRIVETRAIN_LEFT_MOTOR_3);
  private final WPI_TalonFX rightMotor1 = new WPI_TalonFX(Constants.DRIVETRAIN_RIGHT_MOTOR_1);
  private final WPI_TalonFX rightMotor2 = new WPI_TalonFX(Constants.DRIVETRAIN_RIGHT_MOTOR_2);
  private final WPI_TalonFX rightMotor3 = new WPI_TalonFX(Constants.DRIVETRAIN_RIGHT_MOTOR_3);

  private DifferentialDrive drive = new DifferentialDrive(leftMotor1, rightMotor1);

  public Drivetrain() {
    leftMotor1.configFactoryDefault();
    leftMotor2.configFactoryDefault();
    leftMotor3.configFactoryDefault();
    rightMotor1.configFactoryDefault();
    rightMotor2.configFactoryDefault();
    rightMotor3.configFactoryDefault();

    leftMotor2.follow(leftMotor1);
    leftMotor3.follow(leftMotor1);
    rightMotor2.follow(rightMotor1);
    rightMotor3.follow(rightMotor1);

    leftMotor1.setInverted(true);
    leftMotor2.setInverted(InvertType.FollowMaster);
    leftMotor3.setInverted(InvertType.FollowMaster);
    rightMotor1.setInverted(false);
    rightMotor2.setInverted(InvertType.FollowMaster);
    rightMotor3.setInverted(InvertType.FollowMaster);
  
    leftMotor1.setNeutralMode(NeutralMode.Brake);
    leftMotor2.setNeutralMode(NeutralMode.Brake);
    leftMotor3.setNeutralMode(NeutralMode.Brake);
    rightMotor1.setNeutralMode(NeutralMode.Brake);
    rightMotor2.setNeutralMode(NeutralMode.Brake);
    rightMotor3.setNeutralMode(NeutralMode.Brake);

    leftMotor1.configOpenloopRamp(RAMP_RATE);
    leftMotor2.configOpenloopRamp(RAMP_RATE);
    leftMotor3.configOpenloopRamp(RAMP_RATE);
    rightMotor1.configOpenloopRamp(RAMP_RATE);
    rightMotor2.configOpenloopRamp(RAMP_RATE);
    rightMotor3.configOpenloopRamp(RAMP_RATE);

    leftMotor1.configVoltageCompSaturation(12.0);
    rightMotor1.configVoltageCompSaturation(12.0);

    leftMotor1.enableVoltageCompensation(true);
    rightMotor1.enableVoltageCompensation(true);

    drive.setRightSideInverted(false);
  }

  @Override
  public void periodic() {
  }

  public void arcadeDrive(double move, double rotate) {
    final double MIN_MOVE_THRESHOLD = 0.07;
    final double MIN_ROTATE_THRESHOLD = 0.07;

    if (Math.abs(move) < MIN_MOVE_THRESHOLD)
      move = 0.0;

    if (Math.abs(rotate) < MIN_ROTATE_THRESHOLD)
      rotate = 0.0;
    
    drive.arcadeDrive(move, rotate);
  }

}
