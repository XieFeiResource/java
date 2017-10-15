package com.wms.app;

import java.util.Scanner;

public class Systemapp {
	public static int count=0;	
	public static int n=7;
	public static String [][]good=new String[50][3];//商品名称，价格，剩余量
	public static String [][]buycar=new String[50][3];
	static {
		good[0][0]="oppo";	good[0][1]="5000";	good[0][2]="0001";
		good[1][0]="opppoo"; good[1][1]="5050"; good[1][2]="0002";
		good[2][0]="oppopop";good[2][1]="5005";good[2][2]="0003";
		good[3][0]="mi"; good[3][1]="4005";  good[3][2]="0004";
		good[4][0]="miim"; good[4][1]="3005"; good[4][2]="0005";
		good[5][0]="iphon"; good[5][1]="9989"; good[5][2]="0006";
		good[6][0]="vivo"; good[6][1]="2005"; good[6][2]="0007";
	}
	public static void mainMenu() {
	System.out.println("*******欢迎来到超市管理系统*******");
	System.out.println("**********1.录入商品**********");
	System.out.println("**********2.展示所有商品**********");
	System.out.println("**********3.删除商品*******");
	System.out.println("**********4.修改商品**********");
	System.out.println("**********5.模糊搜索**********");
	System.out.println("**********6.购买商品**********");
	System.out.println("**********7.结账**********");
	System.out.println("**********8.退出系统**********");
	System.out.print("请按1~7进行相关操作");
	}
	public static void modifyMenu() {
		System.out.println("******修改界面*******");
		System.out.println("******1.修改价格 *******");
		System.out.println("******2.修改编号 *******");
		System.out.println("请按1~2进行相关操作");
	}
	public static void loginMenu() {
		System.out.println("******隆中超市管理系统*******");
		System.out.println("******请先登录*******");	
		login();
	}
	public static void login(){
		System.out.println("请输入用户名：");
		Scanner in=new Scanner(java.lang.System.in);
		String username=in.next();
		System.out.println("请输入密码：");
		String  password=in.next();
//		in.close();
		if(username.equals("Tom")&&password.equals("123"))
		{
			System.out.println("登陆成功！");
			mainMenu();
		}
		else{			
			if(count >=1){
				System.out.println("对不起！亲，您已经没有机会了！");
				return;
			}else{
				count++;
				System.out.println("对不起，你输入的用户名或密码错误！请重新输入！");
				login();
			}			
		}
}
	public static void addGood() {//添加商品
		String judge;
		do {
		Scanner in=new Scanner(System.in);
		System.out.println("请输入添加的商品名称");
		String name=in.next();
		System.out.println("请输入添加的商品价格");
		String price=in.next();
		System.out.println("请输入添加的商品编码");
		String amount=in.next();
//		in.close();
		good[n][0]=name;
		good[n][1]=price;
		good[n][2]=amount;
		n++;
		System.out.println("是否继续添加？输入Y/y或N/n");
		judge=in.next();
		}while(judge.equalsIgnoreCase("y"));
	}
	
		public static void showGoods() {//展示所有商品,分页显示
			int i=0;
			int page=1;
			int pagesize=3;
			int totalPageNumber=(n/3);
			if(n % pagesize != 0){
				totalPageNumber++;
			}
			System.out.println("*****超市仓库所有商品******");
			do {
			System.out.println("*****第"+page+"页******");
			System.out.println("名称\t 价格\t 编码\t");
			for(int k=i;k<n;k++) {
				for(int j=0;j<3;j++) {
					System.out.print(good[k][j]+"\t");
				}
				System.out.println();	
				if((k+1)%pagesize==0) {
					i=k+1;
					break;
				}
			}
			page++;
		}while(page<=totalPageNumber);
	}
/*	public static void showGoods() {//展示所有商品
		java.lang.System.out.println("*****超市仓库所有商品******");
		java.lang.System.out.println("名称\t 价格\t 编码\t");
		for(int i=0;i<n;i++) {
			for(int j=0;j<3;j++) {
				java.lang.System.out.print(good[i][j]+"\t");
			}
			java.lang.System.out.println();
		}
		
	}*/
	public static int searchGood(String name) {//查找商品
		for(int i=0;i<n;i++) {
			if(good[i][0].equals(name)) {
				return i;
			}
		}
		return -1;
	}
	public static void deleteGood(String name) {//删除商品
		int i=searchGood(name);
		if(i<0) {
			java.lang.System.out.println("没有该商品");
		}else {
			for(int j=i;j<n;j++) {
			good[j][0]=good[j+1][0];
			good[j][1]=good[j+1][1];
			good[j][2]=good[j+1][2];
			}
		}
		n--;
		java.lang.System.out.println("删除成功");
	}
	public static void modifyGood(String name) {//修改商品信息
		int i=searchGood(name);
		if(i<0) {
			java.lang.System.out.println("没有该商品");
		}else {
			Scanner in=new Scanner(java.lang.System.in);
			int k=in.nextInt();
//			in.close();
			switch(k) {
			case 1: {
				java.lang.System.out.println("请输入修改后的商品价格信息");
				String modifyPrice=in.next();
				good[i][1]=modifyPrice;
				break;
			}
			case 2: {
				java.lang.System.out.println("请输入修改后的商品数量信息");
				String modifyAmount=in.next();
				good[i][2]=modifyAmount;
				break;
			}
		  }
		}		
	}
	public static void moHuSearch(String moHuMessage) {//模糊搜索
		java.lang.System.out.println("名称\t 价格\t 编码\t");
		for(int i=0;i<n;i++) {
			if(good[i][0].contains(moHuMessage)) {
				java.lang.System.out.print(good[i][0]+"\t");
				java.lang.System.out.print(good[i][1]+"\t");
				java.lang.System.out.print(good[i][2]+"\t");
				java.lang.System.out.println();
			}	
		}
	}
	public static void buyGoods() {
		showGoods();
		String judge;
		do {
		Scanner in=new Scanner(java.lang.System.in);
		java.lang.System.out.println("请输入想购买的商品名称");
		String goodname=in.next();
		int k=searchGood(goodname);
		if(k<0) {
			System.out.println("没有该商品");
		}else {
		java.lang.System.arraycopy(good[k], 0, buycar[count], 0, 3);
		count++;
		}
		java.lang.System.out.println("是否继续购买？输入Y/y或N/n");
		judge=in.next();		
	  }while(judge.equalsIgnoreCase("y"));
		java.lang.System.out.println("您购买的商品详情如下");
		java.lang.System.out.println("名称\t 价格\t 编码\t");
		for(int i=0;i<count;i++) {
			for(int j=0;j<3;j++) {
				java.lang.System.out.print(buycar[i][j]+"\t");
			}
			java.lang.System.out.println();
		}
	}
	public static void account() {
		int sum=0;
		for(int i=0;i<count;i++) {
			sum=sum+Integer.parseInt(buycar[i][1]);
		}
		java.lang.System.out.println("您一共需要支付"+sum+"$");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int quit=8;
		loginMenu();
		if(count >=1) java.lang.System.exit(0);
		while(true) {
			Scanner in=new Scanner(java.lang.System.in);
			int choose=in.nextInt();
//			in.close();
			switch(choose) {
			case 1:{
				addGood();
				java.lang.System.out.println("添加成功");
				mainMenu();
				break;
				}
			case 2:{
				showGoods();
				mainMenu();
				break;
			}
			case 3:{
				java.lang.System.out.println("请输入要删除的商品名称");
				String goodname=in.next();
				deleteGood(goodname);
				mainMenu();
				break;
			}
			case 4:{
				java.lang.System.out.println("请输入要修改商品的名称");
				String name1=in.next();
				int i=searchGood(name1);
				if(i<0) {
					System.out.println("没有该商品");
				}else {
				modifyMenu();
				modifyGood(name1);
				}
				mainMenu();
				break;
			}
			case 5:{
				java.lang.System.out.println("请输入要搜索的商品的名称");
				String name1=in.next();
				moHuSearch(name1);
				mainMenu();
				break;
			}
			case 6:{
				buyGoods();
				mainMenu();
				break;
			}
			case 7:{
				account();
				mainMenu();
				break;
			}
		}
			if(quit==choose) {
				break;
			}
		}
	}

}
