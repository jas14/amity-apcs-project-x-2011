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

import java.awt.Frame;
import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.SwingUtilities;

import org.amityregion5.projectx.client.preferences.PreferenceManager;

/**
 * Handles username selection
 *
 * @author Joe Stein
 * @author Daniel Centore
 */
public class UsernameWindow extends JDialog
{

   private static final long serialVersionUID = 353L;
   
   /**
    * Creates new form UsernameWindow
    * @param welcome whether or not to include a welcome message, i.e. if the
    * user is using Project X for the first time
    */
   public UsernameWindow(Frame parent, boolean modal, boolean welcome)
   {
      super(parent, modal);
      initComponents();
      if (welcome)
      {
         headText.setText("Welcome to Project X! Enter a username:");
      }
      this.setVisible(true);
   }
   /** This method is called from within the constructor to
    * initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is
    * always regenerated by the Form Editor.
    */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headText = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        okBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Change Username");

        headText.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        headText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headText.setText("Please enter a username:");

        usernameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usernameFieldKeyPressed(evt);
            }
        });

        okBtn.setText("OK");
        okBtn.setEnabled(false);
        okBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(usernameField, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(okBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(headText, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(okBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_okBtnActionPerformed
    {//GEN-HEADEREND:event_okBtnActionPerformed
       PreferenceManager.setUsername(usernameField.getText());
       this.dispose();
    }//GEN-LAST:event_okBtnActionPerformed

    private void usernameFieldKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_usernameFieldKeyPressed
    {//GEN-HEADEREND:event_usernameFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            if (usernameField.getText().length() < 1)
            {
                evt.consume();
            } else
            {
                PreferenceManager.setUsername(usernameField.getText());
                this.dispose();
            }
        }

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                okBtn.setEnabled(usernameField.getText().length() > 0);
            }
        });
    }//GEN-LAST:event_usernameFieldKeyPressed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel headText;
    private javax.swing.JButton okBtn;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
