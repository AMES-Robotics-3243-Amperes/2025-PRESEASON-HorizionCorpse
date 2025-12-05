// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.subsystems.ThriftyModule;

import com.ctre.phoenix6.swerve.SwerveModule;
import com.studica.frc.AHRS;
import com.studica.frc.AHRS.NavXComType;
import edu.wpi.first.math.geometry.Rotation2d;


public class SubsystemThriftySwerveDrivetrain extends SubsystemBase {

   private final ThriftyModule m_frontLeft = new ThriftyModule(
      DriveConstants.kFrontLeftDrivingCanId,
      DriveConstants.kFrontLeftTurningCanId, 3, DriveConstants.kFrontLeftOffset);

  private final ThriftyModule m_frontRight = new ThriftyModule(
      DriveConstants.kFrontRightDrivingCanId,
      DriveConstants.kFrontRightTurningCanId, 0, DriveConstants.kFrontRightOffset);

  private final ThriftyModule m_rearLeft = new ThriftyModule(
      DriveConstants.kRearLeftDrivingCanId,
      DriveConstants.kRearLeftTurningCanId, 2, DriveConstants.kRearLeftOffset);

  private final ThriftyModule m_rearRight = new ThriftyModule(
      DriveConstants.kRearRightDrivingCanId,
      DriveConstants.kRearRightTurningCanId, 1, DriveConstants.kRearRightOffset);


  private final AHRS imu = new AHRS(NavXComType.kMXP_SPI);

  public final SwerveDriveKinematics SwerveKinematics = new SwerveDriveKinematics(
      new Translation2d(DriveConstants.kChassisWidth / 2, DriveConstants.kChassisWidth / 2),
      new Translation2d(DriveConstants.kChassisWidth / 2, -DriveConstants.kChassisWidth / 2),
      new Translation2d(-DriveConstants.kChassisWidth / 2,  DriveConstants.kChassisWidth / 2),
      new Translation2d(-DriveConstants.kChassisWidth / 2, -DriveConstants.kChassisWidth / 2)
      
  );
  
    private boolean m_fieldRelative = true;

    public void setFieldRelative(boolean enabled) {
      m_fieldRelative = enabled;
    }

    public boolean getFieldRelative() {
      return m_fieldRelative;
    }

    public void drive(double vxMetersPerSecond,
      double vyMetersPerSecond,
      double omegaRadiansPerSecond,
      boolean fieldRelative) {

    ChassisSpeeds chassisSpeeds;

    if (fieldRelative) {
      chassisSpeeds = ChassisSpeeds.fromFieldRelativeSpeeds(
        vxMetersPerSecond,
        vyMetersPerSecond,
        omegaRadiansPerSecond,
        Rotation2d.fromDegrees(imu.getYaw())
      );
    } else {
      chassisSpeeds = new ChassisSpeeds(
        vxMetersPerSecond,
        vyMetersPerSecond,
        omegaRadiansPerSecond
      );
      
    }

    SwerveModuleState[] states = SwerveKinematics.toSwerveModuleStates(chassisSpeeds);
    m_frontLeft.setDesiredState(states[0]);
    m_frontRight.setDesiredState(states[1]);
    m_rearLeft.setDesiredState(states[2]);
    m_rearRight.setDesiredState(states[3]);
  }
  
    @Override
    public void periodic() {
  
      m_frontLeft.update();
      m_frontRight.update();
      m_rearLeft.update();
      m_rearRight.update();
      
  }

}