package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase {
  
  private NetworkTable mTable = NetworkTableInstance.getDefault().getTable("limelight");
  
  public Limelight() {
  }

  @Override
  public void periodic() {
  }

  public NetworkTable getLimelightTable() {
    return mTable;
  }

  /**
   * -29.8 to 29.8 degrees
   * 
   * @return Target X Value
   */
  public double getTx() {
    return mTable.getEntry("tx").getDouble(0.0);
  }

  /**
   * -24.85 to 24.85 degrees
   * 
   * @return Target Y Value
   */
  public double getTy() {
    return mTable.getEntry("ty").getDouble(0.0);
  }

  /**
   * 0 if not valid target or 1 if valid target
   * 
   * @return Valid Target Value
   */
  public double getTv() { //0 or 1
    return mTable.getEntry("tv").getDouble(0.0);
  }

  /**
   * 0 to 9
   * 
   * @return Current Pipeline Value
   */
  public double getPipe() { //0 to 9
    return mTable.getEntry("getpipe").getDouble(0.0);
  }

  /**
   * 0: Use current pipline mode
   * 1: Force off
   * 2: Force blink
   * 3: Force on
   * 
   * @param value
   */
  public void setLEDMode(int value) { //0 to 3
    mTable.getEntry("ledMode").setNumber(value);
  }

  /**
   * 0: Vision Processing
   * 1: Drivers Mode
   * 
   * @param value
   */
  public void setCamMode(int value) { //0 or 1
    mTable.getEntry("camMode").setNumber(value);
  }

  /**
   * 0 to 9
   * 
   * @param value
   */
  public void setPipeline(int value) { //0 to 9
    mTable.getEntry("pipeline").setNumber(value);
  }
}