package org.usfirst.frc.team4804.robot.commands;

import org.usfirst.frc.team4804.robot.OI;
import org.usfirst.frc.team4804.robot.Robot;
import org.usfirst.frc.team4804.robot.RobotMap;
import org.usfirst.frc.team4804.robot.subsystems.BecciSubsystem;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class BecciCommand extends Command {
	
	private XboxController driverController = OI.driverController;
	private BecciSubsystem becci = Robot.becci;
	double motorSpeed = 0;
	
    public BecciCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(becci);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//While X is held, increase the speed. Otherwise, hold speed.
    	while(driverController.getXButton()) {
    		//If motor speed is not yet 100% and the current hasn't spiked (i.e. motor hasn't stalled):
    		if(motorSpeed < 1 && becci.getCurrent() <= RobotMap.maxBecciCurrent) {
    			motorSpeed += 0.001;
    		}
    		becci.startClimb(motorSpeed);
    		
    		SmartDashboard.putNumber("Becci Speed", motorSpeed);
    		SmartDashboard.putNumber("Becci Current (Amps)", becci.getCurrent());
    	}
    	
    	//If Y is pressed, stop the Becci and reset the speed.
    	if(driverController.getYButton()) {
    		motorSpeed = 0;
    		becci.stopClimb();
    	}
    	
    	SmartDashboard.putNumber("Becci Speed", motorSpeed);
    	SmartDashboard.putNumber("Becci Current (Amps)", becci.getCurrent());
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
