package com.p3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.text.DecimalFormat;

public class Calculate2 extends JFrame{
	//����
	private JPanel contentPane;
	private JLabel textOutput;
	private JTextField textInput;
	private JButton btnSin;
	private JButton btnSpace;
	private JButton btnPi;
	private JButton btnE;
	private JButton btnSqrt;
	private JButton btnLeft;
	private JButton btnRight;
	private JButton btnAc;
	private JButton btnDel;
	private JButton btnCos;
	private JButton btnTan;
	private JButton btnLn;
	private JButton btnLg;
	private JButton btn7;
	private JButton btn4;
	private JButton btn1;
	private JButton btn0;
	private JButton btn8;
	private JButton btn9;
	private JButton btnPlus;
	private JButton btn5;
	private JButton btn6;
	private JButton btnSub;
	private JButton btn2;
	private JButton btnPoint;
	private JButton btn3;
	private JButton btnMult;
	private JButton btnEqual;
	private JButton btnDiv;
	
	//���롢�����ʾ���
	private String input="";
	private String output[]={"������Ϊ��","������ڴ���","�������㷶Χ��"};
	
	private double answer[];		//��Ϊ�����ŵ�ջ���м���
	private String fianswer;		//�������Ĵ�
	
	private String calB[];		//��Ϊ�����ŵ�ջ���м���
	private char data[];		//��Ŵ���������������ַ�����char����
	private int bracketL[];		//�����������calB�е�λ�ã���calB�е��±�
	private int top=0;		//calB�пɴ�Ķ����±꣬�൱��ָ������
	
	private boolean isEqual=false;		//�����ж�"="�Ƿ���
	private boolean isTrue=false;		//�����ж������������Ƿ���ȷ
	
	//������
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//String x="(((5+6)-7)+5)";
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Calculate2 frame = new Calculate2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//����frame���캯��
	public Calculate2() {
		setBtn();	
	}

	//��ť���ú���������Ϊ�˿��԰Ѵ����۵���������Ȼ̫����
	public void setBtn(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("������ by K.B");
		setResizable(false);		//���������óɲ�������仯
		this.setLocation(600,200);		//���ô���λ��
		
		textOutput = new JLabel("");
		textOutput.setFont(new Font("SimSun", Font.PLAIN, 21));
		textOutput.setHorizontalAlignment(SwingConstants.TRAILING);
		textOutput.setBounds(14, 72, 654, 46);
		contentPane.add(textOutput);
		
		textInput = new JTextField("");
		textInput.setFont(new Font("SimSun", Font.BOLD, 35));
		textInput.setHorizontalAlignment(SwingConstants.RIGHT);
		textInput.setEditable(false);
		textInput.setBounds(14, 13, 654, 55);
		contentPane.add(textInput);
		textInput.setColumns(10);
		
		JButton btnF = new JButton("!");
		btnF.setBackground(new Color(230, 230, 250));
		btnF.setForeground(new Color(0, 0, 0));
		btnF.setFont(new Font("SimSun", Font.BOLD, 30));
		btnF.setBounds(14, 131, 97, 66);
		contentPane.add(btnF);
		
		btnSin = new JButton("sin");
		btnSin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSin.setForeground(Color.BLACK);
		btnSin.setFont(new Font("SimSun", Font.BOLD, 30));
		btnSin.setBackground(new Color(230, 230, 250));
		btnSin.setBounds(125, 131, 97, 66);
		contentPane.add(btnSin);
		
		btnSpace = new JButton("^");
		btnSpace.setForeground(Color.BLACK);
		btnSpace.setFont(new Font("SimSun", Font.BOLD, 30));
		btnSpace.setBackground(new Color(230, 230, 250));
		btnSpace.setBounds(14, 210, 97, 66);
		contentPane.add(btnSpace);
		
		btnPi = new JButton("\u03C0");
		btnPi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input=input+btnPi.getText();
				textInput.setText(input);
			}
		});
		btnPi.setForeground(Color.BLACK);
		btnPi.setFont(new Font("SimSun", Font.BOLD, 30));
		btnPi.setBackground(new Color(230, 230, 250));
		btnPi.setBounds(14, 368, 97, 66);
		contentPane.add(btnPi);
		
		btnE = new JButton("e");
		btnE.setForeground(Color.BLACK);
		btnE.setFont(new Font("SimSun", Font.BOLD, 30));
		btnE.setBackground(new Color(230, 230, 250));
		btnE.setBounds(14, 447, 97, 66);
		contentPane.add(btnE);
		
		btnSqrt = new JButton("\u221A");
		btnSqrt.setForeground(Color.BLACK);
		btnSqrt.setFont(new Font("SimSun", Font.BOLD, 30));
		btnSqrt.setBackground(new Color(230, 230, 250));
		btnSqrt.setBounds(14, 289, 97, 66);
		contentPane.add(btnSqrt);
		
		btnLeft = new JButton("(");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input=input+btnLeft.getText();
				textInput.setText(input);
			}
		});
		btnLeft.setForeground(Color.BLACK);
		btnLeft.setFont(new Font("SimSun", Font.BOLD, 30));
		btnLeft.setBackground(new Color(230, 230, 250));
		btnLeft.setBounds(236, 131, 97, 66);
		contentPane.add(btnLeft);
		
		btnRight = new JButton(")");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input=input+btnRight.getText();
				textInput.setText(input);
			}
		});
		btnRight.setForeground(Color.BLACK);
		btnRight.setFont(new Font("SimSun", Font.BOLD, 30));
		btnRight.setBackground(new Color(230, 230, 250));
		btnRight.setBounds(347, 131, 97, 66);
		contentPane.add(btnRight);
		
		btnAc = new JButton("AC");
		btnAc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnAc.setForeground(new Color(255, 69, 0));
		btnAc.setFont(new Font("SimSun", Font.BOLD, 30));
		btnAc.setBackground(new Color(230, 230, 250));
		btnAc.setBounds(458, 131, 97, 66);
		contentPane.add(btnAc);
		
		btnDel = new JButton("DEL");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input=input.substring(0,input.length()-1);
				textInput.setText(input);
			}
		});
		btnDel.setForeground(Color.BLACK);
		btnDel.setFont(new Font("SimSun", Font.BOLD, 30));
		btnDel.setBackground(new Color(230, 230, 250));
		btnDel.setBounds(569, 131, 97, 66);
		contentPane.add(btnDel);
		
		btnCos = new JButton("cos");
		btnCos.setForeground(Color.BLACK);
		btnCos.setFont(new Font("SimSun", Font.BOLD, 30));
		btnCos.setBackground(new Color(230, 230, 250));
		btnCos.setBounds(125, 210, 97, 66);
		contentPane.add(btnCos);
		
		btnTan = new JButton("tan");
		btnTan.setForeground(Color.BLACK);
		btnTan.setFont(new Font("SimSun", Font.BOLD, 30));
		btnTan.setBackground(new Color(230, 230, 250));
		btnTan.setBounds(125, 289, 97, 66);
		contentPane.add(btnTan);
		
		btnLn = new JButton("ln");
		btnLn.setForeground(Color.BLACK);
		btnLn.setFont(new Font("SimSun", Font.BOLD, 30));
		btnLn.setBackground(new Color(230, 230, 250));
		btnLn.setBounds(125, 368, 97, 66);
		contentPane.add(btnLn);
		
		btnLg = new JButton("lg");
		btnLg.setForeground(Color.BLACK);
		btnLg.setFont(new Font("SimSun", Font.BOLD, 30));
		btnLg.setBackground(new Color(230, 230, 250));
		btnLg.setBounds(125, 447, 97, 66);
		contentPane.add(btnLg);
		
		btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input=input+btn7.getText();
				textInput.setText(input);
			}
		});
		btn7.setForeground(Color.BLACK);
		btn7.setFont(new Font("SimSun", Font.BOLD, 30));
		btn7.setBackground(new Color(230, 230, 250));
		btn7.setBounds(236, 210, 97, 66);
		contentPane.add(btn7);
		
		btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input=input+btn4.getText();
				textInput.setText(input);
			}
		});
		btn4.setForeground(Color.BLACK);
		btn4.setFont(new Font("SimSun", Font.BOLD, 30));
		btn4.setBackground(new Color(230, 230, 250));
		btn4.setBounds(236, 289, 97, 66);
		contentPane.add(btn4);
		
		btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input=input+btn1.getText();
				textInput.setText(input);
			}
		});
		btn1.setForeground(Color.BLACK);
		btn1.setFont(new Font("SimSun", Font.BOLD, 30));
		btn1.setBackground(new Color(230, 230, 250));
		btn1.setBounds(236, 368, 97, 66);
		contentPane.add(btn1);
		
		btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input=input+btn0.getText();
				textInput.setText(input);
			}
		});
		btn0.setForeground(Color.BLACK);
		btn0.setFont(new Font("SimSun", Font.BOLD, 30));
		btn0.setBackground(new Color(230, 230, 250));
		btn0.setBounds(236, 447, 97, 66);
		contentPane.add(btn0);
		
		btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input=input+btn8.getText();
				textInput.setText(input);
			}
		});
		btn8.setForeground(Color.BLACK);
		btn8.setFont(new Font("SimSun", Font.BOLD, 30));
		btn8.setBackground(new Color(230, 230, 250));
		btn8.setBounds(347, 210, 97, 66);
		contentPane.add(btn8);
		
		btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input=input+btn9.getText();
				textInput.setText(input);
			}
		});
		btn9.setForeground(Color.BLACK);
		btn9.setFont(new Font("SimSun", Font.BOLD, 30));
		btn9.setBackground(new Color(230, 230, 250));
		btn9.setBounds(458, 210, 97, 66);
		contentPane.add(btn9);
		
		btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isEqual==true&&fianswer!=null){		//�ж�ǰһ�����µ��ǲ���"="������-��*��\һ��
					textInput.setText(fianswer+btnPlus.getText());
					input=fianswer+btnPlus.getText();
					isEqual=false;
				}else{
					input=input+btnPlus.getText();
					textInput.setText(input);
				}
			}
		});
		btnPlus.setForeground(Color.BLACK);
		btnPlus.setFont(new Font("SimSun", Font.BOLD, 30));
		btnPlus.setBackground(new Color(230, 230, 250));
		btnPlus.setBounds(569, 210, 97, 66);
		contentPane.add(btnPlus);
		
		btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input=input+btn5.getText();
				textInput.setText(input);
			}
		});
		btn5.setForeground(Color.BLACK);
		btn5.setFont(new Font("SimSun", Font.BOLD, 30));
		btn5.setBackground(new Color(230, 230, 250));
		btn5.setBounds(347, 289, 97, 66);
		contentPane.add(btn5);
		
		btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input=input+btn6.getText();
				textInput.setText(input);
			}
		});
		btn6.setForeground(Color.BLACK);
		btn6.setFont(new Font("SimSun", Font.BOLD, 30));
		btn6.setBackground(new Color(230, 230, 250));
		btn6.setBounds(458, 289, 97, 66);
		contentPane.add(btn6);
		
		btnSub = new JButton("-");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isEqual==true&&fianswer!=null){
					textInput.setText(fianswer+btnSub.getText());
					input=fianswer+btnSub.getText();
					isEqual=false;
				}else{
					input=input+btnSub.getText();
					textInput.setText(input);
				}			
			}
		});
		btnSub.setForeground(Color.BLACK);
		btnSub.setFont(new Font("SimSun", Font.BOLD, 30));
		btnSub.setBackground(new Color(230, 230, 250));
		btnSub.setBounds(569, 289, 97, 66);
		contentPane.add(btnSub);
		
		btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input=input+btn2.getText();
				textInput.setText(input);
			}
		});
		btn2.setForeground(Color.BLACK);
		btn2.setFont(new Font("SimSun", Font.BOLD, 30));
		btn2.setBackground(new Color(230, 230, 250));
		btn2.setBounds(347, 368, 97, 66);
		contentPane.add(btn2);
		
		btnPoint = new JButton(".");
		btnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input=input+btnPoint.getText();
				textInput.setText(input);
			}
		});
		btnPoint.setForeground(Color.BLACK);
		btnPoint.setFont(new Font("SimSun", Font.BOLD, 30));
		btnPoint.setBackground(new Color(230, 230, 250));
		btnPoint.setBounds(347, 447, 97, 66);
		contentPane.add(btnPoint);
		
		btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input=input+btn3.getText();
				textInput.setText(input);
			}
		});
		btn3.setForeground(Color.BLACK);
		btn3.setFont(new Font("SimSun", Font.BOLD, 30));
		btn3.setBackground(new Color(230, 230, 250));
		btn3.setBounds(458, 368, 97, 66);
		contentPane.add(btn3);
		
		btnMult = new JButton("\u00D7");
		btnMult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isEqual==true&&fianswer!=null){
					textInput.setText(fianswer+btnMult.getText());
					input=fianswer+btnMult.getText();
					isEqual=false;
				}else{
					input=input+btnMult.getText();
					textInput.setText(input);
				}
			}
		});
		btnMult.setForeground(Color.BLACK);
		btnMult.setFont(new Font("SimSun", Font.BOLD, 30));
		btnMult.setBackground(new Color(230, 230, 250));
		btnMult.setBounds(569, 368, 97, 66);
		contentPane.add(btnMult);
		
		btnEqual = new JButton("=");
		btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate();
				isEqual=true;
			}
		});
		btnEqual.setForeground(new Color(255, 69, 0));
		btnEqual.setFont(new Font("SimSun", Font.BOLD, 30));
		btnEqual.setBackground(new Color(230, 230, 250));
		btnEqual.setBounds(458, 447, 97, 66);
		contentPane.add(btnEqual);
		
		btnDiv = new JButton("\u00F7");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isEqual==true&&fianswer!=null){
					textInput.setText(fianswer+btnDiv.getText());
					input=fianswer+btnDiv.getText();
					isEqual=false;
				}else{
					input=input+btnDiv.getText();
					textInput.setText(input);
				}
			}
		});
		btnDiv.setForeground(Color.BLACK);
		btnDiv.setFont(new Font("SimSun", Font.BOLD, 30));
		btnDiv.setBackground(new Color(230, 230, 250));
		btnDiv.setBounds(569, 447, 97, 66);
		contentPane.add(btnDiv);
	}
	
	//��Ҫ���㺯��
	public void calculate(){
		if(input.contains("(")||(input.contains(")"))){
			if((charNum(input,'('))!=(charNum(input,')'))){
				forResult(1);
			}else{
				if(!(bracketLR(input))){
					forResult(1);
				}else{
					withBracket(input);
					forResult(0);				
				}
			}		
		}else{
			noBracket(input);
			if(isTrue){
				forResult(0);
			}else{
				forResult(1);
			}
			//forResult(0);
		}
	}
	
	//��������ŵ����
	public void withBracket(String tempStr){
		int temp=-1;
		data=tempStr.toCharArray();
		calB=new String[data.length];
		bracketL=new int[data.length/2];
		String forTemp="";
		for(int i=0;i<data.length;i++){
			inStack(tempStr.substring(i,i+1));
			if(data[i]=='('){
				bracketL[++temp]=top-1;
			}
			if(data[i]==')'){
				noBracket(inBracket(bracketL[temp]+1,top-1));
				outStack(bracketL[temp]);
				temp--;
				inStack(fianswer);
			}
		}
		for(int i=0;i<top;i++){
			forTemp=forTemp+calB[i];
		}

		noBracket(forTemp);
		forTemp=null;
	}
	
	//��һ�������ڵ��������㲢������浽calB�����У���ջ��
	public String inBracket(int h,int t){
		String temp="";
		for(int i=h;i<t;i++){
			temp+=calB[i];
		}
		return temp;
	}
	
	//��ջ
	public void inStack(String tempStr){
		 calB[top]=tempStr;
		 top++;
	}
	//��ջ
	public void outStack(int head){
		top=head;
	}
	
	//�ж�����ʽ������ǰ���ϵ�Ƿ���ȷ�������")"��"("֮ǰ
	public boolean bracketLR(String tempStr){
		char bracket[];
		int counter=0;
		bracket=tempStr.toCharArray();
		for(int i=0;i<bracket.length;i++){
			if(bracket[i]=='('){
				counter++;
			}
			if(bracket[i]==')'){
				counter--;
			}
			if(counter<0){
				return false;
			}
		}
		return true;
	}

	//��ȡ�ַ�������ͬ�ַ����ֵĴ�������Ϊ�ж�����������Ŀ�Ƿ����
	public int charNum(String tempStr,char ch){
		int counter=0;
		char tempCh[];
		tempCh=tempStr.toCharArray();
		for(int i=0;i<tempCh.length;i++){
			if(tempCh[i]==ch){
				counter++;
			}
		}
		return counter;
	}
	
	//�������������
	public void noBracket(String tempStr){
		String forTemp="";
		char inputNobracket[]=tempStr.toCharArray();
		for(int i=0;i<inputNobracket.length;i++){			
			if((inputNobracket[i]=='+'||inputNobracket[i]=='-')&&(inputNobracket[i+1]=='��'||inputNobracket[i+1]=='��')){
				//forTemp=tempStr.substring(0,i)+tempStr.substring(i+1);
				forResult(1);
			}else{
				if((inputNobracket[i]=='+'||inputNobracket[i]=='-')&&(inputNobracket[i+1]=='+'||inputNobracket[i+1]=='-'))
				forTemp=forTemp+tempStr.substring(i,i+1);
			}
		}
		inputNobracket=tempStr.toCharArray();		//�������ַ���ת��Ϊ�ַ�����		
		
		if((inputNobracket[0]=='��')||(inputNobracket[0]=='��')||(inputNobracket[inputNobracket.length-1]=='��')||(inputNobracket[inputNobracket.length-1]=='��')||(inputNobracket[inputNobracket.length-1]=='+')||(inputNobracket[inputNobracket.length-1]=='-')){
			forResult(1);
			isTrue=false;
		}else{
			if((inputNobracket[0]=='+')||(inputNobracket[0]=='-')){
				tempStr="0"+tempStr;
				normalCal(tempStr);
				isTrue=true;
			}
			else{
				normalCal(tempStr);
				isTrue=true;
			}
		}		
	}

	//�������㣬����������
	public void normalCal(String tempStr){
		char inputNobracket[]=tempStr.toCharArray();
		double result[];
		String resultStr[];
		char fu[];
		//����ַ���
		resultStr=tempStr.split("\\+|-|��|��");
				
		result=new double[resultStr.length];
		for(int i=0;i<resultStr.length;i++){
			result[i]=Double.parseDouble(resultStr[i]);
		}
				
		//������ʽ���������������һ��char������
		fu=new char[resultStr.length-1];
		int num=0;
		for(int i=0;i<inputNobracket.length;i++){
			switch(inputNobracket[i]){
			case '+':fu[num]='+';num++;break;
			case '-':fu[num]='-';num++;break;
			case '��':fu[num]='��';num++;break;
			case '��':fu[num]='��';num++;break;
			}
		}		
		
		//��ʼ��ջ��������
		answer=new double[2];
		answer[0]=result[0];
		answer[1]=0;
		
		boolean flag=false;		//��Ϊ��־���ȼ��㡰+-��Ϊtrue���ȼ��㡰*/��Ϊfalse
		//����fu[]���飬ȡ�ö�Ӧresult[]�����е����㷽ʽ
		for(int i=0;i<fu.length;i++){
			if(fu[i]=='+'){
				answer[0]=answer[0]+answer[1];
				answer[1]=0;
				answer[1]+=result[i+1];
				flag=true;
			}
			if(fu[i]=='-'){
				answer[0]=answer[0]+answer[1];
				answer[1]=0;
				answer[1]-=result[i+1];
				flag=true;
			}
			if(fu[i]=='��'){
				if(flag){		//��һ�������Ϊ��+-"
					answer[1]=answer[1]*result[i+1];
				}else{		//��һ�������Ϊ��*/"
					answer[0]=answer[0]*result[i+1];
				}
			}
			if(fu[i]=='��'){
				if(flag){		//��һ�������Ϊ��+-"
					answer[1]=answer[1]/result[i+1];
				}else{		//��һ�������Ϊ��*/"
					answer[0]=answer[0]/result[i+1];
				}
			}
		}
		answer[0]=answer[0]+answer[1];		//Ϊ������
		
		//�жϴ�С�����λ����С��λ���ർ�³���double��������ʱ���������
		//��2.1*3��double�ʹ�Ϊ6.300000000000001�������������Ϊ6.3000000000000
		String strTemp=answer[0]+"";		//��double��ת��ΪString
		if(strTemp.length()-strTemp.indexOf('.')-1>=15){
			DecimalFormat df = new DecimalFormat("0.0000000000000");
			fianswer=df.format(answer[0]);
		}else{
			fianswer=strTemp;
		}
	}	

	//������
	public void forResult(int choice){
		switch(choice){
		case 0:textOutput.setText(output[0]+fianswer);break;
		case 1:textOutput.setText(output[1]);break;
		}
	}
	
	//����
	public void reset(){
		textInput.setText("");
		textOutput.setText("");
		input="";
		top=0;
		fianswer=null;
	}
}
