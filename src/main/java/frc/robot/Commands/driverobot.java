package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.Subsystems.DriveMecos;
import java.util.function.Supplier;

public class driverobot extends Command{

    DriveMecos submecos;
    Supplier<Double> X,Y,Z;

    public driverobot (DriveMecos submecos, Supplier<Double> X, Supplier<Double> Y, Supplier<Double> Z){
        this.submecos = submecos;
        this.X = X;
        this.Y = Y;
        this.Z = Z;

        addRequirements(submecos);
    }

    @Override
    public void initialize(){}

    @Override
    public void execute(){

        double velX = X.get();
        double velY = Y.get();
        double velZ = Z.get();

        if (Math.abs(velX) < 0.05){
            velX = 0;
        }
        if (Math.abs(velY) < 0.05){
            velY = 0;
        }
        if (Math.abs(velZ) < 0.05){
            velZ = 0;
        }

        submecos.driveCartesian(velX,velY,velZ);

    }

    @Override
    public void end(boolean interrupted) {
        submecos.driveCartesian(0,0,0);
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}
