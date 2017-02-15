package org.usfirst.frc.team4804.robot.subsystems;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team4804.robot.commands.VisionDisplay;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The DriveTrain subsystem incorporates the sensors and actuators attached to
 * the robots chassis. These include four drive motors, a left and right encoder
 * and a gyro.
 */
public class VisionSubsystem extends Subsystem {
	
	public double cameraHeightMeters = 0.2; //relative to floor
	
	public static boolean visionProcessing;
	//long lastFrameProcessTimeMs;
	//long captureIntervalMs;
	
	public VisionSubsystem() {
		visionProcessing = false;
//		lastFrameProcessTimeMs = 0;
//		captureIntervalMs = 200;
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new VisionDisplay());
	}

	/**
	 * The log method puts interesting information to the SmartDashboard.
	 */ 
	public void log() {
	}
	
	UsbCamera camera;
	CvSink cvSink;
	CvSource outputStream;
	Mat source;
	Mat output;
	
	public void cameraInit() {
		camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setResolution(640, 480);
		
		cvSink = CameraServer.getInstance().getVideo();
		outputStream = CameraServer.getInstance().putVideo("Blur", 640, 480);
	
		source = new Mat();
		output = new Mat();
	}
	
	public void frameAutoDisplay() {		
		cvSink = CameraServer.getInstance().getVideo();
		outputStream = CameraServer.getInstance().putVideo("Blur", 640, 480);
	
		source = new Mat();
		output = new Mat();
		
		cvSink.grabFrame(source);
		Core.flip(source, source, -1);
		Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
		outputStream.putFrame(output);
		
		source.release();
		output.release();
		outputStream.free();
		//cvSink.free(); <-- Crashes the robot because this removes the camera from the video sink
	}
	
	public void frameProcess() {
		//for(int i = 0; i<10; i++) {
		//if(System.currentTimeMillis() - lastFrameProcessTimeMs >= captureIntervalMs) {
		
			//Timer.delay(0.1);
			//lastFrameProcessTimeMs = System.currentTimeMillis();
		//}
		//}
	}
	
	public void enableProcessing() {
		visionProcessing = true;
	}
	
	public void disableProcessing() {
		visionProcessing = false;
	}
}
