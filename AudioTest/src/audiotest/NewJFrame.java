
package audiotest;

import jaco.mp3.player.MP3Player;
import java.awt.Color;
import java.awt.Image;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import javax.swing.Timer;
import newpackage.ListModel;
import newpackage.modelJDBC;



public class NewJFrame extends javax.swing.JFrame
{
    public static final String song =  "C:\\Users\\ASUS\\Downloads\\y2mate.com - Anh Chưa Thương Em Đến Vậy Đâu  Lady Mây  The Masked Singer Vietnam Audio Lyrics.mp3";
    MP3Player mp3Player = new MP3Player();
    public int xVelocaty = 1;
    public final int WIDTH = 339;
    int xLable;
    public ListModel listModel;
    int index_BaiHat = 0;
    
    public NewJFrame()
    {   
        this.setBackground(getForeground().CYAN);
        
        // lấy dữ liệu từ model
       listModel = new ListModel();
       setDataForMP3Player();
       
       // set text cho jlable
       jLabel1 = new JLabel();
       
       initComponents();
        
        // set jProgressbar
        jProgressBar1.setValue(listModel.list.get(index_BaiHat).getTime());
        jProgressBar1.setStringPainted(true);
        jProgressBar1.setBackground(Color.BLACK);
        jProgressBar1.setForeground(Color.blue);
        setProGressBar();
        
        // set icon cho play/pause
        jButton1.setIcon(new ImageIcon("D:\\java\\MyMp_3\\play.png"));
        
        // set time event cho lable
        this.xLable = jLabel1.getX();
        
        Timer time = new Timer(1000,new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
                if(jLabel1.getX() >= WIDTH - (jLabel1.getText().length()) || jLabel1.getX() <= 0)
                {
                    xVelocaty *= -1;
                }
                
                xLable += xVelocaty;
                
                jLabel1.setLocation(xLable, jLabel1.getY());
               
               
                
            }
        });
        time.start();
        
    }

    // lấy dữ liệu từ JDBC đổ vào mp3Player
    public void setDataForMP3Player()
    {
       for(modelJDBC x : listModel.list)
       {
           mp3Player.addToPlayList(new File(x.getSRC()));
       }
        
    }
    
   public void setProGressBar()
   {
       
       
       new Thread(new Runnable()
       {
           @Override
           public void run()
           {
               int count = 0;
               while(count <= 100)
		{
			jProgressBar1.setValue((count++));
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
           }
       }).start();
   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 153));

        jButton1.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionForeground"));
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Candara Light", 0, 18)); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButton2.setIcon(new javax.swing.ImageIcon("D:\\java\\MyMp_3\\previous.png")); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon("D:\\java\\MyMp_3\\next.png")); // NOI18N
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
      String rsc = getNameImage(evt.getSource().toString(), "png");
      SetTextLable();
      if(rsc.equals("play.png"))
      {
          mp3Player.play();
          jButton1.setIcon(new ImageIcon("D:\\java\\MyMp_3\\pause.png"));
      }
      else
      {
          mp3Player.pause();
          jButton1.setIcon(new ImageIcon("D:\\java\\MyMp_3\\play.png"));
      }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        mp3Player.skipForward();
        if(index_BaiHat < listModel.list.size())
        {
            index_BaiHat++;
            SetTextLable();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        mp3Player.skipBackward();
        if(index_BaiHat > 0)
        {
            index_BaiHat--;
            SetTextLable();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public void SetTextLable()
    {
        modelJDBC temp = listModel.list.get(index_BaiHat);
        jLabel1.setText(temp.getTenBaiHat() + " - " + temp.getTenCaSi());
    }
    
   /**
	 * only for src file has '\'
         * 
         * 
	 *  	like C:\\docuemnt\\img.png
	 * */
	public String getNameImage(String resourse,String type)
	{
		
		int end = resourse.indexOf(type);
		int begin = 0;
		for(int i = end - 2; i >= 0; i--)
		{
			// if s[i] == '\'
			if(resourse.charAt(i) == 92)
			{
				begin = i + 1;
				break;
			}
		}
		// get image name
		return (String) resourse.subSequence(begin, end + 3);
	}
   
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run() {
                new NewJFrame().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables

}