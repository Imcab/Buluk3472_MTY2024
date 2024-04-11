package frc.robot.Autos;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.DriveMecos;
import frc.robot.Subsystems.subintake;
import frc.robot.Subsystems.suboutake;
import frc.robot.Subsystems.suboutakeposicion;
import frc.robot.Subsystems.subposintake;

public class ampdospieces extends Command{
    subintake intake;
    suboutake outake;
    DriveMecos chasis;
    suboutakeposicion outpos;
    subposintake posintake;

    private double starttime;
    private double mytime;


    public ampdospieces(subintake intake, suboutake outake, DriveMecos chasis, suboutakeposicion outpos, subposintake posintake){
        this.intake = intake;
        this.outake = outake;
        this.chasis = chasis;
        this.outpos = outpos;
        this.posintake = posintake;

        addRequirements(intake, outake, chasis, outpos, posintake);

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
            chasis.mecanumauto(0.25, -0.26, -0.25, 0.26);
            
        }
        else if (mytime >= 0.9 && mytime <1.0){
            chasis.mecanumauto(0, 0, 0, 0);
        }
        else if (mytime >= 1.0 && mytime <3.0){
            chasis.tankauto(-0.1, -0.21);
        }
        else if (mytime >= 3.0 && mytime <4.0){
            outpos.position_outake(243);
            chasis.tankauto(-0.08, -0.19);

            

        }
        else if (mytime >= 4.0 && mytime <4.5){
            outake.amp(-0.2, -0.7);
    
        }
        else if (mytime >= 4.5 && mytime <4.6){
            outpos.setposspeed(0);
            chasis.tankauto(0, 0);

        }
        else if (mytime >= 4.6 && mytime <5.2){
            outpos.position_outake(90);
            outake.amp(0, 0);
        }
        else if (mytime >= 5.2 && mytime < 5.6){
            outpos.setposspeed(0);
            chasis.tankauto(0.2, 0.21);
        }
        else if (mytime>= 5.6 && mytime<5.9){
            chasis.tankauto(0, 0);
        }
        else if (mytime>= 5.9 && mytime<6.9) {
            chasis.chasis_poss(0, 0.19);
            posintake.autointake();
            
        }
        else if (mytime >= 6.9 && mytime<7.7) {
            posintake.vel(0);
            chasis.tankauto(0.35, 0.36);
            intake.velocities(0.9);
        }
        else if (mytime>= 7.7 && mytime< 7.9){
            chasis.tankauto(0, 0);
            intake.velocities(0.9);

        }
        else if (mytime>= 7.9 && mytime< 8.9){
            chasis.chasis_poss(180, -0.23);
            intake.velocities(0);
            posintake.autoreintake();
        }
        else if(mytime>= 8.9 && mytime< 10.5){
            chasis.mecanumauto(-0.4, 0.41, 0.4, -0.41);
            posintake.vel(0);
        }
        else if (mytime>= 10.5 && mytime< 10.6){
            chasis.mecanumauto(0, 0, 0, 0);
        }
        else if (mytime>= 10.6 && mytime< 11.6){
            chasis.tankauto(-0.1, -0.21);
        }
        else {
            chasis.mecanumauto(0, 0, 0, 0);
            chasis.tankauto(0, 0);
            outake.setoutakespeed(0);
            outpos.setposspeed(0);
            intake.velocities(0);
            posintake.vel(0);
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

