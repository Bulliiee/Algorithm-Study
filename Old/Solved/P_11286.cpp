// ���� ��
#include <iostream>
#include <queue>

using namespace std;

// �񱳿����� Ȱ��
struct cmp {
    bool operator()(int a, int b) {
        int t1, t2;
        if(a < 0) t1 = a * (-1);
        else t1 = a;

        if(b < 0) t2 = b * (-1);
        else t2 = b;

        if(t1 == t2) {
            return a > b;
        }
        else {
            return t1 > t2;
        }
    }
};

void absHeap(priority_queue<int, vector<int>, cmp> *pq, int command) {
    // ���� ���� ���� �� ���, pop
    if(command == 0) {
        int temp = 0;
        if(!pq->empty()) { 
            temp = pq->top();
            pq->pop();
        }
        cout << temp << '\n';
    }
    // �� push
    else {
        pq->push(command);
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    priority_queue<int, vector<int>, cmp> pq;

    int input;
    cin >> input;

    while(input--) {
        int command;
        cin >> command;
        absHeap(&pq, command);
    }

    return 0;
}