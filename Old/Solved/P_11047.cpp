// µ¿Àü 0
#include <iostream>
#include <vector>

using namespace std;

int num, k;
vector<int> coins;

void getCoins() {
    int count = 0;

    for(int i = num - 1; i >= 0; i--) {
        if(k <= 0) break;
        if(coins[i] > k) continue;
        
        k -= coins[i];
        i++;
        count++;
    }

    cout << count << '\n';
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> num >> k;
    for(int i = 0; i < num; i++) {
        int temp;
        cin >> temp;
        coins.push_back(temp);
    }

    getCoins();

    return 0;
}