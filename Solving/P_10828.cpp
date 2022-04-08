// Ω∫≈√
#include <iostream>

using namespace std;

const int MAX = 1e4;

class Stack {
private:
    int data[MAX];
    int index;
public:
    Stack();
    void push(int param);
    void pop();
    void size();
    void empty();
    void top();
};

Stack::Stack() {
    index = 0;
}

void Stack::push(int param) {
    data[index] = param;
    index++;
}

void Stack::pop() {
    if(index == 0) {
        cout << -1 << '\n';
        return;
    }

    index--;
    cout << data[index] << '\n';
}

void Stack::size() {
    cout << index << '\n';
}

void Stack::empty() {
    if(index == 0) {
        cout << 1 << '\n';
    }
    else {
        cout << 0 << '\n';
    }
}

void Stack::top() {
    if(index == 0) {
        cout << -1 << '\n';
        return;
    }
    cout << data[index - 1] << '\n';
}

void runCommand(int input) {
    Stack stack;
    string command;
    int param;

    for(int i = 0; i < input; i++) {
        cin >> command;
        
        if(command == "push") {
            cin >> param;
            stack.push(param);
        }
        else if(command == "pop") {
            stack.pop();
        }
        else if(command == "size") {
            stack.size();
        }
        else if(command == "empty") {
            stack.empty();
        }
        else if(command == "top") {
            stack.top();
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int input;
    cin >> input;

    runCommand(input);

    return 0;
}