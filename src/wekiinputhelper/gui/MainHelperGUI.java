/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wekiinputhelper.gui;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import wekiinputhelper.WekiInputHelperRunner.Closeable;
import wekiinputhelper.util.Util;
import wekiinputhelper.WekiInputHelperRunner;
import wekiinputhelper.WekiInputHelper;
import wekiinputhelper.WekiInputHelperFileData;

/**
 *
 * @author rebecca
 */
public class MainHelperGUI extends javax.swing.JFrame implements Closeable {

    private OSCInputStatusFrame oscInputStatusFrame = null;
    private InputMonitor inputMonitorFrame = null;
    private OutputMonitor outputMonitor = null;
    private final WekiInputHelper w;
    private boolean closeable = true; //flaseif this is the last window open
    
    /**
     * Creates new form MainGUI
     */
    public MainHelperGUI(WekiInputHelper w) {
        initComponents();
        this.w = w;
        addInputsPanel1.setWekiInputHelper(w);
        setGUIForWekiInputHelper();
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Quit?", JOptionPane.YES_NO_OPTION);
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to close this project?", "Close project?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, WekiInputHelperRunner.getIcon());

                if (option == JOptionPane.YES_OPTION) {
                    finishUp();
                }
                
            }
        });

    }

    private void finishUp() {
        w.close();
        this.dispose();
    }

    private void setGUIForWekiInputHelper() {
        this.setTitle(w.getProjectName());
        w.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                wekiInputHelperPropertyChanged(evt);
            }
        });
    }

    private void wekiInputHelperPropertyChanged(PropertyChangeEvent evt) {
        if (evt.getPropertyName() == WekiInputHelper.PROP_PROJECT_NAME) {
            this.setTitle(w.getProjectName());
        } else if (evt.getPropertyName() == WekiInputHelper.PROP_HAS_SAVE_LOCATION) {
            menuItemSave.setEnabled(w.hasSaveLocation());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tabbedPane = new javax.swing.JTabbedPane();
        addInputsPanel1 = new wekiinputhelper.gui.AddInputsPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        menuItemSave = new javax.swing.JMenuItem();
        menuItemSaveAs = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuConsole = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("New project");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tabbedPane.setBackground(new java.awt.Color(255, 255, 255));
        tabbedPane.addTab("Configure Inputs", addInputsPanel1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPane))
        );

        menuFile.setMnemonic('F');
        menuFile.setText("File");

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.META_MASK));
        jMenuItem6.setText("New project");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        menuFile.add(jMenuItem6);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.META_MASK));
        jMenuItem4.setText("Open project...");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menuFile.add(jMenuItem4);

        menuItemSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.META_MASK));
        menuItemSave.setText("Save");
        menuItemSave.setToolTipText("");
        menuItemSave.setEnabled(false);
        menuItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSaveActionPerformed(evt);
            }
        });
        menuFile.add(menuItemSave);

        menuItemSaveAs.setText("Save project as...");
        menuItemSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSaveAsActionPerformed(evt);
            }
        });
        menuFile.add(menuItemSaveAs);

        jMenuBar1.add(menuFile);

        jMenu2.setText("View");

        jMenuItem5.setText("OSC receiver status");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem1.setText("Inputs");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        menuConsole.setText("Console");
        menuConsole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsoleActionPerformed(evt);
            }
        });
        jMenu2.add(menuConsole);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSaveAsActionPerformed
        try {
            if (tabbedPane.getSelectedIndex() == 0) {
                boolean canSave = addInputsPanel1.prepareToSave();
                if (! canSave) {
                    return;
                }
            }
            w.saveAs();
        } catch (IOException ex) {
            Util.showPrettyErrorPane(this, "Could not save file: " + ex.getMessage());
            Logger.getLogger(MainHelperGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemSaveAsActionPerformed

    private void menuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSaveActionPerformed
        if (tabbedPane.getSelectedIndex() == 0) {
                boolean canSave = addInputsPanel1.prepareToSave();
                if (! canSave) {
                    return;
                }
        }
        w.save();
    }//GEN-LAST:event_menuItemSaveActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        //Open project
        
        String homeDir = System.getProperty("user.home");
        File f = Util.findLoadFile(WekiInputHelperFileData.FILENAME_EXTENSION, "Wekinator Input Helper file", homeDir, this);
        if (f != null) {
            try {
                //TODO: Check this isn't same wekinator as mine! (don't load from my same place, or from something already open...)
                WekiInputHelperRunner.getInstance().runFromFile(f.getAbsolutePath());
            } catch (Exception ex) {
                Logger.getLogger(MainHelperGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        showOSCReceiverWindow();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        showInputMonitorWindow();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed

        WekiInputHelperRunner.getInstance().runNewProject();
        //TODO: this or main?

    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void menuConsoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsoleActionPerformed
        w.showConsole();
    }//GEN-LAST:event_menuConsoleActionPerformed

    public void showOutputTable() {
        if (outputMonitor == null) {
            outputMonitor = new OutputMonitor(w);
            outputMonitor.setVisible(true);

           /* Util.callOnClosed(outputTableWindow, (Callable) () -> {
                outputTableWindow = null;
                return null;
            }); */
            Util.CallableOnClosed callMe = new Util.CallableOnClosed() {
                @Override
                public void callMe() {
                    outputMonitor = null;
                }
            };
            Util.callOnClosed(outputMonitor, callMe);
            
        } else {
            outputMonitor.toFront();
        }
    }
    
    public void initializeForInputs() {
        addInputsPanel1.initializeForInputs();
    }

    public void showOSCReceiverWindow() {
        if (oscInputStatusFrame == null) {
            oscInputStatusFrame = new OSCInputStatusFrame(w);
            oscInputStatusFrame.setVisible(true);

            Util.CallableOnClosed callMe = new Util.CallableOnClosed() {
                @Override
                public void callMe() {
                    oscInputStatusFrame = null;
                }
            };
            Util.callOnClosed(oscInputStatusFrame, callMe);
        } else {
            oscInputStatusFrame.toFront();
        }
    }

    private void showInputMonitorWindow() {
        if (inputMonitorFrame == null) {
            inputMonitorFrame = new InputMonitor(w);
            inputMonitorFrame.setVisible(true);

            
            Util.CallableOnClosed callMe = new Util.CallableOnClosed() {
                @Override
                public void callMe() {
                    inputMonitorFrame = null;
                }
            };    
            Util.callOnClosed(inputMonitorFrame, callMe);
        } else {
            inputMonitorFrame.toFront();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /*try {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
         if ("Nimbus".equals(info.getName())) {
         javax.swing.UIManager.setLookAndFeel(info.getClassName());
         break;
         }
         }
         } catch (ClassNotFoundException ex) {
         java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
         //</editor-fold>
         */

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    WekiInputHelper w = WekiInputHelper.TestingWekiInputHelper();
                    new MainHelperGUI(w).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MainHelperGUI.class.getName()).log(Level.SEVERE, null, ex);
                } 

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private wekiinputhelper.gui.AddInputsPanel addInputsPanel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem menuConsole;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem menuItemSave;
    private javax.swing.JMenuItem menuItemSaveAs;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables

    void displayEditOutput(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCloseable(boolean b) {
        this.closeable = b;
    }

    @Override
    public WekiInputHelper getWekiInputHelper() {
        return w;
    }
}
