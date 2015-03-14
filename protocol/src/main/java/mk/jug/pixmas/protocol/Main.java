package mk.jug.pixmas.protocol;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;


public class Main {
  
  public static void main(String[] args) throws InterruptedException {
    GpioController gpioController = GpioFactory.getInstance();
    GpioPinDigitalOutput led = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_00,   // PIN NUMBER
        "LED",           // PIN FRIENDLY NAME (optional)
        PinState.LOW);      // PIN STARTUP STATE (optional)

    int z = 100;
    
    // first 8 bits.
    for (int n = 0; n < 2; n++) {      
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 8; j++) {
          int bit = z & (1 << j);
          led.high();
          if (bit == 0) {
            Thread.currentThread().wait(0, 500);
          } else {
            Thread.currentThread().wait(0, 1200);            
          }
          led.low();
          if (bit == 0) {
            Thread.currentThread().wait(0, 2000);
          } else {
            Thread.currentThread().wait(0, 1300);                        
          }
        }
      }
    }
    led.low();
    
  }

}
