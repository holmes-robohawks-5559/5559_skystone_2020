package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;


@TeleOp(name = "Mecanum Drive", group = "TeleOp")
//FTC Team 11848 | Spare Parts Robotics
public class MecanumDrive extends LinearOpMode
{
    //Variables
    public double leftStickY;
    public double leftStickX;
    public double rightStickX;
    public double FL_power_raw;
    public double FR_power_raw;
    public double RL_power_raw;
    public double RR_power_raw;
    public double FL_power;
    public double FR_power;
    public double RL_power;
    public double RR_power;
    private DcMotor tilt;
    private DcMotor lift;
    double liftJoy;
    private Servo wrist;
    private Servo Claw;

    public double newForward;
    public double newStrafe;
    //BNO055IMU   gyro    = null;
    private DcMotor leftFrontDrive = null;
    private DcMotor rightFrontDrive = null;
    private DcMotor leftBackDrive = null;
    private DcMotor rightBackDrive = null;

    // State used for updating telemetry
    public Orientation angles;
    public Acceleration gravity;

    @Override
    public void runOpMode()
    {
        //gyro = (BNO055IMU)hardwareMap.get(BNO055IMU.class, "gyro");
        leftFrontDrive = hardwareMap.get(DcMotor.class, "leftFrontDT");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "rightFrontDT");
        leftBackDrive = hardwareMap.get(DcMotor.class, "leftBackDT");
        rightBackDrive = hardwareMap.get(DcMotor.class, "rightBackDT");

        tilt = hardwareMap.get(DcMotor.class,"tilt");
        tilt.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        /* tilt.setTargetPosition(2500);
         tilt.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            tilt.setPower(.25);*/

        lift = hardwareMap.get(DcMotor.class,"lift");
        //liftJoy = gamepad2.left_stick_y;

        wrist = hardwareMap.servo.get("wrist");
        Claw = hardwareMap.servo.get("Claw");

        //Wait for the start button to be pressed.
        waitForStart();

        while (opModeIsActive())
        {
            telemetry.addData("count", tilt.getCurrentPosition());
            telemetry.update();

            //lift.setPower(liftJoy);

            if (gamepad2.left_bumper == true) {
                wrist.setPosition(1);

            } else if (gamepad2.right_bumper == true) {
                wrist.setPosition(0);
            }

            if (gamepad2.a) {

                Claw.setPosition(0);

            } else if (gamepad2.b) {
                Claw.setPosition(1);

            }

            if (gamepad2.dpad_up == true) {
                //lift.setTargetPosition(20);
                lift.setPower(.5);

            } else if (gamepad2.dpad_down  == true) {
                //lift.setTargetPosition(2800);
                lift.setPower(-.5);
            } else {
                lift.setPower(0);
            }

            // stick buttons are in as the triggers
            if (gamepad2.y == true) {
                tilt.setTargetPosition(20);
                tilt.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                tilt.setPower(.5);

            } else if (gamepad2.x == true) {
                tilt.setTargetPosition(2800);
                tilt.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                tilt.setPower(.5);
                wrist.setPosition(.5);

            } else {
                tilt.setPower(0);
            }
            telemetry.update();
            controls();
        }

    }


    public void controls()
    {

        //angles = gyro.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);


        holonomicFormula();
        setDriveChainPower();
    }

    public void getJoyValues()
    {
        leftStickY = gamepad1.left_stick_y;
        leftStickX = gamepad1.left_stick_x;
        rightStickX = gamepad1.right_stick_x;

        float pi = 3.1415926f;

        float gyro_degrees = 0;
        //angles.firstAngle;
        float gyro_radians = gyro_degrees * pi/180;
        newForward = leftStickY * Math.cos(gyro_radians) + leftStickX * Math.sin(gyro_radians);
        newStrafe = -leftStickY * Math.sin(gyro_radians) + leftStickX * Math.cos(gyro_radians);
    }

    public void holonomicFormula()
    {
        getJoyValues();

        FL_power_raw = newForward - newStrafe - rightStickX;
        FR_power_raw = newForward + newStrafe + rightStickX;
        RL_power_raw = newForward + newStrafe - rightStickX;
        RR_power_raw = newForward - newStrafe + rightStickX;

        FL_power = Range.clip(FL_power_raw, -1, 1);
        FR_power = Range.clip(FR_power_raw, -1, 1);
        RL_power = Range.clip(RL_power_raw,-1 ,1);
        RR_power = Range.clip(RR_power_raw, -1, 1);
    }

    public void setDriveChainPower()
    {
        leftFrontDrive.setPower(-FL_power);
        rightFrontDrive.setPower(FR_power);
        leftBackDrive.setPower(-RL_power);
        rightBackDrive.setPower(RR_power);
    }
}