package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@TeleOp(name = "Claw", group = "")

public class Claw extends LinearOpMode{

    private Servo wrist;
    private Servo Claw;

    public void runOpMode() {

        wrist = hardwareMap.servo.get("wrist");
        Claw = hardwareMap.servo.get("Claw");


        waitForStart();

        if (opModeIsActive()) {

            if (gamepad2.left_bumper == true) {
                wrist.setPosition(1);
            } else {
                wrist.setPosition(0);
            }
            if (gamepad2.a) {
                Claw.setPosition(0);
            } else if (gamepad2.b) {
                Claw.setPosition(1);
            }
            telemetry.update();
        }
    }
}