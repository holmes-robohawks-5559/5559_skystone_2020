package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "ParkBuildingZoneRed", group = "")

public class ParkBuildingZoneRed extends LinearOpMode {

    // todo: write your code here
    private DcMotor leftBackDT;
    private DcMotor leftFrontDT;
    private DcMotor rightBackDT;
    private DcMotor rightFrontDT;


    public void runOpMode() {
        leftBackDT = hardwareMap.dcMotor.get("leftBackDT");
        leftFrontDT = hardwareMap.dcMotor.get("leftFrontDT");
        rightFrontDT = hardwareMap.dcMotor.get("rightFrontDT");
        rightBackDT = hardwareMap.dcMotor.get("rightBackDT");
        //Put initialization blocks here.

        if (opModeIsActive()){
            while (opModeIsActive()) {

                // Put loop blocks here.
                telemetry.update();
                leftFrontDT.setPower(1);
                leftBackDT.setPower(1);
                rightFrontDT.setPower(1);
                rightBackDT.setPower(1);
                sleep(1000);

                leftFrontDT.setPower(-1);
                rightFrontDT.setPower(1);
                leftBackDT.setPower(1);
                rightBackDT.setPower(-1);
                sleep(1000);

                leftFrontDT.setPower(1);
                rightFrontDT.setPower(1);
                leftBackDT.setPower(1);
                rightBackDT.setPower(1);
                sleep(1000);

                leftFrontDT.setPower(1);
                rightFrontDT.setPower(1);
                leftBackDT.setPower(1);
                rightBackDT.setPower(1);
                sleep(1000);

                leftFrontDT.setPower(1);
                rightFrontDT.setPower(1);
                leftBackDT.setPower(1);
                rightBackDT.setPower(1);
                sleep(1000);

                leftFrontDT.setPower(1);
                rightFrontDT.setPower(1);
                leftBackDT.setPower(1);
                rightBackDT.setPower(1);
                sleep(1000);

                leftFrontDT.setPower(0);
                rightFrontDT.setPower(0);
                leftBackDT.setPower(0);
                rightBackDT.setPower(0);
                sleep(1000);


            }
        }
    }
}
