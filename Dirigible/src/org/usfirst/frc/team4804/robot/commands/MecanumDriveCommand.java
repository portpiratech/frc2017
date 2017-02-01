package org.usfirst.frc.team4804.robot.commands;

import org.usfirst.frc.team4804.robot.OI;
import org.usfirst.frc.team4804.robot.Robot;
import org.usfirst.frc.team4804.robot.RobotMap;
import org.usfirst.frc.team4804.robot.subsystems.GyroSubsystem;
import org.usfirst.frc.team4804.robot.subsystems.MecanumDriveTrain;
import org.usfirst.frc.team4804.robot.subsystems.UltrasonicSubsystem;

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
    	
    	double magnitude, direction, rotation;
    	
    	int dpad = driverController.getPOV();
    	double leftx = driverController.getRawAxis(RobotMap.LEFT_STICK_X_AXIS);
    	double lefty = driverController.getRawAxis(RobotMap.LEFT_STICK_Y_AXIS);
    	double rightx = driverController.getRawAxis(RobotMap.RIGHT_STICK_X_AXIS);
    	//Above code is just to set up more readable variable names.
    	
    	if(dpad == -1) {
	    	magnitude = RobotMap.driveSpeedMultiplier * Math.sqrt(Math.pow(leftx, 2) + Math.pow(lefty,  2));
	    	magnitude = checkTolerance(magnitude, RobotMap.joystickTolerance);
	    	SmartDashboard.putNumber("DriveTrain Magnitude", magnitude);
	    	
	    	direction = Math.toDegrees(Math.atan2(lefty, leftx) + Math.PI/2); //Adds pi/2 to establish the proper "forward"
	    	direction = checkTolerance(direction, RobotMap.joystickTolerance);
	    	SmartDashboard.putNumber("DriveTrain Direction", direction);
    	} else {
    		magnitude = RobotMap.driveSpeedMultiplier * RobotMap.driveSpeedDpadMultiplier;
    		SmartDashboard.putNumber("DriveTrain Magnitude", magnitude);
    		
    		direction = dpad;
    		SmartDashboard.putNumber("DriveTrain Direction", direction);
    	}
    	
    	rotation = RobotMap.driveSpeedMultiplier * rightx;
    	rotation = checkTolerance(rotation, RobotMap.joystickTolerance);
    	SmartDashboard.putNumber("DriveTrain Rotation", rotation);
    	
    	driveTrain.mecanumDrivePolar(magnitude, direction, rotation);
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
    	if (Math.abs(input) < tolerance) {
    		return 0;
    	} else {
    		return input;
    	}
    }
    
    void driveForwardToDistance(double distanceMeters) {
    	while(ultrasonic.getAverageVoltage() - distanceMeters < 0.2) { //drive to within 20 cm
    		double speed = RobotMap.driveSpeedMultiplier * (ultrasonic.getAverageVoltage() - distanceMeters) * 0.4;
    		driveTrain.mecanumDriveCartesian(0, speed, 0, gyro.getAngle());
    	}
    	
    }
}
