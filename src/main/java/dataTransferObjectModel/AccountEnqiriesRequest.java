package dataTransferObjectModel;

import java.io.Serializable;


public class AccountEnqiriesRequest implements Serializable {

    private String accountNo;

    private String bankCode;


    public String getAccountNo() {
        return accountNo;
    }


    public String getBankCode() {
        return bankCode;
    }


    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }


    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }
}
