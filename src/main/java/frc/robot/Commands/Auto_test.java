package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.submecos;
import frc.robot.Subsystems.subindex;
import frc.robot.Subsystems.subintake;
import frc.robot.Subsystems.submecos;
import frc.robot.Subsystems.suboutake;
import frc.robot.Subsystems.subpiston;
import frc.robot.Subsystems.subpos;

public class Auto_test extends Command {

    private submecos mecosmodule;
    private subpos posoutake;
    private suboutake moutake;
    private subindex index;
    private subintake intake;
    private subpiston piston;



    private  double starttime;
    private  double mytime;

    public Auto_test(submecos mecosmodule, subindex index, subintake intake,suboutake moutake, subpos posoutake, subpiston piston){

      this.mecosmodule = mecosmodule;
      this.index = index;
      this.intake = intake;
      this.moutake = moutake;
      this.posoutake = posoutake;
      this.piston = piston;
      

        addRequirements(mecosmodule, index, intake, moutake, posoutake, piston);

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

      if (mytime>0.0 && mytime<1){ // alza brazo, carga outake
        moutake.setoutakespeed(0.95);
        posoutake.setposspeed(-0.08);
        

      } else if (mytime> 1 && mytime<2){ //apaga angulo
        posoutake.setposspeed(0);


      } else if (mytime> 2 && mytime<2.5){ //lanza pieza
        index.setindexspeed(0.6);
    


      }

      else if (mytime>2.5 && mytime<4.5){
        mecosmodule.auto(0.11,0.1); //3.16 metros a 1  5 seg
        intake.velocities(0.9);

      } else if (mytime>4.5 && mytime<4.7){
        mecosmodule.auto(-0.31,-0.3);
        moutake.setoutakespeed(0.95);
    
      }
       else if (mytime>4.7 && mytime<6.7){
        mecosmodule.auto(-0.11,-0.1); //3.16 metros a 1  5 seg
        intake.velocities(0.9);
      
      }

        
        else if (mytime>6.7 && mytime<8){ //lanza
  
        mecosmodule.auto(0.0,0.0);
        
        index.setindexspeed(0.6);

      } else  if(mytime>8 && mytime<12){
        mecosmodule.auto(0.11,0.1);
        

      }else{
        index.setindexspeed(0);
        moutake.setoutakespeed(0);
        intake.velocities(0);
      }


      /*else if (mytime>0.0 && mytime<0.9){ // alza brazo, carga outake
        posoutake.setposspeed(-0.08);
        moutake.setoutakespeed(0.95);

      } else if (mytime> 0.9 && mytime<2){ //apaga angulo
        posoutake.setposspeed(0);*/


      }
    
    
    @Override
      public boolean isFinished(){
          
          return false;
      }

    
}