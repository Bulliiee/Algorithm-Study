// �мǿ� ���غ�
#include <iostream>
#include <map>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int input;
    cin >> input;
    for(int i = 0; i < input; i++) {
        map<string, int> m; // Ű�� �з�, ������ �ش� �з��� �´� ������ ����
        int clothes;
        int result = 1;

        cin >> clothes;
        for(int j = 0; j < clothes; j++) {
            string name, cls;   // �ǻ��̸�, �з�(�ǻ��̸��� �ʿ����)
            cin >> name >> cls;
            m[cls]++;
        }

        // ���÷�
        // hat          heargear
        // turban       headgear
        // sunglasses   eyewear
        // slide        shoes
        // ��ó�� �Է��� ���Դٰ� �ϸ�
        // headgear�з��� 2��, eyewear�з��� 1��, shoes�з��� 1���� �ִ�.
        // ���� ��� headgear�з����� �ϳ��� ��� �Դ� ������ 2���� ���̰�, 
        // ���� �ʴ� ������ �ϸ� 3�̴�.
        // �׷��Ƿ� ������ �ʿ���� 3���߿� 1���� �̾Ƴ��� ����� ���� ���ϸ� �Ǵµ�,
        // �װ��� ������ ����ϴ� ���̴�.
        // headgear�з��� 3C1�� �ǰ�, ����ϸ� 3�̴�.
        // ��ó�� �ٸ� �з��鵵 ��� ����ϸ� eyewear 2, shoes 2�� �ȴ�.
        // ��, �� �з����� �ϳ��� �̴�(���Դ°� ����) ����� ���� �з��� ���� + 1�� �ȴ�.
        // ���� ���� �� ��츦 ��� �����ָ� ���� ���տ� ���� ���� �� �ִ� ����� ���� �ȴ�.
        // ������ ��� ���� ���� ���ľ� �ϹǷ� -1�� ���ָ� ���� �ȴ�.
        for(auto iter = m.begin(); iter != m.end(); iter++) {
            result *= ((iter->second) + 1);
        }
        cout << result - 1 << '\n';
    }


    return 0;
}