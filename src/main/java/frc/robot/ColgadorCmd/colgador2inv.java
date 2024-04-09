package frc.robot.ColgadorCmd;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.subcolgador2;

public class colgador2inv extends Command{
    subcolgador2 colgador2;
    Supplier<Double> speed;
    
    public colgador2inv(subcolgador2 colgador2, Supplier<Double> speed){
            this.colgador2 = colgador2;
            this.speed = speed;
        
        addRequirements(colgador2);
    }

    @Override
    public void initialize(){  
    }

    @Override
    public void execute(){
       
        double vel = speed.get();

        if (vel >0.3){
            colgador2.setcolgador2(-1.0);
        } else {
            colgador2.setcolgador2(0);
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
