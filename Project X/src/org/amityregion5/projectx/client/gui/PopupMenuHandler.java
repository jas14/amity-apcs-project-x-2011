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
package org.amityregion5.projectx.client.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import org.amityregion5.projectx.client.communication.CommunicationHandler;
import org.amityregion5.projectx.common.communication.messages.RequestEntityAddMessage;
import org.amityregion5.projectx.common.entities.Entity;
import org.amityregion5.projectx.common.entities.EntityConstants;
import org.amityregion5.projectx.common.entities.items.field.Block;

/**
 * Note: To add more field items, just modify {@link RequestEntityAddMessage}. It has everything.
 * 
 * @author Daniel Centore
 * 
 */
public class PopupMenuHandler extends MouseAdapter implements ActionListener {

    private int popupX; // where the popup came
    private int popupY;
    private JPopupMenu popup;
    private CommunicationHandler ch;

    public PopupMenuHandler(CommunicationHandler ch)
    {
        this.ch = ch;
        popup = new JPopupMenu();
        JMenu subMenu;
        JMenuItem menuItem;

        // Field Item sub-menu
        subMenu = new JMenu("Add Field Item");

        for (String s : EntityConstants.fieldItems)
        {
            menuItem = new JMenuItem(s);
            menuItem.addActionListener(this);
            subMenu.add(menuItem);
        }
        // End field item sub menu

        popup.add(subMenu);
    }

    public void mousePressed(MouseEvent e)
    {
        maybeShowPopup(e);
    }

    public void mouseReleased(MouseEvent e)
    {
        maybeShowPopup(e);
    }

    private void maybeShowPopup(MouseEvent e)
    {
        if (e.isPopupTrigger())
        {
            popup.show(e.getComponent(), (popupX = e.getX()), (popupY = e.getY()));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();

        ch.send(new RequestEntityAddMessage(s, popupX, popupY));
    }
}