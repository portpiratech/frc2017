package org.usfirst.frc.team4804.robot.commands;

import org.usfirst.frc.team4804.robot.OI;
import org.usfirst.frc.team4804.robot.Robot;
import org.usfirst.frc.team4804.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ShooterCommand extends Command {

	XboxController operatorController = OI.operatorController;
	
	boolean buttonPressed; //for servo
	boolean reversed; //for shooter reverse
	
    public ShooterCommand() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.shooter);
    	requires(Robot.servo);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute(){
    	
    	if(operatorController.getAButton()) {
    		reversed = false;
    		
    		double shooterSpeed = SmartDashboard.getNumber("Shooter Speed", RobotMap.shooterSpeedMultiplier);
    		Robot.shooter.startShooter(shooterSpeed);
    		
    		double agitatorSpeed = SmartDashboard.getNumber("Agitator Speed", RobotMap.agitatorSpeedMultiplier);
    		Robot.shooter.startAgitator();
    		
    		//Timer.delay(1);
    		//Robot.servo.dropGate();
    	}
    	
    	if(operatorController.getBButton()) {
    		reversed = false;
    		//Robot.servo.closeGate();
    		Robot.shooter.stopShooter();
    		Robot.shooter.stopAgitator();
    		
    		//Robot.servo.liftGate();
    	}
    	
    	if(operatorController.getStartButton()) {
    		//Robot.servo.liftGate();
    	}
    	
    	if(operatorController.getBackButton()) {
    		//Robot.servo.closeGate();
    		reversed = true;
    		Robot.shooter.reverseShooter();
    	} else if (!operatorController.getBackButton() && reversed == true) {
    		reversed = false;
    		Robot.shooter.stopShooter();
    	}
    	
    	if(operatorController.getXButton()) {
    		buttonPressed = true;
    		Robot.servo.reverseGate();
    	} else if(operatorController.getYButton()) {
    		buttonPressed = true;
    		Robot.servo.liftGate();
    	} else if(operatorController.getTriggerAxis(Hand.kRight) > 0.15) {
    		buttonPressed = false;
    		Robot.servo.dropGate(operatorController.getTriggerAxis(Hand.kRight));
    	} else if(operatorController.getTriggerAxis(Hand.kRight) <= 0.15 && buttonPressed == false) {
    		Robot.servo.liftGate();
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
