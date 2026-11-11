package frc.robot.subsystems;

import java.io.File;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import swervelib.SwerveDrive;
import swervelib.parser.SwerveParser;

public class Drivetrain extends SubsystemBase {
    
    public final SwerveDrive swerveDrive;

    //Constructor
    public Drivetrain(File directory){
        try {
            swerveDrive = new SwerveParser(new File(Filesystem.getDeployDirectory(), "swerve")).createSwerveDrive(6);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new RuntimeException("failed");
        }
    }
    
}

@Override
public void periodic(){

    //Testing
    SmartDashboard.putNumber("front right offset: ", swerveDrive.getModuleMap().get("frontright").getRelativePosition());
    SmartDashboard.putNumber("back right offset: ", swerveDrive.getModuleMap().get("backright").getRelativePosition());
    SmartDashboard.putNumber("front left offset: ", swerveDrive.getModuleMap().get("frontleft").getRelativePosition());
    SmartDashboard.putNumber("back left offset: ", swerveDrive.getModuleMap().get("backleft").getRelativePosition());
}