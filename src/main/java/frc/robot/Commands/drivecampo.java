package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.Subsystems.DriveMecos;
import java.util.function.Supplier;

public class drivecampo extends Command{

    DriveMecos mecanum;
    Supplier<Double> X,Y,GYROANGLE,rot;

    public drivecampo (DriveMecos mecanum, Supplier<Double> X, Supplier<Double> Y, Supplier<Double>rot){
        this.mecanum = mecanum;
        this.X = X;
        this.Y = Y;
        this.rot = rot;
     
        addRequirements(mecanum);
    }

    @Override
    public void initialize(){}

    @Override
    public void execute(){

        double velX = X.get();
        double velY = Y.get();
        double rotation = rot.get();

        if (Math.abs(velX) < 0.05){
            velX = 0;
        }
        if (Math.abs(velY) < 0.05){
            velY = 0;

        }
        if (Math.abs(rotation) < 0.05){
            rotation = 0;
        }

        mecanum.driveCartesian(velX,velY,rotation, mecanum.angle());
    }

    @Override
    public void end(boolean interrupted) {
        mecanum.driveCartesian(0,0,0);
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}
