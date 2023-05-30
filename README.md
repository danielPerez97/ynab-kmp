# In Development
Please be aware this library is far from complete or usable.

# ynab-kmp
ynab-kmp stands for "You Need A Budget - Multiplatform". It is a library for interfacing with YNAB's own [developer API][1] leveraging [Kotlin's
Multiplatform Features][2] so it can be used on Android with iOS and JS planned for the future.

# Modules
Currently there are two modules: 'json' and 'ynab-http'. 'json' holds all the JSON data classes using kotlinx.serialization, and 'http' is a JVM/Android 
only module that will provide Okhttp interceptors and Retrofit interfaces for use with the YNAB developer API.

To test, run the following:  
`./gradlew :json:clean :json:check`  
`./gradlew :ynab-http:clean :ynab-http:check`

# Current Goals
* Provide API's that can fully support [Personal Access Tokens][3] and [OAuth Applications][4] per the YNAB documentation.
* Have the project be feature-complete enough to build an Android App that provides a widget to view a users age of money

# Endpoint Checklist
https://api.ynab.com/v1#/

### User
- [X] GET /user

### Budgets(BudgetService.kt)
- [X] GET /budgets
- [X] GET /budgets/{budget_id}
- [X] GET /budgets/{budget_id}/settings

### Accounts(AccountService.kt)

- [X] GET /budgets/{budget_id}/accounts
- [X] POST /budgets/{budget_id}/accounts
- [X] GET /budgets/{budget_id}/accounts/{account_id}

### Categories(CategoriesService.kt)
- [ ] GET /budgets/{budget_id}/categories
- [ ] GET /budgets/{budget_id}/categories/{category_id}
- [ ] GET /budgets/{budget_id}/months/{month}/categories/{category_id}
- [ ] PATCH /budgets/{budget_id}/months/{month}/categories/{category_id}

### Payees(PayeesServiceService.kt)
- [X] GET /budgets/{budget_id}/payees
- [X] GET /budgets/{budget_id}/payees/{payee_id}

### Payee Locations(PayeeLocationsService.kt)
- [ ] GET /budgets/{budget_id}/payee_locations
- [ ] GET /budgets/{budget_id}/payee_locations/{payee_location_id}
- [ ] GET /budgets/{budget_id}/payees/{payee_id}/payee_locations

### Months(MonthsService.kt)
- [ ] GET /budgets/{budget_id}/months
- [ ] GET /budgets/{budget_id}/months/{month}

### Transactions(TransactionsService.kt)
- [ ] GET /budgets/{budget_id}/transactions
- [ ] POST /budgets/{budget_id}/transactions
- [ ] PATCH /budgets/{budget_id}/transactions
- [ ] POST /budgets/{budget_id}/transactions/import
- [ ] GET /budgets/{budget_id}/transactions/{transaction_id}
- [ ] PUT /budgets/{budget_id}/transactions/{transaction_id}
- [ ] DELETE /budgets/{budget_id}/transactions/{transaction_id}
- [ ] GET /budgets/{budget_id}/accounts/{account_id}/transactions
- [ ] GET /budgets/{budget_id}/categories/{category_id}/transactions
- [ ] GET /budgets/{budget_id}/payees/{payee_id}/transactions

### Scheduled Transactions(ScheduledTransactionsService.kt)
- [ ] GET /budgets/{budget_id}/scheduled_transactions
- [ ] GET /budgets/{budget_id}/scheduled_transactions/{scheduled_transaction_id}


[1]: https://api.youneedabudget.com/#hello
[2]: https://kotlinlang.org/lp/mobile/
[3]: https://api.youneedabudget.com/#personal-access-tokens
[4]: https://api.youneedabudget.com/#outh-applications
