package frc.robot.Commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.suboutake;

public class comout extends Command{
    suboutake moutake;
    Supplier<Double>speed, speed2, invspeed, invspeed2;

    public comout(suboutake moutake, Supplier<Double>speed, Supplier<Double>speed2, Supplier<Double>invspeed,Supplier<Double>invspeed2){
        
        this.moutake = moutake;
        this.speed = speed;
        this.speed2 = speed2;
        this.invspeed = invspeed;
        this.invspeed2 = invspeed2;
        addRequirements(moutake);        

    }

    @Override
    public void initialize(){
        
    }

    @Override
    public void execute(){
       double gatder = speed.get();
       double gatizq = speed2.get();

       double invgatder = invspeed.get();
       double invgatizq = invspeed2.get();

       if (gatder > 0.3 && gatizq < 0.001 && invgatder <0.001 && invgatizq <0.001){
        
        moutake.setoutakespeed(0.9); //cambiar a vel rapida despues(0.9)
       }
       
       else if (gatder < 0.001 && gatizq > 0.001 && invgatder <0.001 && invgatizq <0.001){

        moutake.setoutakespeed(0.45);}
        
        else if (gatder < 0.001 && gatizq <0.001 && invgatder <0.001 && invgatizq >0.001){
                 moutake.setoutakespeed(-0.45);}

        else if (gatder < 0.001 && gatizq <0.001 && invgatder >0.3 && invgatizq <0.001){
            moutake.setoutakespeed(-0.9);
        }else{
            moutake.setoutakespeed(0);
        }}

       

    @Override
    public boolean isFinished(){
        
        return false;
    }
  
}
