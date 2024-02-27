package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.subpiston;

public class pistonreverse extends Command{
    subpiston piston;

    public pistonreverse(subpiston piston){

       this.piston = piston;

       addRequirements(piston);
    }

    @Override
    public void initialize(){
        
         piston.Reverse();
    }

    @Override
    public void execute(){
       
    }

    @Override
    public void end(boolean interrupted) {
        
    }

    @Override
    public boolean isFinished(){   
        return false;
    }
  
}
