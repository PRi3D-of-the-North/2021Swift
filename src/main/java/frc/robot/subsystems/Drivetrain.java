package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  private final double RAMP_RATE = 0.3;

  private final WPI_TalonFX mLeftMotor1 = new WPI_TalonFX(Constants.DRIVETRAIN_LEFT_MOTOR_1);
  private final WPI_TalonFX mLeftMotor2 = new WPI_TalonFX(Constants.DRIVETRAIN_LEFT_MOTOR_2);
  private final WPI_TalonFX mLeftMotor3 = new WPI_TalonFX(Constants.DRIVETRAIN_LEFT_MOTOR_3);
  private final WPI_TalonFX mRightMotor1 = new WPI_TalonFX(Constants.DRIVETRAIN_RIGHT_MOTOR_1);
  private final WPI_TalonFX mRightMotor2 = new WPI_TalonFX(Constants.DRIVETRAIN_RIGHT_MOTOR_2);
  private final WPI_TalonFX mRightMotor3 = new WPI_TalonFX(Constants.DRIVETRAIN_RIGHT_MOTOR_3);

  private final DifferentialDrive mDrive = new DifferentialDrive(mLeftMotor1, mRightMotor1);

  public Drivetrain() {
    mLeftMotor1.configFactoryDefault();
    mLeftMotor2.configFactoryDefault();
    mLeftMotor3.configFactoryDefault();
    mRightMotor1.configFactoryDefault();
    mRightMotor2.configFactoryDefault();
    mRightMotor3.configFactoryDefault();

    mLeftMotor2.follow(mLeftMotor1);
    mLeftMotor3.follow(mLeftMotor1);
    mRightMotor2.follow(mRightMotor1);
    mRightMotor3.follow(mRightMotor1);

    mLeftMotor1.setInverted(true);
    mLeftMotor2.setInverted(InvertType.FollowMaster);
    mLeftMotor3.setInverted(InvertType.FollowMaster);
    mRightMotor1.setInverted(false);
    mRightMotor2.setInverted(InvertType.FollowMaster);
    mRightMotor3.setInverted(InvertType.FollowMaster);
  
    mLeftMotor1.setNeutralMode(NeutralMode.Brake);
    mLeftMotor2.setNeutralMode(NeutralMode.Brake);
    mLeftMotor3.setNeutralMode(NeutralMode.Brake);
    mRightMotor1.setNeutralMode(NeutralMode.Brake);
    mRightMotor2.setNeutralMode(NeutralMode.Brake);
    mRightMotor3.setNeutralMode(NeutralMode.Brake);

    mLeftMotor1.configOpenloopRamp(RAMP_RATE);
    mLeftMotor2.configOpenloopRamp(RAMP_RATE);
    mLeftMotor3.configOpenloopRamp(RAMP_RATE);
    mRightMotor1.configOpenloopRamp(RAMP_RATE);
    mRightMotor2.configOpenloopRamp(RAMP_RATE);
    mRightMotor3.configOpenloopRamp(RAMP_RATE);

    mLeftMotor1.configVoltageCompSaturation(12.0);
    mRightMotor1.configVoltageCompSaturation(12.0);

    mLeftMotor1.enableVoltageCompensation(true);
    mRightMotor1.enableVoltageCompensation(true);

    mDrive.setRightSideInverted(false);
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
    
    mDrive.arcadeDrive(move, rotate);
  }

}
