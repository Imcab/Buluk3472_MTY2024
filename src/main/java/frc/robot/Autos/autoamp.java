package frc.robot.Autos;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.DriveMecos;
import frc.robot.Subsystems.subintake;
import frc.robot.Subsystems.suboutake;
import frc.robot.Subsystems.suboutakeposicion;

public class autoamp extends Command{

    subintake intake;
    suboutake outake;
    DriveMecos chasis;
    suboutakeposicion outpos;
    boolean TargetAvaliable;

    private double starttime;
    private double mytime;


    public autoamp(subintake intake, suboutake outake, DriveMecos chasis, suboutakeposicion outpos){
        this.intake = intake;
        this.outake = outake;
        this.chasis = chasis;
        this.outpos = outpos;

        addRequirements(intake, outake, chasis, outpos);

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

        if (mytime >= 0.0 && mytime <2.5){
            chasis.tankauto(0.11,0.1);
        }

        else if (mytime >= 2.5 && mytime < 4.0){
            chasis.chasis_poss(90, 0.35);
        }
         else if (mytime >= 4.0 && mytime < 4.3 ){
            chasis.tankauto(0.11, 0.1);
        } 
        else if (mytime >= 4.3 && mytime < 4.5){
            chasis.tankauto(0.06, 0.05);
            outpos.position_outake(242);

        }  else if (mytime >= 4.5 && mytime < 5){
            chasis.tankauto(0.06, 0.05);
            outpos.position_outake(242);
            outake.amp(-0.2, -0.7);
        }else if (mytime >= 5 && mytime < 5.3){
            chasis.tankauto(0.07, 0.06);
            outpos.position_outake(242);
        }else if (mytime >= 5.3 && mytime < 5.5){
            outpos.position_outake(48);
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

