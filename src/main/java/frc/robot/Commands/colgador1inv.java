package frc.robot.Commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.subcolgador1;

public class colgador1inv extends Command{
    subcolgador1 colgador1;
   Supplier <Double> vel;

    public colgador1inv(subcolgador1 colgador1, Supplier<Double> vel){

            this.colgador1 = colgador1;
            this.vel = vel;

        addRequirements(colgador1);
    }

    @Override
    public void initialize(){
        
    }

    @Override
    public void execute(){
        
        double velocity = vel.get();

        if(velocity > 0.3){
            colgador1.setcolgador1(-1.0);
        }else{
            colgador1.setcolgador1(0); 
        }

    }

    @Override
    public void end(boolean interrupted) {
        colgador1.setcolgador1(0);
    }


    @Override
    public boolean isFinished(){
        
        
        return false;
    }

    
}
