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
        //menos afuerita es derecha, menos adentro es izquierda

        //atras todo 0.2 seg .4 velocidad
        //adelante 3/4 0.2 seg a .2 de velocidad
        //2.3 seg a 2 de velocidad para cualquier lado
        //subir intake 1 seg
        //bajar intake 2 seg
        // cargar outake 1 seg
        // CAMBIA LAS PAUSAS :'v

       
       // if (mytime>=0 && mytime < 1.0){
            
        //}

       /* if  (mytime>= 0.0 && mytime < 0.2){
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
