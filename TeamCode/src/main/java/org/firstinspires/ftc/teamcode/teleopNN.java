package org.firstinspires.ftc.teamcode;

        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
        import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
        import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "teleopNN (Blocks to Java)", group = "")
public class teleopNN extends LinearOpMode {

    private DcMotor leftbackDT;
    private DcMotor leftfrontDT;
    private DcMotor rightbackDT;
    private DcMotor rightfrontDT;

    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        double tgtPower;

        leftbackDT = hardwareMap.dcMotor.get("leftbackDT");
        leftfrontDT = hardwareMap.dcMotor.get("leftfrontDT");
        rightbackDT = hardwareMap.dcMotor.get("rightbackDT");
        rightfrontDT = hardwareMap.dcMotor.get("rightfrontDT");

        // Put initialization blocks here.
        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.
            while (opModeIsActive()) {
                // Put loop blocks here.
                tgtPower = -gamepad1.right_stick_x;
                tgtPower = gamepad1.right_stick_y;
                leftbackDT.setPower(tgtPower);
                leftfrontDT.setPower(tgtPower);
                rightbackDT.setPower(tgtPower);
                rightfrontDT.setPower(tgtPower);
                telemetry.addData("Target Power", tgtPower);
                telemetry.addData("Motor Power", leftbackDT.getPower());
                telemetry.addData("Motor Power", leftfrontDT.getPower());
                telemetry.addData("Motor Power", rightbackDT.getPower());
                telemetry.addData("Motor Power", rightfrontDT.getPower());
                telemetry.update();
            }
        }
    }
}
