package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.constants;
import frc.robot.Subsystems.DriveMecos;
import frc.robot.Subsystems.subintake;
import frc.robot.Subsystems.suboutake;
import frc.robot.Subsystems.suboutakeposicion;
import frc.robot.Subsystems.subposintake;

public class tridente extends Command{

    DriveMecos mecanum;
    suboutakeposicion posoutake;
    suboutake moutake;
    subintake intake;
    subposintake posintake;

    private double starttime;
    private double mytime;

    public tridente(DriveMecos mecanum, suboutakeposicion posoutake, subintake intake, suboutake moutake, subposintake posintake){
       
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
    else if (mytime >= 3.5 && mytime <3.7){
         mecanum.tankauto(0.0, 0.0);
         moutake.setoutakespeed(1);
    }
    else if (mytime >= 3.7 && mytime <4.0){
         mecanum.tankauto(-0.52, -0.5);
         posoutake.position_outake(20);
    }
    else if (mytime >= 4.0&& mytime < 4.8){
       intake.velocities(0);
       mecanum.tankauto(0.0, 0.0);
       posoutake.setposspeed(0.0);
       posintake.vel(-0.45);
       moutake.setoutakespeed(1);
    }
    else if (mytime >= 4.8&& mytime < 5.8){
         
       posintake.vel(0);
        moutake.setoutakespeed(1);
    }
    else if  (mytime >= 6.9 && mytime <7.5){
        
       moutake.setoutakespeed(1);
         posoutake.position_outake(constants.auto.angle2);
    }
    else if (mytime >= 7.5 && mytime <7.7){
         intake.velocities(-1);
    }
       // bolok
      

    else if (mytime >= 7.7 && mytime <8.5){
      intake.velocities(0);
      posintake.vel(0);
       posintake.vel(0.6);
      
    }
    else if  (mytime >= 8.5 && mytime <10.8){
      posintake.vel(0.0);
       mecanum.mecanumauto(0.3, -0.32, -0.3, 0.32);
    }
    else if  (mytime >= 10.8 && mytime <11.1){
      mecanum.mecanumauto(0,0,0,0);
      
      intake.velocities(0.8); 
      mecanum.tankauto(0.42, 0.42);
      posintake.vel(0.0);
      
    }
    else if (mytime >= 10.3 && mytime <11.1){
       posintake.vel(-0.85);
      intake.velocities(0.0); 
      mecanum.tankauto(0,0);
    
    }
    else if  (mytime >= 11.1 && mytime <11.2){
      posintake.vel(0.0);
     
      
    } 
    else if  (mytime >= 11.2 && mytime <13.5){
      moutake.setoutakespeed(1);
      mecanum.mecanumauto(-0.3, 0.31, 0.3, -0.31);
    }
    else if (mytime >= 13.5 && mytime <13.8){
       mecanum.mecanumauto(0,0,0,0);
       moutake.setoutakespeed(1);
    }
    else if  (mytime >= 13.8 && mytime <14.0){
      intake.velocities(-1);
      mecanum.tankauto(0.-42, -0.42);
    }
    
   else{
      intake.velocities(0);
      posintake.vel(0);
      mecanum.tankauto(0.0, 0.0);
      moutake.setoutakespeed(0);
      posoutake.setposspeed(0);
       mecanum.mecanumauto(0,0,0,0);
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
