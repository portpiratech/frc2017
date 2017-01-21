package org.usfirst.frc.team4804.robot.commands;

import org.usfirst.frc.team4804.robot.OI;
import org.usfirst.frc.team4804.robot.Robot;
import org.usfirst.frc.team4804.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MecanumDriveCommand extends Command {

    public MecanumDriveCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//double leftValue = this.driverController.getRawAxis(RobotMap.LEFT_STICK_Y_AXIS);
    	double leftx = OI.driverController.getRawAxis(RobotMap.LEFT_STICK_X_AXIS);
    	double lefty = OI.driverController.getRawAxis(RobotMap.LEFT_STICK_Y_AXIS);
    	double rightx = OI.driverController.getRawAxis(RobotMap.RIGHT_STICK_X_AXIS);
    	//Above code is just to set up more readable variable names.
    	double magnitude = Math.sqrt(Math.pow(leftx, 2) + Math.pow(lefty,  2));
    	SmartDashboard.putNumber("DriveTrain Magnitude", magnitude);
    	double direction = Math.atan2(lefty, leftx);
    	SmartDashboard.putNumber("Direction", direction);
    	double rotation = rightx;
    	
    	Robot.driveTrain.mecanumDrive(magnitude, direction, rotation);
    	
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
