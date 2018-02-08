package org.usfirst.frc.team2929.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.*;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Robot extends IterativeRobot
{

	WPI_TalonSRX	leftMotor1	= new WPI_TalonSRX(0),
					leftMotor2	= new WPI_TalonSRX(1),
					leftMotor3	= new WPI_TalonSRX(2),
					rightMotor1	= new WPI_TalonSRX(3),
					rightMotor2	= new WPI_TalonSRX(4),
					rightMotor3	= new WPI_TalonSRX(5),
					
					liftMotor			= new WPI_TalonSRX(6),
					leftIntakeMotor		= new WPI_TalonSRX(7),
					rightIntakeMotor	= new WPI_TalonSRX(8);
	
	Joystick		gamePad			= new Joystick(0);
	
	JoystickButton	hoistButton		= new JoystickButton(gamePad, 2),
					intakeButton	= new JoystickButton(gamePad, 7),
					ejectButton		= new JoystickButton(gamePad, 8),
					shiftButton		= new JoystickButton(gamePad, 3);
	
	DigitalInput	liftTopSwitch		= new DigitalInput(0),
					liftBottomSwitch	= new DigitalInput(1);
	
	Compressor		comp			= new Compressor(0);
	
	Solenoid		shifter			= new Solenoid(0);
	
	ArcadeDrive		robotDrive;
	ArmLift			robotLift;
	ArmIntake		robotIntake;
	
	float			leftStickY,
					rightStickY,
					deadBand		= (float) 0.2;
	
	@Override
	public void robotInit()
	{
		comp.start();

		robotDrive = new ArcadeDrive();
		robotDrive.driveCreation(leftMotor1, leftMotor2, leftMotor3, rightMotor1, rightMotor2, rightMotor3);
		
		robotLift = new ArmLift();
		robotLift.liftCreation(liftMotor);
		
		robotIntake = new ArmIntake();
		robotIntake.intakeCreation(leftIntakeMotor, rightIntakeMotor);
	}

	@Override
	public void autonomousInit()
	{
		
	}
	
	@Override
	public void autonomousPeriodic()
	{
		robotDrive.deployAuto();
	}

	@Override
	public void teleopPeriodic()
	{
		robotDrive.driver(leftStickY, rightStickY, deadBand);
		robotLift.deployLift(hoistButton, liftTopSwitch, liftBottomSwitch);
		robotIntake.intake(intakeButton, ejectButton);
	}

	@Override
	public void testPeriodic()
	{

	}
}
