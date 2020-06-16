package com.ibm.walletSpringCore.Wallet;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibm.walletSpring.ui.UserInterface;
//import com.ibm.walletSpring.ui.walletSpringUI;

public class App 
{
    public static void main( String[] args )
    {
       
    	ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("appContext.xml");
    	
//    	UserInterface wallet=context.getBean("UI", UserInterface.class);
//    	wallet.choice();
    	NamedParameterSupportDemo a = context.getBean("try",NamedParameterSupportDemo.class);
    	System.out.println(a.getUserName(1009));
    }
}
