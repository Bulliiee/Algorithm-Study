// 서로 다른 부분 문자열의 개수
#include <iostream>
#include <string>
#include <set>
#include <unordered_set>

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);

    // key, value쌍으로 저장할 필요 없어서 map이 아닌 set사용
    // std::set<std::string> string_set;
    std::unordered_set<std::string> string_set;
    std::string input;
    // 문자열 길이 1부터 입력한 문자열의 길이까지 늘려가면서 맵에 저장
    int string_size = 1;
    int input_size;
    std::cin >> input;
    input_size = input.length();

    std::string set_index;
    for(int i = 0; i < input_size; i++) {
        for(int j = i; j < input_size; j++) {
            set_index += input[j];
            // std::cout << set_index << '\n';
            string_set.insert(set_index);
        }
        set_index = "";
    }

    // set에 중복 안담기니까 그대로 길이만 출력해주면 답
    std::cout << string_set.size();

    return 0;
}