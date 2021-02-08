/**
 * Bank Account
 * Mimics all bank account functions
 * */
public class BankAccount{
    /**
     * Account balance
     * */
    private int accountBalance = -1;

    /**
     * Account is active/open
     * */
    private boolean accountOpened = false;

    /**
     * Message for when negative amount is deposited or withdrawn
     * */
    private static final String AMOUNT_INVALID = "Cannot deposit or withdraw negative amount";



    /**
     * Opens the bank account
     * */
    public synchronized void open() {
        this.accountOpened = true;
        this.accountBalance = 0;
    }

    /**
     * @throws BankAccountActionInvalidException if {@link BankAccount#accountOpened} is false
     * */
    private void checkAccountStatus( ) throws BankAccountActionInvalidException {
        if( !this.accountOpened ){
            throw new BankAccountActionInvalidException( "Account closed" );
        }
    }

    /**
     * Gets balance of the account
     * */
    public int getBalance() throws BankAccountActionInvalidException {
        this.checkAccountStatus();

        synchronized ( this ) {
            return this.accountBalance;
        }
    }

    /**
     * Deposits fixed amount into the bank account
     * @param amount amount to be deposited
     * @throws BankAccountActionInvalidException with message {@link BankAccount#AMOUNT_INVALID} if amount is less than 0
     * */
    public void deposit( int amount ) throws BankAccountActionInvalidException {
        this.checkAccountStatus();

        if( amount < 0 ) {
            throw new BankAccountActionInvalidException( BankAccount.AMOUNT_INVALID );
        }

        synchronized ( this ) {
            this.accountBalance += amount;
        }
    }

    /**
     * Withdraws fixed amount into the bank account
     * @param amount amount to be withdrawn
     * @throws BankAccountActionInvalidException with message {@link BankAccount#AMOUNT_INVALID} if amount is less than 0
     * @throws BankAccountActionInvalidException for balance related errors
     * */
    public void withdraw( int amount ) throws BankAccountActionInvalidException{
        this.checkAccountStatus();

        if( amount < 0 ) {
            throw new BankAccountActionInvalidException( BankAccount.AMOUNT_INVALID );
        } else if( 0 == this.accountBalance ) {
            throw new BankAccountActionInvalidException( "Cannot withdraw money from an empty account" );
        } else if( this.accountBalance < amount ) {
            throw new BankAccountActionInvalidException( "Cannot withdraw more money than is currently in the account" );
        }

        synchronized ( this ) {
            this.accountBalance -= amount;
        }
    }

    /**
     * Closes the account & resets the balance
 * */
    public synchronized void close(){
        if( this.accountOpened ){
            this.accountBalance = 0;
            this.accountOpened = false;
        }
    }
}