// 덱
#include <iostream>

using namespace std;

const int MAX = 1e5;    // 1 * 10^5, 덱의 최대 사이즈임

class Deque {
private:
    int data[MAX];      // 덱에 넣은 원소 저장
    int index;          // 덱에 들어간 원소 갯수

    void pushRightDeque();   // 덱 오른쪽으로 하나씩 미는 함수
    void pushLeftDeque();    // 덱 왼쪽으로 하나씩 미는 함수

public:
    Deque();                    // 생성자, index_front, back을 0으로 초기화
    void push_front(int num);   // 정수를 덱의 앞에 넣음
    void push_back(int num);    // 정수를 덱의 뒤에 넣음
    void pop_front();           // 덱 가장 앞의 수 pop 후 출력, 덱 비었으면 -1출력
    void pop_back();            // 덱 가장 뒤의 수 pop 후 출력, 덱 비었으면 -1출력
    int size();                 // 덱에 들어있는 정수의 개수 출력
    int empty();                // 덱이 비었으면 1, 아니면 0 출력
    void front();               // 덱 가장 앞의 수 출력, 덱 비었으면 -1출력
    void back();                // 덱 가장 뒤의 수 출력, 덱 비었으면 -1출력
    void printDeque();
};

void Deque::pushRightDeque() {
    for(int i = index; i > 0; i--) {
        data[i] = data[i - 1];
    }
}

void Deque::pushLeftDeque() {
    for(int i = 0; i < index; i++) {
        data[i] = data[i + 1];
    }
}

Deque::Deque() {
    index = 0;
}

void Deque::push_front(int num) {
    if(index != 0) {
        pushRightDeque();
    }
    data[0] = num;
    index++;
}

void Deque::push_back(int num) {
    data[index] = num;
    index++;
}

void Deque::pop_front() {
    if(index == 0) {
        cout << -1 << '\n';
        return;
    }
    cout << data[0] << '\n';
    pushLeftDeque();
    index--;
}

void Deque::pop_back() {
    if(index == 0) {
        cout << -1 << '\n';
        return;
    }
    index--;
    cout << data[index] << '\n';
}

int Deque::size() {
    return index;
}

int Deque::empty() {
    return index == 0 ? 1 : 0;
}

void Deque::front() {
    if(index == 0) {
        cout << -1 << '\n';
        return;
    }
    cout << data[0] << '\n';
}

void Deque::back() {
    if(index == 0) {
        cout << -1 << '\n';
        return;
    }
    cout << data[index - 1] << '\n';
}

void Deque::printDeque() {
    for(int i = 0; i < size(); i++) {
        cout << data[i] << ", ";
    }
    cout << '\n';
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    Deque deque;

    int input;
    string command;
    int param;

    cin >> input;
    for(int i = 0; i < input; i++) {
        cin >> command;

        if(command == "push_front") {
            cin >> param;
            deque.push_front(param);
        }
        else if(command == "push_back") {
            cin >> param;
            deque.push_back(param);
        }
        else if(command == "pop_front") {
            deque.pop_front();
        }
        else if(command == "pop_back") {
            deque.pop_back();
        }
        else if(command == "size") {
            cout << deque.size() << '\n';
        }
        else if(command == "empty") {
            cout << deque.empty() << '\n';
        }
        else if(command == "front") {
            deque.front();
        }
        else if(command == "back") {
            deque.back();
        }
    }
    

    return 0;
}