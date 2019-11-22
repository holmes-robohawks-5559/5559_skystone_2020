package org.firstinspires.ftc.teamcode;

        import com.qualcomm.robotcore.eventloop.opmode.Disabled;
        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
        import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
        import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Intake (Blocks to Java)", group = "")
@Disabled
public class Tilt extends LinearOpMode {

    private DcMotor tilt;

    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        tilt = hardwareMap.get(DcMotor.class,"tilt");
        tilt.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //tilt.setTargetPosition(2500);
        //tilt.setPower(.25);
        // Put initialization blocks here.
        waitForStart();
        if (opModeIsActive()) {
            //tilt.setTargetPosition(2500);
            //tilt.setPower(.25);
            // Put run blocks here.
            while (opModeIsActive()) {
                // stick buttons are in as the triggers
                if (gamepad2.y == true) {
                    tilt.setTargetPosition(0);
                    tilt.setPower(.25);

                } else if (gamepad2.x == true) {
                    tilt.setTargetPosition(5000);
                    tilt.setPower(.25);
                } else {
                    tilt.setPower(0);
                }
                telemetry.update();
            }
        }
    }
}
