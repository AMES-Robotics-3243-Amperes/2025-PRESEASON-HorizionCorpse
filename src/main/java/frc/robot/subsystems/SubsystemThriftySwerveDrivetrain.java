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

import com.studica.frc.AHRS;
import com.studica.frc.AHRS.NavXComType;
import edu.wpi.first.math.geometry.Rotation2d;


public class SubsystemThriftySwerveDrivetrain extends SubsystemBase {
  private final ThriftyModule m_frontLeft  = new ThriftyModule(1, 2, 0, Rotation2d.fromRotations(0.265429));
  private final ThriftyModule m_frontRight = new ThriftyModule(3, 4, 1, Rotation2d.fromRotations( 0.192577));   
  private final ThriftyModule m_backLeft   = new ThriftyModule(5, 6, 2, Rotation2d.fromRotations(0.878503));
  private final ThriftyModule m_backRight  = new ThriftyModule(7, 8,  3, Rotation2d.fromRotations(0.849766));


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
    m_backLeft.setDesiredState(states[2]);
    m_backRight.setDesiredState(states[3]);
  }
  
    @Override
    public void periodic() {
      m_frontLeft.update();
      m_frontRight.update();
      m_backLeft.update();
      m_backRight.update();
  }

}