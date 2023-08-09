// ť
#include <iostream>

using namespace std;

const int MAX = 1e4;    // 1e4 = 1 * 10^4 = 10000

class Queue {
private:
    int data[MAX];  // ť�� ����ִ� ������
    int index;      // �ε���(ť�� ���� ���� ����)

    void leftMoveData();    // pop�ϰ� �������� �б�

public:
    Queue();                // ������, �ε��� �ʱ�ȭ
    void push(int param);   // ť�� param push
    void pop();             // ť���� ���� ���� ���� pop, ������ -1
    void size();            // ť ���� ����
    void empty();           // ť ������� 1, �ƴϸ� 0 ���
    void front();            // ť ���� ���� ���� ���, ������ -1
    void back();            // ť ���� ���� ���� ���, ������ -1
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