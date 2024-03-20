# renewjava01
## Sequence Diagram

```mermaid
sequenceDiagram
participant Client
participant UI
participant Program

participant Account
participant TransactionsHistory
participant FileCsv
    
Program->>FileCsv: import accounts csv
FileCsv-->>Account: create accounts list
Account->>TransactionsHistory: create accounts list create events

loop MENU IN LOOP
Program-->>UI: Show Options!
Client->>UI: CREATE ACCOUNT<br><br>inputData:<br>accountNumber<br>agencyNumber<br>accountType<br>limit<br>name<br>amount
UI->>Program: inputData
Program->>Account: inputData
Account->>TransactionsHistory: copy inputData<br>addDataTime<br>addDescription
Account-->>UI: Account Created
UI-->>Client: Account Created
Program-->>UI: Show Options!
end
    


```




## Class Diagram 
```mermaid
classDiagram

Program <--> UI
Program --> Account
Program --> TransactionsHistory
Program --o FileCsv

Account <-- TransactionsHistory
FileCsv <--o Account
FileCsv <--o TransactionsHistory


Program : main()
Program : menuExecute()
Program : foundHistory()
Program : foundAccount()
Program : setTransactionsHistory()

Account : String accountNumber
Account : String agencyNumber
Account : String accountType
Account : double limit
Account : String name
Account : double amount
Account : deposit()
Account : withdraw()
Account : changeLimit()

TransactionsHistory : String accountNumber
TransactionsHistory : String agencyNumber
TransactionsHistory : String accountType
TransactionsHistory : double limit
TransactionsHistory : String name
TransactionsHistory : double amount
TransactionsHistory : String description
TransactionsHistory : LocalTime transactionTime

FileCsv
FileCsv : List<Account> importFile()
FileCsv : exportHistory()
FileCsv : exportFile()

UI : showMenu()
UI : showBalance()
UI : showHistory()

```
