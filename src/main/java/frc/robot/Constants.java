package frc.robot;

public final class Constants {
    public static final int DRIVETRAIN_LEFT_MOTOR_1 = 1,    //TalonFX
                            DRIVETRAIN_LEFT_MOTOR_2 = 2,
                            DRIVETRAIN_LEFT_MOTOR_3 = 3,
                            DRIVETRAIN_RIGHT_MOTOR_1 = 4,
                            DRIVETRAIN_RIGHT_MOTOR_2 = 5,
                            DRIVETRAIN_RIGHT_MOTOR_3 = 6;

    public static final int SHOOTER_MOTOR_1 = 7,            //TalonSRX //Encoder
                            HOPPER_MOTOR = 8,
                            TURRET_MOTOR = 9;

    public static final int SHOOTER_MOTOR_2 = 1;            //VictorSPX

    public static final int CLIMBER_MOTOR = 1,              //SparkMAX //Encoder (Not Used)
                            FEEDER_WHEEL_MOTOR = 2,               //Encoder
                            INTAKE_MOTOR = 3;

    public static final int TURRET_LEFT_LIMIT = 0,          //DIO
                            TURRET_RIGHT_LIMIT = 1,
                            HOPPER_LIMIT_SWITCH = 2;

    public static final int COMPRESSOR = 0,                 //Pneumatics Control Module

                            DRIVETRAIN_SHIFTING_SOLENOID_FORWARD = 0,
                            DRIVETRAIN_SHIFTING_SOLENOID_REVERSE = 1,
                            GRAPPLER_SOLENOID_FORWARD = 2,
                            GRAPPLER_SOLENOID_REVERSE = 3,
                            INTAKE_SOLENOID_FORWARD = 4,
                            INTAKE_SOLENOID_REVERSE = 5;

    public static final int TIMEOUT_MS = 30,
                            COUNTS_PER_REVOLUTION_ENCODER_SRX = 4096,
                            COUNTS_PER_REVOLUTION_ENCODER_MAX = 42;
    
    public static final double EPSILON = 0.0001,
                               FEEDER_WHEELS_RPM = 3000.0; //TODO Tune #
}
