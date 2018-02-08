package org.usfirst.frc.team2929.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class ArcadeDrive
{
	WPI_TalonSRX	leftMotor1,
					leftMotor2,
					leftMotor3,
					rightMotor1,
					rightMotor2,
					rightMotor3;
	
	AutoRoutine		defaultAuto	= new AutoRoutine();
	
	
	public void driveCreation(WPI_TalonSRX leftDrive1, WPI_TalonSRX leftDrive2, WPI_TalonSRX leftDrive3, WPI_TalonSRX rightDrive1, 
							WPI_TalonSRX rightDrive2, WPI_TalonSRX rightDrive3)
	{
		leftMotor1 	= leftDrive1;
		leftMotor2 	= leftDrive2;
		leftMotor3 	= leftDrive3;
		rightMotor1 = rightDrive1;
		rightMotor2 = rightDrive2;
		rightMotor3 = rightDrive3;
	}
	
	public void driver(float leftStickY, float rightStickY, float dB)
	{
		if(leftStickY > dB || rightStickY < -dB)
		{
			leftMotor1.set(-leftStickY);
			leftMotor2.set(-leftStickY);
			leftMotor3.set(-leftStickY);
		}
		else
		{
			leftMotor1.set(0);
			leftMotor2.set(0);
			leftMotor3.set(0);
		}
		
		if(rightStickY > dB || rightStickY < -dB)
		{
			rightMotor1.set(rightStickY);
			rightMotor2.set(rightStickY);
			rightMotor3.set(rightStickY);
		}
		else
		{
			rightMotor1.set(0);
			rightMotor2.set(0);
			rightMotor3.set(0);
		}
	}
	
	public void deployAuto()
	{
		defaultAuto.basicRoutine(leftMotor1, leftMotor2, leftMotor3, rightMotor1, rightMotor2, rightMotor3);
	}
}
