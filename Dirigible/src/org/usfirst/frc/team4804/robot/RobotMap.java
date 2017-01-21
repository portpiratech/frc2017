package org.usfirst.frc.team4804.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // Controller ID number
	public static final int DRIVER_CONTROLLER_ID = 0;
	
	
	// CAN Device IDs
	//Drive Train:
	public static final int FRONT_LEFT_ID = 1;
	public static final int REAR_LEFT_ID = 2;
	public static final int FRONT_RIGHT_ID = 3;
	public static final int REAR_RIGHT_ID = 4;
	//Shooter:
	public static final int SHOOTINGDRIVE_ID = 5; //CAN Talon SRX

		
	
	// Xbox Controller Axis Information
	public static final int LEFT_STICK_X_AXIS = 0;
	public static final int LEFT_STICK_Y_AXIS = 1;
	public static final int RIGHT_STICK_X_AXIS = 4;
	public static final int RIGHT_STICK_Y_AXIS = 5;

	public static final double JOYSTICK_TOLERANCE = 0.05;
	
	// Shooter
	public static double shooterSpeed = 0.8;
    
	
	//Constants / Multipliers
	public static final double DRIVE_SPEED_MULTIPLIER = 0.3;
	
	
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
