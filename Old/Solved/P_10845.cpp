// 큐
#include <iostream>

using namespace std;

const int MAX = 1e4;    // 1e4 = 1 * 10^4 = 10000

class Queue {
private:
    int data[MAX];  // 큐에 들어있는 데이터
    int index;      // 인덱스(큐가 가진 원소 갯수)

    void leftMoveData();    // pop하고 왼쪽으로 밀기

public:
    Queue();                // 생성자, 인덱스 초기화
    void push(int param);   // 큐에 param push
    void pop();             // 큐에서 가장 앞의 정수 pop, 없으면 -1
    void size();            // 큐 원소 갯수
    void empty();           // 큐 비었으면 1, 아니면 0 출력
    void front();            // 큐 가장 앞의 정수 출력, 없으면 -1
    void back();            // 큐 가장 뒤의 정수 출력, 없으면 -1
};

void Queue::leftMoveData() {
    for(int i = 1; i < index; i++) {
        data[i - 1] = data[i];
    }
}

Queue::Queue() {
    index = 0;
}

void Queue::push(int param) {
    data[index] = param;
    index++;
}

void Queue::pop() {
    if(index == 0) {
        cout << -1 << '\n';
        return;
    }

    cout << data[0] << '\n';
    leftMoveData();
    index--;
}

void Queue::size() {
    cout << index << '\n';
}

void Queue::empty() {
    if(index == 0) {
        cout << 1 << '\n';
    }
    else {
        cout << 0 << '\n';
    }
}

void Queue::front() {
    if(index == 0) {
        cout << -1 << '\n';
        return;
    }

    cout << data[0] << '\n';
}

void Queue::back() {
    if(index == 0) {
        cout << -1 << '\n';
        return;
    }

    cout << data[index - 1] << '\n';
}

void runCommand(int input) {
    Queue queue;
    string command;
    int param;

    for(int i = 0; i < input; i++) {
        cin >> command;

        if(command == "push") {
            cin >> param;
            queue.push(param);
        }
        else if(command == "pop") {
            queue.pop();
        }
        else if(command == "size") {
            queue.size();
        }
        else if(command == "empty") {
            queue.empty();
        }
        else if(command == "front") {
            queue.front();
        }
        else if(command == "back") {
            queue.back();
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