package frc.robot.commands.automated;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Units;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.FeederWheel;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Turret;

public class AimingAndShooting extends CommandBase {

  private final Limelight mLimelight;
  private final FeederWheel mFeederWheel;
  private final Shooter mShooter;
  private final Turret mTurret;
  private Joystick mJoystick;
  private double mFeederWheelRPM;

  private final double kPTurret = 0.02; // TODO TUNE
  private final double kHeightOfInnerGoalInches = 98.25;
  private final double kHeightOfLimelightInches = 0.0; // TODO TUNE
  private final double kAngleOfLimelightDegrees = 0.0; // TODO TUNE

  public AimingAndShooting(Limelight limelight, FeederWheel feederWheel, Shooter shooter, Turret turret, Joystick joystick, double feederWheelRPM) {
    mLimelight = limelight;
    mFeederWheel = feederWheel;
    mShooter = shooter;
    mTurret = turret;
    mJoystick = joystick;
    mFeederWheelRPM = feederWheelRPM;
    addRequirements(mLimelight, mFeederWheel, mShooter, mTurret);
  }

  @Override
  public void initialize() {
    mLimelight.setCamMode(0);
    mLimelight.setPipeline(1);
    mLimelight.setLEDMode(3);
  }

  @Override
  public void execute() {
    double tv = mLimelight.getTv();

    if (tv == 1) {
      boolean mOnTarget;
      boolean mFeederWheelAtRPM;
      boolean mShooterAtRPM;
      double mTurretMove;
      double mShooterTargetRPM;
      double tx = mLimelight.getTx();
      double ty = mLimelight.getTy();
      double distanceToGoal = ((kHeightOfInnerGoalInches - kHeightOfLimelightInches) / (Math.tan(Units.degreesToRadians(kAngleOfLimelightDegrees + ty)))); 

      if (Math.abs(tx) < 0.5) {
        mOnTarget = true;
        mTurretMove = 0.0;
      } else if (mTurret.getLeftLimit() && mTurret.getMotorOutputVoltage() > Constants.EPSILON) { //TODO Check direction
        mOnTarget = false;
        mTurretMove = 0.0;
      } else if (mTurret.getRightLimit() && mTurret.getMotorOutputVoltage() < -Constants.EPSILON) {
        mOnTarget = false;
        mTurretMove = 0.0;
      } else {
        mOnTarget = false;
        mTurretMove = kPTurret * tx;
      }

      mShooterTargetRPM = -1; //TODO Make equation with distanceToGoal as a variable (graph)

      if ((mShooterTargetRPM - 50.0) < mShooter.getRPM() && (mShooterTargetRPM + 50) > mShooter.getRPM()) {
        mShooterAtRPM = true;
      } else {
        mShooterAtRPM = false;
      }

      if ((mFeederWheelRPM - 50.0) < mFeederWheel.getRPM() && (mShooterTargetRPM + 50) > mShooter.getRPM()) {
        mFeederWheelAtRPM = true;
      } else {
        mFeederWheelAtRPM = false;
      }

      SmartDashboard.putBoolean("Turret In Line", mOnTarget);
      SmartDashboard.putBoolean("Feeder Wheel At RPM", mFeederWheelAtRPM);
      SmartDashboard.putBoolean("Shooter At RPM", mShooterAtRPM);

      mTurret.setPercentOutput(mTurretMove);
      mShooter.setVelocity(mShooterTargetRPM);
    } else {
      double mTurretMove = mJoystick.getRawAxis(2);
      double mSpeed = (-mJoystick.getRawAxis(3) + 1.0) / 2.0; //1 to -1 --> 0 to 1
    
      if (mTurret.getLeftLimit() && mTurret.getMotorOutputVoltage() > Constants.EPSILON) { //TODO Check direction
        mTurretMove = 0.0;
      } else if (mTurret.getRightLimit() && mTurret.getMotorOutputVoltage() < -Constants.EPSILON) {
        mTurretMove = 0.0;
      } else if (mTurretMove < 0.15 && mTurretMove > -0.15) {
        mTurretMove = 0.0;
      }

      mTurret.setPercentOutput(mTurretMove);
      mShooter.setPercentOutput(mSpeed);
      }
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}