// �ּ� ��
#include <iostream>
#define MAX 100001      // �ε��� 1���� ����

using namespace std;

int heapSize = 0;  // �ּ����� ����ִ� ����� ��������, ���� ������ �ε���
int minHeap[MAX];   // ��������Ʈ���� �迭�� ���·� ǥ���Ѵ�.(�ε��� 1���� ���)
// ���� ��� {0, 2, 3, 5, 4, 7, 6}�� ���
//        2
//     /     \
//    3       5
//   / \     /
//  4   7   6
// ���¶�� ���� �ȴ�.
// �θ��� �ε����� ���ϴ� ����� �ε��� / 2 �ϸ� ��������.
// ������� [5]�ε����� �θ� �ε����� ���Ϸ��� 5 / 2 = 2�̹Ƿ�
// �θ����� �ε����� [2], ���� 3�� �ȴ�. 

// �ּ����� �� �ֱ�
void pushHeap(int num) {
    int tempIndex = heapSize + 1;  // ���� ������ �ε��� ������ �־�� �ϹǷ� +1 ���ش�.

    // Ʈ���� ���� �ܸ�(������ �ǾƷ�)�� ���� ���� �ִ´�.
    minHeap[tempIndex] = num;

    // ���� �ܸ��� ���� ���� �θ�� ���ذ��� �۴ٸ� �θ�� swap�Ѵ�.
    // ���� üũ�ϴ� ��尡 ��Ʈ��尡 �ƴϰ�, �θ��庸�� ���� �۴ٸ�
    while((tempIndex != 1) && (num < minHeap[tempIndex / 2])) {
        // �θ���� ���� ��带 swap�Ѵ�.
        int t = minHeap[tempIndex];
        minHeap[tempIndex] = minHeap[tempIndex / 2];
        minHeap[tempIndex / 2] = t;
        
        tempIndex /= 2;
    }

    heapSize++; // ���� �� �־����ϵ���ִ� ����� ������ 1�� �÷��ش�.
}

// �ּ������� �ּҰ� ����
int popHeap() {
    int min;

    // �� ũ�Ⱑ 0�̶�� �ƹ��͵� ������� ���� ���̹Ƿ� 0����
    if(heapSize == 0) {
        return 0;
    }

    // min�� ��Ʈ���(�ּҰ�) ���
    // �ܸ��� ��Ʈ�� swap�Ѵ�.
    min = minHeap[1];
    minHeap[1] = minHeap[heapSize];
    // minHeap[heapSize] = min;
    heapSize--; // �� ����� �ٿ��� �ܸ�(���� ���� ��)�� ����

    // swap������ �ٽ� Ʈ���� �����ش�.
    // root���� �ڽ��� �۴ٸ�
    // root������ �Ʒ��� �ڽ� 2���� ���ؼ� �� �� �� �����ָ� ���� �ø���.
    int parentIndex = 1;
    while(true) {
        int childIndex = parentIndex * 2;

        // �ڽ� 2�� ���ؼ� �� �����ָ� �ø��غ� ��
        // �ڽĳ���� �����ʰ� ���� �ִ� ��� �������� �۰�(�ڽĳ�尡 2�� �� �ִ� ���) �����ʰ� ���ʺ��� ������
        // childIndex����, �ᱹ �ڽĳ�� �� �����ְ� childIndex�� ����.
        if(childIndex + 1 <= heapSize && minHeap[childIndex] > minHeap[childIndex + 1]) {
            childIndex++;
        }

        // childIndex�� heapSize ����ų� �θ𺸴� ū ��찡 �Ǹ� ���������� ��
        if(childIndex > heapSize || minHeap[childIndex] > minHeap[parentIndex]) {
            break;
        }

        // �θ�� �ڽ��� ������ swap
        int temp = minHeap[childIndex];
        minHeap[childIndex] = minHeap[parentIndex];
        minHeap[parentIndex] = temp;

        parentIndex = childIndex;
    }
    

    return min;
}

void quary(int command) {
    // ���
    if(command == 0) {
        cout << popHeap() << '\n';
        // cout << "result>>>>>>>>>>>>>>>: " << popHeap() << '\n';
    }
    // ����
    else {
        pushHeap(command);
    }

    // cout << "heapSize: " << heapSize << '\n';
    // cout << "minHeap: ";
    // for(int i = 0; i <= heapSize; i++) {
    //     cout << minHeap[i] << ' ';
    // }
    // cout << '\n';
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int input, command;
    cin >> input;

    while(input--) {
        cin >> command;
        quary(command);
    }

    return 0;
}