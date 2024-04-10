package frc.robot.Autos;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.DriveMecos;
import frc.robot.Subsystems.subintake;
import frc.robot.Subsystems.suboutake;
import frc.robot.Subsystems.suboutakeposicion;

public class autoampazul extends Command{

    subintake intake;
    suboutake outake;
    DriveMecos chasis;
    suboutakeposicion outpos;

    private double starttime;
    private double mytime;


    public autoampazul(subintake intake, suboutake outake, DriveMecos chasis, suboutakeposicion outpos){
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

        if (mytime >= 0.0 && mytime <0.9){
            chasis.mecanumauto(-0.4, 0.41, 0.4, -0.41);
            
        }
        else if (mytime >= 0.9 && mytime <1.0){
            chasis.mecanumauto(0, 0, 0, 0);
        }
        else if (mytime >= 1.0 && mytime <3.0){
            chasis.tankauto(-0.1, -0.21);
        }
        else if (mytime >= 3.0 && mytime <4.0){
            outpos.position_outake(243);
            
        }
        else if (mytime >= 4.0 && mytime <4.5){
            outake.amp(-0.2, -0.7);
        }
        else if (mytime >= 4.5 && mytime <4.6){
            outpos.setposspeed(0);
        }
        else if (mytime >= 4.6 && mytime <5.2){
            outpos.position_outake(90);
            outake.amp(0, 0);
        }
        else if (mytime >= 5.2 && mytime <7.6){
            outpos.setposspeed(0);
            chasis.mecanumauto(-0.3, 0.21, 0.3, -0.21);
        }
        
        else {
            chasis.mecanumauto(0, 0, 0, 0);
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

