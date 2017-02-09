package org.usfirst.frc.team4804.robot.subsystems;

import org.usfirst.frc.team4804.robot.Robot;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MecanumPID extends PIDSubsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public double p, i, d;
	public boolean centered = false;
	
	public MecanumPID() {
		super(0.5, 0.0, 0.3); //initial PID constants
		p = getPIDController().getP();
		i = getPIDController().getI();
		d = getPIDController().getD();
		
		getPIDController().setContinuous(false);
		getPIDController().setAbsoluteTolerance(0.01);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
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
    	//Robot.driveTrain.p = p;
    	//Robot.driveTrain.i = i;
    	//Robot.driveTrain.d = d;
    	//Robot.driveTrain.getPIDController().setPID(p, i, d);
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

