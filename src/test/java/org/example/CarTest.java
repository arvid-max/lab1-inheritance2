package org.example;

import org.junit.jupiter.api.Test;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
class CarTest {
    @Test // tests getNrDoors()
    void saabDoorsTest() {
        Saab95 saab = new Saab95();
        assertEquals(2, saab.getNrDoors());
    }
    @Test // tests getEnginePower()
    void volvoPowerTest() {
        Volvo240 volvo = new Volvo240();
        assertEquals(100, volvo.getEnginePower());
    }
    @Test // tests getColor() and setColor()
    void saabColorTest() {
        Saab95 saab = new Saab95();
        assertSame(saab.getColor(), Color.red);
        saab.setColor(Color.blue);
        assertSame(saab.getColor(), Color.blue);
    }
    @Test // tests getCurrentSpeed() and startEngine()
    void volvoEngineTest() {
        Volvo240 volvo = new Volvo240();
        assertEquals(0, volvo.getCurrentSpeed());
        volvo.startEngine();
        assertEquals(0.1, volvo.getCurrentSpeed());
    }
    @Test // tests setTurboOn() and setTurboOff()
    void saabTurboTest() {
        Saab95 saab = new Saab95();
        assertFalse(saab.turboOn);
        saab.setTurboOn();
        assertTrue(saab.turboOn);
        saab.setTurboOff();
        assertFalse(saab.turboOn);
    }
    @Test // tests intervals for currentSpeed
    void volvoSpeedIntervalTest() {
        Volvo240 volvo = new Volvo240();
        volvo.incrementSpeed(200);
        assertEquals(100, volvo.getCurrentSpeed());
        volvo.decrementSpeed(400);
        assertEquals(0, volvo.getCurrentSpeed());
    }
    @Test // tests for interval in gas() and brake()
    void saabGasAndBreakIntervalFailure() {
        Saab95 saab = new Saab95();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    saab.gas(2);
                });
        assertThrows(IllegalArgumentException.class,
                () -> {
                    saab.brake(2);
                });
    }
    @Test // tests that gas() can't increase speed
    void volvoGasCantDecreaseSpeed(){
        Volvo240 volvo = new Volvo240();
        double speed_1 = volvo.getCurrentSpeed();
        volvo.gas(0);
        double speed_2 = volvo.getCurrentSpeed();
        assertFalse(speed_1 > speed_2);
        volvo.gas(1);
        double speed_3 = volvo.getCurrentSpeed();
        assertFalse(speed_2 > speed_3);
    }
    @Test // tests that brake() can't decrease speed
    void saabBrakeCantIncreaseSpeed(){
        Saab95 saab = new Saab95();
        saab.incrementSpeed(5);
        double speed_1 = saab.getCurrentSpeed();
        saab.brake(0);
        double speed_2 = saab.getCurrentSpeed();
        assertFalse(speed_1 < speed_2);
        saab.brake(1);
        double speed_3 = saab.getCurrentSpeed();
        assertFalse(speed_2 < speed_3);
    }
}