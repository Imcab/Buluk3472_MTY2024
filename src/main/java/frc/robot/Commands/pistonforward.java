package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.subpiston;

public class pistonforward extends Command{
    subpiston piston;

    public pistonforward(subpiston piston){

       this.piston = piston;

       addRequirements(piston);
    }

    @Override
    public void initialize(){
        piston.forward();
         
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
