package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Autos.kickPieces;
import frc.robot.Autos.outexit;
import frc.robot.Autos.outexitder;
import frc.robot.Autos.outexitizq;
import frc.robot.ChasisCmd.driverobot;
import frc.robot.ColgadorCmd.colgador1;
import frc.robot.ColgadorCmd.colgador1inv;
import frc.robot.ColgadorCmd.colgador2;
import frc.robot.ColgadorCmd.colgador2inv;
import frc.robot.IntakeCmd.comintake;
import frc.robot.IntakeCmd.composintake;
import frc.robot.LimelightCmd.setangle;
import frc.robot.OutakeCmd.PIDoutake;
import frc.robot.OutakeCmd.comout;
import frc.robot.OutakeCmd.composout;
import frc.robot.Subsystems.DriveMecos;
import frc.robot.Subsystems.subcolgador1;
import frc.robot.Subsystems.subcolgador2;
import frc.robot.Subsystems.subintake;
import frc.robot.Subsystems.limelight;
import frc.robot.Subsystems.suboutake;
import frc.robot.Subsystems.suboutakeposicion;
import frc.robot.Subsystems.subposintake;

public class RobotContainer {

  private final DriveMecos mecanum = new DriveMecos();

  private final suboutake moutake = new suboutake();

  private final suboutakeposicion posoutake = new suboutakeposicion();

  private final subintake intake = new subintake();

  private final subcolgador2 colgador2 = new subcolgador2();

  private final subcolgador1 colgador1= new subcolgador1();

  private final subposintake posintake = new subposintake();

  private final limelight limelight = new limelight(); 

  public CommandXboxController driverjoytick = new CommandXboxController(0);
  public CommandXboxController mechjoytick = new CommandXboxController(1);

  private final Command outexit = new outexit(intake, moutake, mecanum, limelight, posoutake);

  private final Command outexitder = new outexitder(intake, moutake, mecanum, limelight, posoutake);

  private final Command outexitizq = new outexitizq(intake, moutake, mecanum, limelight, posoutake);

  private final Command kickPiecesCmd = new kickPieces(mecanum);

  SendableChooser<Command> m_chooser = new SendableChooser<>(); //for autonomous
 
  public RobotContainer() {
    //m_chooser.addOption("1 PIECE", onepiece);
    m_chooser.addOption("1PZ EXIT RIGHT", outexitder);
    m_chooser.addOption("1PZ EXIT LEFT", outexitizq);
    m_chooser.setDefaultOption("1PZ EXIT MIDDLE", outexit);
   
    SmartDashboard.putData(m_chooser); 
  
    driverobot cmdDriverobot = new driverobot(mecanum,

      ()-> driverjoytick.getRawAxis(XboxController.Axis.kLeftX.value),
      ()-> driverjoytick.getRawAxis(XboxController.Axis.kLeftY.value),
      ()-> driverjoytick.getRawAxis(XboxController.Axis.kRightX.value));


    mecanum.setDefaultCommand(cmdDriverobot
    );

    moutake.setDefaultCommand(new comout(moutake,
  
    ()-> mechjoytick.getRawAxis(XboxController.Axis.kRightTrigger.value),
    ()-> mechjoytick.getRawAxis(XboxController.Axis.kLeftTrigger.value)
    ){

    });

    colgador1.setDefaultCommand(new colgador1inv(colgador1,
  
    ()-> driverjoytick.getRawAxis(XboxController.Axis.kRightTrigger.value)
 
    ){

    });

    colgador2.setDefaultCommand(new colgador2inv(colgador2,
  
    ()-> driverjoytick.getRawAxis(XboxController.Axis.kLeftTrigger.value)
 
    ){

    });

    posoutake.setDefaultCommand(new composout(posoutake,

    ()-> mechjoytick.getRawAxis(XboxController.Axis.kLeftY.value)){
    
    });

    configureBindings(); 

  }

  private void configureBindings() { 
 
    mechjoytick.a().whileTrue(new comintake(intake, 0.9));

    mechjoytick.x().whileTrue(new comintake(intake, -0.9));
    
    driverjoytick.rightBumper().whileTrue(new colgador1(colgador1, 1.0));

    driverjoytick.leftBumper().whileTrue(new colgador2(colgador2, 1.0));

   //mechjoytick.rightBumper().whileTrue (new ParallelCommandGroup(new BOOSTREintake(posintake,  145),  new PIDoutake(posoutake, 20.00)));

    mechjoytick.rightBumper().whileTrue(new ParallelCommandGroup(new composintake(posintake, 0.3),new PIDoutake(posoutake, 20.00)));
    mechjoytick.leftBumper().whileTrue(new ParallelCommandGroup(new composintake(posintake, -0.3),new PIDoutake(posoutake, 20.00)));

   // mechjoytick.leftBumper().whileTrue(new ParallelCommandGroup(new BOOSTintake(posintake,  100), new PIDoutake(posoutake, 20.00))); 

    mechjoytick.y().whileTrue(new PIDoutake(posoutake, 242)); //amp

    mechjoytick.b().whileTrue(new setangle(posoutake, limelight)); 
      
  }
  
  public Command getAutonomousCommand() {
    return kickPiecesCmd;
  }
  
} 