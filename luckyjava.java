package sd;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class luckyjava extends JFrame implements ActionListener{
    private JLabel jla1 = new JLabel("һ�Ƚ��н����룺");
    private JLabel jla2 = new JLabel("���Ƚ��н����룺");
    private JLabel jla3 = new JLabel("���Ƚ��н����룺");
    private JLabel jlb = new JLabel();//���ڹ�����ʾ����
    private JButton jba1 = new JButton("��һ�Ƚ�");
    private JButton jba2 = new JButton("����Ƚ�");
    private JButton jba3 = new JButton("�����Ƚ�");
    private JButton jbb = new JButton("ֹͣ");
    private static boolean flag = true;//�齱���
    int n1,n21,n22=0;//��ֹ�ظ��н�
    String path = "bj6.jpg";//���ñ���ͼƬ·��
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
        
        ImageIcon background = new ImageIcon(path);// ����ͼƬ
	    JLabel jlbg = new JLabel(background);// �ѱ���ͼƬ��ʾ��һ����ǩ����
	    jlbg.setBounds(0,0,800,600);// �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������	
	    JPanel imagePanel = (JPanel)this.getContentPane();
		imagePanel.setOpaque(false);		
		this.getLayeredPane().add(jlbg, new Integer(Integer.MIN_VALUE));	
         // �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����
   
        jla1.setFont(new Font("Courier",Font.PLAIN,22));
        jla1.setHorizontalAlignment(JLabel.CENTER);
        jla1.setVerticalAlignment(JLabel.CENTER);         
        jla1.setBounds(100,100,380,30);

        ImageIcon pic_qiche=new ImageIcon(pathqc); //��Ʒ������ͼƬ
        jlqc=new JLabel(pic_qiche);
        this.getContentPane().add(jlqc);
        jlqc.setBounds(480,100,100,100);   
        jlqc.setVisible(false);     
        
        jla2.setFont(new Font("Courier",Font.PLAIN,22));
        jla2.setHorizontalAlignment(JLabel.CENTER);
        jla2.setVerticalAlignment(JLabel.CENTER);         
        jla2.setBounds(100,150,380,30);
        
        ImageIcon pic_dn=new ImageIcon(pathdn); //��Ʒ���Ե�ͼƬ
        jldn=new JLabel(pic_dn);
        this.getContentPane().add(jldn);
        jldn.setBounds(530,200,100,100);           
        jldn.setVisible(false);   
        
        jla3.setFont(new Font("Courier",Font.PLAIN,22));
        jla3.setHorizontalAlignment(JLabel.CENTER);
        jla3.setVerticalAlignment(JLabel.CENTER);         
        jla3.setBounds(100,200,380,30);
        
        ImageIcon pic_sj=new ImageIcon(pathsj); //��Ʒ�ֻ���ͼƬ
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
        
        jba1.setBackground(Color.red);//��ť��ɫ����
        jba2.setBackground(Color.red);
        jba3.setBackground(Color.red);
        jbb.setBackground(Color.red);
        
        jba2.setEnabled(false);//��ʱ�رն����Ƚ����ȴ�һ�Ƚ����
        jba3.setEnabled(false);
        
        jba1.addActionListener(this);
        jba2.addActionListener(this);
        jba3.addActionListener(this);
        jbb.addActionListener(this);
        this.setTitle("�齱����");
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
                    int randomInt = r.nextInt(460);  //ȡ460���ڵ������
                        randomInt =randomInt+1027;  //+1027��Ϊ1028-1487��Χ�ڵ������
                          jlb.setText("������룺"+randomInt);
                          jla1.setText("һ�Ƚ��н�����Ϊ��"+randomInt);
                          n1=randomInt;   }
                          jba2.setEnabled(true);//�������Ƚ���ȡ
                          jlqc.setVisible(true);//��ʾ������ͼƬ
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
                          jlb.setText("������룺"+randomInt1+"+"+randomInt2);
                          jla2.setText("���Ƚ��н�����Ϊ��"+randomInt1+"+"+randomInt2);
                          n21=randomInt1;
                          n22=randomInt2;}
                    }//ȡ1028-1487��Χ�ڵ������
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
                          jlb.setText("������룺"+randomInt1+"+"+randomInt2+"+"+randomInt3);
                          jla3.setText("���Ƚ��н�����Ϊ��"+randomInt1+"+"+randomInt2+"+"+randomInt3);}
                    }//ȡ1028-1487��Χ�ڵ������
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

