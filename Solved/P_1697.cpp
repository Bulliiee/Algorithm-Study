// 숨바꼭질
#include <iostream>
#include <vector>
#include <queue>
#define MAX 100001

using namespace std;

int getBro(int n, int k) {
    // 현재위치, 걸린시간 쌍
    queue<pair<int, int>> q;
    // 탐색했던 경우가 나오면(true) 이후 탐색 안하게 하기 위함    
    bool visited[MAX] = { false };  
    int sec = 0;

    q.push(make_pair(n, 0));

    // int i = 0;
    while(!q.empty()) {
        // 큐에서 꺼내서 수빈이 현재위치와 걸린 시간 담음
        int subin = q.front().first;
        int time = q.front().second;
        q.pop();
        // cout << "count: " << i++ << " \\ " << subin << ", " << time << endl;

        // 수빈이가 동생 잡았으면
        if(subin == k) {
            // 큐에서 방금 꺼낸 시간 그대로 반환
            sec = time;
            break;
        }

        // 수빈이 좌표 3가지 경우 전부 체크
        // -1하는 경우는 0보다 작아지면 안되고, 방문 안한 경우에
        // 방문했다고 체크하고 큐에 걸린 시간 넣음
        if(0 <= subin - 1 && !visited[subin - 1]) {
            visited[subin - 1] = true;
            q.push(make_pair(subin - 1, time + 1));
        }
        // +1하는 경우는 최대 거리인 100000보다 작거나 같아야 함
        if(subin + 1 < MAX && !visited[subin + 1]) {
            visited[subin + 1] = true;
            q.push(make_pair(subin + 1, time + 1));
        }
        // *2하는 경우도 최대 거리인 100000보다 작거나 같아야 함
        if(subin * 2 < MAX && !visited[subin * 2]) {
            visited[subin * 2] = true;
            q.push(make_pair(subin * 2, time + 1));
        }
    }

    return sec;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, k;   // 수빈이 위치, 동생 위치
    cin >> n >> k;

    cout << getBro(n, k);

    return 0;
}