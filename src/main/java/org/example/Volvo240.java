package org.example;

import java.awt.*;

public class Volvo240 extends Car {
    public Volvo240(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        trimFactor = 1.25;
        modelName = "Volvo240";
        direction = "right";
        position_x = 0;
        position_y = 0;
        stopEngine();
    }
}
