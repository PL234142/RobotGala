// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants.RobotMap;


public class DriveTrainSubsystem extends SubsystemBase {

  public DifferentialDrive drive;

  WPI_TalonFX   rightMasterMotor    = new WPI_TalonFX(  RobotMap.rightMasterPort);
  WPI_TalonFX   leftMasterMotor     = new WPI_TalonFX(  RobotMap.leftMasterPort);
  WPI_VictorSPX rightFollowerMotor  = new WPI_VictorSPX(RobotMap.rightFollowerPort);
  WPI_VictorSPX leftFollowerMotor   = new WPI_VictorSPX(RobotMap.leftFollowerPort);

  /** Creates a new ExampleSubsystem. */
  public DriveTrainSubsystem() {
    rightFollowerMotor.follow(rightMasterMotor);
    leftFollowerMotor .follow(leftMasterMotor);

    rightMasterMotor  .setInverted(false);
    rightFollowerMotor.setInverted(false);
    leftMasterMotor   .setInverted(false);
    leftFollowerMotor .setInverted(false);

    drive = new DifferentialDrive(leftMasterMotor, rightMasterMotor);
    
  }

  // public void arcade(double move, double turn){
  //   drive.arcadeDrive(move,-turn);
  //   //leftMaster.set(-.1);
  //   //rightMaster.set(0.1);
  //   //rightFollower.set();
  // }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  // Timed Auto Method
  public void AutoDrive(double Left, double Right) {
    rightMasterMotor.set(ControlMode.PercentOutput, Right);
    rightFollowerMotor.set(ControlMode.PercentOutput, Right);
    leftMasterMotor.set(ControlMode.PercentOutput, Left);
    leftFollowerMotor.set(ControlMode.PercentOutput, Left);
  }
}
