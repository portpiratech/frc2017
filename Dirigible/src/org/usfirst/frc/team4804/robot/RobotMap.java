package org.usfirst.frc.team4804.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	
	// CAN Device IDs
	// Drive Train:
	public static final int FRONT_LEFT_ID = 1;
	public static final int REAR_LEFT_ID = 2;
	public static final int FRONT_RIGHT_ID = 3;
	public static final int REAR_RIGHT_ID = 4;
	// Shooter:
	public static final int SHOOTINGDRIVE_ID = 5; //CAN Talon SRX

		
	
	// Xbox Controller Information
	// Controller IDs:
	public static final int DRIVER_CONTROLLER_ID = 0;
	// Joysticks [-1,1]:
	public static final int LEFT_STICK_X_AXIS = 0;
	public static final int LEFT_STICK_Y_AXIS = 1;
	public static final int RIGHT_STICK_X_AXIS = 4;
	public static final int RIGHT_STICK_Y_AXIS = 5;
	// Triggers: [0,1]:
	public static final int LEFT_TRIGGER_AXIS = 2;
	public static final int RIGHT_TRIGGER_AXIS = 3;
    
	
	// Constants / Multipliers / Variables
	// General:
	public static double joystickTolerance = 0.15;
	// DriveTrain:
	public static double driveSpeedMultiplier = 0.3;
	public static double driveSpeedDpadMultiplier = 0.8;
	// Shooter:
	public static double shooterSpeedMultiplier = 0.8;
	// Picker-Upper Of Balls (PUOB):
	
	
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
