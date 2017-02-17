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
	
	GripPipeline grip = new GripPipeline();
	
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
		//cvSink.free(); <-- Crashes the robot b/c this removes the camera from the video sink
	}
	
	public void frameProcess() {
		grip.process(source);
		/* throws an exception... fix this later
		 * [org.opencv.imgproc.Imgproc.findContours_1(Native Method),
		 * org.opencv.imgproc.Imgproc.findContours(Unknown Source),
		 * org.usfirst.frc.team4804.robot.subsystems.GripPipeline.findContours(GripPipeline.java:290),
		 * org.usfirst.frc.team4804.robot.subsystems.GripPipeline.process(GripPipeline.java:66),
		 * org.usfirst.frc.team4804.robot.subsystems.VisionSubsystem.frameProcess(VisionSubsystem.java:89)]
		 */
	}
	
	public void enableProcessing() {
		visionProcessing = true;
	}
	
	public void disableProcessing() {
		visionProcessing = false;
	}
}
