/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;


public class ShooterCommands extends Command {
  public ShooterCommands() {
    requires(Robot.shooter); 
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.shooter.leftMotor.set(RobotMap.LOWGEARPERCENT);
    Robot.shooter.rightMotor.set(RobotMap.LOWGEARPERCENT);
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(Robot.m_oi.getLowGear()){
      Robot.shooter.lowerToggle();
    }
    if(Robot.m_oi.getHighGear()){
      Robot.shooter.highToggle();
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.shooter.leftMotor.set(0);
    Robot.shooter.leftMotor.set(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
