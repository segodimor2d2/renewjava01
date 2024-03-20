# renewjava01

## Instruções de Execução e operação da plicação

[![Alt Text](http://img.youtube.com/vi/nA0c8N9awoI/0.jpg)](http://www.youtube.com/watch?v=nA0c8N9awoI)

Aqui tem um programa de teste para um sistema bancário básico com funcionalidades como criação de contas, verificação de saldo, depósito, saque, transferência, histórico de transações e operações de salvamento e importação de dados em arquivos CSV.

Aqui está um resumo:

Configuração Inicial:
Instancia objetos para manipulação de arquivos CSV.
Cria listas para armazenar contas e histórico de transações.

Menu Principal:
Utiliza um loop while para exibir um menu de opções ao usuário até que ele decida sair.
O usuário pode escolher entre várias opções, como criar uma nova conta, verificar saldo, depositar, sacar, transferir, visualizar histórico de transações, salvar dados em arquivos CSV, entre outros.

Execução do Menu:
Cada opção do menu é implementada como um case em um switch.
Dependendo da opção selecionada, o programa executa a operação correspondente, como criar uma nova conta, verificar saldo, depositar, sacar, transferir, visualizar histórico de transações, salvar dados em arquivos CSV, entre outros.

Funções Auxiliares:
foundAccount: Localiza uma conta pelo número da conta.
setTransactionsHistory: Adiciona uma nova entrada no histórico de transações.

Gerenciamento de Transações:
As transações são registradas em uma lista de histórico de transações.
Cada transação é armazenada com informações como número da conta, tipo de conta, saldo, valor da transação, descrição e horário.


Entrada do Usuário:
O código utiliza a classe Scanner para obter entradas do usuário para várias operações, como criar conta, depositar, sacar, transferir, etc.

Exibição de Dados:
O código utiliza métodos da classe UI para exibir informações ao usuário, como saldo da conta e histórico de transações.

Manipulação de Arquivos CSV:
Os dados das contas e histórico de transações podem ser salvos e importados de arquivos CSV.


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
UI-->>Client: Show Options!

Client->>UI: CREATE ACCOUNT<br><br>inputData:<br>accountNumber<br>agencyNumber<br>accountType<br>limit<br>name<br>amount
UI->>Program: inputData
Program->>Account: inputData
Account->>TransactionsHistory: copy inputData<br>addDataTime<br>addDescription
Account-->>Program: Account Created
Program-->>UI: Account Created
UI-->>Client: Show New Account Balance
UI-->>Client: Show Options

Client->>UI: BALANCE
UI->>Program: 
Program->>Account: accountsList
Account-->>Program: filterByAccountNumber
Program-->>UI: Balance
UI-->>Client: Show Balance
UI-->>Client: Show Options!

end     
```

```mermaid
sequenceDiagram
participant Client
participant UI
participant Program

participant Account
participant TransactionsHistory
participant FileCsv
    
loop MENU IN LOOP
UI-->>Client: Show Options!

Client->>UI: DEPOSIT
UI->>Program: 
Program-->>Client: Enter the Account Number:
Client->>Program: accountNumber
Program->>Account: accountsList
Account-->>Program: accountData
Program-->>Client: What is the deposit amount?
Client->>Program: amount
Program->>Account: accountData.deposit(amountChange)
Account->>TransactionsHistory: setTransactionsHistory<br>description: deposit<br>dateTime
Account-->>Program: Account Deposit
Program-->>UI: New Balance
UI-->>Client: Show Balance
UI-->>Client: Show Options

end
```

```mermaid
sequenceDiagram
participant Client
participant UI
participant Program

participant Account
participant TransactionsHistory
participant FileCsv
    
loop MENU IN LOOP
UI-->>Client: Show Options!

Client->>UI: WITHDRAW
UI->>Program: 
Program-->>Client: Enter the Account Number:
Client->>Program: accountNumber
Program->>Account: accountsList
Account-->>Program: accountData
Program-->>Client: What is the withdraw amount?
Client->>Program: amount
Program->>Account: accountData.withdraw(amountChange)
Account->>TransactionsHistory: setTransactionsHistory<br>description: withdraw<br>dateTime
Account-->>Program: Account withdraw
Program-->>UI: New Balance
UI-->>Client: Show Balance
UI-->>Client: Show Options

end
```
```mermaid
sequenceDiagram
participant Client
participant UI
participant Program

participant Account
participant TransactionsHistory
participant FileCsv
    
loop MENU IN LOOP
UI-->>Client: Show Options!

Client->>UI: CHANGE LIMIT
UI->>Program: 
Program-->>Client: Enter the Account Number:
Client->>Program: accountNumber
Program->>Account: accountsList
Account-->>Program: accountData
Program-->>Client: What is the new Limit?
Client->>Program: amountChange
Program->>Account: accountData.changeLimit(amountChange)
Account->>TransactionsHistory: setTransactionsHistory<br>description: changeLimit<br>dateTime
Account-->>Program: Account Limit
Program-->>UI: New Balance
UI-->>Client: Show Balance
UI-->>Client: Show Options


end

```

```mermaid
sequenceDiagram
participant Client
participant UI
participant Program

participant Account
participant TransactionsHistory
participant FileCsv
    
loop MENU IN LOOP
UI-->>Client: Show Options!

Client->>UI: TRANSFER
UI->>Program: 
Program-->>Client: Enter the 'Payer' Account Number:
Client->>Program: payerNumber
Program->>Account: accountsList
Account-->>Program: payerAccountData

Program-->>Client: Enter the 'Beneficiary' Account Number:
Client->>Program: beneficiaryNumber
Program->>Account: accountsList
Account-->>Program: beneficiaryAccountData

Program-->>Client: What is the amount to transfer?
Client->>Program: amountChange
Program->>Account: accountDataPrayer.withdraw(amountChange)
Account->>TransactionsHistory: setTransactionsHistory<br>description: withdraw<br>dateTime
Program->>Account: accountDataBenefy.deposit(amountChange)
Account->>TransactionsHistory: setTransactionsHistory<br>description: deposit<br>dateTime

Account-->>Program: Account Transfer Payer
Program-->>UI: New Balance
UI-->>Client: Show Balance
UI-->>Client: Show Options


end

```
```mermaid
sequenceDiagram
participant Client
participant UI
participant Program

participant Account
participant TransactionsHistory
participant FileCsv
    
loop MENU IN LOOP
UI-->>Client: Show Options!

Client->>UI: TRANSACTION HISTORY
UI->>Program: 
Program-->>Client: Enter the Account Number:
Client->>Program: accountNumber
Program->>Account: transactionsHistoryList
Account->>TransactionsHistory: foundHistory<br>by accountNumber
TransactionsHistory-->>Program: foundHistory
Program-->>UI: foundHistory
UI-->>Client: Show History
UI-->>Client: Show Options


end

```
```mermaid
sequenceDiagram
participant Client
participant UI
participant Program

participant Account
participant TransactionsHistory
participant FileCsv
    
loop MENU IN LOOP
UI-->>Client: Show Options!

Client->>UI: SAVE TRANSACTION HISTORY TO CSV
UI->>Program: 
Program-->>Client: Enter the Account Number:
Client->>Program: accountNumber
Program->>Account: transactionsHistoryList
Account->>TransactionsHistory: foundHistory<br>by accountNumber
TransactionsHistory->>FileCsv: fcsv.exportHistory(filteredList)
FileCsv-->>UI: csv created
UI-->>Client: csv created
UI-->>Client: Show Options

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
