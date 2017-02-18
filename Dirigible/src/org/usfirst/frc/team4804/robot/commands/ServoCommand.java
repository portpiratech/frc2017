package org.usfirst.frc.team4804.robot.commands;

import org.usfirst.frc.team4804.robot.OI;
import org.usfirst.frc.team4804.robot.Robot;
import org.usfirst.frc.team4804.robot.subsystems.ServoSubsystem;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ServoCommand extends Command {

	private ServoSubsystem servo = Robot.servo;
	private XboxController operatorController = OI.operatorController;
	
	boolean alreadyToggled = false;
	
    public ServoCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(servo);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	while(operatorController.getStartButton()) {
    		//servo.liftGate();
    		alreadyToggled = true;
    	}
    	if(alreadyToggled) {
    		//servo.closeGate();
    		alreadyToggled = false;
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
