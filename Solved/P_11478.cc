// ���� �ٸ� �κ� ���ڿ��� ����
#include <iostream>
#include <string>
#include <set>
#include <unordered_set>

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);

    // key, value������ ������ �ʿ� ��� map�� �ƴ� set���
    // std::set<std::string> string_set;
    std::unordered_set<std::string> string_set;
    std::string input;
    // ���ڿ� ���� 1���� �Է��� ���ڿ��� ���̱��� �÷����鼭 �ʿ� ����
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

    // set�� �ߺ� �ȴ��ϱ� �״�� ���̸� ������ָ� ��
    std::cout << string_set.size();

    return 0;
}