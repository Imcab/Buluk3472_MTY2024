package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.subindex;
import frc.robot.Subsystems.subintake;
import frc.robot.Subsystems.submecos;
import frc.robot.Subsystems.suboutake;
import frc.robot.Subsystems.subpiston;
import frc.robot.Subsystems.subpos;


public class Autoright extends Command {


    submecos mecosmodule;
    subpos posoutake;
    suboutake moutake;
    subindex index;
    subintake intake;
    subpiston piston;


    private  double starttime;
    private  double mytime;

    public Autoright(submecos mecosmodule, subpos posoutake, subindex index, subintake intake, subpiston piston, suboutake moutake){
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

      if (mytime>0.0 && mytime<1){

        



      }









    }

}