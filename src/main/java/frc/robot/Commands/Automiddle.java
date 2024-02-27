package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.subindex;
import frc.robot.Subsystems.subintake;
import frc.robot.Subsystems.submecos;
import frc.robot.Subsystems.suboutake;
import frc.robot.Subsystems.subpiston;
import frc.robot.Subsystems.subpos;


public class Automiddle extends Command {

    private submecos mecosmodule;
    private subpos posoutake;
    private suboutake moutake;
    private subindex index;
    private subintake intake;
    private subpiston piston;


    private  double starttime;
    private  double mytime;


    public Automiddle(submecos mecosmodule, subpos posoutake, subindex index, subintake intake, subpiston piston, suboutake moutake){
      this.mecosmodule = mecosmodule;
      this.index = index;
      this.intake = intake;
      this.moutake = moutake;
      this.posoutake = posoutake;
      this.piston = piston;
      
      addRequirements(mecosmodule, intake, index, moutake, posoutake, piston);
    }
   

    @Override
    public void initialize(){
      starttime = System.currentTimeMillis();
      System.out.println("start time"+starttime);
      
    }

    @Override
    public void execute() {
      mytime = (System.currentTimeMillis() - starttime)/1000;
      System.out.println("mytime"+mytime);


      if (mytime>0.0 && mytime<0.9){ // alza brazo, carga outake
        posoutake.setposspeed(-0.08);
        moutake.setoutakespeed(0.95);

      } else if (mytime> 0.9 && mytime<2){ //apaga angulo
        posoutake.setposspeed(0);


      } else if (mytime> 2 && mytime<2.5){ //lanza pieza
        index.setindexspeed(0.6);
    


      }
       else if (mytime>1 && mytime<3){ //avanza atras 92 cm y toma pieza
        posoutake.setposspeed(0);
        moutake.setoutakespeed(0);
        index.setindexspeed(0); }

        /* mecosmodule.auto(-0.5,-0.5);
       // piston.forward();
       // intake.velocities(0.9);


      } else if (mytime>4 && mytime<4.5){ //parar y cargar outake
       // intake.velocities(0);
        //piston.Reverse();
        mecosmodule.auto(0, 0);
        moutake.setoutakespeed(0.4);
    
      } else if (mytime>4.5 && mytime<6.5){ // avanzar a posicion inicial

        mecosmodule.auto(0.5,0.5);

      } else if (mytime>6.5 && mytime<8){ // lanzar 2da pieza

        mecosmodule.auto(0.0,0.0);
        index.setindexspeed(0.5);  
      
      } else if (mytime>8 && mytime<8.6){ // atras 72 cm
        mecosmodule.auto(-0.5,-0.5);


      } else if (mytime>8.6 && mytime<9){ // rotar derecha
        mecosmodule.auto(-0.5,0.3);

      }  else if (mytime>9 && mytime<10){ // atras 145 cm
        mecosmodule.auto(-0.5,-0.5);
        // intake.velocities(0.9);
        //piston.forward();

      }  else if (mytime>10 && mytime<11){ // parar alinear y cargar outake
        mecosmodule.auto(0.0,0.0);
        moutake.setoutakespeed(0.4);
        posoutake.setposspeed(-0.05);
        
      } else if (mytime>11 && mytime<12){ // lanzar
        index.setindexspeed(0.5);
        
      } else {
        intake.velocities(0);
       // piston.Reverse();
        mecosmodule.auto(0, 0);
        posoutake.setposspeed(0);
        moutake.setoutakespeed(0);
        */
      }


      @Override
      public boolean isFinished(){
          
          return false;
      }
        
    
}