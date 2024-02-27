package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.subindex;
import frc.robot.Subsystems.subintake;
import frc.robot.Subsystems.submecos;
import frc.robot.Subsystems.suboutake;
import frc.robot.Subsystems.subpiston;
import frc.robot.Subsystems.subpos;


public class Autoleft extends Command {


    submecos mecosmodule;
    subpos posoutake;
    suboutake moutake;
    subindex index;
    subintake intake;
    subpiston piston;


    private  double starttime;
    private  double mytime;

    public Autoleft(submecos mecosmodule, subpos posoutake, subindex index, subintake intake, subpiston piston, suboutake moutake){
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

       mecosmodule.auto(0, 0);
        index.setindexspeed(0.5);

      if (mytime>0.0 && mytime<1){ // alza brazo, carga outake
        posoutake.setposspeed(0.1);
        moutake.setoutakespeed(0.4);
  
      } else if (mytime>1 && mytime<2){ //prende index y lanza
        index.setindexspeed(0.5);  
        //piston.Reverse();

      } else if (mytime>2 && mytime<3){ // atras 40 cm 
        index.setindexspeed(0.0);
        mecosmodule.auto(-0-5, -0.5);
  
      }  else if (mytime>3 && mytime<3.5){ // rotar izquierda quedar alineado con la siguiente pieza
        index.setindexspeed(0.0);
        mecosmodule.auto(0.3, -0.5);
  
      } else if (mytime>3.5 && mytime<5.5){ // atras 140 cm
        index.setindexspeed(0.0);
        mecosmodule.auto(0, 0);
        //piston.forward();
        //intake.velocities(0.9);
  
      } else if (mytime>3 && mytime<3.5){ // rotar derecha quedar alineado con objetivo
        index.setindexspeed(0.0);
        mecosmodule.auto(-0.3, 0.5);
  
      } else if (mytime>5.5 && mytime<6){ // alinea brazo, carga outake
        posoutake.setposspeed(-0.1);
        moutake.setoutakespeed(0.4);
  
      } else if (mytime>6 && mytime<7){ // lanza
        posoutake.setposspeed(-0.1);
        moutake.setoutakespeed(0.4);
  
      } else {
        intake.velocities(0);
       // piston.Reverse();
        mecosmodule.auto(0, 0);
        posoutake.setposspeed(0);
        moutake.setoutakespeed(0);
        
      }

      }

      @Override
      public boolean isFinished(){
          
          return false;
      }
    }