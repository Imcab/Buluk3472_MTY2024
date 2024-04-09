package frc.robot.Autos;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.DriveMecos;
import frc.robot.Subsystems.limelight;
import frc.robot.Subsystems.subintake;
import frc.robot.Subsystems.suboutake;
import frc.robot.Subsystems.suboutakeposicion;

public class outexit extends Command{

    subintake intake;
    suboutake outake;
    DriveMecos chasis;
    limelight autolimeght;
    suboutakeposicion outpos;
    boolean TargetAvaliable;

    private double starttime;
    private double mytime;


    public outexit(subintake intake, suboutake outake, DriveMecos chasis, limelight autolimelight, suboutakeposicion outpos){
        this.intake = intake;
        this.outake = outake;
        this.chasis = chasis;
        this.autolimeght = autolimelight;
        this.outpos = outpos;

        addRequirements(intake, outake, chasis, autolimelight, outpos);

    }

    @Override
    public void initialize(){  
        starttime = System.currentTimeMillis();
        System.out.println("start time"+starttime); 
    }

    @Override
    public void execute(){
        mytime = (System.currentTimeMillis() - starttime)/1000;
        System.out.println("mytime"+mytime);
        TargetAvaliable = autolimeght.targetfound();

        if (mytime >= 0.0 && mytime <3.5){
            chasis.tankauto(0.11,0.1);
        }

        else if (mytime >= 3.5 && mytime < 4.0){
            outpos.position_outake(48);
            outake.setoutakespeed(1.0);
        }
         else if (mytime >= 4.0 && mytime < 4.5 ){
            outake.setoutakespeed(1.0);
    
            if (TargetAvaliable = true){ 
            outpos.poslimelight(autolimeght.getY());    
            } 
            else{
           outpos.setposspeed(0); 
            }
                    
        
        } 
        else if (mytime >= 4.5 && mytime < 5.0){
            
            intake.velocities(-0.9);

            if (TargetAvaliable = true){ 
            outpos.poslimelight(autolimeght.getY());    
            } 
            else{
           outpos.setposspeed(0); 
            }

            outake.setoutakespeed(1.0);

        }

        else{
            intake.velocities(0);
            chasis.tankauto(0.0, 0.0);
            outake.setoutakespeed(0);
            outpos.setposspeed(0);
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
