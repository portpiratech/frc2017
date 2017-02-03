package org.usfirst.frc.team4804.robot.commands;

import org.usfirst.frc.team4804.robot.OI;
import org.usfirst.frc.team4804.robot.Robot;
import org.usfirst.frc.team4804.robot.RobotMap;
import org.usfirst.frc.team4804.robot.subsystems.GyroSubsystem;
import org.usfirst.frc.team4804.robot.subsystems.MecanumDriveTrain;
import org.usfirst.frc.team4804.robot.subsystems.UltrasonicSubsystem;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MecanumDriveCommand extends Command {
	
	private MecanumDriveTrain driveTrain = Robot.driveTrain;
	private GyroSubsystem gyro = Robot.gyro;
	private UltrasonicSubsystem ultrasonic = Robot.ultrasonic;
	private XboxController driverController = OI.driverController;
	
	boolean polarControl = false;
	
    public MecanumDriveCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(driveTrain);
    	requires(gyro);
    	requires(ultrasonic);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Update multipliers from smartdashboard
    	RobotMap.driveSpeedMultiplier = SmartDashboard.getNumber("DriveTrain Speed Mult", RobotMap.driveSpeedMultiplier);
    	RobotMap.driveSpeedDpadMultiplier = SmartDashboard.getNumber("DriveTrain Dpad Mult", RobotMap.driveSpeedDpadMultiplier);
    	RobotMap.joystickTolerance = SmartDashboard.getNumber("Joystick Tolerance", RobotMap.joystickTolerance);
    	RobotMap.distanceToleranceMeters = SmartDashboard.getNumber("Distance Tolerance", RobotMap.distanceToleranceMeters);
    	RobotMap.autoApproachSpeedMultiplier = SmartDashboard.getNumber("DriveTrain Auto Approach Mult", RobotMap.autoApproachSpeedMultiplier);
    	
    	double magnitude, direction, rotation;
    	double xSpeed, ySpeed;
    	
    	int dpad = driverController.getPOV();
    	double leftx = driverController.getRawAxis(RobotMap.LEFT_STICK_X_AXIS);
    	double lefty = driverController.getRawAxis(RobotMap.LEFT_STICK_Y_AXIS);
    	double rightx = driverController.getRawAxis(RobotMap.RIGHT_STICK_X_AXIS);
    	double gyroAngle = gyro.getAngle();
    	//Above code is just to set up more readable variable names.
    	
    	//Gyro reset
    	if (driverController.getBumper(Hand.kLeft)) {
    		gyro.reset();
    	}
    	
    	//Read gyro
    	SmartDashboard.putNumber("Gyro Angle: ", gyro.getAngle());
    	SmartDashboard.putNumber("Gyro Rate: ", gyro.getRate());
    	
    	//Read ultrasonic
    	double voltage = ultrasonic.getVoltage();
    	SmartDashboard.putNumber("Ultrasonic Voltage", voltage);
    	SmartDashboard.putNumber("Ultrasonic Average Voltage", ultrasonic.getAverageVoltage());
    	SmartDashboard.putNumber("Ultrasonic Distance", ultrasonic.getDistance());
    	
    	//This is currently really messy. It'll need to be cleaned up eventually
    	if(driverController.getYButton()) {
    		RobotMap.distanceSetpointMeters = SmartDashboard.getNumber("Distance Setpoint", RobotMap.distanceSetpointMeters);
    		driveForwardToDistance(RobotMap.distanceSetpointMeters);
    	} else if(dpad == -1) {
    		// Dpad not pressed
    		if(polarControl) {
    			// Mecanum drive polar using left joystick
		    	magnitude = RobotMap.driveSpeedMultiplier * Math.sqrt(Math.pow(leftx, 2) + Math.pow(lefty,  2));
		    	magnitude = checkTolerance(magnitude, RobotMap.joystickTolerance);
		    	SmartDashboard.putNumber("DriveTrain Magnitude", magnitude);
		    	
		    	direction = Math.toDegrees(Math.atan2(lefty, leftx) + Math.PI/2); //Adds pi/2 to establish the proper "forward"
		    	direction = checkTolerance(direction, RobotMap.joystickTolerance);
		    	SmartDashboard.putNumber("DriveTrain Direction", direction);
		    	
		    	rotation = RobotMap.driveSpeedMultiplier * rightx;
		    	rotation = checkTolerance(rotation, RobotMap.joystickTolerance);
		    	SmartDashboard.putNumber("DriveTrain Rotation", rotation);
		    	
		    	driveTrain.mecanumDrivePolar(magnitude, direction, rotation);
    		} else {
    			// Mecanum drive cartesian using left joystick + gyro feed
	    		xSpeed = leftx * RobotMap.driveSpeedMultiplier;
	    		xSpeed = checkTolerance(xSpeed, RobotMap.joystickTolerance);
	    		SmartDashboard.putNumber("DriveTrain Speed X", xSpeed);
	    		
	    		ySpeed = lefty * RobotMap.driveSpeedMultiplier;
	    		ySpeed = checkTolerance(ySpeed, RobotMap.joystickTolerance);
	    		SmartDashboard.putNumber("DriveTrain Speed Y", ySpeed);
	    		
	    		rotation = rightx * RobotMap.driveSpeedMultiplier;
	    		rotation = checkTolerance(rotation, RobotMap.joystickTolerance);
	    		SmartDashboard.putNumber("DriveTrain Rotation", rotation);
	    		
	    		driveTrain.mecanumDriveCartesian(xSpeed, ySpeed, rotation, gyroAngle);
    		}
    	} else if(dpad != -1) {
    		// Dpad pressed
    		magnitude = RobotMap.driveSpeedMultiplier * RobotMap.driveSpeedDpadMultiplier;
    		SmartDashboard.putNumber("DriveTrain Magnitude", magnitude);
    		
    		direction = dpad;
    		SmartDashboard.putNumber("DriveTrain Direction", direction);
    		
    		rotation = RobotMap.driveSpeedMultiplier * rightx;
        	rotation = checkTolerance(rotation, RobotMap.joystickTolerance);
        	SmartDashboard.putNumber("DriveTrain Rotation", rotation);
        	
        	driveTrain.mecanumDrivePolar(magnitude, direction, rotation);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    private double checkTolerance(double input, double tolerance) {
    	double output;
    	
    	if (Math.abs(input) < tolerance) {
    		output = 0.0;
    	} else {
    		output = input;
    	}
    	
    	return output;
    }
    
    void driveForwardToDistance(double distanceMeters) {
    	//Drive to distance, within a certain tolerance, ONLY while button is pressed
    	while(ultrasonic.getDistance() - distanceMeters > RobotMap.distanceToleranceMeters && driverController.getYButton()) {
    		double speed = - RobotMap.driveSpeedMultiplier * (ultrasonic.getDistance() - distanceMeters) * RobotMap.autoApproachSpeedMultiplier;
    		// Speed is negated because the ultrasonic is mounted opposite to the front of the robot.
    		
    		driveTrain.mecanumDrivePolar(speed, 0, 0);
    	}
    	
    	driveTrain.stop();
    }
}
