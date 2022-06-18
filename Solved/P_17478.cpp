// ����Լ��� ������?
#include <iostream>

using namespace std;

int input;

void print_underbar(int num) {
    for(int i = 0; i < num; i++) {
        cout << "____";
    }
}

void recursive(int num) {
    if(num > input) {
        return ;
    }

    print_underbar(num);
    cout << "\"����Լ��� ������?\"\n";

    if(num == input) {
        print_underbar(num);
        cout << "\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"\n";
    }
    else {
        print_underbar(num);
        cout << "\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.\n";
        
        print_underbar(num);
        cout << "���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.\n";
        
        print_underbar(num);
        cout << "���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"\n";
    }

    recursive(num + 1);

    print_underbar(num);
    cout << "��� �亯�Ͽ���.\n";
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> input;

    cout << "��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.\n";
    recursive(0);

    return 0;
}