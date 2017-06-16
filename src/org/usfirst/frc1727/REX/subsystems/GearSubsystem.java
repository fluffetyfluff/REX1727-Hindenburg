
package org.usfirst.frc1727.REX.subsystems;

import org.usfirst.frc1727.REX.Robot;
import org.usfirst.frc1727.REX.RobotMap;
import org.usfirst.frc1727.REX.commands.*;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;

import edu.wpi.first.wpilibj.command.Subsystem;

public class GearSubsystem extends Subsystem {

    private final CANTalon intakeMotor = RobotMap.gearSubsystemintakeMotor;
    
    private final DoubleSolenoid raiser = RobotMap.gearSubsystemraiser;
    
    public SpeedController getIntakeMotor() {
    	return intakeMotor;
    }
    
    public DoubleSolenoid getRaiser() {
    	return raiser;
    }
    
    public void initDefaultCommand() {

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}