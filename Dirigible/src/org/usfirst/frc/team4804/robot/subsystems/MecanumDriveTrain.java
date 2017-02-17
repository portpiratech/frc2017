package org.usfirst.frc.team4804.robot.subsystems;

import org.usfirst.frc.team4804.robot.Robot;
import org.usfirst.frc.team4804.robot.RobotMap;
import org.usfirst.frc.team4804.robot.commands.MecanumDriveCommand;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MecanumDriveTrain extends PIDSubsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public RobotDrive drive;
	
	private CANTalon frontLeft = new CANTalon(RobotMap.FRONT_LEFT_ID); 
	private CANTalon rearLeft = new CANTalon(RobotMap.REAR_LEFT_ID);
	private CANTalon frontRight = new CANTalon(RobotMap.FRONT_RIGHT_ID);
	private CANTalon rearRight = new CANTalon(RobotMap.REAR_RIGHT_ID);
	
	public double p, i, d;
	public boolean centered = false;
	
	public MecanumDriveTrain() {
		super(0.5, 0.0, 0.3);
		
		p = getPIDController().getP();
		i = getPIDController().getI();
		d = getPIDController().getD();
		
		getPIDController().setContinuous(false);
		getPIDController().setAbsoluteTolerance(0.01);
		
		//invert  the left side motors so that mecanum works
		frontLeft.setInverted(true);
		rearLeft.setInverted(true);
		
		drive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new MecanumDriveCommand());
    }
    
    public void mecanumDrivePolar(double magnitude, double direction, double rotation){
    	drive.mecanumDrive_Polar(magnitude, direction, rotation);
    }
    
    public void mecanumDriveCartesian(double xSpeed, double ySpeed, double rotation, double gyroAngle) {
    	drive.mecanumDrive_Cartesian(xSpeed, ySpeed, rotation, gyroAngle);
    }
    
    public void stop() {
    	mecanumDrivePolar(0, 0, 0);
    }
    
    public void rotateToAngle(double gyroAngle, double targetAngle) {
    	double rotation;
    	
    	while(Math.abs(targetAngle - gyroAngle) > 2) {
    		// if (targetAngle - gyroAngle > 0) { rotate CCW }
    		// if (targetAngle - gyroAngle < 0) { rotate CW }
    		rotation = RobotMap.driveSpeedMultiplier*(targetAngle - gyroAngle);
    		mecanumDriveCartesian(0, 0, rotation, gyroAngle);
    	}
    }
    
    public void enablePID() {
		getPIDController().enable();
	}
	
	public void enablePID(boolean enable) {
		if(enable) {
			getPIDController().enable();
		} else {
			getPIDController().disable();
		}
	}
	
	//PID constants
	public void setPID(double p, double i, double d) {
    	Robot.driveTrain.p = p;
    	Robot.driveTrain.i = i;
    	Robot.driveTrain.d = d;
    	Robot.driveTrain.getPIDController().setPID(p, i, d);
    }
    
    public void updatePID() {
    	p = SmartDashboard.getNumber("Drive const-Proportional (p)", p);
    	i = SmartDashboard.getNumber("Drive const-Integral (i)", i);
    	d = SmartDashboard.getNumber("Drive const-Derivative (d)", d);
    	setPID(p, i, d);
    }

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub\
		double pidInput = 0;
		return pidInput;
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		
	}
}

