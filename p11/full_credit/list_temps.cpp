#include <iostream>
#include <fstream>
#include <map>
#include <sstream>
#include <iomanip>
#include <string>
#include "date.h"

typedef double Temp;

int main(int argc, char* argv[]) {
    if (argc != 2) {
        std::cerr << "usage: " << argv[0] << " <data file>" << std::endl;
        return 1;
    }

    std::string filename = argv[1];
    std::ifstream infile(filename);
    if (!infile) {
        std::cerr << "Can't open input file " << filename << std::endl;
        return 1;
    }

    std::map<Date, Temp> temps;
    std::string line;

    // Load data from the CSV file into the map
    while (std::getline(infile, line)) {
        std::stringstream ss(line);
        std::string continent, country, state, region;
        int month, day, year;
        Temp temperature;

        // Ignore the first 4 fields (continent, country, state, region)
        std::getline(ss, continent, ',');
        std::getline(ss, country, ',');
        std::getline(ss, state, ',');
        std::getline(ss, region, ',');

        // Extract month, day, year, and temperature
        ss >> month; ss.ignore(1);
        ss >> day; ss.ignore(1);
        ss >> year; ss.ignore(1);
        ss >> temperature;

        // Create a Date object and add it to the map
        Date date(year, month, day);
        temps[date] = temperature;
    }

    // Main loop to query date ranges and print temperatures
    while (true) {
        int start_month, start_day, start_year;
        int end_month, end_day, end_year;

        // Get start date from the user
        std::cout << "Enter start date (MM DD YYYY): ";
        std::cin >> start_month >> start_day >> start_year;
        if (!std::cin.good()) break;

        // Get end date from the user
        std::cout << "Enter end date (MM DD YYYY): ";
        std::cin >> end_month >> end_day >> end_year;
        if (!std::cin.good()) break;

        Date start_date(start_year, start_month, start_day);
        Date end_date(end_year, end_month, end_day);

        // Print header
        std::cout << "Date        Temperature" << std::endl;
        std::cout << "-----------------------" << std::endl;

        // Iterator loop to find and print temperatures within the date range
        auto it = temps.lower_bound(start_date);
        bool found = false;
        while (it != temps.end() && it->first <= end_date) {
            std::cout << it->first << "  " << std::fixed << std::setprecision(1) << it->second << std::endl;
            ++it;
            found = true;
        }

        // If no dates were found in the range, indicate that
        if (!found) {
            std::cout << "No data found in the specified date range." << std::endl;
        }
    }

    return 0;
}
