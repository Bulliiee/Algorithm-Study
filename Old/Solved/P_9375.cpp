// 패션왕 신해빈
#include <iostream>
#include <map>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int input;
    cin >> input;
    for(int i = 0; i < input; i++) {
        map<string, int> m; // 키로 분류, 값으로 해당 분류에 맞는 갯수만 저장
        int clothes;
        int result = 1;

        cin >> clothes;
        for(int j = 0; j < clothes; j++) {
            string name, cls;   // 의상이름, 분류(의상이름은 필요없음)
            cin >> name >> cls;
            m[cls]++;
        }

        // 예시로
        // hat          heargear
        // turban       headgear
        // sunglasses   eyewear
        // slide        shoes
        // 위처럼 입력이 들어왔다고 하면
        // headgear분류에 2개, eyewear분류에 1개, shoes분류에 1개가 있다.
        // 예를 들어 headgear분류에서 하나씩 골라 입는 갯수가 2개인 것이고, 
        // 입지 않는 경우까지 하면 3이다.
        // 그러므로 순서가 필요없이 3개중에 1개를 뽑아내는 경우의 수를 구하면 되는데,
        // 그것은 조합을 사용하는 것이다.
        // headgear분류는 3C1이 되고, 계산하면 3이다.
        // 이처럼 다른 분류들도 모두 계산하면 eyewear 2, shoes 2가 된다.
        // 즉, 각 분류별로 하나를 뽑는(안입는것 포함) 경우의 수는 분류의 갯수 + 1이 된다.
        // 위를 통해 각 경우를 모두 곱해주면 각각 조합에 따라 입을 수 있는 경우의 수가 된다.
        // 하지만 모두 벗는 경우는 안쳐야 하므로 -1을 해주면 답이 된다.
        for(auto iter = m.begin(); iter != m.end(); iter++) {
            result *= ((iter->second) + 1);
        }
        cout << result - 1 << '\n';
    }


    return 0;
}