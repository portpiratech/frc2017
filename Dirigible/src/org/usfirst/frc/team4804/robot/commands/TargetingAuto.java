package org.usfirst.frc.team4804.robot.commands;

import org.usfirst.frc.team4804.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Switch the robot into auto targeting mode
 */
public class TargetingAuto extends Command {
	
	boolean finished = false;
	boolean autonomous = false;
	double secs, startTimeMs;
	
    public TargetingAuto() {
    	requires(Robot.driveTrain);
    }
    
    public TargetingAuto(double seconds) {
    	requires(Robot.driveTrain);
    	
    	autonomous = true;
    	secs = seconds;
    	startTimeMs = System.currentTimeMillis();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.vision.enableProcessing(); //make sure vision processing is enabled
    	
    	Robot.driveTrain.enablePID(true);
	    SmartDashboard.putNumber("Drive const-Proportional (p)", Robot.driveTrain.p);
	    SmartDashboard.putNumber("Drive const-Integral (i)", Robot.driveTrain.i);
	    SmartDashboard.putNumber("Drive const-Derivative (d)", Robot.driveTrain.d);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.updatePID();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(autonomous && System.currentTimeMillis() - startTimeMs >= 1000*secs) {
    		finished = true;
    	}
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	cancel();
    	end();
    }
}
