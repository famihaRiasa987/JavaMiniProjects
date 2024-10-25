#include <iostream>
#include <string>
int main(){

    std:: string name;
    std::cout << "Whats your name? ";
    std::getline(std::cin, name);  // reading name and spaces 
    std::cout << "Hello "+ name + "!\n";

}