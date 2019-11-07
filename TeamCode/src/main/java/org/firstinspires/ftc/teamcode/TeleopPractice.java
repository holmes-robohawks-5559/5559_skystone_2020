package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "teleoppractice (Blocks to Java)", group = "")
public class TeleopPractice extends LinearOpMode {

    private DcMotor leftBackDT;
    private DcMotor leftFrontDT;
    private DcMotor rightBackDT;
    private DcMotor rightFrontDT;
    private Servo foundationclamp1;

    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        double tgtPower;

        leftBackDT = hardwareMap.dcMotor.get("leftBackDT");
        leftFrontDT = hardwareMap.dcMotor.get("leftFrontDT");
        rightBackDT = hardwareMap.dcMotor.get("rightBackDT");
        rightFrontDT = hardwareMap.dcMotor.get("rightFrontDT");
        foundationclamp1 = hardwareMap.servo.get("foundation clamp1");

        // Put initialization blocks here.
        leftBackDT.setDirection(DcMotorSimple.Direction.REVERSE);
        leftFrontDT.setDirection(DcMotorSimple.Direction.REVERSE);
        rightBackDT.setDirection(DcMotorSimple.Direction.REVERSE);
        rightFrontDT.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();
        if (opModeIsActive()) {
            // Put loop blocks here.
            if (gamepad1.a == true) {
                foundationclamp1.setPosition(0);
            } else if ((gamepad1.x && gamepad1.b) == true) {
                foundationclamp1.setPosition(0.5);
            } else if (gamepad1.b == true) {
                foundationclamp1.setPosition(1);
            } else {
                foundationclamp1.setPosition(0.5);
            }
            while (opModeIsActive()) {
                // Put loop blocks here.
                tgtPower = -gamepad1.left_stick_y;
                leftBackDT.setPower(tgtPower);
                telemetry.addData("Target Power", tgtPower);
                telemetry.addData("Motor Power", leftBackDT.getPower());
                telemetry.addData("Servo Position", leftBackDT.getPower());
                telemetry.update();
                tgtPower = -gamepad1.left_stick_y;
                leftFrontDT.setPower(tgtPower);
                telemetry.addData("Target Power", tgtPower);
                telemetry.addData("Motor Power", leftFrontDT.getPower());
                telemetry.addData("Servo Position", leftFrontDT.getPower());
                tgtPower = -gamepad1.left_stick_y;
                rightBackDT.setPower(tgtPower);
                telemetry.addData("Target Power", tgtPower);
                telemetry.addData("Motor Power", rightBackDT.getPower());
                telemetry.addData("Servo Position", rightBackDT.getPower());
                tgtPower = -gamepad1.left_stick_y;
                rightFrontDT.setPower(tgtPower);
                telemetry.addData("Target Power", tgtPower);
                telemetry.addData("Motor Power", rightFrontDT.getPower());
                telemetry.addData("Servo Position", rightFrontDT.getPower());
            }
        }
    }
}
