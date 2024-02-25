package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.subpiston;

public class compiston extends Command{
    subpiston piston;

    public compiston(){
       
    }

    @Override
    public void initialize(){
        piston.Reverse();    
    }

    @Override
    public void execute(){
       piston.forward();
    }

    @Override
    public void end(boolean interrupted) {
     piston.Reverse();
    }

    @Override
    public boolean isFinished(){   
        return false;
    }
  
}
