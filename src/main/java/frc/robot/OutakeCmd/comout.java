package frc.robot.OutakeCmd;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.suboutake;

public class comout extends Command{
    suboutake moutake;
    Supplier<Double>speed, speed2;

    public comout(suboutake moutake, Supplier<Double>speed, Supplier<Double>speed2){
        
        this.moutake = moutake;
        this.speed = speed;
        this.speed2 = speed2;
     
        addRequirements(moutake);        
    }

    @Override
    public void initialize(){
    }

    @Override
    public void execute(){
       double gatder = speed.get();
       double gatizq = speed2.get();

        if (gatder > 0.3 && gatizq < 0.001){
            moutake.setoutakespeed(1.0); 
        }
       
       else if (gatder < 0.001 && gatizq > 0.001){
            moutake.amp(-0.2, -0.7);
        }
        
        else{
            moutake.setoutakespeed(0);
            moutake.amp(0.0, 0.0);
        }
    }

    @Override
    public boolean isFinished(){
        return false;
    }
  
}
