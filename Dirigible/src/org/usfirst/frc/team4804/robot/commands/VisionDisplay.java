/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team4804.robot.commands;
import org.usfirst.frc.team4804.robot.OI;
import org.usfirst.frc.team4804.robot.Robot;
//import org.usfirst.frc.team4804.robot.subsystems.VisionSubsystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;


public class VisionDisplay extends Command {
    
	XboxController driver = OI.driverController;
	boolean visionProcessing = true;
	boolean primed = true;
	boolean called = true;
	
    public VisionDisplay() {
        requires(Robot.vision);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.vision.frameAutoDisplay();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//call a method once after toggling
        /*if(!called) {
        	if(visionProcessing) {
        		Timer.delay(0.1);
        		Robot.vision.frameProcess();
        	} else {
        		Robot.vision.frameAutoDisplay();
        	}
        }
        called = true;
        
        //toggle algorithm; press start button to toggle
        if (driver.getStartButton()){
        	if (primed){
        		visionProcessing = !visionProcessing;
        		called = false;
        	}
        	primed = false;
        }else{
        	primed = true;
        }*/ //replace with visionthread?
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false; // Runs until interrupted, Xbox controller determines when finished
    }

    // Called once after isFinished returns true
    protected void end() {
        //Robot.pistonSubsystem.stopArms();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
