package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.submecos;

public class Auto_test extends Command {

    private submecos mecosmodule;

    private  double starttime;
    private  double mytime;

    public Auto_test(submecos mecosmodule){

        this.mecosmodule = mecosmodule;

        addRequirements(mecosmodule);

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

      if (mytime>0.0 && mytime<5){
        mecosmodule.auto(-0.1,-0.3);
      } else if (mytime>5.0 && mytime<6){
        mecosmodule.auto(0.0,0.0);
      }
    }

    @Override
      public boolean isFinished(){
          
          return false;
      }

    
}