/**
 * Copyright (c) 2011 Amity AP CS A Students of 2010-2011.
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
package org.amityregion5.projectx.common.communication.messages;

import java.io.Serializable;

/**
 * Class used to represent a message.
 * 
 * @author Daniel Centore
 * @author Joe Stein
 * @author Michael Zuo
 */
public abstract class Message implements Serializable {
    
    private static final long serialVersionUID = 575L;
    
    public Message()
    {
        try
        {
            throw new Exception();
        } catch (Exception e)
        {
//            System.out.println(e.getStackTrace()[1]);
        }
    }
    
}
