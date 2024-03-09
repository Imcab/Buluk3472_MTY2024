package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.DriveMecos;
import frc.robot.Subsystems.subintake;
import frc.robot.Subsystems.suboutake;
import frc.robot.Subsystems.subpos;

public class autotridente extends Command{

    DriveMecos mecanum;
    subpos posoutake;
    suboutake moutake;
    subintake intake;

    private double starttime;
    private double mytime;

    public autotridente(DriveMecos mecanum, subpos posoutake, subintake intake, suboutake moutake){
       
        this.mecanum = mecanum;
        this.posoutake = posoutake;
        this.moutake = moutake;
        this.intake = intake;

        addRequirements(mecanum, posoutake, moutake, intake);
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

        // CAMBIA LAS PAUSAS :'v

        if  (mytime>= 0.0 && mytime < 0.2){
            mecanum.tankauto(0.41, 0.4);
            
        }

        else if(mytime>= 0.2 && mytime < 1.2){
            mecanum.tankauto(0.0, 0.0);
        }

        else if (mytime>= 1.2 && mytime < 1.4){
            mecanum.tankauto(-0.21,- 0.2);
        }

        else if (mytime>= 1.4 && mytime < 2.4){
            mecanum.tankauto(0, 0);
        }

        else if (mytime>= 2.4 && mytime < 4.7){
            
            mecanum.mecanumauto(-0.2, 0.21, 0.2, -0.21);
        }
      
        else if (mytime>= 4.7 && mytime < 6.7){
            mecanum.mecanumauto(0, 0, 0, 0);
        }
        else  if (mytime>= 6.7 && mytime < 9.0){
            mecanum.mecanumauto(0.2, -0.21, -0.2, 0.21);
        }
        
        else if (mytime>= 9.0 && mytime < 10.2){
             mecanum.mecanumauto(0, 0, 0, 0);
        }
        else  if (mytime>= 10.2 && mytime < 12.5){
            mecanum.mecanumauto(0.2, 0-.21, -0.2, 0.21);
        }

        else  if (mytime>= 12.5 && mytime < 13){
             mecanum.mecanumauto(0, 0, 0, 0);
        }
        else  if (mytime>= 13 && mytime < 15.4){
              mecanum.mecanumauto(-0.2, 0.21, 0.2, -0.21);
        }
        
        
        else{
            mecanum.tankauto(0, 0);
            mecanum.mecanumauto(0, 0, 0, 0);
            moutake.setoutakespeed(0);
            intake.velocities(0);
            
          }
       /*  if (mytime>= 0 && mytime<0.55){ //se fue pa atras
           mecanum.tankauto(-0.41, -0.4); // (derecha, izquierda)
        }
        

        else if (mytime>=0.55 && mytime<1.1){ // se fue pa lante :)
            mecanum.tankauto(0.41, 0.4);
        }

        else if (mytime>=1.1 && mytime<1.4){ // se fue pa atras a la mita' :/
            mecanum.tankauto(-0.41, -0.4);
        }
     
        else if (mytime>=1.4 && mytime<1.95){ // se va pa un lado (derecha)
            mecanum.mecanumauto(0.2, -0.21, -0.2, 0.21); //fi fd ai ad
        }

        else if (mytime>=1.95 && mytime<2.25){ // se fue pa atras a la mita' de la 2da pieza xd
            mecanum.tankauto(-0.41, -0.4);
        }

        else if (mytime>=2.25 && mytime<2.55){ // se va pa lante a la mitad de la 2da pieza (regreso)
            mecanum.tankauto(0.41, 0.4);
        }

        else if (mytime>=2.55 && mytime<3.1){ // se va pa un lado (del lado derecho de regreso al centro)
            mecanum.mecanumauto(-0.2, 0.21, 0.2, -0.21); //fi fd ai ad
        }

        else if (mytime>=3.1 && mytime<3.4){ // se fue pa adelante a la mita'
            mecanum.tankauto(0.41, 0.4);
        }

        else if (mytime>=3.4 && mytime<3.7){ // se fue pa atras a la mita' :/
            mecanum.tankauto(-0.41, -0.4);
        }
        
        else if (mytime>=3.7&& mytime<4.25){ // se va pa un lado (izquierda)
            mecanum.mecanumauto(-0.2, 0.21, 0.2, -0.21); //fi fd ai ad
        }
        
        else if (mytime>=4.25 && mytime<4.55){ // se fue pa atras a la mita' de la 3ra pieza xd
            mecanum.tankauto(-0.41, -0.4);
        }

        else if (mytime>=4.55 && mytime<4.85){ // se va pa lante a la mitad de la 3ra pieza (regreso)
            mecanum.tankauto(0.41, 0.4);
        }

        else if (mytime>=4.85 && mytime<5.4){ // se va pa un lado (del lado izquierdo de regreso al centro)
            mecanum.mecanumauto(0.2, -0.21, -0.2, 0.21); //fi fd ai ad
        }

        else if (mytime>=5.4 && mytime<5.7){ // se fue pa adelante a la mita'
            mecanum.tankauto(0.41, 0.4);
        } */

    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished(){     
        return false;
    } 
}
