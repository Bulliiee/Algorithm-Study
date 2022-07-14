// ������� ���ġ��
#include <iostream>
#include <vector>

// ��� ������, ���� �� ����, ��� �� ������ ���۷����� ����
// ���� ���� �� ��� ����
int EggBreaker(std::vector<std::pair<int, int>> &eggs, int &egg_amount) {
    // for(auto i : eggs) {
    //     std::cout << "Eggs: " << i.first << ' ' << i.second << '\n';
    // }

    // bool broken_egg[egg_amount] = { false };    // t: ������
    int max_broken_count = 0;
    int cur_egg = 0;    // ���� ���� ������� ����

    while(cur_egg < egg_amount) {
        int diff = 300;   // �տ� �� ��� ���� - ���� ��� ������, �� ���� �ִ밪���� ���� ��� ����
        int hit_egg;    // ���� ���
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

    int egg_amount; // ����� ����
    std::vector<std::pair<int, int>> eggs(8);   // ������, ���� ��

    std::cin >> egg_amount;
    for(int i = 0; i < egg_amount; i++) {
        int durability, weight;
        std::cin >> durability >> weight;
        eggs[i] = std::make_pair(durability, weight);
    }

    std::cout << EggBreaker(eggs, egg_amount);

    return 0;
}