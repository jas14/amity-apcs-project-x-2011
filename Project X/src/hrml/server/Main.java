/**
 * Copyright (c) 2011 res.
 * 
 * ex: set filetype=java expandtab tabstop=4 shiftwidth=4 :
 * 
 * This program is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * 
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published
 * by the Free Software Foundation.
 */
package hrml.server;

import java.net.BindException;
import java.net.ServerSocket;

import hrml.common.Magic;
import hrml.common.Report;

/**
 * @author Michael Zuo <sreservoir@gmail.com>
 */
public class Main
{
    public static void main(String[] argv) {
        Report.debug("started.");
        main();
    }
    public static void main() {
        try {
            loop();
        }
        catch (BindException e) {
            Report.major(e);
            System.exit(1);
        }
        catch (Exception e) {
            Report.error(e);
            main();
        }
    }

    public static int loop()
        throws Exception
    {
        Report.debug("main loop entered.");
        ServerSocket ss = new ServerSocket(Magic.PORT);
        Report.debug("socket established");
        for (int i = 0; ; i++) {
            Client[] reqs = new Client[4];
            double sum = 0;
            for (int j = 0; j < 4; j++) {
                reqs[j] = new Client(ss.accept());
                Report.debug("accept client " + i + "," + j);
                sum += reqs[j].scan.nextDouble();
            }
            for (Client req : reqs)
                req.send.println(sum);
        }
    }

}
