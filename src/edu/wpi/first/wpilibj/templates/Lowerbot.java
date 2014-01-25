package edu.wpi.first.wpilibj.templates;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.SimpleRobot;

public class Lowerbot extends SimpleRobot {
    //RobotDrive drive = new RobotDrive (1,2);// Drive  
    Joystick LeftStick = new Joystick (1);  // Left drive stick
    Joystick RightStick = new Joystick (2); // Right drive stick
    Joystick ThirdStick = new Joystick (3); // Arm joystick
    //Compressor mainCompressor = new Compressor(1,1); //Compressor Object
    Solenoid piston1out = new Solenoid(1); //First Solenoid Object
    Solenoid piston1in = new Solenoid (2); //Second Solenoid Object
    Victor testMotor = new Victor(1);
    /*
    public void robotinit(){
        mainCompressor.start();
    }
    */
    public void autonomous() {
        while (true && isAutonomous() && isEnabled()){
        testMotor.set(0.2);
        piston1out.set(true);
        piston1in.set(false);
        Timer.delay(10.0);
         piston1in.set(true);
        piston1out.set(false);
        Timer.delay(10.0);
        piston1in.set(false);
        piston1out.set(false);
        
        testMotor.set(0.0);
        }
    }
    
    public void operatorControl() {
        while (true && isOperatorControl() && isEnabled()){
   
        
        
    if(LeftStick.getRawButton(6) == true){
        piston1out.set(true);
        piston1in.set(false);
    }
    else if(LeftStick.getRawButton(7) == true){
        piston1in.set(true);
        piston1out.set(false);
    }
    
    else{
        piston1in.set(false);
        piston1out.set(false);
        }
        }
    }
}
