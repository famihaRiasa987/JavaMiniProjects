#include <iostream>
#include <string>
#include <map>
#include "purse.h"

int main() {
    std::map<std::string, Purse> vault;
    int numAccounts;

    std::cout << "Enter the number of accounts: ";
    std::cin >> numAccounts;
    std::cin.ignore();

    for (int i = 0; i < numAccounts; ++i) {
        std::string accountName;
        int pounds, shillings, pence;

        std::cout << "Enter account name: ";
        std::getline(std::cin, accountName);

        std::cout << "Enter initial deposit (pounds shillings pence): ";
        std::cin >> pounds >> shillings >> pence;
        std::cin.ignore();

        Purse initialDeposit(pounds, shillings, pence);
        vault[accountName] = initialDeposit;
    }

    Purse total;

    std::cout << "\nAccount List:\n";
    for (const auto& entry : vault) {
        std::cout << entry.first << ": " << entry.second << '\n';
        total += entry.second;
    }

    std::cout << "\nTotal amount in bank: " << total << '\n';

    return 0;
}
