// 계란으로 계란치기
#include <iostream>
#include <vector>

// 계란 내구도, 무게 쌍 벡터, 계란 총 갯수를 레퍼런스로 받음
// 가장 많이 깬 계란 리턴
int EggBreaker(std::vector<std::pair<int, int>> &eggs, int &egg_amount) {
    // for(auto i : eggs) {
    //     std::cout << "Eggs: " << i.first << ' ' << i.second << '\n';
    // }

    // bool broken_egg[egg_amount] = { false };    // t: 깨진것
    int max_broken_count = 0;
    int cur_egg = 0;    // 가장 왼쪽 계란으로 시작

    while(cur_egg < egg_amount) {
        int diff = 300;   // 손에 든 계란 무게 - 때릴 계란 내구도, 이 값의 최대값으로 때릴 계란 정함
        int hit_egg;    // 때릴 계란
        for(int i = 0; i < egg_amount; i++) {
            if(i == cur_egg) continue;

            int temp_diff = eggs[cur_egg].second - eggs[i].first;
            if(temp_diff > 0 && temp_diff < diff) {
                diff = temp_diff;
                hit_egg = i;
            }
        }

        

        
    }

    return 0;
}

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);

    int egg_amount; // 계란의 갯수
    std::vector<std::pair<int, int>> eggs(8);   // 내구도, 무게 쌍

    std::cin >> egg_amount;
    for(int i = 0; i < egg_amount; i++) {
        int durability, weight;
        std::cin >> durability >> weight;
        eggs[i] = std::make_pair(durability, weight);
    }

    std::cout << EggBreaker(eggs, egg_amount);

    return 0;
}