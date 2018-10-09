/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acousticfield3d.gui.misc;

import acousticfield3d.algorithms.CalcField;
import acousticfield3d.algorithms.SliceCalculation;
import acousticfield3d.gui.MainForm;
import acousticfield3d.math.M;
import acousticfield3d.math.Vector2f;
import acousticfield3d.math.Vector2i;
import acousticfield3d.math.Vector3f;
import acousticfield3d.scene.Entity;
import acousticfield3d.scene.Scene;
import acousticfield3d.simulation.ControlPoint;
import acousticfield3d.utils.FileUtils;
import acousticfield3d.utils.Parse;
import acousticfield3d.utils.TimerUtil;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author am14010
 */
public class SliceExperiments extends javax.swing.JFrame {
    final MainForm mf;
    private SliceCalculation sc;
    
    public SliceExperiments(MainForm mf) {
        this.mf = mf;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nPointsText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        minSepText = new javax.swing.JTextField();
        calcButton = new javax.swing.JButton();
        initSliceButton = new javax.swing.JButton();
        calcSliceButton = new javax.swing.JButton();
        calcPeaksButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        nPointsMinText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nPointsMaxText = new javax.swing.JTextField();
        startButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        outputText = new javax.swing.JTextField();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Slice Experiments");

        jLabel1.setText("points:");

        nPointsText.setText("200 200");

        jLabel2.setText("separation:");

        minSepText.setText("0.001");

        calcButton.setText("Calc");
        calcButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcButtonActionPerformed(evt);
            }
        });

        initSliceButton.setText("Init Slice");
        initSliceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initSliceButtonActionPerformed(evt);
            }
        });

        calcSliceButton.setText("Calc slice");
        calcSliceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcSliceButtonActionPerformed(evt);
            }
        });

        calcPeaksButton.setText("Calc Peaks");
        calcPeaksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcPeaksButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("nPoints min:");

        nPointsMinText.setText("1");

        jLabel4.setText("to");

        nPointsMaxText.setText("25");

        startButton.setText("start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("outputPrefix:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nPointsText, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minSepText, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(calcButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(initSliceButton)
                        .addGap(18, 18, 18)
                        .addComponent(calcSliceButton)
                        .addGap(18, 18, 18)
                        .addComponent(calcPeaksButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(outputText))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nPointsMinText, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nPointsMaxText, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(startButton))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nPointsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(minSepText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calcButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(initSliceButton)
                    .addComponent(calcSliceButton)
                    .addComponent(calcPeaksButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nPointsMinText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(nPointsMaxText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(outputText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private Entity getSelectedSlice(){
        return Scene.getFirstWithTag(mf.selection, Entity.TAG_SLICE);
    }
    
    private void calcButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcButtonActionPerformed
        final Entity slice = getSelectedSlice();
        if (slice == null) {return;}
        
        final float w = slice.getTransform().getScale().x;
        final float h = slice.getTransform().getScale().y;
        final float minDist = Parse.toFloat( minSepText.getText() );
        
        final int pw = (int)(w / minDist)+1;
        final int ph = (int)(h / minDist)+1;
        nPointsText.setText( pw + " " + ph);
    }//GEN-LAST:event_calcButtonActionPerformed

    private void initSliceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initSliceButtonActionPerformed
        final Entity slice = getSelectedSlice();
        if (slice == null) {return;}
        
        String[] pText = nPointsText.getText().split(" ");
        final int n = Parse.toInt( pText[0] );
        final int m = Parse.toInt( pText[1] );
        
        sc = new SliceCalculation(mf.simulation.getTransducers().size(), n, m);
        //TimerUtil.get().tick("init slice");
        sc.initSliceXZ(mf.simulation, slice.getTransform().getTranslation()
                , slice.getTransform().getScale().x, slice.getTransform().getScale().y);
        //TimerUtil.get().tack("init slice");
    }//GEN-LAST:event_initSliceButtonActionPerformed

    private void calcSliceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcSliceButtonActionPerformed
        //TimerUtil.get().tick("calc slice");
        sc.calcAmp(mf.simulation);
        //TimerUtil.get().tack("calc slice");
    }//GEN-LAST:event_calcSliceButtonActionPerformed

    private void calcPeaksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcPeaksButtonActionPerformed
        final Entity slice = getSelectedSlice();
        if (slice == null) {return;}
        
        final ArrayList<Vector2i> points = sc.findPeaks();
        final ArrayList<Vector3f> points3d = sc.transformPeaksTo3D(points);
        for (Vector3f p : points3d) {
            mf.pointsPanel.addControlPoint(p);
        }
        //System.out.println("Found " + points.size() + " peaks");
    }//GEN-LAST:event_calcPeaksButtonActionPerformed

    private float findRatio(final float[][] points){
        final ArrayList<Vector2i> artefacts = sc.findPeaks();
        final float minDistThre = Parse.toFloat( minSepText.getText() );
        
        //filter the points3D, if they are closer than 1 nw,nh to a real focal point, get he maximum amplitude
        float maxAmpArt = 0;
        final Vector3f art3d = new Vector3f();
        for (Vector2i artefact : artefacts) {
            sc.transform2DTo3D(artefact, art3d);
            final float minDist = minDist(art3d, points); //find the minimum distance to the points
            if (minDist > minDistThre){ //it is not a real point
                final float amp = (float) sc.getAmp()[artefact.x][artefact.y];
                maxAmpArt = M.max(maxAmpArt, amp);
            }
        }
        
        //get minimum amplitude of the points
        float minAmpP = Float.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            float[] point = points[i];
            final float press = CalcField.calcFieldAt( new Vector3f(point), mf).length();
            minAmpP = Math.min(minAmpP, press);
        }
        
        return minAmpP / maxAmpArt;
    }
    
    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        final int startingPoint = Parse.toInt(nPointsMinText.getText());
        final int maxPoints = Parse.toInt(nPointsMaxText.getText());

        //init the slice calculation
        initSliceButtonActionPerformed(null);
                
        for (int iPoint = startingPoint; iPoint <= maxPoints; ++iPoint) {
            try {
                final float[][][] pointsToUse = (float[][][]) FileUtils.readObject(new File("points" + iPoint + ".xml"));

                FileWriter fw = null;
                fw = new FileWriter(new File(outputText.getText() + iPoint + ".csv"));

                final int repetitions = pointsToUse.length;
                //final int repetitions = 100;
                final int nPoints = pointsToUse[0].length;
                
                //create the points
                final ControlPoint[] cPoints = new ControlPoint[nPoints];
                mf.clearSelection();
                for (int i = 0; i < nPoints; ++i) {
                    final ControlPoint cp = new ControlPoint();
                    cPoints[i] = cp;
                    mf.selection.add(cp);
                }

                TimerUtil.get().tick("Seconds");

                for (int i = 0; i < repetitions; ++i) {
                    final float[][] pointSet = pointsToUse[i];
                    //place the control points
                    for (int j = 0; j < nPoints; ++j) {
                        final float[] point = pointSet[j];
                        cPoints[j].getTransform().getTranslation().set(point[0], point[1], point[2]);
                    }

                    //clear the phases
                    mf.simulation.resetTransducers();

                    //run algorithm
                    mf.algForm.runBFGS(false, false, false);

                    //calc the slice
                    calcSliceButtonActionPerformed(null);
                    
                    //calculate ratio min(focal) / max(artefacts)
                    
                    final float ratio = findRatio(pointSet);
                    
                    fw.write(i + "," + ratio + "\n");
 
                }
                TimerUtil.get().tack("Seconds", false);

                mf.clearSelection();

                fw.close();

            } catch (IOException ex) {
                Logger.getLogger(RandPointsExpFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_startButtonActionPerformed

    private float minDist(final Vector3f art3d,final float[][] points) {
        float minDist = Float.MAX_VALUE;
        final Vector3f tmpV =  new Vector3f();
        for (float[] point : points) {
            tmpV.set( point );
            final float cDist = art3d.distance(tmpV);
            minDist = M.min(minDist, cDist);
        }
        return minDist;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calcButton;
    private javax.swing.JButton calcPeaksButton;
    private javax.swing.JButton calcSliceButton;
    private javax.swing.JButton initSliceButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField minSepText;
    private javax.swing.JTextField nPointsMaxText;
    private javax.swing.JTextField nPointsMinText;
    private javax.swing.JTextField nPointsText;
    private javax.swing.JTextField outputText;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables

    
}
