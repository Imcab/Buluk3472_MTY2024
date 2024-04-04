package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.limelight;
import frc.robot.Subsystems.subpos;

public class setangle extends Command{

    subpos posoutake;
    limelight limelight;

    public setangle(subpos posoutake, limelight limelight){
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

// :v

}
