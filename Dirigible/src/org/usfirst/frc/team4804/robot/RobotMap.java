package org.usfirst.frc.team4804.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	/* CAN Device IDs (CAN Talon SRX) */
	// Drive Train:
	public static final int FRONT_LEFT_ID = 2; //2;
	public static final int REAR_LEFT_ID = 3; //1;
	public static final int FRONT_RIGHT_ID = 0; //6;
	public static final int REAR_RIGHT_ID = 1; //7;
	// Shooter:
	public static final int SHOOTINGDRIVE_ID = 5;
	// Puob ID:
	public static final int PUOB_ID = 4;
	// Becci (climber) IDs:
	public static final int CLIMB_MOTOR_1_ID = 63; //3;
	
	
	/* Other Device IDs */
	public static final int ULTRASONIC_ANALOG_ID = 0; //Analog In [0,3]
	public static final int AGITATOR_RELAY_ID = 0; //PWM (Spike Relay) [0,9]
	public static final int BALLGATE_SERVO_ID = 0; //PWM (Servo) [0,9]
	public static final int SWITCH_1 = 1; //Digital IO
	public static final int SWITCH_2 = 2; //Digital IO
	public static final int SWITCH_3 = 3; //Digital IO
		
	
	/* Xbox Controller Information */
	// Controller IDs:
	public static final int DRIVER_CONTROLLER_ID = 0;
	public static final int OPERATOR_CONTROLLER_ID = 1;
	// Joysticks; output [-1,1]:
	public static final int LEFT_STICK_X_AXIS = 0;
	public static final int LEFT_STICK_Y_AXIS = 1;
	public static final int RIGHT_STICK_X_AXIS = 4;
	public static final int RIGHT_STICK_Y_AXIS = 5;
	// Triggers; output [0,1]:
	public static final int LEFT_TRIGGER_AXIS = 2;
	public static final int RIGHT_TRIGGER_AXIS = 3;
	
	
	/* Constants, Multipliers, & Variables */
	// General:
	public static double joystickTolerance = 0.15;
	// DriveTrain:
	public static double driveSpeedMultiplier = 1.0;
	public static double driveSpeedDpadMultiplier = 0.8;
	public static double autoApproachSpeedMultiplier = 0.50;
	public static double distanceToleranceMeters = 0.02;
	public static double distanceSetpointMeters = 0.5;
	// Shooter:
	public static double shooterSpeedMultiplier = -1.0;
	public static double agitatorSpeedMultiplier = 0.16; //"We are going at 16 speed"
	public static double servoUpPos = 90; //need to fine-tune
	public static double servoDownPos = 0;
	// Picker-Upper Of Balls (PUOB):
	public static double puobSpeed = 1.0;
	// Ben's Excellent Climber Contraption Ingenious (BECCI):
	public static double becciSpeedMultiplier = 1.0;
	public static double maxBecciCurrent = 300000000; //Amperes
	
	
    
	////
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
