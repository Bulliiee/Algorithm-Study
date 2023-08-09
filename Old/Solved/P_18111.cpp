// 마인크래프트
#include <iostream>

using namespace std;

void init() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
}

int main() {
    init();
    int n, m, b;        // 세로길이, 가로길이, 인벤에 있는 블록 수
    int maxHeight = 0;  // 땅에서 가장 높은 높이

    cin >> n >> m >> b;
    int ground[n][m];    // 땅 담을 배열

    // 땅 입력받기
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cin >> ground[i][j];

            // 최대높이 넣기
            if(ground[i][j] > maxHeight) {
                maxHeight = ground[i][j];
            }
        }
    }

    int takeTime = 0x7f7f7f7f;   // 걸린 시간
    int tempB = b;            // 인벤토리 임시
    int tempTime = 0;
    int tempMaxHeight = 257;    // 256부터 0까지 계속 탐색해서 가장 적절한 값 만들기
    while(tempMaxHeight--) {
        // cout << "tempMaxHeight: " <<  tempMaxHeight << '\n';
        tempB = b;
        tempTime = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int diff = tempMaxHeight - ground[i][j];
                
                // 블럭 쌓기
                if(diff > 0) {
                    tempB -= diff;
                    tempTime += diff;
                }
                // 블럭 파기
                else if(diff < 0) {
                    tempB -= diff;
                    tempTime -= (diff * 2);
                }
            }
        }

        if(tempB < 0) { // 인벤 음수면
            continue;
        }
        else {
            if(tempTime < takeTime) {
                takeTime = tempTime;
                maxHeight = tempMaxHeight;
            }
            else if(tempTime == takeTime) {
                if(maxHeight < tempMaxHeight) {
                    maxHeight = tempMaxHeight;
                }
            }
        }
    }

    
    // cout << "tempTime: " << takeTime << '\n';
    // cout << "maxHeight: " << maxHeight << '\n';
    cout << takeTime << ' ' << maxHeight << '\n';


    return 0;
}