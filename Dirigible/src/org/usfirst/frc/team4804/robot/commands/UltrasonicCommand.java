package org.usfirst.frc.team4804.robot.commands;

import java.text.DecimalFormat;

import org.usfirst.frc.team4804.robot.Robot;
import org.usfirst.frc.team4804.robot.subsystems.UltrasonicSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class UltrasonicCommand extends Command {

	private UltrasonicSubsystem ultrasonic = Robot.ultrasonic;
	
    public UltrasonicCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(ultrasonic);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double voltage = ultrasonic.getVoltage();
    	SmartDashboard.putNumber("Ultrasonic Voltage", voltage);
    	SmartDashboard.putNumber("Ultrasonic Average Voltage", ultrasonic.getAverageVoltage());
    	SmartDashboard.putNumber("Ultrasonic Distance", ultrasonic.getDistance());
    	
    	double distance = ultrasonic.getDistance();
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
