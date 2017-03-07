package org.usfirst.frc.team4804.robot.commands;

import org.usfirst.frc.team4804.robot.Robot;
import org.usfirst.frc.team4804.robot.RobotMap;
import org.usfirst.frc.team4804.robot.subsystems.GyroSubsystem;
import org.usfirst.frc.team4804.robot.subsystems.MecanumDriveTrain;
import org.usfirst.frc.team4804.robot.subsystems.UltrasonicSubsystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDriveForward extends Command {

	private MecanumDriveTrain driveTrain = Robot.driveTrain;
	private GyroSubsystem gyro = Robot.gyro;
	private UltrasonicSubsystem ultrasonic = Robot.ultrasonic;
	
	double offsetDegrees;
	double timeSeconds;
	double distanceMeters;
	
	/**
	 * @param timeSeconds		Time to drive forward at constant speed
	 * @param distanceMeters	Distance set-point from wall (set negative to ignore)
	 */
    public AutoDriveForward(double timeSeconds, double distanceMeters) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(driveTrain);
    	requires(gyro);
    	requires(ultrasonic);
    	
    	this.timeSeconds = timeSeconds;
    	this.distanceMeters = distanceMeters;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	driveTrain.mecanumDriveCartesian(0.0, RobotMap.driveSpeedMultiplier, 0.0, gyro.getAngle() + offsetDegrees);
    	Timer.delay(timeSeconds);
    	
    	driveTrain.stop();
    	
    	driveForwardToDistance(distanceMeters);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    void driveForwardToDistance(double distanceMeters) {
    	//Drive to distance, within a certain tolerance
    	while(ultrasonic.getDistance() - distanceMeters > RobotMap.distanceToleranceMeters) {
    		double speed = - RobotMap.driveSpeedMultiplier * (ultrasonic.getDistance() - distanceMeters) * RobotMap.autoApproachSpeedMultiplier;
    		// Speed is negated because the ultrasonic is mounted opposite to the front of the robot.
    		
    		driveTrain.mecanumDrivePolar(speed, offsetDegrees, 0);
    	}
    	
    	driveTrain.stop();
    }
}
