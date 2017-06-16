package org.usfirst.frc1727.REX.subsystems;

import org.usfirst.frc1727.REX.Robot;
import org.usfirst.frc1727.REX.RobotMap;
import org.usfirst.frc1727.REX.commands.*;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class DriveSubsystem extends Subsystem {

	// Drive
    private final SpeedController leftDrive = RobotMap.driveSubsystemleftDrive;
    private final SpeedController rightDrive = RobotMap.driveSubsystemrightDrive;
    private final RobotDrive robotDrive = RobotMap.driveSubsystemRobotDrive;
    
    // Encoders
    private final Encoder leftDriveEncoder = RobotMap.driveSubsystemleftEncoder;
    private final Encoder rightDriveEncoder = RobotMap.driveSubsystemrightEncoder;
    
    // PID Controllers
    private final PIDController leftDriveDistancePID = RobotMap.driveDistanceLeftPID;
    private final PIDController rightDriveDistancePID = RobotMap.driveDistanceRightPID;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public SpeedController setLeftDrive() {
    	return leftDrive;
    }
    
    public SpeedController getRightDrive() {
    	return rightDrive;
    }
    
    public RobotDrive getRobotDrive() {
    	return robotDrive;
    }
    
    public Encoder getLeftDriveEncoder() {
    	return leftDriveEncoder;
    }
    
    public Encoder getRightDriveEncoder() {
    	return rightDriveEncoder;
    }
    
    public PIDController getLeftDriveDistancePID() {
    	return leftDriveDistancePID;
    }
    
    public PIDController getRightDriveDistancePID() {
    	return rightDriveDistancePID;
    }
    
    public void initDefaultCommand() {

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}

