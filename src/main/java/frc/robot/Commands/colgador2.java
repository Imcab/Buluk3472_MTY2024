package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.subcolgador2;

public class colgador2 extends Command{
    subcolgador2 colgador2;
    Double speed;
    

    public colgador2(subcolgador2 colgador2, Double speed){

        this.colgador2 = colgador2;
        this.speed = speed;
        
        addRequirements(colgador2);
    }

    @Override
    public void initialize(){   
    }

    @Override
    public void execute(){
       
        double vel = speed;

        colgador2.setcolgador2(vel);

    }

    @Override
    public void end(boolean interrupted) {
        colgador2.setcolgador2(0);
    }


    @Override
    public boolean isFinished(){
        return false;
    }

    
}
