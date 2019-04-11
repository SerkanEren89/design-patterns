package builder;

/**
 * Builder design pattern example
 *
 * - When the process involved in creating an object is extremely complex, with lots of mandatory and optional parameters
 * - When an increase in the number of constructor parameters leads to a large list of constructors
 *
 * @author eren
 */
public class BankAccount {

    private String name;
    private String accountNumber;
    private String email;
    private boolean newsletter;

    private BankAccount(BankAccountBuilder bankAccountBuilder) {
        this.accountNumber = bankAccountBuilder.accountNumber;
        this.name = bankAccountBuilder.name;
        this.email = bankAccountBuilder.email;
        this.newsletter = bankAccountBuilder.newsletter;
    }

    public static class BankAccountBuilder {

        private String name;
        private String accountNumber;
        private String email;
        private boolean newsletter;

        /**
         * Mandatory fields
         *
         * @param name          name
         * @param accountNumber account number
         */
        BankAccountBuilder(String name, String accountNumber) {
            this.name = name;
            this.accountNumber = accountNumber;
        }

        BankAccountBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        BankAccountBuilder wantNewsletter(boolean newsletter) {
            this.newsletter = newsletter;
            return this;
        }

        BankAccount build() {
            return new BankAccount(this);
        }
    }


    public static void main(String[] args) {
        BankAccount newAccount = new BankAccount
                .BankAccountBuilder("Jon", "22738022275")
                .withEmail("jon@example.com")
                .wantNewsletter(true)
                .build();
    }
}
