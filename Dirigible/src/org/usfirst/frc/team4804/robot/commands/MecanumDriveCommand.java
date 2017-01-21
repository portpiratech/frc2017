package org.usfirst.frc.team4804.robot.commands;

import org.usfirst.frc.team4804.robot.OI;
import org.usfirst.frc.team4804.robot.Robot;
import org.usfirst.frc.team4804.robot.RobotMap;
import org.usfirst.frc.team4804.robot.subsystems.MecanumDriveTrain;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MecanumDriveCommand extends Command {
	
	private MecanumDriveTrain driveTrain = Robot.driveTrain;
	private XboxController driverController = OI.driverController;
	
    public MecanumDriveCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//double leftValue = this.driverController.getRawAxis(RobotMap.LEFT_STICK_Y_AXIS);
    	double leftx = driverController.getRawAxis(RobotMap.LEFT_STICK_X_AXIS);
    	double lefty = driverController.getRawAxis(RobotMap.LEFT_STICK_Y_AXIS);
    	double rightx = driverController.getRawAxis(RobotMap.RIGHT_STICK_X_AXIS);
    	//Above code is just to set up more readable variable names.
    	double magnitude = RobotMap.DRIVE_SPEED_MULTIPLIER * Math.sqrt(Math.pow(leftx, 2) + Math.pow(lefty,  2));
    	magnitude = checkTolerance(magnitude, RobotMap.JOYSTICK_TOLERANCE);
    	SmartDashboard.putNumber("DriveTrain Magnitude", magnitude);
    	double direction = Math.toDegrees(Math.atan2(lefty, leftx) + Math.PI/2); //Adds pi/2 to establish the proper "forward"
    	SmartDashboard.putNumber("Direction", direction);
    	double rotation = RobotMap.DRIVE_SPEED_MULTIPLIER * rightx;
    	SmartDashboard.putNumber("Rotation", rotation);
    	
    	int dpad = driverController.getPOV();
    	
    	if(dpad != -1) {
    		switch(dpad) {
    		case 0:
    			break;
    		case 45:
    			break;
    		case 90:
    			break;
    		case 135:
    			break;
    		case 180:
    			break;
    		case 225:
    			break;
    		case 270:
    			break;
    		case 315:
    			break;
    		}
    	}
    	
    	driveTrain.mecanumDrive(magnitude, direction, rotation);
    	
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
    
    private double checkTolerance(double input, double tolerance){
    	if (Math.abs(input) < tolerance){
    		return 0;
    	}else{
    		return input;
    	}
    }
}
