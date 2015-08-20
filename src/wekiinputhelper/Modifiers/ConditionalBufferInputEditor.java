/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wekiinputhelper.Modifiers;

import wekiinputhelper.util.Util;
import java.util.HashSet;
import javax.swing.DefaultComboBoxModel;
import wekiinputhelper.Criterion;
import wekiinputhelper.WekiInputHelper;
import wekiinputhelper.gui.InputModifierBuilderPanel;

/**
 *
 * @author rebecca
 */
public class ConditionalBufferInputEditor extends InputModifierBuilderPanel {
    private final WekiInputHelper w;
    //private static final HashSet<String> usedNames = new HashSet<String>();
    
    /**
     * Creates new form FirstOrderDifferenceEditor
     */
    public ConditionalBufferInputEditor() {
        initComponents();
        w = null;
        setDimensionality(10);
        populateTriggerTypes();
    }
    
    public ConditionalBufferInputEditor(WekiInputHelper w) {
        initComponents();
        this.w = w;
        initForWeki(w);
        populateTriggerTypes();
        setDimensionality(10);
        updateNames();
    }
    
    public ConditionalBufferInputEditor(WekiInputHelper w, ConditionalBufferedInput in) {
        initComponents();
        this.w = w;
        initForWeki(w);
        populateTriggerTypes();
        initForExisting(in);
    }
    
    private void populateTriggerTypes() {
        comboCriterion1.setModel(new javax.swing.DefaultComboBoxModel(Criterion.triggerDescriptors));
        comboCriterion2.setModel(new javax.swing.DefaultComboBoxModel(Criterion.triggerDescriptors));

    }

    private void initForExisting(ConditionalBufferedInput in) {
        comboFeatureNames.setSelectedIndex(in.getIndex());
        textBufferSize.setText(Integer.toString(in.getSize()));
        Criterion start = in.getStartCriterion();
        Criterion stop = in.getStopCriterion();
                
        comboInput1.setSelectedIndex(start.getInputIndex());
        comboInput2.setSelectedIndex(stop.getInputIndex());
        
        comboCriterion1.setSelectedIndex(Criterion.getIndexForDescriptor(start.getType()));
        comboCriterion2.setSelectedIndex(Criterion.getIndexForDescriptor(stop.getType()));
        
        textValue1.setText(Double.toString(start.getCriterionValue()));
        textValue2.setText(Double.toString(stop.getCriterionValue()));
        
        setDimensionality(in.getSize());
        updateNames();
    }
    
    private void initForWeki(WekiInputHelper w) {
        String[] inputNames = w.getInputManager().getInputNames();
        comboFeatureNames.setModel(new DefaultComboBoxModel(inputNames));
        comboInput1.setModel(new DefaultComboBoxModel(inputNames));
        comboInput2.setModel(new DefaultComboBoxModel(inputNames));
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
        jLabel1 = new javax.swing.JLabel();
        comboFeatureNames = new javax.swing.JComboBox();
        labelName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textBufferSize = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboInput1 = new javax.swing.JComboBox();
        comboCriterion1 = new javax.swing.JComboBox();
        textValue1 = new javax.swing.JTextField();
        comboInput2 = new javax.swing.JComboBox();
        comboCriterion2 = new javax.swing.JComboBox();
        textValue2 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(468, 175));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jLabel1.setText("using input:");

        comboFeatureNames.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        comboFeatureNames.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboFeatureNames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFeatureNamesActionPerformed(evt);
            }
        });

        labelName.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        labelName.setText("Names: feature1[n]...feature1[n-10]");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jLabel2.setText("Then downsample results into buffer of size ");

        textBufferSize.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        textBufferSize.setText("10");
        textBufferSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBufferSizeActionPerformed(evt);
            }
        });
        textBufferSize.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textBufferSizeKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textBufferSizeKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jLabel3.setText("Start recording when");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jLabel4.setText("Stop recording when");

        comboInput1.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        comboInput1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "input-1", "input-2", "input-3" }));

        comboCriterion1.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        comboCriterion1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "is greater than or equal to", "is less than or equal to", "changes" }));
        comboCriterion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCriterion1ActionPerformed(evt);
            }
        });

        textValue1.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        textValue1.setText("0");
        textValue1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textValue1KeyTyped(evt);
            }
        });

        comboInput2.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        comboInput2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "input-1", "input-2", "input-3" }));

        comboCriterion2.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        comboCriterion2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "is greater than or equal to", "is less than or equal to", "changes" }));
        comboCriterion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCriterion2ActionPerformed(evt);
            }
        });

        textValue2.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        textValue2.setText("0");
        textValue2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textValue2KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(345, 345, 345))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, 0)
                        .addComponent(comboFeatureNames, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(labelName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(comboInput1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboCriterion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(textValue1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(comboInput2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboCriterion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textValue2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textBufferSize, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboFeatureNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboInput1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCriterion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textValue1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboInput2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCriterion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textValue2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textBufferSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(labelName)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboFeatureNamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFeatureNamesActionPerformed
       // labelName.setText("Name: " + FirstOrderDifference.makeName(w.getInputManager().getInputNames()[comboFeatureNames.getSelectedIndex()]));
        updateNames();
    }//GEN-LAST:event_comboFeatureNamesActionPerformed

    private void textBufferSizeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBufferSizeKeyTyped
        char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        } else {
            updateNames();
        }
    }//GEN-LAST:event_textBufferSizeKeyTyped

    private void textBufferSizeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBufferSizeKeyReleased
        updateDimensionality();
        updateNames();
    }//GEN-LAST:event_textBufferSizeKeyReleased

    private void textBufferSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBufferSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textBufferSizeActionPerformed

    private void comboCriterion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCriterion1ActionPerformed

    }//GEN-LAST:event_comboCriterion1ActionPerformed

    private void textValue1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textValue1KeyTyped
        char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter)) && !(enter == '.') && !(enter == '-')) {
            evt.consume();
        }
    }//GEN-LAST:event_textValue1KeyTyped

    private void comboCriterion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCriterion2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCriterion2ActionPerformed

    private void textValue2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textValue2KeyTyped
        char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter)) && !(enter == '.') && !(enter == '-')) {
            evt.consume();
        }
    }//GEN-LAST:event_textValue2KeyTyped

    private void updateDimensionality() {
        try { 
            int i = Integer.parseInt(textBufferSize.getText());
            setDimensionality(i);
        } catch (NumberFormatException ex) {
            setDimensionality(0);
        }
    }
    
    private void updateNames() {
        try {
            String baseName = w.getInputManager().getInputNames()[comboFeatureNames.getSelectedIndex()];
            String baseMod = baseName + "_buf" + getDimensionality();
            
            int i = getDimensionality();
            if (i > 0) {
                StringBuilder sb = new StringBuilder("Names: ");
                sb.append(baseMod).append("[n]");
                if (i > 1) {
                    sb.append(", ").append(baseMod).append("[n-1]");
                } 
                if (i > 2) {
                    if (i ==3) {
                        sb.append(", ").append(baseMod).append("[n-2]");
                    } else {
                        sb.append("...").append(baseMod).append("[n-").append(i-1).append("]");
                    }
                }
                labelName.setText(sb.toString());
            } else {
                labelName.setText("Names: ");
            }
        
        } catch (NumberFormatException ex) {
            labelName.setText("Names: ");    
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboCriterion1;
    private javax.swing.JComboBox comboCriterion2;
    private javax.swing.JComboBox comboFeatureNames;
    private javax.swing.JComboBox comboInput1;
    private javax.swing.JComboBox comboInput2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelName;
    private javax.swing.JTextField textBufferSize;
    private javax.swing.JTextField textValue1;
    private javax.swing.JTextField textValue2;
    // End of variables declaration//GEN-END:variables

    @Override
    public boolean validateForm() {
        try {
            int i = Integer.parseInt(textBufferSize.getText());
            if (i < 1) {
              Util.showPrettyErrorPane(this, "Buffer size must be greater than 0");
                return false;  
            }
        } catch (NumberFormatException ex) {
            Util.showPrettyErrorPane(this, "Buffer size must be greater than 0");
            return false;
        }
        try {
            double d = Double.parseDouble(textValue1.getText());
        } catch (NumberFormatException ex) {
            Util.showPrettyErrorPane(this, "Start condition must be a valid number");
            return false;
        }
        try {
            double d = Double.parseDouble(textValue2.getText());
        } catch (NumberFormatException ex) {
            Util.showPrettyErrorPane(this, "STop condition must be a valid number");
            return false;
        }
        return true;
    }

    @Override
    public ModifiedInput getModifiedInput() {
        int i = comboFeatureNames.getSelectedIndex();
        int s = Integer.parseInt(textBufferSize.getText());
        Criterion start = getStartFromForm();
        Criterion stop = getStopFromForm();
        return new ConditionalBufferedInput(w.getInputManager().getInputNames()[i],i, s, start, stop);
    }
    
    private Criterion getStartFromForm() {
        int index = comboInput1.getSelectedIndex();
        int which = comboCriterion1.getSelectedIndex();
        Criterion.CriterionType type = Criterion.typesForTriggerDescriptors[which];
        double val = Double.parseDouble(textValue1.getText());
        return new Criterion(type, Criterion.HowLong.REPEAT, index, Criterion.AppliesTo.INPUT, val);
    }
    
    private Criterion getStopFromForm() {
        int index = comboInput2.getSelectedIndex();
        int which = comboCriterion2.getSelectedIndex();
        Criterion.CriterionType type = Criterion.typesForTriggerDescriptors[which];
        double val = Double.parseDouble(textValue2.getText());
        return new Criterion(type, Criterion.HowLong.REPEAT, index, Criterion.AppliesTo.INPUT, val);
    }
    
    /*public static String getNewNameModifier(String baseName) { 
        int i = 1;
        String s = baseName + "_buf" + i;
        while (usedNames.contains(s)) {
            i++;
            s = baseName + "_buf" + i;
        }
        usedNames.add(s);
        return s;
    } */
}