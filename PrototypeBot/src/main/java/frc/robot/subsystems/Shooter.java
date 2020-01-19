/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ShooterCommands;



/**
 * Add your docs here.
 */

public class Shooter extends Subsystem {

 public  CANSparkMax leftMotor = new CANSparkMax(RobotMap.LEFTSIDESHOOTER, MotorType.kBrushless);
 public  CANSparkMax rightMotor = new CANSparkMax(RobotMap.RIGHTSIDESHOOTER, MotorType.kBrushless);
 private static Encoder shooterEncoder = new Encoder(RobotMap.DIGITALSOURCEA, RobotMap.DIGITALSOURCEB);

 private static boolean isLow = true;
 private static boolean isHigh = false;

public void lowerToggle(){
  if (isLow){
    rightMotor.set(0);
    leftMotor.set(0);
    isLow=false;
  } else {
    rightMotor.set(RobotMap.LOWGEARPERCENT);
    leftMotor.set(-RobotMap.LOWGEARPERCENT);
    
    isLow=true;
  }
}

public void highToggle (){
  if (isHigh){
    if (isLow==false){
      rightMotor.set(0);
      leftMotor.set(0);
    } else {
      rightMotor.set(RobotMap.LOWGEARPERCENT);
      leftMotor.set(-RobotMap.LOWGEARPERCENT);
    }
    isHigh = false;
  } else {
    rightMotor.set(RobotMap.HIGHGEARPERCENT);
    leftMotor.set(-RobotMap.HIGHGEARPERCENT);
    isHigh = true; 
  }
}
public Shooter (){

}
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ShooterCommands());
  }
}
