package org.usfirst.frc.team4804.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // Controller number
	public static final int DRIVER_CONTROLLER_ID = 0;
	
<<<<<<< HEAD
    // CAN Device IDs
	//RobotMap.FRONT_LEFT_ID, RobotMap.REAR_LEFT_ID, RobotMap.FRONT_RIGHT_ID, RobotMap.REAR_RIGHT_ID
	public static final int FRONT_LEFT_ID = 1;
	public static final int REAR_LEFT_ID = 2;
	public static final int FRONT_RIGHT_ID = 3;
	public static final int REAR_RIGHT_ID = 4;
    //public static final int TANKDRIVE_RIGHT_ID = 6; //CAN Talon SRX
	//public static final int TANKDRIVE_LEFT_ID = 3; //CAN Talon SRX
	public static final int SHOOTINGDRIVE_ID = 5; //CAN Talon SRX
=======
    // CAN Device ID;
    public static final int TANKDRIVE_RIGHT_ID = 1; //CAN Talon SRX
	public static final int TANKDRIVE_LEFT_ID = 2; //CAN Talon SRX
	public static final int SHOOTINGDRIVE_ID = 3; //CAN Talon SRX
	
	// Axis Information
	public static final int LEFT_DRIVE_AXIS = 1;
	public static final int RIGHT_DRIVE_AXIS = 5;
>>>>>>> branch 'master' of https://github.com/portpiratech/frc2017.git

	// Axis Information
	public static final int LEFT_STICK_X_AXIS = 0;
	public static final int LEFT_STICK_Y_AXIS = 1;
	public static final int RIGHT_STICK_X_AXIS = 4;
	public static final int RIGHT_STICK_Y_AXIS = 5;

	public static double shooterSpeed = 0.8;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
