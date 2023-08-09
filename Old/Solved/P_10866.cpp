// ��
#include <iostream>

using namespace std;

const int MAX = 1e5;    // 1 * 10^5, ���� �ִ� ��������

class Deque {
private:
    int data[MAX];      // ���� ���� ���� ����
    int index;          // ���� �� ���� ����

    void pushRightDeque();   // �� ���������� �ϳ��� �̴� �Լ�
    void pushLeftDeque();    // �� �������� �ϳ��� �̴� �Լ�

public:
    Deque();                    // ������, index_front, back�� 0���� �ʱ�ȭ
    void push_front(int num);   // ������ ���� �տ� ����
    void push_back(int num);    // ������ ���� �ڿ� ����
    void pop_front();           // �� ���� ���� �� pop �� ���, �� ������� -1���
    void pop_back();            // �� ���� ���� �� pop �� ���, �� ������� -1���
    int size();                 // ���� ����ִ� ������ ���� ���
    int empty();                // ���� ������� 1, �ƴϸ� 0 ���
    void front();               // �� ���� ���� �� ���, �� ������� -1���
    void back();                // �� ���� ���� �� ���, �� ������� -1���
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