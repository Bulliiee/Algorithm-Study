#include <iostream>
#include <string>
#include <math.h>

using namespace std;

int convertAlphabet(char alphabet) {
    int res;

    if(alphabet >= 'A' && alphabet <= 'Z') {
        res = (int)(alphabet - 'A') + 10;
    }
    else {
        res = (int)(alphabet - '0');
    }

    return res;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    string input;
    int notation;       // max 36
    int result = 0;     // max billion

    cin >> input >> notation;

    int temp = 0;
    for(int i = input.size() - 1; i >= 0; i--) {
        result += convertAlphabet(input.at(i)) * pow(notation, temp++);
    }

    cout << result;


    return 0;
}