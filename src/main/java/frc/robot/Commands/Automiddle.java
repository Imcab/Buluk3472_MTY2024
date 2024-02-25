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

      /*if (mytime>0.0 && mytime<5){
        mecosmodule.auto(0.1,0.1);
      } else if (mytime>5.0 && mytime<6){
        mecosmodule.auto(0.0,0.0);
      }*/

      if (mytime>0.0 && mytime<1){ // alza brazo, carga outake
        posoutake.setposspeed(0.1);
        moutake.setoutakespeed(0.4);

      } else if (mytime>1 && mytime<2){ //prende index y lanza
        index.setindexspeed(0.5);  
        //piston.Reverse();
      } 
        else if (mytime>2 && mytime<3){ //avanza atras y toma pieza
        posoutake.setposspeed(0);
        moutake.setoutakespeed(0);
        index.setindexspeed(0);

        mecosmodule.auto(0.5,0.5);
       // piston.forward();
       // intake.velocities(1);


      } else if (mytime>3 && mytime<3.5){ //Acomodar brazo y cargar outake
       // intake.velocities(0);
        //piston.Reverse();
        mecosmodule.auto(0, 0);

        posoutake.setposspeed(-0.1);
        moutake.setoutakespeed(0.4);
    
      } else if (mytime>3.5 && mytime<4.5){
        index.setindexspeed(0.5);

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