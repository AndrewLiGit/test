package com.briup.chap07;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame{
	private Container contentPane;
	private JTextField jtxt;	//�����
	private JLabel statusLbl;   //prepared
	private JPanel panel;
	private JButton addBtn;
	private JButton subBtn;
	private JButton mulBtn;
	private JButton divBtn;
	private JButton eqlBtn;
	private JButton clrBtn;
	private JButton[] numBtn;
	
	public Calculator(){
		setTitle("Calculator");
		setSize(300,300);
		setLocation(500, 200);
		contentPane = getContentPane();	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
		setVisible(true);
	}
	public void init(){
		contentPane.setLayout(new BorderLayout(5,5));
		jtxt = new JTextField(10);
		jtxt.setFont(new Font(null,Font.BOLD,25));
		jtxt.setHorizontalAlignment(JTextField.RIGHT);
		statusLbl = new JLabel("Prepared");
		panel = new JPanel();
		panel.setLayout(new GridLayout(4,4,5,5));
		addBtn = new JButton("+");		
		subBtn = new JButton("-");		
		mulBtn = new JButton("*");		
		divBtn = new JButton("/");		
		eqlBtn = new JButton("=");		
		clrBtn = new JButton("C");		
		numBtn = new JButton[10];		

		ActionListener btnListener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String s = jtxt.getText();
				if(s.trim().length() == 0)
					return;
				if(e.getSource() == addBtn)
					jtxt.setText(s + "+");
				else if(e.getSource() == subBtn)
					jtxt.setText(s + "-");
				else if(e.getSource() == mulBtn)
					jtxt.setText(s + "*");
				else if(e.getSource() == divBtn)
					jtxt.setText(s + "/");
			}
		};	
		addBtn.addActionListener(btnListener);
		subBtn.addActionListener(btnListener);
		mulBtn.addActionListener(btnListener);
		divBtn.addActionListener(btnListener);
		/*
		addBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String s = jtxt.getText();
				if(s.trim().length() == 0)
					return;
				jtxt.setText(s + "+");
			}
		});	
		subBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String s = jtxt.getText();
				if(s.trim().length() == 0)
					return;
				jtxt.setText(s + "-");
			}
		});	
		mulBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String s = jtxt.getText();
				if(s.trim().length() == 0)
					return;
				jtxt.setText(s + "*");
			}
		});	
		divBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String s = jtxt.getText();
				if(s.trim().length() == 0)
					return;
				jtxt.setText(s + "/");
			}
		});	
		*/
		clrBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				jtxt.setText("");
				statusLbl.setText("Prepared");
			}
		});	
		eqlBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String s = jtxt.getText();
				if(s.trim().length() == 0)
					return;
				StringCalculator sc = new StringCalculator();
				String result = sc.calculateMain(s);
				jtxt.setText(result);
				statusLbl.setText("Calculated");
			}
		});	

		for(int i = 0; i < numBtn.length;i++){
			numBtn[i] = new JButton(i+"");
			final int j = i;
			numBtn[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					String s = jtxt.getText();
					jtxt.setText(s + j);
				}
			});
		}

		for(int i = 1; i <= 16;i++){
			if(i == 4)
				panel.add(addBtn);
			else if(i >= 5 && i <= 7)
				panel.add(numBtn[i-1]);
			else if(i == 8)
				panel.add(subBtn);
			else if(i >= 9 && i <= 11)
				panel.add(numBtn[i - 2]);
			else if(i == 12)
				panel.add(mulBtn);
			else if(i == 13)
				panel.add(numBtn[0]);
			else if(i == 14)
				panel.add(clrBtn);
			else if(i == 15)
				panel.add(eqlBtn);
			else if(i == 16)
				panel.add(divBtn);
			else{
				panel.add(numBtn[i]);
			}
		}
			
		add(jtxt,BorderLayout.NORTH);	
		add(statusLbl,BorderLayout.SOUTH);
		add(panel,BorderLayout.CENTER);
	}
	public static void main(String[] args){
		new Calculator();
	}
}

class StringCalculator {
  //�����㷽������Ϊһ����������ַ���
 public static String calculateMain(String str){
  String []str1=str.split("[+-]");   //���ַ����á�+-�����
  for(int i=0;i<str1.length;i++){    //����ֵ��Ӵ�������*/���߼����㣬�����ø߼����㺯��
   if(str1[i].indexOf("/")>0||str1[i].indexOf("*")>0){
    str1[i]=caculateUnder(str1[i]);
   }
  }  
  char stdfc[]=str.toCharArray();    //�����ַ���ת���ַ�����
  char stdf[]=new char[50];     //���ڴ���ַ������з���
  int j=0,count=1;  
  for(int i=0;i<stdfc.length;i++){   //��¼�ַ������е�������ż������
    if(stdfc[i]=='+')
    {stdf[j]='+';j++;count++;}
   if(stdfc[i]=='-')
       {stdf[j]='-';j++;count++;}    
  }
  double stdd[]=new double[50];  
  for(int i=0;i<str1.length;i++)    //���Ӵ�ת����ʵ��
   stdd[i]=Double.parseDouble(str1[i]);
  for(int i=1;i<stdf.length;i++){    //��ת���ɵ�ʵ�������ϼ�¼�ķ������������
   if(stdf[i-1]=='+')
    stdd[0] += stdd[i];  
   if(stdf[i-1]=='-')
    stdd[0] -=stdd[i];
  }
  Double d=new Double(stdd[0]);
  String result=d.toString();
  return result; //����ֵΪ���������ַ�������
 }
  //�˷���Ϊ˽�з���ֻ��������caculateMain()�ܵ��ã��˷������ڼ��㺬�С�*/���߼��ַ���
 private static String caculateUnder(String str){//�˺������ڼ��������/*���߼�����
  //String stds[];
  char stdf[]=new char[50];     //���ڼ�¼�����ַ����е��������
  double stdd[]=new double[50];    //���ڴ������ֳɵ��ַ�����ʵ��ת��
  String stds[]=str.split("[/*]");      //����������ַ�������
  for(int i=0;i<stds.length;i++)    //���ֿ����Ӵ�ת����ʵ��
   stdd[i]=Double.parseDouble(stds[i]);
  char stdfc[]=str.toCharArray();    //�������ַ���ת���ַ�����
  int j=0,count=1;  
  for(int i=0;i<stdfc.length;i++){   //������stdf[]��¼�ַ�������������ŵ�λ��
    if(stdfc[i]=='/')
    {stdf[j]='/';j++;count++;}
   if(stdfc[i]=='*')
       {stdf[j]='*';j++;count++;}    
  } 
  for(int i=1;i<count;i++){     //����ת���ɵ�ʵ������ͼ�¼���ŵ�����������
   if(stdf[i-1]=='/')
    stdd[0] /= stdd[i];
   if(stdf[i-1]=='*')
    stdd[0] *=stdd[i]; 
  }
  Double d =new Double(stdd[0]);
  String result=d.toString();
  return result;        //����ֵΪ������ַ�������
 }
 
 //�˺������ڼ���������ŵ��ַ���
public static String caculateHigh(String str){ 
  String []str1;
  str1=str.split("[(]");      //�������Ž����������ָ�
  String str2;
  str2=calculateMain(str1[str1.length-1]);  //����ס���㷽��  
  String str3;
  str3="("+str1[str1.length-1];
  str=str.replace(str3, str2);    //�������еĽ���滻��ԭ�����ŵ�λ��
  return str;
 }
/* 
 public static void main(String[] args) {
  System.out.println(calculateMain("3*4/2+5*4/2+3-4+9*2/4*2"));
 }
*/
}
