package mk.jug.pixmas.protocol;

import com.pi4j.wiringpi.Spi;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    Main main = new Main();
//    for (int f = 20000000; f < 32000000; f+=100000) {
//      for (int a1 = 1; a1 < 15; a1++) {
//        for (int a2 = 10; a2 < 23; a2++) {
//          main.doIt(f, a1, a2);
//        }
//      }
//    }
//    main.doIt(500000, 25, 5, 15);
//    main.doIt(1000000, 25, 5, 15);
//    main.doIt(20000000, 25, 5, 12);

//    main.doIt(4000000, 5, 1, 4);
//    main.doIt(8000000, 10, 2, 7);
    main.doIt(20000000, 25, 3, 12);
  }

  public synchronized void doIt(int f, int L, int aa1, int aa2) throws InterruptedException {
    System.out.println(f + " " + aa1 + " " + aa2);
    
    // GpioController gpioController = GpioFactory.getInstance();
    // GpioPinDigitalOutput led = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_00, // PIN
    // // NUMBER
    // "LED", // PIN FRIENDLY NAME (optional)
    // PinState.LOW); // PIN STARTUP STATE (optional)
    //
    // int z = 100;
    // int t = 100;
    // boolean a = true;
    // long b = System.nanoTime();
    // Gpio.digitalWrite(0, false);
    // GpioPinPwmOutput pwmPin = gpioController.provisionPwmOutputPin(RaspiPin.GPIO_01);
    // pwmPin.setMode(null);
    
    byte[] data = new byte[4096];

    int[] matrix = new int[9];
    matrix[0] = 100;
    matrix[1] = 0;
    matrix[2] = 0;
//    matrix[3] = 0;
//    matrix[4] = 100;
//    matrix[5] = 0;
//    matrix[6] = 0;
//    matrix[7] = 0;
//    matrix[8] = 100;

    int xa = 0;
    int xb = 0;
    int xc = 0;

    int a1 = 0;
    StringBuffer sb = new StringBuffer();  
    for (int z = 0; z < 5; z++) {
      
      for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < 8; j++) {
          int xz = (matrix[i] & (1 << j));
          if (xz == 0) {
            a1 = aa1;
          } else {
            a1 = aa2;
          }
          for (int k = 0; k < L; k++) {
            xa = xa * 2;
            xb++;
            if (k < a1) {
              xa = xa + 1;
            }
            if (xb == 8 || (i == matrix.length - 1 && j == 7 && k == (L - 1))) {

              data[xc] = (byte) xa;

              xa = 0;
              xb = 0;
              xc++;
            }
          }
        }
      }
    }
    
//    for (int i = 0; i < xc; i++) {
//      System.out.printf("%#04x, ", (byte) data[i]);
//      String s = Integer.toBinaryString((byte) data[i]);
//      while (s.length() < 8) {
//        s = "0" + s;
//      }
//      sb.append(s);
//      if (i % 20 == 0) {
//        System.out.println();
//      }
//    }
    

    
    int u = Spi.wiringPiSPISetup(Spi.CHANNEL_0, f);
    System.out.println(u);
    u = Spi.wiringPiSPIDataRW(Spi.CHANNEL_0, data, xc);
    System.out.println(u);



    
//    for (int i = 0; i < sb.length(); i++) {
//      if (i % L == 0) {
//        System.out.println("");
//        System.out.print("" + ((i / L) + 1) + " ");
//      }
//      System.out.print(sb.charAt(i));
//    }
//    System.out.println();
//    
//    
//    for (int i = 0; i < xc; i++) {
//      System.out.print(data[i]);
//    }
//    System.out.println();
    
    // System.out.println(System.nanoTime() - b);
    //
    // // first 8 bits.
    // for (int n = 0; n < 2; n++) {
    // for (int i = 0; i < 3; i++) {
    // for (int j = 0; j < 8; j++) {
    // int bit = z & (1 << j);
    // if (a) {
    // System.out.println(System.nanoTime() - b);
    // b = System.nanoTime();
    // }
    // led.high();
    // if (bit == 0) {
    // this.wait(0, 500 - t);
    // } else {
    // this.wait(0, 1200 - t);
    // }
    // if (a) {
    // System.out.println(System.nanoTime() - b);
    // b = System.nanoTime();
    // }
    // led.low();
    // if (bit == 0) {
    // this.wait(0, 2000 - t);
    // } else {
    // this.wait(0, 1300 - t);
    // }
    // }
    // a = false;
    // }
    // }
    //
    // led.low();

    this.wait(1);

  }

}
