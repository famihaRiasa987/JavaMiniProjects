#include <iostream>
#include <string>
#include <map>
#include <sstream>
#include "purse.h"

int main() {
    std::map<std::string, Purse> vault;
    int numAccounts;

    std::cout << "Enter the number of accounts: ";
    std::cin >> numAccounts;
    std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n'); // Clear buffer

    for (int i = 0; i < numAccounts; ++i) {
        std::string accountName, depositInput;
        int pounds, shillings, pence;

        std::cout << "Enter account name: ";
        std::getline(std::cin, accountName);

        std::cout << "Enter initial deposit as #pounds shillings spence (e.g., #12 3s4d): ";
        std::getline(std::cin, depositInput);

        std::istringstream depositStream(depositInput);
        char hash, sChar, dChar;

        if (depositStream >> hash >> pounds >> shillings >> sChar >> pence >> dChar
            && hash == '#' && sChar == 's' && dChar == 'd') {
            Purse account(pounds, shillings, pence);
            vault[accountName] = account;
        } else {
            std::cerr << "Invalid input format. Please use #pounds shillings spence (e.g., #12 3s4d)." << std::endl;
            return 1;
        }
    }

    Purse total;

    std::cout << "\nAccount List:\n";
    for (const auto& [name, purse] : vault) {
        std::cout << name << ": " << purse << "\n";
        total += purse;
    }

    std::cout << "\nTotal amount in bank: " << total << std::endl;
    return 0;
}
