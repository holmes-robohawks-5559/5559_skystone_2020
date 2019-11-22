package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "AutonMediumRed1", group = "")

public class AutonMediumRed1 extends LinearOpMode {

    private DcMotor leftBackDT;
    private DcMotor leftFrontDT;
    private DcMotor rightFrontDT;
    private DcMotor RightBackDT;
    private Servo THECLAW;
    private Servo foundationclamp1;
    private Servo foundationclamp2;

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
        foundationclamp1 = hardwareMap.servo.get("clamp1");
        foundationclamp2 = hardwareMap.servo.get("clamp2");

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
                foundationclamp1.setPosition(0.25);
                foundationclamp2.setPosition(-0.25);
                sleep(1000);
                THECLAW.setPosition(1);
                foundationclamp1.setPosition(0);
                foundationclamp2.setPosition(0);
                leftBackDT.setPower(-0.4);
                RightBackDT.setPower(-0.4);
                leftFrontDT.setPower(-0.4);
                rightFrontDT.setPower(-0.4);
                sleep(1000);
                leftBackDT.setPower(-0.8);
                RightBackDT.setPower(-0.8);
                leftFrontDT.setPower(-0.8);
                rightFrontDT.setPower(-0.8);
                sleep(1000);
                strafeLeft(1, 1);
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
