package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.subindex;
import frc.robot.Subsystems.subintake;
import frc.robot.Subsystems.submecos;
import frc.robot.Subsystems.suboutake;
import frc.robot.Subsystems.subpiston;
import frc.robot.Subsystems.subpos;


public class autista extends Command {


    submecos mecosmodule;
    subpos posoutake;
    suboutake moutake;
    subindex index;
    subintake intake;
    subpiston piston;


    private  double starttime;
    private  double mytime;

    public autista(submecos mecosmodule, subpos posoutake, subindex index, subintake intake, subpiston piston, suboutake moutake){
        
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

      if (mytime>=0 && mytime<=1){ // alza brazo, carga outake
        moutake.setoutakespeed(1.0);
        posoutake.setposspeed(-0.08);
        piston.forward();
      }

      else if (mytime> 1 && mytime<=1.5){ // apaga angulo
        moutake.setoutakespeed(1.0);
        posoutake.setposspeed(0);
      }

      else if (mytime> 1.5 && mytime<=2.5){ //lanza pieza
        index.setindexspeed(0.6);
        moutake.setoutakespeed(1.0);
      }
 

      else{
        mecosmodule.auto(0.0,0.0);
        index.setindexspeed(0);
        moutake.setoutakespeed(0);
        intake.velocities(0);
        
      }


      



  
    
    }



    @Override
    public boolean isFinished(){
          
          return false;
      } 
    
    
    
    }