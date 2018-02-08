package org.usfirst.frc.team2929.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class ArmIntake
{

	WPI_TalonSRX 	leftIntake,
					rightIntake;
	
	public void intakeCreation(WPI_TalonSRX leftIntakeMotor, WPI_TalonSRX rightIntakeMotor)
	{
		leftIntake 	= leftIntakeMotor;
		rightIntake = rightIntakeMotor;
	}
	
	public void intake(JoystickButton intakeButton, JoystickButton ejectButton)
	{
		if(intakeButton.get() && !ejectButton.get())
		{
			leftIntake.set(0.25);
			rightIntake.set(-0.25);
		}
		else if(!intakeButton.get() && ejectButton.get())
		{
			leftIntake.set(-.25);
			rightIntake.set(0.25);
		}
		else
		{
			leftIntake.set(0);
			rightIntake.set(0);
		}
	}
	
}
