package frc.robot;

public final class Constants {
    public static final int DRIVETRAIN_LEFT_MOTOR_1 = 1,    //TalonFX
                            DRIVETRAIN_LEFT_MOTOR_2 = 2,
                            DRIVETRAIN_LEFT_MOTOR_3 = 3,
                            DRIVETRAIN_RIGHT_MOTOR_1 = 4,
                            DRIVETRAIN_RIGHT_MOTOR_2 = 5,
                            DRIVETRAIN_RIGHT_MOTOR_3 = 6;

    public static final int SHOOTER_MOTOR_1 = 7,            //TalonSRX //Encoder
                            HOPPER_MOTOR = 8,                          //Encoder
                            TURRET_MOTOR = 9;

    public static final int SHOOTER_MOTOR_2 = 1;            //VictorSPX

    public static final int CLIMBER_MOTOR = 1,              //SparkMAX //Encoder (Not Used)
                            FEEDER_WHEEL_MOTOR = 2,                    //Encoder
                            INTAKE_MOTOR = 3;

    public static final int COMPRESSOR = 0,                 //Pneumatics Control Module

                            DRIVETRAIN_SHIFTING_SOLENOID_FORWARD = 0,
                            DRIVETRAIN_SHIFTING_SOLENOID_REVERSE = 1,
                            INTAKE_SOLENOID_FORWARD = 2,
                            INTAKE_SOLENOID_REVERSE = 3,
                            GRAPPLER_SOLENOID_FORWARD = 4,
                            GRAPPLER_SOLENOID_REVERSE = 5;

    public static final int TIMEOUT_MS = 30,
                            COUNTS_PER_REVOLUTION_ENCODER = 4096;
    
    public static final double EPSILON = 0.0001,
                               FEEDER_WHEELS_RPM = 3000.0,
                               HOPPER_RPM = 40.0,
                               SHOOTER_RPM = 4250.0;
}
