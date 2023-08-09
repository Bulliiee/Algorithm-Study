// �ִ� ��(1927 �ּ��� ����)
#include <iostream>
#define MAX 100001  // �ε��� 1���� ����

using namespace std;

int heapSize = 0;   // heap�� ��尹��(ũ��)���� ���� ������ ��� ����Ű�� �ε���
int maxHeap[MAX];

void swap(int* n1, int* n2) {
    int temp = *n1;
    *n1 = *n2;
    *n2 = temp;
}

void pushHeap(int num) {
    int tempIndex = heapSize + 1;   // ���� �ε����� �־���ϹǷ� + 1

    maxHeap[tempIndex] = num;

    // üũ�ϴ� ��尡 1(��Ʈ)�ƴϰ�, push�� ���� �θ��庸�� ũ�ٸ� �ݺ�
    while(tempIndex != 1 && num > maxHeap[tempIndex / 2]) {
        // �θ𺸴� ũ�� ����
        swap(maxHeap[tempIndex], maxHeap[tempIndex / 2]);
        tempIndex /= 2;
    }

    heapSize++;
}

int popHeap() {
    int max = 0;

    // heapSize�� 0�̸� �׳� 0���, �ƴϸ� ��Ʈ(�ִ밪) �̾Ƽ� Ʈ�� ���� �� ����
    if(heapSize != 0) {
        max = maxHeap[1];
        maxHeap[1] = maxHeap[heapSize];
        heapSize--;

        int parentIndex = 1;
        while(true) {
            int childIndex = parentIndex * 2;

            // �ڽĳ�尡 2�� && �����ʰ� ���ʺ��� ũ�ٸ�
            if(childIndex + 1 <= heapSize && maxHeap[childIndex] < maxHeap[childIndex + 1]) {
                childIndex++;   // �������ڽ��� �ε����� ����
            }
            // �ڽ� �ε����� ���� ũ�⺸�� Ŀ���ų� �̹� �θ� �ڽĺ��� ũ��
            if(childIndex > heapSize || maxHeap[parentIndex] > maxHeap[childIndex]) {
                break;  // while�� Ż��
            }

            swap(maxHeap[parentIndex], maxHeap[childIndex]);

            parentIndex = childIndex;
        }
    }

    return max;
}

void quary(int command) {
    if(command == 0) {
        cout << popHeap() << '\n';
    }
    else {
        pushHeap(command);
    }
}

void input() {
    int num, command;
    cin >> num;

    for(int i = 0; i < num; i++) {
        cin >> command;
        quary(command);
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    input();

    return 0;
}