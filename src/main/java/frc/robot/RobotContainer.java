package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ClimberSetPercentOutput;
import frc.robot.commands.DrivetrainArcadeDrive;
import frc.robot.commands.DrivetrainShiftingSetState;
import frc.robot.commands.FeederWheelSetPercentOutput;
import frc.robot.commands.GrapplerSetState;
import frc.robot.commands.HopperSetPercentOutput;
import frc.robot.commands.IntakeMotorSetPercentOutput;
import frc.robot.commands.IntakePistonsSetState;
import frc.robot.commands.LimelightDriversMode;
import frc.robot.commands.ShooterSetPercentOutput;
import frc.robot.commands.ShooterSetPercentOutputWithThrottle;
import frc.robot.commands.TurretSetPercentOutputWithJoystick;
import frc.robot.commands.automated.AimingAndShooting;
import frc.robot.commands.automated.HopperSpinToLimit;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.DrivetrainShifting;
import frc.robot.subsystems.FeederWheel;
import frc.robot.subsystems.Grappler;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.IntakeMotor;
import frc.robot.subsystems.IntakePistons;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Turret;

public class RobotContainer {
	private final XboxController mXbox = new XboxController(0);
	private final Joystick mJoystick = new Joystick(1);
	private final Climber mClimber = new Climber();
	private final Drivetrain mDrivetrain = new Drivetrain();
	private final DrivetrainShifting mDrivetrainShifting = new DrivetrainShifting();
	private final FeederWheel mFeederWheel = new FeederWheel();
	private final Grappler mGrappler = new Grappler();
	private final Hopper mHopper = new Hopper();
	private final IntakeMotor mIntakeMotor = new IntakeMotor();
	private final IntakePistons mIntakePistons = new IntakePistons();
	private final Limelight mLimelight = new Limelight();
	private final Shooter mShooter = new Shooter();
	private final Turret mTurret = new Turret();

	public RobotContainer() {
		mClimber.setDefaultCommand(new ClimberSetPercentOutput(mClimber, 0.0));
		mDrivetrain.setDefaultCommand(new DrivetrainArcadeDrive(mDrivetrain, mXbox));
		mDrivetrainShifting.setDefaultCommand(new DrivetrainShiftingSetState(mDrivetrainShifting, true));
		mFeederWheel.setDefaultCommand(new FeederWheelSetPercentOutput(mFeederWheel, 0.0));
		mGrappler.setDefaultCommand(new GrapplerSetState(mGrappler, false));
		mHopper.setDefaultCommand(new HopperSpinToLimit(mHopper, 0.4));
		mIntakeMotor.setDefaultCommand(new IntakeMotorSetPercentOutput(mIntakeMotor, 0.0));
		mIntakePistons.setDefaultCommand(new IntakePistonsSetState(mIntakePistons, true));
		mLimelight.setDefaultCommand(new LimelightDriversMode(mLimelight));
		mShooter.setDefaultCommand(new ShooterSetPercentOutput(mShooter, 0.0));
		mTurret.setDefaultCommand(new TurretSetPercentOutputWithJoystick(mTurret, mJoystick));

		configureButtonBindings();

		UsbCamera cam0 = CameraServer.getInstance().startAutomaticCapture(0);
		cam0.setResolution(320, 240);
		cam0.setFPS(10);
	}

	private void configureButtonBindings() {
		JoystickButton xButtonA, xButtonB, xButtonX, xButtonY, xButtonLeftBumper, xButtonRightBumper, xButtonLeftStick,
				xButtonRightStick;
		JoystickButton jButton1, jButton2, jButton3, jButton4, jButton5, jButton6, jButton7, jButton8, jButton9,
				jButton10, jButton11, jButton12;

		xButtonA = new JoystickButton(mXbox, 1);
		xButtonB = new JoystickButton(mXbox, 2);
		xButtonX = new JoystickButton(mXbox, 3);
		xButtonY = new JoystickButton(mXbox, 4);
		xButtonLeftBumper = new JoystickButton(mXbox, 5);
		xButtonRightBumper = new JoystickButton(mXbox, 6);
		xButtonLeftStick = new JoystickButton(mXbox, 9);
		xButtonRightStick = new JoystickButton(mXbox, 10);

		jButton1 = new JoystickButton(mJoystick, 1);
		jButton2 = new JoystickButton(mJoystick, 2);
		jButton3 = new JoystickButton(mJoystick, 3);
		jButton4 = new JoystickButton(mJoystick, 4);
		jButton5 = new JoystickButton(mJoystick, 5);
		jButton6 = new JoystickButton(mJoystick, 6);
		jButton7 = new JoystickButton(mJoystick, 7);
		jButton8 = new JoystickButton(mJoystick, 8);
		jButton9 = new JoystickButton(mJoystick, 9);
		jButton10 = new JoystickButton(mJoystick, 10);
		jButton11 = new JoystickButton(mJoystick, 11);
		jButton12 = new JoystickButton(mJoystick, 12);

		xButtonA.whenPressed(new DrivetrainShiftingSetState(mDrivetrainShifting, false));
		xButtonB.whenPressed(new DrivetrainShiftingSetState(mDrivetrainShifting, true));

		jButton1.whileHeld(new HopperSetPercentOutput(mHopper, 0.75));
		jButton2.whileHeld(new AimingAndShooting(mLimelight, mFeederWheel, mShooter, mTurret, mJoystick, Constants.FEEDER_WHEELS_RPM)); //TODO 

		jButton3.whileHeld(new HopperSetPercentOutput(mHopper, -0.5));
		jButton4.whileHeld(new HopperSetPercentOutput(mHopper, 0.5));
		jButton5.whileHeld(new IntakeMotorSetPercentOutput(mIntakeMotor, -0.8));
		jButton6.whileHeld(new IntakeMotorSetPercentOutput(mIntakeMotor, 0.8));
		jButton7.whenPressed(new IntakePistonsSetState(mIntakePistons, false));
		jButton8.whenPressed(new IntakePistonsSetState(mIntakePistons, true));

		jButton11.whenPressed(new GrapplerSetState(mGrappler, true));
		jButton12.whileHeld(new ClimberSetPercentOutput(mClimber, 1.0));
	}
}
