
package org.usfirst.frc1727.REX.commands;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc1727.REX.Robot;

/**
 *
 */
public class GearCommand extends Command {

	boolean isLowered = false;
	
    public GearCommand() {
        requires(Robot.driveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {    	
    	if (isLowered != Robot.oi.getOperator().getRawButton(2)) {
    		isLowered = Robot.oi.getOperator().getRawButton(2);
    		if (isLowered)
    			Robot.gearSubsystem.getRaiser().set(DoubleSolenoid.Value.kForward);
    		else
    			Robot.gearSubsystem.getRaiser().set(DoubleSolenoid.Value.kReverse);
    	}
    	
    	if (Robot.oi.getOperator().getRawButton(11))
    		Robot.gearSubsystem.getIntakeMotor().set(0.75);
    	else if (Robot.oi.getOperator().getRawButton(12))
    		Robot.gearSubsystem.getIntakeMotor().set(0);
    	else if (Robot.oi.getOperator().getRawButton(10))
    		Robot.gearSubsystem.getIntakeMotor().set(-0.75);
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
