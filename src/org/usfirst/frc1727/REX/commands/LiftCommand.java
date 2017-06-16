package org.usfirst.frc1727.REX.commands;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc1727.REX.Robot;

/**
 *
 */
public class LiftCommand extends Command {

	boolean isActive = false;
	
    public LiftCommand() {
        requires(Robot.liftSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {    	
    	if (isActive != Robot.oi.getOperator().getRawButton(1)) {
    		isActive = Robot.oi.getOperator().getRawButton(1);
    		if (isActive) {
    			Robot.liftSubsystem.getBrake().set(DoubleSolenoid.Value.kReverse);
    		}
    		else {
    			Robot.liftSubsystem.getBrake().set(DoubleSolenoid.Value.kForward);
    		}
    	}
    	
    	if (isActive) 
    		Robot.liftSubsystem.getLiftMotor().set(-Robot.oi.getOperator().getRawAxis(1));
    	else
    		Robot.liftSubsystem.getLiftMotor().set(0);
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
