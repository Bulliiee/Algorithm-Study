// 최소 힙
#include <iostream>
#define MAX 100001      // 인덱스 1부터 시작

using namespace std;

int heapSize = 0;  // 최소힙에 들어있는 노드의 갯수이자, 가장 마지막 인덱스
int minHeap[MAX];   // 완전이진트리를 배열의 형태로 표시한다.(인덱스 1부터 사용)
// 예를 들어 {0, 2, 3, 5, 4, 7, 6}인 경우
//        2
//     /     \
//    3       5
//   / \     /
//  4   7   6
// 형태라고 보면 된다.
// 부모노드 인덱스는 원하는 노드의 인덱스 / 2 하면 구해진다.
// 예를들어 [5]인덱스의 부모 인덱스를 구하려면 5 / 2 = 2이므로
// 부모노드의 인덱스는 [2], 값은 3이 된다. 

// 최소힙에 값 넣기
void pushHeap(int num) {
    int tempIndex = heapSize + 1;  // 가장 마지막 인덱스 다음에 넣어야 하므로 +1 해준다.

    // 트리의 가장 단말(오른쪽 맨아래)에 들어온 값을 넣는다.
    minHeap[tempIndex] = num;

    // 가장 단말에 넣은 다음 부모와 비교해가며 작다면 부모와 swap한다.
    // 현재 체크하는 노드가 루트노드가 아니고, 부모노드보다 값이 작다면
    while((tempIndex != 1) && (num < minHeap[tempIndex / 2])) {
        // 부모노드와 현재 노드를 swap한다.
        int t = minHeap[tempIndex];
        minHeap[tempIndex] = minHeap[tempIndex / 2];
        minHeap[tempIndex / 2] = t;
        
        tempIndex /= 2;
    }

    heapSize++; // 값을 다 넣었으니들어있는 노드의 갯수를 1개 늘려준다.
}

// 최소힙에서 최소값 빼기
int popHeap() {
    int min;

    // 힙 크기가 0이라면 아무것도 들어있지 않은 것이므로 0리턴
    if(heapSize == 0) {
        return 0;
    }

    // min에 루트노드(최소값) 담고
    // 단말과 루트를 swap한다.
    min = minHeap[1];
    minHeap[1] = minHeap[heapSize];
    // minHeap[heapSize] = min;
    heapSize--; // 힙 사이즈를 줄여서 단말(가장 작은 값)을 제거

    // swap했으니 다시 트리를 맞춰준다.
    // root보다 자식이 작다면
    // root노드부터 아래로 자식 2개와 비교해서 둘 중 더 작은애를 위로 올린다.
    int parentIndex = 1;
    while(true) {
        int childIndex = parentIndex * 2;

        // 자식 2개 비교해서 더 작은애를 올릴준비 함
        // 자식노드중 오른쪽게 힙에 있는 노드 갯수보다 작고(자식노드가 2개 다 있는 경우) 오른쪽게 왼쪽보다 작으면
        // childIndex갱신, 결국 자식노드 중 작은애가 childIndex에 들어간다.
        if(childIndex + 1 <= heapSize && minHeap[childIndex] > minHeap[childIndex + 1]) {
            childIndex++;
        }

        // childIndex가 heapSize 벗어나거나 부모보다 큰 경우가 되면 빠져나가게 함
        if(childIndex > heapSize || minHeap[childIndex] > minHeap[parentIndex]) {
            break;
        }

        // 부모와 자식중 작은애 swap
        int temp = minHeap[childIndex];
        minHeap[childIndex] = minHeap[parentIndex];
        minHeap[parentIndex] = temp;

        parentIndex = childIndex;
    }
    

    return min;
}

void quary(int command) {
    // 출력
    if(command == 0) {
        cout << popHeap() << '\n';
        // cout << "result>>>>>>>>>>>>>>>: " << popHeap() << '\n';
    }
    // 삽입
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