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

      if (mytime>=0 && mytime<=1){ // alza brazo, carga outake
        piston.forward();
      }

      else if (mytime> 1 && mytime<=2){ // alinea angulo
        moutake.setoutakespeed(1.0);
        posoutake.setposspeed(-0.08);
      }

      else if (mytime> 2 && mytime<=2.5){ // apaga angulo
        moutake.setoutakespeed(1.0);
        posoutake.setposspeed(0);
      }

      else if (mytime> 2.5 && mytime<=3.5){ //lanza pieza
        index.setindexspeed(0.6);
        moutake.setoutakespeed(1.0);
      }

      else if (mytime> 3.5 && mytime<=4.6){
        index.setindexspeed(0);
        intake.velocities(1.0);
        moutake.setoutakespeed(1.0);
        mecosmodule.auto(0.21, 0.2);
      }

      else if (mytime>4.6&& mytime <= 5.7){ //toma 2da pieza
        intake.velocities(1.0);
        mecosmodule.auto(0, 0);
        moutake.setoutakespeed(1.0);
      }

      else if (mytime>5.7&& mytime <= 6.7){  //vuelve a adelante
        intake.velocities(1.0);
        mecosmodule.auto(-0.21, -0.2);
        moutake.setoutakespeed(1.0);
      }

      else if (mytime>6.7&& mytime <= 7.8){
        index.setindexspeed(0.6);
        moutake.setoutakespeed(1.0);
      }

      else if (mytime>7.8&& mytime <= 9.1){
        moutake.setoutakespeed(1.0);
        mecosmodule.auto(0, 0);
      }

      else if (mytime>9.1&& mytime <= 10.4){
        index.setindexspeed(0);
        mecosmodule.auto(0.21, 0.2);
      }
 
      else{
        mecosmodule.auto(0.0,0.0);
        index.setindexspeed(0);
        moutake.setoutakespeed(0);
        intake.velocities(0);  
      }


      /*if (mytime>0 && mytime<1){ // alza brazo, carga outake
        moutake.setoutakespeed(0.95);
        posoutake.setposspeed(-0.08);
        piston.forward();
      }

      else if (mytime> 1 && mytime<1.5){ // apaga angulo
        moutake.setoutakespeed(0.95);
        posoutake.setposspeed(0);
      }

      else if (mytime> 1.5 && mytime<2.5){ //lanza pieza
        index.setindexspeed(0.6);
        moutake.setoutakespeed(0.95);
      }

      else if (mytime>2.5 && mytime<5){
        mecosmodule.auto(0.11,0.1); //3.16 metros a 1  5 seg
        intake.velocities(0.9);
        index.setindexspeed(0);

      } else if (mytime>5 && mytime<5.2){ //freno
        mecosmodule.auto(-0.31,-0.3);
        moutake.setoutakespeed(0.95);
    
      }

       else if (mytime>5.2 && mytime<7.7){ //vuelve a pósicion inicial
        mecosmodule.auto(-0.11,-0.1); //3.16 metros a 1  5 seg
        intake.velocities(0.9);
      
      }

        else if (mytime>7.7 && mytime<9){ //lanza
        mecosmodule.auto(0.0,0.0);
        index.setindexspeed(0.6);

      } else  if(mytime>9 && mytime<12){//Sale de la linea
        mecosmodule.auto(0.11,0.1); 
        

      }else{
        index.setindexspeed(0);
        moutake.setoutakespeed(0);
        intake.velocities(0);
        
      }/* */
      }


      @Override
      public boolean isFinished(){
          
          return false;
      }
        
    
}