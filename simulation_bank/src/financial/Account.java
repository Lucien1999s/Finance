package financial;

import java.io.Serializable;

public class Account implements Serializable {
    private int balance;
    private String id,remark,password;
    public Account(String id,String password,int money,String remark){
        this.id = id;
        this.password = password;
        this.balance = money;
        this.remark = remark;
    }
    public void deposit(int 曼尼) throws AccountError{
        if(曼尼<0)
            throw new AccountError("Deposit amount cannot be negative");
        else
            balance+=曼尼;
    }
    public void withdraw(int money)throws AccountError{
        if(money>balance)
            throw new AccountError("Insufficient balance");
        else
            balance -= money;
    }
    public boolean auth(String pwd){
        boolean 確認;
        if(pwd.equals(this.password)){
            確認 = false;
        }
        else{
            確認 = true;
        }
        return 確認;
    }
    public int transfer(int money)throws AccountError{
        if(money<0){
            throw new AccountError("Transfer amount cannot be negative");
        }
        else if (money>balance){
            throw new AccountError("Insufficient balance");
        }
        else
            this.balance-=money;
        return money;
    }
    public String getPassword(){
        return this.password;
    }
    public int checkBalance(){return balance;}
    public String toString(){
        return "ID:"+id+",remark:"+remark;
    }
}
