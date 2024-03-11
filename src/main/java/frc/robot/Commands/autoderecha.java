package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.DriveMecos;
import frc.robot.Subsystems.subintake;
import frc.robot.Subsystems.suboutake;
import frc.robot.Subsystems.subpos;

public class autoderecha extends Command {

    DriveMecos mecanum;
    subpos posoutake;
    suboutake moutake;
    subintake intake;

    private double starttime;
    private double mytime;
    double angle; 

    public autoderecha(DriveMecos mecanum, subpos posoutake, suboutake moutake, subintake intake, double angle){

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

    //Cuando va hacia adelante las llantas es negativo, si es para atras es positivo
    @Override 
    public void execute(){
        mytime = (System.currentTimeMillis() - starttime)/1000;
        System.out.println("mytime"+mytime); 
        angle = mecanum.angle();
        
        if (mytime>= 0 && mytime<0.40){ 
            //outtake 
         }
 
         else if (angle > 0 ){ 
            mecanum.mecanumauto(-0.1, 0.11, -0.1, 0.11); // El roboto gira hasta que llega al angulo de 0 
         }

         else if ( mytime >= 0.40 && mytime < 0.50){
            mecanum.mecanumauto(-0.1, 0.11, 0.1, -0.11); //Se mueve en forma de cangrejo hacia la derecha

         }
         else if ( mytime >= 0.50 && mytime < 1.1 ){ //Se mueve hacia el atras para agarrar la pieza 
            mecanum.tankauto(0.41, 0.4); 
            //baja el intake 
         }
          else if ( mytime >= 1.1 && mytime < 2.0 ){ //Llega a la pieza, se detenia y toma la pieza 
            mecanum.tankauto(0.0, 0.0);
            //Prender motores del intake que extraen la pieza  
         }
        
         else if ( mytime >= 0.50 && mytime < 1.1 ){ //Se mueve hacia el atras para volver a la posicion donde estaba
           mecanum.tankauto(-0.41, -0.4); 
        }
        
          else if (  angle > 0 ){  //   Gira para volver al angulo donde estaba 
           mecanum.mecanumauto(0.1, -0.11, 0.1, -0.11);
    
         }

         else if ( mytime >= 2.0 && mytime < 2.3 ){ //Se acerca a la posicion donde estaba 
           mecanum.tankauto(-0.1, -0.11);
         }

         else if ( mytime >= 2.3 && mytime < 2.3 ){ //Se detiene el chasis y se prende el outtake para lanzar la pieza 
           mecanum.tankauto(0.0, 0.0);
           //Prender el aouttake para lanzar la pieza 
         }

         
         //Todo lo que este abajo de esta linea, sera una posibilidad para que siga este autonomo, en caso de que nuestro equipo no pase por la posicion de enmedio 
        
         else if ( mytime >= 2.3 && mytime < 2.3 ){ //Se detiene el chasis y se prende el outtake para lanzar la pieza 
           mecanum.tankauto(0.0, 0.0);
           //Prender el aouttake para lanzar la pieza 
         }

         else {
            mecanum.tankauto(0.0, 0.0);
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
