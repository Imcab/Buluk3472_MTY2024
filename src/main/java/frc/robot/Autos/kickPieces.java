package frc.robot.Autos;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.DriveMecos;

public class kickPieces extends Command{
    DriveMecos chasis;

    private double starttime;
    private double mytime;

    public kickPieces(DriveMecos chasis){
        this.chasis = chasis;
        addRequirements(chasis);

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
        
        if (mytime >= 0.0 && mytime <3.25){
            chasis.tankauto(-0.51,-0.5);
            
        }
        else if (mytime >= 3.25 && mytime < 3.35){
            chasis.tankauto(0, 0);
        }
        else if (mytime >= 3.35 && mytime < 3.85){
            chasis.tankauto(0.51, 0.5);
        }
        else if(mytime >= 3.85 && mytime < 3.9){
            chasis.tankauto(0, 0);
        }
        else if (mytime >= 3.9 && mytime < 4.6){
            chasis.mecanumauto(0.6, -0.51, -0.5, 0.51);
        }
        else if (mytime >= 4.6 && mytime < 4.8){
            chasis.mecanumauto(-0.5, 0.71, 0.6, -0.61);
        }
        else if (mytime >= 4.8 && mytime < 4.9){
            chasis.mecanumauto(0, 0, 0, 0);
        }
        else if (mytime >= 4.9 && mytime < 6.4){
             chasis.tankauto(-0.51,-0.5);
        }
        else if  (mytime >= 6.4 && mytime < 6.5){
            chasis.tankauto(0, 0);

        }
        else if (mytime >= 6.5 && mytime < 7.0){
            chasis.tankauto(0.51, 0.5);
        }


        
        else{
            chasis.tankauto(0, 0);
        }
    }
}
