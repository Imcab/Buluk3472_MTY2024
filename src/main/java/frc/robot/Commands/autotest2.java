package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.DriveMecos;
import frc.robot.Subsystems.subintake;
import frc.robot.Subsystems.suboutake;
import frc.robot.Subsystems.subpos;
import frc.robot.Subsystems.subposintake;

public class autotest2 extends Command{

    DriveMecos mecanum;
    subpos posoutake;
    suboutake moutake;
    subintake intake;
    subposintake posintake;

    private double starttime;
    private double mytime;

    public autotest2(DriveMecos mecanum, subpos posoutake, subintake intake, suboutake moutake, subposintake posintake){
       
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

        //atras todo 0.2 seg .4 velocidad
        //adelante 3/4 0.2 seg a .2 de velocidad
        //2.3 seg a 2 de velocidad para cualquier lado
        //subir intake 1 seg
        //bajar intake 2 seg
        // cargar outake 1 seg
        // CAMBIA LAS PAUSAS :'v
     
        if (mytime >= 0.0 && mytime <2.0){
          posoutake.position_outake(30.0);
          moutake.setoutakespeed(1);
     }
     else if (mytime >= 2.0 && mytime <2.2){
          intake.velocities(-1);
          posoutake.setposspeed(0.0);
     }
     else if (mytime >= 2.2 && mytime <4.2){
          intake.velocities(0);
          moutake.setoutakespeed(0);
          posintake.autointake();
     }
     else if  (mytime >= 4.2 && mytime <4.7){
          mecanum.tankauto(0.42, 0.40);
          posintake.vel(0);
          intake.velocities(.8);
     }
     else if (mytime >= 4.7 && mytime <5.2){
          mecanum.tankauto(0.0, 0.0);
     }
     else if (mytime >= 5.2 && mytime <5.5){
          mecanum.tankauto(-0.41, -0.4);
          posoutake.position_outake(20);
     }
     else if (mytime >= 5.5&& mytime < 6.9){
          intake.velocities(0);
          mecanum.tankauto(0.0, 0.0);
          posoutake.setposspeed(0.0);
          posintake.autoreintake();
          moutake.setoutakespeed(1);
     }
     else if  (mytime >= 6.9 && mytime <7.5){
          posintake.vel(0);
          posoutake.position_outake(45);
     }
     else if (mytime >= 7.5 && mytime <7.7){
          intake.velocities(-1);
     }
       //
       else if (mytime >= 7.7 && mytime <7.9){
        intake.velocities(0);
        posintake.vel(0);
        mecanum.tankauto(-0.31, -0.3);
        moutake.setoutakespeed(0);
        posoutake.setposspeed(0);
       }
       else if (mytime >= 7.9 && mytime <8.0){
          mecanum.tankauto(0.0,0.0);
       }
       else if  (mytime >= 8.0&& mytime <10.3){
          posintake.autointake();
          mecanum.mecanumauto(-0.3, 0.31, 0.3, -0.31);
          intake.velocities(0.8);
          
       }
       else if (mytime >= 10.3&& mytime <10.4){ //cambiar
          mecanum.mecanumauto(0.0, 0.0, 0.0, 0.0);
          posintake.vel(0);
          intake.velocities(0.8);
       }
       else if (mytime >= 10.4&& mytime <11.2){
          mecanum.tankauto(0.31, 0.3);
          intake.velocities(0.8);
       }
       else if  (mytime >= 11.2&& mytime <11.4){
          mecanum.tankauto(-0.31, -0.3);
          
       }
       else if  (mytime >= 11.4&& mytime <11.5){
          mecanum.tankauto(0.0, 0.0);
       }
       else if  (mytime >= 11.5&& mytime <13.8){
          intake.velocities(0);
          posintake.autoreintake();
          mecanum.mecanumauto(0.3, -0.31, -0.3, 0.31);
          posoutake.position_outake(20);
          moutake.setoutakespeed(1);
       }
       else if (mytime >= 13.8&& mytime <13.9){
          posoutake.setposspeed(0);
          posintake.vel(0);
          moutake.setoutakespeed(1);
       }
       else if  (mytime >= 13.9&& mytime <14.1){
          posoutake.position_outake(45);
          moutake.setoutakespeed(1);
       }
       else if (mytime >= 14.1&& mytime <14.3){
          posoutake.setposspeed(0);
          intake.velocities(-1);
          moutake.setoutakespeed(1);
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
