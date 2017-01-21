package org.usfirst.frc.team4804.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4804.robot.OI;
import org.usfirst.frc.team4804.robot.Robot;
import org.usfirst.frc.team4804.robot.RobotMap;

/**
 *
 */
public class JoystickDriveCommand extends Command {

	private XboxController driverController;
    public JoystickDriveCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
        driverController = OI.driverController;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double leftValue = this.driverController.getRawAxis(RobotMap.LEFT_STICK_Y_AXIS);
    	double rightValue = this.driverController.getRawAxis(RobotMap.RIGHT_STICK_Y_AXIS);
 //   	Robot.driveTrain.joystickDrive(leftValue, rightValue);
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
