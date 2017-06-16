package org.usfirst.frc1727.REX.subsystems;

import org.usfirst.frc1727.REX.Robot;
import org.usfirst.frc1727.REX.RobotMap;
import org.usfirst.frc1727.REX.commands.*;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class LiftSubsystem extends Subsystem {

    private final SpeedController liftMotor = RobotMap.liftSubsystemliftMotor;
    
    private final DoubleSolenoid brake = RobotMap.liftSubsystembrake;
    
    public SpeedController getLiftMotor() {
    	return liftMotor;
    }
    
    public DoubleSolenoid getBrake() {
    	return brake;
    }
    
    public void initDefaultCommand() {

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}

