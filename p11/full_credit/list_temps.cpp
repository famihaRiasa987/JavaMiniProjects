#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <map>
#include <iomanip>
#include "Date.h"

typedef double Temp;

int main(int argc, char* argv[]) {
    if (argc != 2) {
        std::cerr << "usage: " << argv[0] << " <data file>" << std::endl;
        return 1;
    }

    std::string filename = argv[1];
    std::ifstream file(filename);
    if (!file.is_open()) {
        std::cerr << "Can't open input file " << filename << std::endl;
        return 1;
    }

    std::map<Date, Temp> temps;
    std::string line;
    while (std::getline(file, line)) {
        std::istringstream ss(line);
        std::string continent, country, state, region, monthStr, dayStr, yearStr, tempStr;

        std::getline(ss, continent, ',');
        std::getline(ss, country, ',');
        std::getline(ss, state, ',');
        std::getline(ss, region, ',');
        std::getline(ss, monthStr, ',');
        std::getline(ss, dayStr, ',');
        std::getline(ss, yearStr, ',');
        std::getline(ss, tempStr, ',');

        int month = std::stoi(monthStr);
        int day = std::stoi(dayStr);
        int year = std::stoi(yearStr);
        Temp temp = std::stod(tempStr);

        Date date(year, month, day);
        temps[date] = temp;
    }
    file.close();

    while (true) {
        Date startDate, endDate;
        std::cout << "Starting date to list (year month day): ";
        if (!(std::cin >> startDate)) break;
        std::cout << "Ending date to list (year month day): ";
        if (!(std::cin >> endDate)) break;

        std::cout << "Date       Temperature (°F)" << std::endl;
        std::cout << "---------------------------" << std::endl;

        auto it = temps.lower_bound(startDate);
        for (; it != temps.end() && it->first <= endDate; ++it) {
            std::cout << it->first << "   " << std::fixed << std::setprecision(1) << it->second << std::endl;
        }
    }

    return 0;
}
