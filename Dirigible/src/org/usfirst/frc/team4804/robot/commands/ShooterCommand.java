package org.usfirst.frc.team4804.robot.commands;

import org.usfirst.frc.team4804.robot.Robot;
import org.usfirst.frc.team4804.robot.RobotMap;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ShooterCommand extends Command {

	XboxController controller = new XboxController(RobotMap.DRIVER_CONTROLLER_ID);
	
    public ShooterCommand() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	double distance = Robot.shooter.getDistance();
    	
    	SmartDashboard.putNumber("In getA", 0);
    	SmartDashboard.putNumber("In getY", 0);
    	SmartDashboard.putNumber("Range", distance);
    	
    	if(controller.getAButton()) {
    		double speed = SmartDashboard.getNumber("Shooter Speed", RobotMap.shooterSpeedMultiplier);
    		Robot.shooter.shoot(speed);
    		SmartDashboard.putNumber("In getA", speed);
    	}
    	
    	if(controller.getBButton()) {
    		Robot.shooter.stop();
    		
    	}
    	
    	/*if(controller.getYButton()) {
    		double speed = SmartDashboard.getNumber("Speed", RobotMap.shooterSpeedMultiplier);
    		//Robot.shooter.setSpeed(speed);
    		SmartDashboard.putNumber("In getY", speed);
    	}*/
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
