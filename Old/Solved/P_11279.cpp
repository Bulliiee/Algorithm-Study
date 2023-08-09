// 최대 힙(1927 최소힙 참고)
#include <iostream>
#define MAX 100001  // 인덱스 1부터 시작

using namespace std;

int heapSize = 0;   // heap의 노드갯수(크기)이자 가장 마지막 노드 가리키는 인덱스
int maxHeap[MAX];

void swap(int* n1, int* n2) {
    int temp = *n1;
    *n1 = *n2;
    *n2 = temp;
}

void pushHeap(int num) {
    int tempIndex = heapSize + 1;   // 다음 인덱스에 넣어야하므로 + 1

    maxHeap[tempIndex] = num;

    // 체크하는 노드가 1(루트)아니고, push할 값이 부모노드보다 크다면 반복
    while(tempIndex != 1 && num > maxHeap[tempIndex / 2]) {
        // 부모보다 크면 스왑
        swap(maxHeap[tempIndex], maxHeap[tempIndex / 2]);
        tempIndex /= 2;
    }

    heapSize++;
}

int popHeap() {
    int max = 0;

    // heapSize가 0이면 그냥 0출력, 아니면 루트(최대값) 뽑아서 트리 정렬 후 리턴
    if(heapSize != 0) {
        max = maxHeap[1];
        maxHeap[1] = maxHeap[heapSize];
        heapSize--;

        int parentIndex = 1;
        while(true) {
            int childIndex = parentIndex * 2;

            // 자식노드가 2개 && 오른쪽게 왼쪽보다 크다면
            if(childIndex + 1 <= heapSize && maxHeap[childIndex] < maxHeap[childIndex + 1]) {
                childIndex++;   // 오른쪽자식을 인덱스로 설정
            }
            // 자식 인덱스가 힙의 크기보다 커지거나 이미 부모가 자식보다 크면
            if(childIndex > heapSize || maxHeap[parentIndex] > maxHeap[childIndex]) {
                break;  // while문 탈출
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