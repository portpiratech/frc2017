package org.usfirst.frc.team4804.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	
	// CAN Device IDs (CAN Talon SRX)
	// Drive Train:
	public static final int FRONT_LEFT_ID = 1;
	public static final int REAR_LEFT_ID = 2;
	public static final int FRONT_RIGHT_ID = 3;
	public static final int REAR_RIGHT_ID = 4;
	// Shooter:
	public static final int SHOOTINGDRIVE_ID = 5;
	// Puob ID:
	public static final int PUOB_ID = 6;
	// Becci (climber) IDs:
	public static final int CLIMB_MOTOR_1_ID = 7;
	
	// Other Device IDs
	public static final int ULTRASONIC_ANALOG_ID = 0;

		
	
	// Xbox Controller Information
	// Controller IDs:
	public static final int DRIVER_CONTROLLER_ID = 0;
	public static final int OPERATOR_CONTROLLER_ID = 1;
	// Joysticks [-1,1]:
	public static final int LEFT_STICK_X_AXIS = 0;
	public static final int LEFT_STICK_Y_AXIS = 1;
	public static final int RIGHT_STICK_X_AXIS = 4;
	public static final int RIGHT_STICK_Y_AXIS = 5;
	// Triggers [0,1]:
	public static final int LEFT_TRIGGER_AXIS = 2;
	public static final int RIGHT_TRIGGER_AXIS = 3;
	
	
	
	// Constants / Multipliers / Variables
	// General:
	public static double joystickTolerance = 0.15;
	// DriveTrain:
	public static double driveSpeedMultiplier = 0.3;
	public static double driveSpeedDpadMultiplier = 0.8;
	public static double autoApproachSpeedMultiplier = 0.50;
	public static double distanceToleranceMeters = 0.02;
	public static double distanceSetpointMeters = 0.5;
	// Shooter:
	public static double shooterSpeedMultiplier = -0.75;
	// Picker-Upper Of Balls (PUOB):
	// Ben's Excellent Climber Contraption Ingenious or something (BECCI):
	
	
	
	////
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
