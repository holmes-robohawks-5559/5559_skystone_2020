package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "AutonBasicBlue", group = "")

public class AutonBasicBlue extends LinearOpMode {

    private DcMotor leftBackDT;
    private DcMotor leftFrontDT;
    private DcMotor rightFrontDT;
    private DcMotor RightBackDT;
    private Servo THECLAW;

    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        leftBackDT = hardwareMap.dcMotor.get("leftBackDT");
        leftFrontDT = hardwareMap.dcMotor.get("leftFrontDT");
        rightFrontDT = hardwareMap.dcMotor.get("rightFrontDT");
        RightBackDT = hardwareMap.dcMotor.get("rightBackDT");

        THECLAW = hardwareMap.servo.get("claw");


        // Put initialization blocks here.
        leftBackDT.setDirection(DcMotorSimple.Direction.REVERSE);
        leftFrontDT.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.
            while (opModeIsActive()) {
                // Put loop blocks here.
                telemetry.update();
                leftFrontDT.setPower(1);
                rightFrontDT.setPower(1);
                leftBackDT.setPower(1);
                RightBackDT.setPower(1);
                sleep(1000);
                THECLAW.setPosition(1);
                leftBackDT.setPower(-0.4);
                RightBackDT.setPower(-0.4);
                leftFrontDT.setPower(-0.4);
                rightFrontDT.setPower(-0.4);
                sleep(1000);
                strafeRight(1, 1);
                leftBackDT.setPower(-0);
                RightBackDT.setPower(-0);
                leftFrontDT.setPower(-0);
                rightFrontDT.setPower(-0);
                sleep(90002);
            }
        }
    }

    private void strafeRight(float speed, int time) {
        leftBackDT.setPower(-speed);
        RightBackDT.setPower(speed);
        leftFrontDT.setPower(speed);
        rightFrontDT.setPower(-speed);
        sleep(time);
    }

    private void strafeLeft(float speed, int time) {
        leftBackDT.setPower(speed);
        RightBackDT.setPower(-speed);
        leftFrontDT.setPower(-speed);
        rightFrontDT.setPower(speed);
        sleep(time);
    }
}