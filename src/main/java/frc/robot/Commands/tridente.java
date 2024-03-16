package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.constants;
import frc.robot.Subsystems.DriveMecos;
import frc.robot.Subsystems.subintake;
import frc.robot.Subsystems.suboutake;
import frc.robot.Subsystems.subpos;
import frc.robot.Subsystems.subposintake;

public class tridente extends Command{

    DriveMecos mecanum;
    subpos posoutake;
    suboutake moutake;
    subintake intake;
    subposintake posintake;

    private double starttime;
    private double mytime;

    public tridente(DriveMecos mecanum, subpos posoutake, subintake intake, suboutake moutake, subposintake posintake){
       
        this.mecanum = mecanum;
        this.posoutake = posoutake;
        this.intake = intake;
        this.moutake = moutake;
        this.posintake = posintake;

        addRequirements(mecanum, posoutake, intake, moutake, posintake);
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

         //regresar negativo, bajar positivo
        //atras todo 0.2 seg .4 velocidad
        //adelante 3/4 0.2 seg a .2 de velocidad
        //2.3 seg a 2 de velocidad para cualquier lado
        //subir intake 1 seg
        //bajar intake 2 seg
        // cargar outake 1 seg
        // CAMBIA LAS PAUSAS :'v
     
        if (mytime >= 0.0 && mytime <2.0){
          posoutake.position_outake(constants.auto.angle1);
          moutake.setoutakespeed(1);
     }
     else if (mytime >= 2.0 && mytime <2.2){
          intake.velocities(-1);
          posoutake.setposspeed(0.0);
     }
     else if (mytime >= 2.2 && mytime <3.0){
          intake.velocities(0);
          moutake.setoutakespeed(0);
          posintake.vel(0.3);
     }
     else if  (mytime >= 3.0 && mytime <3.5){
          mecanum.tankauto(0.42, 0.40);
          posintake.vel(0);
          intake.velocities(.8);
     }
     else if (mytime >= 3.5 && mytime <4.0){
          mecanum.tankauto(0.0, 0.0);
     }
     else if (mytime >= 4.0 && mytime <4.3){
          mecanum.tankauto(-0.41, -0.4);
          posoutake.position_outake(20);
          moutake.setoutakespeed(1);
     }
     else if (mytime >= 4.3&& mytime < 5.1){
         intake.velocities(0);
         mecanum.tankauto(0.0, 0.0);
         posoutake.setposspeed(0.0);
         posintake.vel(-0.45);
     }
     else if (mytime >= 5.1&& mytime < 6.0){ 
         posintake.vel(0); 
         moutake.setoutakespeed(1);
     }
     else if  (mytime >= 6.0 && mytime <6.6){
          
          posoutake.position_outake(constants.auto.angle2);
          moutake.setoutakespeed(1);
     }
     else if (mytime >= 6.6 && mytime <6.8){
          moutake.setoutakespeed(1);
          intake.velocities(-1);
     }
       // bolok
       else if (mytime >= 6.8 && mytime <7.0){
        intake.velocities(0);
        posintake.vel(0);
        mecanum.tankauto(-0.31, -0.3);
        moutake.setoutakespeed(0);
        posoutake.setposspeed(0);
       }
       else if (mytime >= 7.0 && mytime <7.9){
          mecanum.tankauto(0.0,0.0);
         posintake.vel(0.3);
       }
       else if  (mytime >= 7.9&& mytime <10.2){
          posintake.vel(0);
          mecanum.mecanumauto(-0.3, 0.32, 0.3, -0.32);
          intake.velocities(0.8);
          
       } 
       else if (mytime >= 10.2&& mytime <10.3){ // :v
          mecanum.mecanumauto(0.0, 0.0, 0.0, 0.0);
          posintake.vel(0);
          intake.velocities(0.8);
       }
       else if (mytime >= 10.3&& mytime <11.1){
          mecanum.tankauto(0.31, 0.3);
          intake.velocities(0.8);
       }
       else if  (mytime >= 11.1&& mytime <11.3){
          mecanum.tankauto(0.0, 0.0);
          
       }
       else if  (mytime >= 11.3&& mytime <11.4){
          
          mecanum.tankauto(-0.42, -0.4);
       }
       else if  (mytime >= 11.4&& mytime <12.2){
         posintake.vel(-0.45);
       }
       else if  (mytime >= 12.2&& mytime <14.3){
          intake.velocities(0);
          posintake.vel(0.0);
          mecanum.mecanumauto(0.3, -0.32, -0.3, 0.32);
          posoutake.position_outake(33.5);
          moutake.setoutakespeed(1);
       }
       else if (mytime >= 14.3&& mytime <14.4){
          posoutake.setposspeed(0);
          posintake.vel(0);
          moutake.setoutakespeed(1);
       }
       else if  (mytime >= 14.4&& mytime <14.6){
          posoutake.position_outake(33.5);
          moutake.setoutakespeed(1);
       }
       else if (mytime >= 14.6&& mytime <14.9){
          posoutake.setposspeed(0);
          moutake.setoutakespeed(1);
          intake.velocities(-1);
          
       }

       else{
        intake.velocities(0);
        posintake.vel(0);
        mecanum.tankauto(0.0, 0.0);
        moutake.setoutakespeed(0);
        posoutake.setposspeed(0);
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
