/**
 * Bank Account
 * Mimics all bank account functions
 */
public class BankAccount {
    /**
     * Account balance
     */
    private int accountBalance = -1;

    /**
     * Account is active/open
     */
    private boolean accountOpened = false;


    /**
     * Opens the bank account
     */
    public void open() {
        synchronized ( this ) {
            this.accountOpened = true;
            this.accountBalance = 0;
        }
    }

    /**
     * @throws BankAccountActionInvalidException if {@link BankAccount#accountOpened} is false
     */
    private void checkAccountStatus() throws BankAccountActionInvalidException {
        if ( !this.accountOpened ) {
            throw new BankAccountActionInvalidException( "Account closed" );
        }
    }

    /**
     * Checks if input amount is less than 0
     *
     * @param amount of the transaction to be performed
     * @throws BankAccountActionInvalidException if not
     */
    private void checkAmount( int amount ) throws BankAccountActionInvalidException {
        if ( amount < 0 ) {
            throw new BankAccountActionInvalidException( "Cannot deposit or withdraw negative amount" );
        }
    }

    /**
     * Gets balance of the account
     */
    public int getBalance() throws BankAccountActionInvalidException {
        synchronized ( this ) {
            this.checkAccountStatus();
            return this.accountBalance;
        }
    }

    /**
     * Deposits fixed amount into the bank account
     *
     * @param amount amount to be deposited
     */
    public void deposit( int amount ) throws BankAccountActionInvalidException {

        this.checkAmount( amount );

        synchronized ( this ) {
            this.checkAccountStatus();
            this.accountBalance += amount;
        }
    }

    /**
     * Withdraws fixed amount into the bank account
     *
     * @param amount amount to be withdrawn
     * @throws BankAccountActionInvalidException for balance related errors
     */
    public void withdraw( int amount ) throws BankAccountActionInvalidException {

        synchronized ( this ) {
            this.checkAccountStatus();
            this.checkAmount( amount );
            if ( 0 == this.accountBalance ) {
                throw new BankAccountActionInvalidException( "Cannot withdraw money from an empty account" );
            } else if ( this.accountBalance < amount ) {
                throw new BankAccountActionInvalidException( "Cannot withdraw more money than is currently in the account" );
            }
            this.accountBalance -= amount;
        }
    }

    /**
     * Closes the account & resets the balance
     */
    public void close() {
        synchronized ( this ) {
            if ( this.accountOpened ) {
                this.accountBalance = 0;
                this.accountOpened = false;
            }
        }
    }
}