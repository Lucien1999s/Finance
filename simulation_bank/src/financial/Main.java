package financial;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static boolean Chooses(int choose)throws OperationsException{
        if((choose>0&&choose<7)||choose==99){
            System.out.println();
        }
        else
            throw new OperationsException("Please enter number 1~6 !");
        return true;
    }
    public static void main(String[] args) {
        int choose;
        ArrayList<Account> accounts = new ArrayList<>();
        while (true) {
            try {
                System.out.print("1.open account 2.deposit 3.withdraw 4.transfer 5.check balance 6.exit :"); //password check 99
                Scanner sc = new Scanner(System.in);
                choose = sc.nextInt();

                if (choose == 1) {
                    System.out.print("Enter user id:");
                    String id = sc.next();
                    System.out.print("Enter password:");
                    String password = sc.next();
                    System.out.print("How much initial capital to deposit:");
                    int initial_capital = sc.nextInt();
                    System.out.print("Remark:");
                    String remark = sc.next();
                    accounts.add(new Account(id, password, initial_capital, remark));
                    System.out.println("id:" + id + ",initial capital:" + initial_capital);
                } else if (choose == 2) {
                    int num = 0;
                    boolean makeSure;
                    for (Account a : accounts) {
                        System.out.println(num + ". " + a);
                        num++;
                    }
                    System.out.println();
                    System.out.print("Choose account :");
                    int choose_id = sc.nextInt();
                    do {
                        System.out.print("Enter password:");
                        String password = sc.next();
                        makeSure = accounts.get(choose_id).auth(password);
                        if (makeSure) {
                            System.out.println("wrong password pls enter again or press 'out' to leave");
                        } else if (password.equals("out")) {
                            System.exit(0);
                        }
                    } while (makeSure);

                    System.out.print("How much to deposit:");
                    int money = sc.nextInt();
                    accounts.get(choose_id).deposit(money);
                    System.out.println(accounts.get(choose_id));
                } else if (choose == 3) {
                    int num = 0;
                    boolean makeSure;
                    for (Account a : accounts) {
                        System.out.println(num + ". " + a);
                        num++;
                    }
                    System.out.println();
                    System.out.print("Choose account :");
                    int choose_id = sc.nextInt();

                    do {
                        System.out.print("Enter password:");
                        String password = sc.next();
                        makeSure = accounts.get(choose_id).auth(password);
                        if (makeSure) {
                            System.out.println("wrong password pls enter again or press 'out' to leave");
                        } else if (password.equals("out")) {
                            System.exit(0);
                        }
                    } while (makeSure);

                    System.out.print("How much to withdraw :");
                    int money = sc.nextInt();
                    accounts.get(choose_id).withdraw(money);
                    System.out.println(accounts.get(choose_id));
                } else if (choose == 4) {
                    int num = 0;
                    boolean makeSure;
                    if(accounts.size()<2){
                        System.out.println("System does not have enough accounts!");
                        continue;
                    }
                    for (Account a : accounts) {
                        System.out.println(num + ". " + a);
                        num++;
                    }
                    System.out.println();

                    System.out.print("Choose sender account :");
                    int choose_sender_id = sc.nextInt();
                    System.out.print("Choose receiver account :");
                    int choose_receiver_id = sc.nextInt();
                    do {
                        System.out.print("Enter sender password:");
                        String password = sc.next();
                        makeSure = accounts.get(choose_sender_id).auth(password);
                        if (makeSure) {
                            System.out.println("wrong password pls enter again or press 'out' to leave");
                        } else if (password.equals("out")) {
                            System.exit(0);
                        }
                    } while (makeSure);
                    System.out.print("How much to transfer :");
                    int money = sc.nextInt();
                    int transfer_money=accounts.get(choose_sender_id).transfer(money);
                    accounts.get(choose_receiver_id).deposit(transfer_money);
                    System.out.println("Transfer successful");

                } else if (choose == 5) {
                    int num = 0;
                    boolean makeSure;
                    for (Account a : accounts) {
                        System.out.println(num + ". " + a);
                        num++;
                    }
                    System.out.println();
                    System.out.print("Choose account to check balance:");
                    int choose_id = sc.nextInt();


                    do {
                        System.out.print("Enter password:");
                        String password = sc.next();
                        makeSure = accounts.get(choose_id).auth(password);
                        if (makeSure) {
                            System.out.println("wrong password pls enter again or enter 'out' to leave");
                        } else if (password.equals("out")) {
                            System.exit(0);
                        }
                    } while (makeSure);
                    System.out.println(accounts.get(choose_id).checkBalance());
                }
                else if (choose == 6) {
                    System.out.println("System out......");
                    System.exit(0);
                }
                else if(choose == 99){
                    int num = 0;
                    for (Account a : accounts) {
                        System.out.println(num + ". " + a);
                        num++;
                    }
                    System.out.println();
                    System.out.print("Choose account to check password:");
                    int choose_id = sc.nextInt();
                    System.out.print("password is ->");
                    System.out.println(accounts.get(choose_id).getPassword());
                }
            } catch (AccountError e) {
                e.printStackTrace();
            }
            catch (InputMismatchException e){
                System.out.println("You must enter number ,not any other character!");
            }
            catch (IndexOutOfBoundsException e){
                System.out.println("At least create an account first!");
            }
        }
    }
}
