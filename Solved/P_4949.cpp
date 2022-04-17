// �������� ����
/* �������� ��ȣ üũ
    getline�� �� ���� ����

    std::istream::getline - cin.getline()
    getline(char* s, streamsize n, char delim);
    s: c���ó�� ���ڿ� ���� �迭 ����Ű�� ������
    n: ������ ���� �ִ� ����
    delim: ������, �ش� ���� ���� �� ���� ����, �ش� ���ڴ� s�� ��ϵ��� ������ ��Ʈ������ �����
    �����ڰ� ���� ��� �ڵ����� ���๮��(����)
    ex)
    char a[10];
    cin.getline(a, 10); // "hello lee" �Է�
    cout << a;  // hello lee ���

    std::getline(string)
    getline(istream& is, string& str, char delim);
    is: �Է� ��Ʈ�� ������Ʈ ex)cin
    str: �Է¹��� ���ڿ� ������ string��ü
    delim: ������, �ش� ���� ���� �� ���� ����, �ش� ���ڴ� str�� ��ϵ��� ������ ��Ʈ������ �����
    �����ڰ� ���� ��� �ڵ����� ���๮��(����)
    ex)
    string a;
    getline(cin, a);    // "hello lee" �Է�
    cout << a;  // hello lee ���

    cin ��� ��(cin�� ����, ���ڿ� ��� �Է� ����)
    char a[10];
    cin >> a;   // "hello lee" �Է�
    cout << a;  // hello ���
    ��ó�� getline��� �ٸ��� ���� �� �� �ع���

    get ��� ��(get�� ���ڸ� �Է� ����)
    char a, b, c;
    cin.get(a);
    cin.get(b);
    cin.get(c); // a b��� �Է�
    cout << a << ' ' << b << ' ' << c; // a�� 'a', b�� ' ', c�� b�� �������
    ��ó�� ���⸦ �Է� ���ᰡ �ƴ� �Է¹��� ���ڷ� �ν�
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