package sd;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class luckyjava extends JFrame implements ActionListener{
    private JLabel jla1 = new JLabel("一等奖中奖号码：");
    private JLabel jla2 = new JLabel("二等奖中奖号码：");
    private JLabel jla3 = new JLabel("三等奖中奖号码：");
    private JLabel jlb = new JLabel();//用于滚动显示数字
    private JButton jba1 = new JButton("抽一等奖");
    private JButton jba2 = new JButton("抽二等奖");
    private JButton jba3 = new JButton("抽三等奖");
    private JButton jbb = new JButton("停止");
    private static boolean flag = true;//抽奖标记
    int n1,n21,n22=0;//防止重复中奖
    String path = "bj6.jpg";//设置背景图片路径
    String pathqc = "qiche.png";
    String pathdn = "diannao.png";
    String pathsj = "shouji.png";
    JLabel jlqc,jldn,jlsj;
    		
    public luckyjava(){
        //this.setLayout(null);
        this.getContentPane().setLayout(null);
        this.getContentPane().add(jla1);
        this.getContentPane().add(jla2);
        this.getContentPane().add(jla3);
        this.getContentPane().add(jlb);
        
        ImageIcon background = new ImageIcon(path);// 背景图片
	    JLabel jlbg = new JLabel(background);// 把背景图片显示在一个标签里面
	    jlbg.setBounds(0,0,800,600);// 把标签的大小位置设置为图片刚好填充整个面板	
	    JPanel imagePanel = (JPanel)this.getContentPane();
		imagePanel.setOpaque(false);		
		this.getLayeredPane().add(jlbg, new Integer(Integer.MIN_VALUE));	
         // 把背景图片添加到分层窗格的最底层作为背景
   
        jla1.setFont(new Font("Courier",Font.PLAIN,22));
        jla1.setHorizontalAlignment(JLabel.CENTER);
        jla1.setVerticalAlignment(JLabel.CENTER);         
        jla1.setBounds(100,100,380,30);

        ImageIcon pic_qiche=new ImageIcon(pathqc); //奖品汽车的图片
        jlqc=new JLabel(pic_qiche);
        this.getContentPane().add(jlqc);
        jlqc.setBounds(480,100,100,100);   
        jlqc.setVisible(false);     
        
        jla2.setFont(new Font("Courier",Font.PLAIN,22));
        jla2.setHorizontalAlignment(JLabel.CENTER);
        jla2.setVerticalAlignment(JLabel.CENTER);         
        jla2.setBounds(100,150,380,30);
        
        ImageIcon pic_dn=new ImageIcon(pathdn); //奖品电脑的图片
        jldn=new JLabel(pic_dn);
        this.getContentPane().add(jldn);
        jldn.setBounds(530,200,100,100);           
        jldn.setVisible(false);   
        
        jla3.setFont(new Font("Courier",Font.PLAIN,22));
        jla3.setHorizontalAlignment(JLabel.CENTER);
        jla3.setVerticalAlignment(JLabel.CENTER);         
        jla3.setBounds(100,200,380,30);
        
        ImageIcon pic_sj=new ImageIcon(pathsj); //奖品手机的图片
        jlsj=new JLabel(pic_sj);
        this.getContentPane().add(jlsj);
        jlsj.setBounds(580,300,100,100);
        jlsj.setVisible(false);      
         
        jlb.setFont(new Font("Courier",Font.PLAIN,22));
        jlb.setHorizontalAlignment(JLabel.CENTER);
        jlb.setVerticalAlignment(JLabel.CENTER);         
        jlb.setBounds(100,250,380,30);
         
        this.getContentPane().add(jba1);
        this.getContentPane().add(jba2);
        this.getContentPane().add(jba3);
        this.getContentPane().add(jbb);
        
        jba1.setBounds(175,300,100,26);
        jba2.setBounds(175,330,100,26);
        jba3.setBounds(175,360,100,26);
        jbb.setBounds(300,300,80,86);
        
        jba1.setBackground(Color.red);//按钮红色背景
        jba2.setBackground(Color.red);
        jba3.setBackground(Color.red);
        jbb.setBackground(Color.red);
        
        jba2.setEnabled(false);//暂时关闭二三等奖，等待一等奖抽出
        jba3.setEnabled(false);
        
        jba1.addActionListener(this);
        jba2.addActionListener(this);
        jba3.addActionListener(this);
        jbb.addActionListener(this);
        this.setTitle("抽奖程序");
        this.setBounds(100,100,800,600);
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==jba1){
            flag = true;
            new Thread(){    
                public void run(){
                    while(luckyjava.flag){
                    Random r = new Random(); 
                    int randomInt = r.nextInt(460);  //取460以内的随机数
                        randomInt =randomInt+1027;  //+1027变为1028-1487范围内的随机数
                          jlb.setText("抽出号码："+randomInt);
                          jla1.setText("一等奖中奖号码为："+randomInt);
                          n1=randomInt;   }
                          jba2.setEnabled(true);//开发二等奖抽取
                          jlqc.setVisible(true);//显示大奖汽车图片
                }                
            }.start();
        }
        if(e.getSource()==jba2){
            flag = true;
            new Thread(){    
                public void run(){
                    while(luckyjava.flag){
                    Random r = new Random(); 
                    int randomInt1 = r.nextInt(460);
                    randomInt1 =randomInt1+1027;
                    int randomInt2 = r.nextInt(460);
                    randomInt2 =randomInt2+1027;
                    if (randomInt1!=n1 && randomInt2!=n1){
                          jlb.setText("抽出号码："+randomInt1+"+"+randomInt2);
                          jla2.setText("二等奖中奖号码为："+randomInt1+"+"+randomInt2);
                          n21=randomInt1;
                          n22=randomInt2;}
                    }//取1028-1487范围内的随机数
                    jba3.setEnabled(true);
                    jldn.setVisible(true);
                }                
            }.start();
        }
        if(e.getSource()==jba3){
            flag = true;
            new Thread(){    
                public void run(){
                    while(luckyjava.flag){
                    	Random r = new Random(); 
                    int randomInt1 = r.nextInt(460);
                    int randomInt2 = r.nextInt(460);
                    int randomInt3 = r.nextInt(460);
                    randomInt1 =randomInt1+1027;
                    randomInt2 =randomInt2+1027;
                    randomInt3 =randomInt3+1027;
                    if (randomInt1!=n21 && randomInt2!=n21 && randomInt3!=n21 && randomInt1!=n22 && randomInt2!=n22 && randomInt3!=n22){
                          jlb.setText("抽出号码："+randomInt1+"+"+randomInt2+"+"+randomInt3);
                          jla3.setText("三等奖中奖号码为："+randomInt1+"+"+randomInt2+"+"+randomInt3);}
                    }//取1028-1487范围内的随机数
                    jlsj.setVisible(true);
                }                
            }.start();
        }
        if(e.getSource()==jbb){
            flag = false;
        }
    }
    public static void main(String arguments []){ 
        luckyjava lj=new luckyjava();
        lj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

