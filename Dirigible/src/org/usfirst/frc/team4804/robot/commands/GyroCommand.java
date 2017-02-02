package org.usfirst.frc.team4804.robot.commands;

import org.usfirst.frc.team4804.robot.Robot;
import org.usfirst.frc.team4804.robot.subsystems.GyroSubsystem;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GyroCommand extends Command {

	private GyroSubsystem gyroSubsystem = Robot.gyro;
	XboxController driverController = Robot.oi.driverController;
	
    public GyroCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(gyroSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (driverController.getBumper(Hand.kLeft)) {
    		gyroSubsystem.reset();
    	}
    	
    	SmartDashboard.putNumber("Gyro Angle: ", gyroSubsystem.getAngle());
    	SmartDashboard.putNumber("Gyro Rate: ", gyroSubsystem.getRate());
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
}
