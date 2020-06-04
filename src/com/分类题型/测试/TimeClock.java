package com.分类题型.测试;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.Timer;
public class TimeClock extends JFrame implements ActionListener
{
    SimpleDateFormat sf = new SimpleDateFormat("HH:mm:ss");
    JLabel label=new JLabel(sf.format(new Date()));
    Timer timer=new Timer(50,this);    //创建一个定时器，并注册当前对象为监视器
    public static void main(String[] args)
    {
        TimeClock frm=new TimeClock("小时钟");
        frm.setBounds(0,0,1920,500);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
    TimeClock(String s)
    {
        setTitle(s);
        setLayout(new FlowLayout());
        label.setFont(new Font("宋体",Font.BOLD,350));      	//设置字体
        add(label);
        timer.start();   	//定时器开始
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String s=sf.format(new Date());
        label.setText(s);
    }
}