package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.limelight;
import frc.robot.Subsystems.suboutakeposicion;

public class setangle extends Command{

    suboutakeposicion posoutake;
    limelight limelight;

    public setangle(suboutakeposicion posoutake, limelight limelight){
        this.limelight = limelight;
        this.posoutake = posoutake;

        addRequirements(limelight, posoutake);
    }

    @Override
    public void initialize(){
    }
    
    @Override
    public void execute(){
        boolean TargetAvaliable = limelight.targetfound();
        System.out.println(TargetAvaliable);

        if (TargetAvaliable = true){
            
            posoutake.poslimelight(limelight.getY());
            
        } else{
           posoutake.setposspeed(0); 
            
        }
    }
    
    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished(){     
        return false;
    } 

}

// :v