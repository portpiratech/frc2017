package org.usfirst.frc.team4804.robot.commands;

import org.usfirst.frc.team4804.robot.OI;
import org.usfirst.frc.team4804.robot.Robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PuobCommand extends Command {

	
	private XboxController operatorController = OI.operatorController;
	private boolean motorOn;
	
    public PuobCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.puob);
    	motorOn = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Toggle motor
    	if (operatorController.getBumper(Hand.kLeft)) {
    		motorOn = true;
    	} else if (operatorController.getBumper(Hand.kRight)) {
    		motorOn = false;
    	}
    	
    	if (motorOn) {
    		Robot.puob.startPuob(1);
    	} else {
    		Robot.puob.startPuob(0);
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
}
