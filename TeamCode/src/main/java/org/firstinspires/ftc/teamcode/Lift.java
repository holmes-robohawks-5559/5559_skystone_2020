package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;



@TeleOp(name = "Lift", group = "")

public class Lift extends LinearOpMode {

    private DcMotor lift;
    double liftJoy;

    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        lift = hardwareMap.get(DcMotor.class,"lift");
        liftJoy = gamepad2.left_stick_y;
        //lift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        // Put initialization blocks here.
        waitForStart();
        if (opModeIsActive()) {

            // Put run blocks here.
            while (opModeIsActive()) {
                // stick buttons are in as the triggers

                //lift.setPower(liftJoy);
                if (gamepad2.dpad_up == true) {
                    //lift.setTargetPosition(20);
                    lift.setPower(.5);

                } else if (gamepad2.dpad_down  == true) {
                    //lift.setTargetPosition(2800);
                    lift.setPower(-.5);
                } else {
                    lift.setPower(0);
                }

                telemetry.update();
            }
        }
    }
}
