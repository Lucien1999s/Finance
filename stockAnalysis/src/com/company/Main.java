package com.company;
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.Integer;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Main extends JFrame{
    JTextArea txt;                                                  //txt editor's object
    JFileChooser file = new JFileChooser(".");
    public static void main(String[] args) throws IOException {

        System.out.println("""
                --------------------------
                Stock Securities Analysis
                --------------------------
                """);
        Main f = new Main();                                                 //call a note with Main method
        f.setSize(600,700);                                      //setting the size of note's window
        f.setVisible(true);                                                  //open

        BufferedReader br2 =
                new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("""
                    (1)Open an account (2)Browse data (3)Technical analysis 
                    (4)Profit Arrangement (other) exit""");
            System.out.print("-->");
            int choice = Integer.parseInt(br2.readLine());
            Scanner scanner = new Scanner(System.in);
            switch (choice){
                case 1:
                    try {
                        String url = "//www.sinotrade.com.tw/openact?strProd=0002&strWeb=0002/";         //browse open stock account's website
                        java.net.URI uri = java.net.URI.create(url);
                        java.awt.Desktop dp = java.awt.Desktop.getDesktop();
                        if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
                            dp.browse(uri);
                        }
                    } catch (NullPointerException | IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        String url = "//www.cnyes.com/";                             //browse Anue which is a financial website
                        java.net.URI uri = java.net.URI.create(url);
                        java.awt.Desktop dp = java.awt.Desktop.getDesktop();
                        if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
                            dp.browse(uri);
                        }
                    } catch (NullPointerException | IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    String s1 = "Recommended to sell";
                    String s2 = "Recommended to observe";
                    String s3 = "Recommended to buy";
                    System.out.println("\nplease key current price:");
                    float currentPrice = scanner.nextFloat();
                    System.out.println("please key highest price in a year:");
                    Float highestPrice = scanner.nextFloat();
                    System.out.println("please key lowest price in a year:");
                    Float lowestPrice = scanner.nextFloat();

                    Float distance = (highestPrice-lowestPrice)/3;
                    float highPoint = highestPrice-distance;
                    float lowPoint = lowestPrice+distance;

                    System.out.println("Long position:  "+highestPrice+" ~ "+highPoint);
                    System.out.println("Observe area:   "+highPoint+" ~ "+lowPoint);
                    System.out.println("Short position: "+lowPoint+" ~ "+lowestPrice);
                    System.out.println("\nCurrent price is:"+currentPrice);
                    if(currentPrice<=highestPrice && currentPrice>=highPoint)
                        System.out.println(s1);
                    else if(currentPrice<highPoint && currentPrice>lowPoint)
                        System.out.println(s2);
                    else if(currentPrice<=lowPoint && currentPrice>=lowestPrice)
                        System.out.println(s3);
                    break;
                case 4:
                    System.out.println("Calculate the compound amount of long-term savings");
                    System.out.println("(1)Stock yield calculate to interest(2)Other financial products:");
                    int choice1 = scanner.nextInt();
                    if (choice1 == 1) {
                        System.out.println("Cash dividend:");
                        float cd = scanner.nextFloat();
                        System.out.println("Price:");
                        float price1 = scanner.nextFloat();
                        float rate = (cd / price1) * 100;
                        System.out.println("Stock yield: " + rate + " %");
                        System.out.println("How many principal?:");
                        long pv = scanner.nextLong();
                        System.out.print("How many years?:");
                        int year = scanner.nextInt();

                        System.out.println("Your principle:" + pv + " dollars");
                        System.out.println("Saving time:" + year + " years");
                        System.out.println("Interest:" + rate + " %");
                        System.out.print("Profit after " + year + " years later is :" + pv * Math.pow(1 + rate / 100, year) + " dollars\n");
                    } else {
                        BufferedReader cr =
                                new BufferedReader(new InputStreamReader(System.in));
                        System.out.print("please enter fixed deposit interest(%):");
                        String str1 = cr.readLine();
                        float rate1 = Float.parseFloat(str1);

                        System.out.println("How many principal?:");
                        long pv1 = scanner.nextLong();
                        System.out.print("How many years?:");
                        str1 = cr.readLine();
                        int year1 = Integer.parseInt(str1);

                        System.out.println("Your principle:" + pv1 + " dollars");
                        System.out.println("Saving time:" + year1 + " years");
                        System.out.println("Interest:" + rate1 + " %");
                        System.out.print("Profit after " + year1 + " years later is :" + pv1 * Math.pow(1 + rate1 / 100, year1) + " dollars\n");
                    }
                    break;
                default:
                    System.out.println("System out......");
                    System.exit(0);
            }
        }
    }
    /* 建立筆記本 */
    public Main(){                                                     //build GUI note's manners
        txt = new JTextArea(80,80);
        JScrollPane p = new JScrollPane(txt);

        Container contentPane = getContentPane();                    //get container
        contentPane.add(buildMenu(),"North");              //position of object in jframe
        contentPane.add(p,"Center");
    }
    public JMenuBar buildMenu(){                                    //build feature table
        JMenuBar mbar = new JMenuBar();
        JMenu menu = new JMenu("File (F)");
        menu.setMnemonic(KeyEvent.VK_F);                            //set keyboard's key
        mbar.add(menu);                                            //add to menu

        JMenuItem item = new JMenuItem("Open (O)",KeyEvent.VK_O);              //if open ,read file in com
        item.addActionListener(e -> readFile());
        menu.add(item);

        item = new JMenuItem("Store(S)",KeyEvent.VK_S);                    //if store,write file in com
        item.addActionListener(e -> writeFile());
        menu.add(item);                                     //add item to the feature table
        item = new JMenuItem("Exit(X)",KeyEvent.VK_X);                   //if out,close all the program
        item.addActionListener(e -> System.exit(0));
        menu.add(item);                                      //add item to the feature table

        return mbar;
    }
    public void readFile(){
        int state = file.showOpenDialog(this);                   //open and show interaction windows
        if(state == JFileChooser.APPROVE_OPTION){
            File f = file.getSelectedFile();
            try {
                txt.read(new FileReader(f),"");                  //read in try...catch
            }catch (IOException ignored){

            }
            setTitle(f.getName());                                    //set the title on file name
        }
    }
    public void writeFile() {
        int state = file.showOpenDialog(this);
        if(state == JFileChooser.APPROVE_OPTION){
            File f = file.getSelectedFile();
            try{
                txt.write(new FileWriter(f));
            }catch (IOException ignored){
            }
        }
    }
}
