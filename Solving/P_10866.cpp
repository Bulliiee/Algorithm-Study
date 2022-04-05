// µ¦
#include <iostream>

using namespace std;

int deque(string command, int *arr, int index) {
    int param;

    if(command == "push_front") {
        cin >> param;

        if(index != 0) {
            // ÇÑ Ä­¾¿ µÚ·Î ¹Ð°í
            for(int i = index + 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
        }

        arr[0] = param;
        index++;
    }
    else if(command == "push_back") {
        cin >> param;

        arr[index] = param;
        index++;
    }
    else if(command == "pop_front") {
        if(index != 0) {
            cout << arr[0] << '\n';
            // ÇÑ Ä­¾¿ ¾ÕÀ¸·Î ¹Ð±â
            for(int i = 1; i < index; i++) {
                arr[i] = arr[i - 1];
            }
        }
        else {
            cout << -1 << '\n';
        }

        index--;
    }
    else if(command == "pop_back") {
    
    }
    else if(command == "size") {
    
    }
    else if(command == "empty") {
    
    }
    else if(command == "front") {
    
    }
    else if(command == "back") {
    
    }

    return index;
}

int main() {
    ios_base :: sync_with_stdio(false);
    // cin.tie(NULL);

    string command;
    int input;
    int index = 0;
    int *arr = new int;

    cin >> input;
    for(int i = 0; i < input; i++) {
        cin >> command;
        index = deque(command, arr, index);

        for(int i = 0; i < index; i++) {
            cout << arr[i] + ", ";
        }
        cout << '\n';
    }

    return 0;
}