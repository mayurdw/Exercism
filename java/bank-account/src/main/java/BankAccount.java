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
     * Message for when bank account is closed
     * */
    private static final String ACCOUNT_CLOSED = "Account closed";

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
     * Gets balance of the account
     * @throws BankAccountActionInvalidException with message {@link BankAccount#ACCOUNT_CLOSED}
     * */
    public synchronized int getBalance() throws BankAccountActionInvalidException {
        if( !this.accountOpened ){
            throw new BankAccountActionInvalidException( BankAccount.ACCOUNT_CLOSED );
        }

        return this.accountBalance;
    }

    /**
     * Deposits fixed amount into the bank account
     * @param amount amount to be deposited
     * @throws BankAccountActionInvalidException with message {@link BankAccount#AMOUNT_INVALID} if amount is less than 0
     * @throws BankAccountActionInvalidException with message {@link BankAccount#ACCOUNT_CLOSED} if account is closed
     * */
    public synchronized void deposit( int amount ) throws BankAccountActionInvalidException {

        if( !this.accountOpened ) {
            throw new BankAccountActionInvalidException( BankAccount.ACCOUNT_CLOSED );
        } else if( amount < 0 ) {
            throw new BankAccountActionInvalidException( BankAccount.AMOUNT_INVALID );
        }

        this.accountBalance += amount;
    }

    /**
     * Withdraws fixed amount into the bank account
     * @param amount amount to be withdrawn
     * @throws BankAccountActionInvalidException with message {@link BankAccount#AMOUNT_INVALID} if amount is less than 0
     * @throws BankAccountActionInvalidException with message {@link BankAccount#ACCOUNT_CLOSED} if account is closed
     * @throws BankAccountActionInvalidException for balance related errors
     * */
    public synchronized void withdraw( int amount ) throws BankAccountActionInvalidException{
        if( !this.accountOpened ) {
            throw new BankAccountActionInvalidException( BankAccount.ACCOUNT_CLOSED );
        } else if( amount < 0 ) {
            throw new BankAccountActionInvalidException( BankAccount.AMOUNT_INVALID );
        } else if( 0 == this.accountBalance ) {
            throw new BankAccountActionInvalidException( "Cannot withdraw money from an empty account" );
        } else if( this.accountBalance < amount ) {
            throw new BankAccountActionInvalidException( "Cannot withdraw more money than is currently in the account" );
        }

        this.accountBalance -= amount;
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