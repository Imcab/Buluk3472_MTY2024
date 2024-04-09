package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Commands.setangle;
import frc.robot.Commands.colgador1inv;
import frc.robot.Commands.colgador2inv;
import frc.robot.Commands.colgador2;
import frc.robot.Commands.PIDoutake;
import frc.robot.Commands.colgador1;
import frc.robot.Commands.comintake;
import frc.robot.Commands.comout;
import frc.robot.Commands.composintake;
import frc.robot.Commands.composout;
import frc.robot.Commands.driverobot;
import frc.robot.Commands.onepiece;
import frc.robot.Commands.pieceOut;
import frc.robot.Commands.tridente;
import frc.robot.Commands.twopieces;
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

  private final Command onepiece = new onepiece(mecanum, posoutake, intake, moutake, posintake);

  private final Command twopieces = new twopieces(mecanum, posoutake, intake, moutake, posintake);

  private final Command threepieces = new tridente(mecanum, posoutake, intake, moutake, posintake);

  private final Command pieceOut = new pieceOut(mecanum, posoutake, intake, moutake, posintake);

  SendableChooser<Command> m_chooser = new SendableChooser<>(); //for autonomous
 
  public RobotContainer() {
    m_chooser.addOption("1 PIECE", onepiece);
    m_chooser.addOption("SHOOT AND GO", pieceOut);
    m_chooser.addOption("2 PIECES MIDDLE", twopieces);
    m_chooser.setDefaultOption("3 PIECES MIDDLE", threepieces);
   
    SmartDashboard.putData(m_chooser);
    limelight.getDefaultCommand(); 
    double x= limelight.getX(); 
    SmartDashboard.putNumber("x", x); 


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
    return m_chooser.getSelected();
  }
  
} 