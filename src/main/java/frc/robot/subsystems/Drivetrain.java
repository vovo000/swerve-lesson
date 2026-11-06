package frc.robot.subsystems;

import java.io.File;

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
