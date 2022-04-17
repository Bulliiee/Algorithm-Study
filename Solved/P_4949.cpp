// �������� ����
/* �������� ��ȣ üũ
    std::getline(string)
    getline(istream& is, string& str, char delim);
    is: �Է� ��Ʈ�� ������Ʈ ex)cin
    str: �Է¹��� ���ڿ� ������ string��ü
    delim: ������, �ش� ���� ���� �� ���� ����, �ش� ���ڴ� str�� ��ϵ��� ������ ��Ʈ������ �����
*/
#include <iostream>
#include <string>
#include <stack>

using namespace std;

void balanced(string line, int length) {
    stack<char> bracketCheck;
    bool check = true; // t�� yes, f�� no

    for (int i = 0; i < line.length(); i++) {
        // ��ȣ ���°Ÿ� ���ÿ� �ٷ� ����
        if (line[i] == '(' || line[i] == '[') {
            bracketCheck.push(line[i]);
        }
        // ��ȣ �ݴ� ���
        else if(line[i] == ')') {
            // ���ÿ� ���°� ���µ� �ݴ°� ���� ��쳪 ��ȣ �ȸ����� ��� no
            if(bracketCheck.size() == 0 || bracketCheck.top() != '(') {
                check = false;
                break;
            }
            else {
                bracketCheck.pop();
            }
        }
        else if(line[i] == ']') {
            if(bracketCheck.size() == 0 || bracketCheck.top() != '[') {
                check = false;
                break;
            }
            else {
                bracketCheck.pop();
            }
        }
    }

    if(bracketCheck.size() == 0 && check) {
        cout << "yes" << '\n';
    }
    else {
        cout << "no" << '\n';
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    string line;

    // string�� length�� ���ڿ��� ����, size�� �޸𸮿��� ������ ����ϴ� ũ��
    while(true) {
        getline(cin, line);
        // �׳� ���� ���Դ��� üũ
        if(line[0] == '.') {
            break;
        }
        // �� ���� �о����� ������ ���� �ƴϸ� �� ���ö����� ��� �о ����
        while(line[line.length() - 1] != '.') {
            string temp;
            getline(cin, temp);
            line.append(temp);
        }


        balanced(line, line.length());
    }

    return 0;
}